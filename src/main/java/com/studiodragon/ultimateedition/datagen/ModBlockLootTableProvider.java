package com.studiodragon.ultimateedition.datagen;

import com.studiodragon.ultimateedition.block.ModBlocks;
import com.studiodragon.ultimateedition.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {

    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        //region Apple wood set
        add(ModBlocks.APPLE_LEAVES.get(),
                block -> createLeavesDrops(block, ModBlocks.APPLE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        dropSelf(ModBlocks.APPLE_LOG.get());
        dropSelf(ModBlocks.STRIPPED_APPLE_LOG.get());
        dropSelf(ModBlocks.APPLE_WOOD.get());
        dropSelf(ModBlocks.STRIPPED_APPLE_WOOD.get());
        dropSelf(ModBlocks.APPLE_SAPLING.get());
        add(ModBlocks.POTTED_APPLE_SAPLING.get(), createPotFlowerItemTable(ModBlocks.APPLE_SAPLING.get()));
        dropSelf(ModBlocks.APPLE_PLANKS.get());
        dropSelf(ModBlocks.APPLE_STAIRS.get());
        add(ModBlocks.APPLE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.APPLE_SLAB.get()));
        dropSelf(ModBlocks.APPLE_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.APPLE_BUTTON.get());
        dropSelf(ModBlocks.APPLE_FENCE.get());
        dropSelf(ModBlocks.APPLE_FENCE_GATE.get());
        add(ModBlocks.APPLE_DOOR.get(),
                block -> createDoorTable(ModBlocks.APPLE_DOOR.get()));
        dropSelf(ModBlocks.APPLE_TRAPDOOR.get());
        dropOther(ModBlocks.APPLE_STANDING_SIGN.get(), ModItems.APPLE_SIGN);
        dropOther(ModBlocks.APPLE_WALL_SIGN.get(), ModItems.APPLE_SIGN);
        dropOther(ModBlocks.APPLE_CEILING_HANGING_SIGN.get(), ModItems.APPLE_HANGING_SIGN);
        dropOther(ModBlocks.APPLE_WALL_HANGING_SIGN.get(), ModItems.APPLE_HANGING_SIGN);
        //endregion

        //region Azalea wood set
        dropSelf(ModBlocks.AZALEA_LOG.get());
        dropSelf(ModBlocks.STRIPPED_AZALEA_LOG.get());
        dropSelf(ModBlocks.AZALEA_WOOD.get());
        dropSelf(ModBlocks.STRIPPED_AZALEA_WOOD.get());
        dropSelf(ModBlocks.AZALEA_PLANKS.get());
        dropSelf(ModBlocks.AZALEA_STAIRS.get());
        add(ModBlocks.AZALEA_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.AZALEA_SLAB.get()));
        dropSelf(ModBlocks.AZALEA_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.AZALEA_BUTTON.get());
        dropSelf(ModBlocks.AZALEA_FENCE.get());
        dropSelf(ModBlocks.AZALEA_FENCE_GATE.get());
        add(ModBlocks.AZALEA_DOOR.get(),
                block -> createDoorTable(ModBlocks.AZALEA_DOOR.get()));
        dropSelf(ModBlocks.AZALEA_TRAPDOOR.get());
        dropOther(ModBlocks.AZALEA_STANDING_SIGN.get(), ModItems.AZALEA_SIGN);
        dropOther(ModBlocks.AZALEA_WALL_SIGN.get(), ModItems.AZALEA_SIGN);
        dropOther(ModBlocks.AZALEA_CEILING_HANGING_SIGN.get(), ModItems.AZALEA_HANGING_SIGN);
        dropOther(ModBlocks.AZALEA_WALL_HANGING_SIGN.get(), ModItems.AZALEA_HANGING_SIGN);
        //endregion

        //region Orange wood set
        add(ModBlocks.ORANGE_LEAVES.get(),
                block -> createLeavesDrops(block, ModBlocks.ORANGE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        dropSelf(ModBlocks.ORANGE_LOG.get());
        dropSelf(ModBlocks.STRIPPED_ORANGE_LOG.get());
        dropSelf(ModBlocks.ORANGE_WOOD.get());
        dropSelf(ModBlocks.STRIPPED_ORANGE_WOOD.get());
        dropSelf(ModBlocks.ORANGE_SAPLING.get());
        add(ModBlocks.POTTED_ORANGE_SAPLING.get(), createPotFlowerItemTable(ModBlocks.ORANGE_SAPLING.get()));
        dropSelf(ModBlocks.ORANGE_PLANKS.get());
        dropSelf(ModBlocks.ORANGE_STAIRS.get());
        add(ModBlocks.ORANGE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ORANGE_SLAB.get()));
        dropSelf(ModBlocks.ORANGE_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.ORANGE_BUTTON.get());
        dropSelf(ModBlocks.ORANGE_FENCE.get());
        dropSelf(ModBlocks.ORANGE_FENCE_GATE.get());
        add(ModBlocks.ORANGE_DOOR.get(),
                block -> createDoorTable(ModBlocks.ORANGE_DOOR.get()));
        dropSelf(ModBlocks.ORANGE_TRAPDOOR.get());
        dropOther(ModBlocks.ORANGE_STANDING_SIGN.get(), ModItems.ORANGE_SIGN);
        dropOther(ModBlocks.ORANGE_WALL_SIGN.get(), ModItems.ORANGE_SIGN);
        dropOther(ModBlocks.ORANGE_CEILING_HANGING_SIGN.get(), ModItems.ORANGE_HANGING_SIGN);
        dropOther(ModBlocks.ORANGE_WALL_HANGING_SIGN.get(), ModItems.ORANGE_HANGING_SIGN);
        //endregion

        //region Pear wood set
        add(ModBlocks.PEAR_LEAVES.get(),
                block -> createLeavesDrops(block, ModBlocks.PEAR_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        dropSelf(ModBlocks.PEAR_LOG.get());
        dropSelf(ModBlocks.STRIPPED_PEAR_LOG.get());
        dropSelf(ModBlocks.PEAR_WOOD.get());
        dropSelf(ModBlocks.STRIPPED_PEAR_WOOD.get());
        dropSelf(ModBlocks.PEAR_SAPLING.get());
        add(ModBlocks.POTTED_PEAR_SAPLING.get(), createPotFlowerItemTable(ModBlocks.PEAR_SAPLING.get()));
        dropSelf(ModBlocks.PEAR_PLANKS.get());
        dropSelf(ModBlocks.PEAR_STAIRS.get());
        add(ModBlocks.PEAR_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PEAR_SLAB.get()));
        dropSelf(ModBlocks.PEAR_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.PEAR_BUTTON.get());
        dropSelf(ModBlocks.PEAR_FENCE.get());
        dropSelf(ModBlocks.PEAR_FENCE_GATE.get());
        add(ModBlocks.PEAR_DOOR.get(),
                block -> createDoorTable(ModBlocks.PEAR_DOOR.get()));
        dropSelf(ModBlocks.PEAR_TRAPDOOR.get());
        dropOther(ModBlocks.PEAR_STANDING_SIGN.get(), ModItems.PEAR_SIGN);
        dropOther(ModBlocks.PEAR_WALL_SIGN.get(), ModItems.PEAR_SIGN);
        dropOther(ModBlocks.PEAR_CEILING_HANGING_SIGN.get(), ModItems.PEAR_HANGING_SIGN);
        dropOther(ModBlocks.PEAR_WALL_HANGING_SIGN.get(), ModItems.PEAR_HANGING_SIGN);
        //endregion

        //region Misc
        dropSelf(ModBlocks.CYAN_ROSE.get());
        add(ModBlocks.POTTED_CYAN_ROSE.get(), createPotFlowerItemTable(ModBlocks.CYAN_ROSE.get()));
        dropSelf(ModBlocks.PEONIA.get());
        add(ModBlocks.POTTED_PEONIA.get(), createPotFlowerItemTable(ModBlocks.PEONIA.get()));
        dropSelf(ModBlocks.PLASTER.get());
        dropSelf(ModBlocks.PINECONE_BLOCK.get());
        dropSelf(ModBlocks.ROSE.get());
        add(ModBlocks.POTTED_ROSE.get(), createPotFlowerItemTable(ModBlocks.ROSE.get()));
        //endregion
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        var blockRegistry = this.registries.lookupOrThrow(net.minecraft.core.registries.Registries.BLOCK);
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)
                .filter(block -> block != ModBlocks.FLOWERING_ACACIA_LEAVES.get())
                .filter(block -> block != ModBlocks.FLOWERING_APPLE_LEAVES.get())
                .filter(block -> block != ModBlocks.FLOWERING_BIRCH_LEAVES.get())
                .filter(block -> block != ModBlocks.FLOWERING_CHERRY_LEAVES.get())
                .filter(block -> block != ModBlocks.FLOWERING_DARK_OAK_LEAVES.get())
                .filter(block -> block != ModBlocks.FLOWERING_JUNGLE_LEAVES.get())
                .filter(block -> block != ModBlocks.FLOWERING_OAK_LEAVES.get())
                .filter(block -> block != ModBlocks.FLOWERING_ORANGE_LEAVES.get())
                .filter(block -> block != ModBlocks.FLOWERING_PEAR_LEAVES.get())
                .filter(block -> block != ModBlocks.FLOWERING_SPRUCE_LEAVES.get())
                ::iterator;
    }
}