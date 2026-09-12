package com.studiodragon.ultimateedition.event;

import com.studiodragon.ultimateedition.world.level.block.FloweringLeavesBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.dispenser.OptionalDispenseItemBehavior;
import net.minecraft.util.Mth;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.CommonHooks;
import org.jetbrains.annotations.NotNull;

public class Dispenser extends OptionalDispenseItemBehavior {
    public static void register(IEventBus modEventBus) {
    }

    @Override
    protected @NotNull ItemStack execute(BlockSource blockSource, @NotNull ItemStack item) {
        Level level = blockSource.level();
        Direction direction = blockSource.state().getValue(DispenserBlock.FACING);
        BlockPos targetBlockPos = blockSource.pos().relative(direction);
        BlockState targetBlockState = level.getBlockState(targetBlockPos);
        Block targetBlock = targetBlockState.getBlock();

        if (!level.isClientSide && targetBlock instanceof FloweringLeavesBlock floweringLeavesBlock) {
            int age = targetBlockState.getValue(FloweringLeavesBlock.AGE);
            int distance = targetBlockState.getValue(FloweringLeavesBlock.DISTANCE);
            boolean persistent = targetBlockState.getValue(FloweringLeavesBlock.PERSISTENT);
            boolean waterlogged = targetBlockState.getValue(FloweringLeavesBlock.WATERLOGGED);
            Item fruit = floweringLeavesBlock.getFruit();

            if (item.is(Items.SHEARS) && age>0) {
                level.setBlock(targetBlockPos, targetBlockState
                        .setValue(FloweringLeavesBlock.AGE, 0)
                        .setValue(FloweringLeavesBlock.DISTANCE, distance)
                        .setValue(FloweringLeavesBlock.PERSISTENT, persistent)
                        .setValue(FloweringLeavesBlock.WATERLOGGED, waterlogged), 2);
                Block.popResource(level, targetBlockPos, new ItemStack(fruit, age + Mth.nextInt(level.random, 0, 1)));
                item.setDamageValue(1);
                this.setSuccess(true);
                return item;
            } else if (item.is(Items.BONE_MEAL) && age < 2) {
                level.setBlock(targetBlockPos, targetBlockState
                        .setValue(FloweringLeavesBlock.AGE, age + 1)
                        .setValue(FloweringLeavesBlock.DISTANCE, distance)
                        .setValue(FloweringLeavesBlock.PERSISTENT, persistent)
                        .setValue(FloweringLeavesBlock.WATERLOGGED, waterlogged), 2);
                CommonHooks.fireCropGrowPost(level, targetBlockPos, targetBlockState);
                item.shrink(1);
                this.setSuccess(true);
                return item;
            }
        }
        return super.execute(blockSource, item);
    }
}