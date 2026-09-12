package com.studiodragon.ultimateedition.datagen;

import com.studiodragon.ultimateedition.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {

    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.PLASTER.get());
        dropSelf(ModBlocks.PINECONE_BLOCK.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        var blockRegistry = this.registries.lookupOrThrow(net.minecraft.core.registries.Registries.BLOCK);
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)
                .filter(block -> block != ModBlocks.FLOWERING_ACACIA_LEAVES.get())
                .filter(block -> block != ModBlocks.FLOWERING_BIRCH_LEAVES.get())
                .filter(block -> block != ModBlocks.FLOWERING_CHERRY_LEAVES.get())
                .filter(block -> block != ModBlocks.FLOWERING_DARK_OAK_LEAVES.get())
                .filter(block -> block != ModBlocks.FLOWERING_JUNGLE_LEAVES.get())
                .filter(block -> block != ModBlocks.FLOWERING_OAK_LEAVES.get())
                .filter(block -> block != ModBlocks.FLOWERING_SPRUCE_LEAVES.get())
                ::iterator;
    }
}