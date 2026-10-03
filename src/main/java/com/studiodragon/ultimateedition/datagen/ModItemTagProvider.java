package com.studiodragon.ultimateedition.datagen;

import com.studiodragon.ultimateedition.UltimateEdition;
import com.studiodragon.ultimateedition.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {

    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, UltimateEdition.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        tag(ItemTags.LEAVES)
                .add(ModBlocks.APPLE_LEAVES.get().asItem())
                .add(ModBlocks.FLOWERING_ACACIA_LEAVES.get().asItem())
                .add(ModBlocks.FLOWERING_APPLE_LEAVES.get().asItem())
                .add(ModBlocks.FLOWERING_BIRCH_LEAVES.get().asItem())
                .add(ModBlocks.FLOWERING_CHERRY_LEAVES.get().asItem())
                .add(ModBlocks.FLOWERING_DARK_OAK_LEAVES.get().asItem())
                .add(ModBlocks.FLOWERING_JUNGLE_LEAVES.get().asItem())
                .add(ModBlocks.FLOWERING_OAK_LEAVES.get().asItem())
                .add(ModBlocks.FLOWERING_ORANGE_LEAVES.get().asItem())
                .add(ModBlocks.FLOWERING_PEAR_LEAVES.get().asItem())
                .add(ModBlocks.FLOWERING_SPRUCE_LEAVES.get().asItem())
                .add(ModBlocks.ORANGE_LEAVES.get().asItem())
                .add(ModBlocks.PEAR_LEAVES.get().asItem());

        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.APPLE_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_APPLE_LOG.get().asItem())
                .add(ModBlocks.APPLE_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_APPLE_WOOD.get().asItem())
                .add(ModBlocks.AZALEA_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_AZALEA_LOG.get().asItem())
                .add(ModBlocks.AZALEA_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_AZALEA_WOOD.get().asItem())
                .add(ModBlocks.ORANGE_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_ORANGE_LOG.get().asItem())
                .add(ModBlocks.ORANGE_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_ORANGE_WOOD.get().asItem())
                .add(ModBlocks.PEAR_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_PEAR_LOG.get().asItem())
                .add(ModBlocks.PEAR_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_PEAR_WOOD.get().asItem());

        this.tag(ItemTags.PLANKS)
                .add(ModBlocks.APPLE_PLANKS.get().asItem())
                .add(ModBlocks.AZALEA_PLANKS.get().asItem())
                .add(ModBlocks.ORANGE_PLANKS.get().asItem())
                .add(ModBlocks.PEAR_PLANKS.get().asItem());
    }
}