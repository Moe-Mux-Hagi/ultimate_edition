package com.studiodragon.ultimateedition.item.custom;

import com.studiodragon.ultimateedition.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

@EventBusSubscriber(modid = "ultimateedition")
public class ApplePlantingHandler {

    @SubscribeEvent
    public static void onRightClick(PlayerInteractEvent.RightClickBlock event) {
        ItemStack itemStack = event.getItemStack();
        if (!itemStack.is(Items.APPLE)) return;

        Player player = event.getEntity();
        Level level = event.getLevel();
        BlockPos clickedPos = event.getPos();
        BlockPos targetPos = clickedPos.above();
        BlockState saplingBlock = ModBlocks.APPLE_SAPLING.get().defaultBlockState();

        if (level.isEmptyBlock(targetPos)) {
            BlockState soil = level.getBlockState(clickedPos);
            if (soil.is(Blocks.GRASS_BLOCK) || soil.is(Blocks.MYCELIUM) || soil.is(Blocks.PODZOL) || soil.is(BlockTags.DIRT) || soil.is(Blocks.MOSS_BLOCK)) {
                if (!level.isClientSide()) {
                    level.setBlock(targetPos, saplingBlock, 3);
                    level.playSound(null, targetPos, SoundEvents.GRASS_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);
                    itemStack.consume(1, player); // Use shrink instead of consume depending on your version
                }

                event.setCancellationResult(InteractionResult.sidedSuccess(level.isClientSide()));
                event.setCanceled(true);
            }
        }
    }
}