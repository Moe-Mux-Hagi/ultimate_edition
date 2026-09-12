package com.studiodragon.ultimateedition.world.level.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.common.CommonHooks;
import org.jetbrains.annotations.NotNull;

public abstract class FloweringLeavesBlock extends LeavesBlock {
    public static final IntegerProperty AGE;

    public FloweringLeavesBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(this.getAgeProperty(), 0)
                .setValue(DISTANCE, 7)
                .setValue(PERSISTENT, false)
                .setValue(WATERLOGGED, false));
    }

    public abstract Item getFruit();

    //Random tick events
    protected boolean isRandomlyTicking(@NotNull BlockState state) {
        return !this.isMaxAge(state);
    }

    protected void randomTick(@NotNull BlockState state, ServerLevel level, @NotNull BlockPos pos, @NotNull RandomSource random) {
        if (level.isAreaLoaded(pos, 1)) {
            if (level.getRawBrightness(pos, 0) >= 9) {
                int i = this.getAge(state);
                int distance = state.getValue(DISTANCE);
                boolean persistent = state.getValue(PERSISTENT);
                boolean waterlogged = state.getValue(WATERLOGGED);
                if (i < this.getMaxAge()) {
                    level.setBlock(pos, this
                            .getStateForAge(i + 1)
                            .setValue(DISTANCE, distance)
                            .setValue(PERSISTENT, persistent)
                            .setValue(WATERLOGGED, waterlogged), 2);
                    CommonHooks.fireCropGrowPost(level, pos, state);
                }
            }

        }
        if (this.decaying(state)) {
            dropResources(state, level, pos);
            level.removeBlock(pos, false);
        }
    }

    //Fruit Growth
    protected IntegerProperty getAgeProperty() {
        return AGE;
    }

    public int getMaxAge() {
        return 2;
    }

    public int getAge(BlockState state) {
        return state.getValue(this.getAgeProperty());
    }

    public BlockState getStateForAge(int age) {
        return this.defaultBlockState().setValue(this.getAgeProperty(), age);
    }

    public final boolean isMaxAge(BlockState state) {
        return this.getAge(state) >= this.getMaxAge();
    }

    static {
        AGE = BlockStateProperties.AGE_2;
    }

    //Interactions
    @Override
    protected @NotNull InteractionResult useWithoutItem(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, Player player, @NotNull BlockHitResult hitResult) {
        int age = this.getAge(state);
        int distance = state.getValue(DISTANCE);
        boolean persistent = state.getValue(PERSISTENT);
        boolean waterlogged = state.getValue(WATERLOGGED);

        ItemStack heldItem = player.getItemInHand(InteractionHand.MAIN_HAND);

        //Use bone meal
        if (heldItem.is(Items.BONE_MEAL)) {
            if (age < this.getMaxAge()) {
                level.setBlock(pos, this
                        .getStateForAge(age + /*Mth.nextInt(level.random, 1, 2)*/ 1)
                        .setValue(DISTANCE, distance)
                        .setValue(PERSISTENT, persistent)
                        .setValue(WATERLOGGED, waterlogged), 2);
                CommonHooks.fireCropGrowPost(level, pos, state);
                heldItem.consume(1, player);
                return InteractionResult.SUCCESS;
            }
        }

        //Use water bucket
        if (heldItem.is(Items.WATER_BUCKET) && !waterlogged) {
            level.setBlock(pos, this.getStateForAge(age)
                    .setValue(DISTANCE, distance)
                    .setValue(PERSISTENT, persistent)
                    .setValue(WATERLOGGED, true), 2);
            CommonHooks.fireCropGrowPost(level, pos, state);
            if (!player.isCreative()) {
                ItemStack emptyBucket = new ItemStack(Items.BUCKET);
                player.setItemInHand(InteractionHand.MAIN_HAND, emptyBucket);
            }
            return InteractionResult.SUCCESS;
        }

        //Use empty bucket
        if (heldItem.is(Items.BUCKET) && waterlogged) {
            level.setBlock(pos, this.getStateForAge(age)
                    .setValue(DISTANCE, distance)
                    .setValue(PERSISTENT, persistent)
                    .setValue(WATERLOGGED, false), 2);
            CommonHooks.fireCropGrowPost(level, pos, state);
            if (!player.isCreative()) {
                ItemStack fullBucket = new ItemStack(Items.WATER_BUCKET);
                player.setItemInHand(InteractionHand.MAIN_HAND, fullBucket);
            }
            return InteractionResult.SUCCESS;
        }

        //Place block
        if (heldItem.getItem() instanceof BlockItem) {
            return InteractionResult.PASS;
        }

        //Collect fruit
        if (!level.isClientSide && age>0) {
            Block.popResource(level, pos, new ItemStack(this.getFruit(), age + Mth.nextInt(level.random, 0, 1)));
            level.setBlock(pos, this.getStateForAge(0)
                    .setValue(DISTANCE, distance)
                    .setValue(PERSISTENT, persistent)
                    .setValue(WATERLOGGED, waterlogged), 2);
            return InteractionResult.SUCCESS;
        }

        if (this.decaying(state)) {
            dropResources(state, level, pos);
            level.removeBlock(pos, false);
        }

        return InteractionResult.SUCCESS;
    }

    //Blockstate definer
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
        builder.add(DISTANCE);
        builder.add(PERSISTENT);
        builder.add(WATERLOGGED);
    }

    @Override
    public @NotNull FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public @NotNull BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        return this.defaultBlockState()
                .setValue(AGE, 0)
                .setValue(PERSISTENT, true);
    }
}