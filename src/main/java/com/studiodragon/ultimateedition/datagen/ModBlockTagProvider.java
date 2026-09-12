package com.studiodragon.ultimateedition.datagen;

import com.studiodragon.ultimateedition.UltimateEdition;
import com.studiodragon.ultimateedition.block.ModBlocks;
import com.studiodragon.ultimateedition.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {

    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, UltimateEdition.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        tag(ModTags.Blocks.FLOWERING_LEAVES)
                .add(ModBlocks.FLOWERING_DARK_OAK_LEAVES.get())
                .add(ModBlocks.FLOWERING_OAK_LEAVES.get())
                .add(ModBlocks.FLOWERING_SPRUCE_LEAVES.get());
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.PINECONE_BLOCK.get());
        tag(BlockTags.MINEABLE_WITH_HOE)
                .add(ModBlocks.FLOWERING_DARK_OAK_LEAVES.get())
                .add(ModBlocks.FLOWERING_OAK_LEAVES.get())
                .add(ModBlocks.FLOWERING_SPRUCE_LEAVES.get());
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.PLASTER.get());
    }
}