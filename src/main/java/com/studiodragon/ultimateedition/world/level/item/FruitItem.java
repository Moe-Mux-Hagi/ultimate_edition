package com.studiodragon.ultimateedition.world.level.item;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public abstract class FruitItem extends Item {

    public FruitItem(Properties properties) {
        super(properties);
    }

    protected abstract Block getSapling();

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        ItemStack itemStack = context.getItemInHand();
        Player player = context.getPlayer();
        Level level = context.getLevel();
        BlockPos clickedPos = context.getClickedPos();
        BlockPos targetPos = clickedPos.above();
        BlockState saplingBlock = this.getSapling().defaultBlockState();

        if (!level.isClientSide() && level.isEmptyBlock(targetPos)) {
            BlockState soil = level.getBlockState(clickedPos);
            if (soil.is(Blocks.GRASS_BLOCK) || soil.is(Blocks.MYCELIUM) || soil.is(Blocks.PODZOL) || soil.is(BlockTags.DIRT) || soil.is(Blocks.MOSS_BLOCK)) {
                level.setBlock(targetPos, saplingBlock.getBlock().defaultBlockState(), 3);
                level.playSound(null, targetPos.getX(), targetPos.getY(), targetPos.getZ(), SoundEvents.GRASS_BREAK, SoundSource.BLOCKS, 1F, 1f);
                itemStack.consume(1, player);
                return InteractionResult.SUCCESS;
            }
        }
        return level.isClientSide() ? InteractionResult.SUCCESS : InteractionResult.PASS;
    }
}