package com.studiodragon.ultimateedition.datagen;

import com.studiodragon.ultimateedition.UltimateEdition;
import com.studiodragon.ultimateedition.block.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, UltimateEdition.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        //region Apple wood set
        leavesBlock(ModBlocks.APPLE_LEAVES);
        logBlock((RotatedPillarBlock) ModBlocks.APPLE_LOG.get());
            blockItem(ModBlocks.APPLE_LOG);
        logBlock((RotatedPillarBlock) ModBlocks.STRIPPED_APPLE_LOG.get());
            blockItem(ModBlocks.STRIPPED_APPLE_LOG);
        axisBlock((RotatedPillarBlock) ModBlocks.APPLE_WOOD.get(), blockTexture(ModBlocks.APPLE_LOG.get()), blockTexture(ModBlocks.APPLE_LOG.get()));
            blockItem(ModBlocks.APPLE_WOOD);
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_APPLE_WOOD.get(), blockTexture(ModBlocks.STRIPPED_APPLE_LOG.get()), blockTexture(ModBlocks.STRIPPED_APPLE_LOG.get()));
            blockItem(ModBlocks.STRIPPED_APPLE_WOOD);
        saplingBlock(ModBlocks.APPLE_SAPLING);
        simpleBlockWithItem(ModBlocks.POTTED_APPLE_SAPLING.get(), models().singleTexture("potted_apple_sapling", ResourceLocation.fromNamespaceAndPath("minecraft","flower_pot_cross"), "plant", blockTexture(ModBlocks.APPLE_SAPLING.get())).renderType("cutout"));
        blockWithItem(ModBlocks.APPLE_PLANKS);
        stairsBlock(ModBlocks.APPLE_STAIRS.get(), blockTexture(ModBlocks.APPLE_PLANKS.get()));
            blockItem(ModBlocks.APPLE_STAIRS);
        slabBlock(ModBlocks.APPLE_SLAB.get(), blockTexture(ModBlocks.APPLE_PLANKS.get()), blockTexture(ModBlocks.APPLE_PLANKS.get()));
            blockItem(ModBlocks.APPLE_SLAB);
        buttonBlock(ModBlocks.APPLE_BUTTON.get(), blockTexture(ModBlocks.APPLE_PLANKS.get()));
        pressurePlateBlock(ModBlocks.APPLE_PRESSURE_PLATE.get(), blockTexture(ModBlocks.APPLE_PLANKS.get()));
            blockItem(ModBlocks.APPLE_PRESSURE_PLATE);
        fenceBlock(ModBlocks.APPLE_FENCE.get(), blockTexture(ModBlocks.APPLE_PLANKS.get()));
        fenceGateBlock(ModBlocks.APPLE_FENCE_GATE.get(), blockTexture(ModBlocks.APPLE_PLANKS.get()));
            blockItem(ModBlocks.APPLE_FENCE_GATE);
        doorBlockWithRenderType(ModBlocks.APPLE_DOOR.get(), modLoc("block/apple_door_bottom"), modLoc("block/apple_door_top"), "translucent");  //<<<DO NOT FORGET TO SET IT TO "CUTOUT" FOR OTHER DOORS (OR "SOLID" IF NO TRANSPARENCY)
        trapdoorBlockWithRenderType(ModBlocks.APPLE_TRAPDOOR.get(), modLoc("block/apple_trapdoor"), true, "translucent");
            blockItem(ModBlocks.APPLE_TRAPDOOR, "_bottom");
        signBlock(ModBlocks.APPLE_STANDING_SIGN.get(), ModBlocks.APPLE_WALL_SIGN.get(), modLoc("block/apple_sign"));
        hangingSignBlock(ModBlocks.APPLE_CEILING_HANGING_SIGN.get(), ModBlocks.APPLE_WALL_HANGING_SIGN.get(), modLoc("block/apple_hanging_sign"));
        //endregion

        //region Azalea wood set
        logBlock((RotatedPillarBlock) ModBlocks.AZALEA_LOG.get());
        blockItem(ModBlocks.AZALEA_LOG);
        logBlock((RotatedPillarBlock) ModBlocks.STRIPPED_AZALEA_LOG.get());
        blockItem(ModBlocks.STRIPPED_AZALEA_LOG);
        axisBlock((RotatedPillarBlock) ModBlocks.AZALEA_WOOD.get(), blockTexture(ModBlocks.AZALEA_LOG.get()), blockTexture(ModBlocks.AZALEA_LOG.get()));
        blockItem(ModBlocks.AZALEA_WOOD);
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_AZALEA_WOOD.get(), blockTexture(ModBlocks.STRIPPED_AZALEA_LOG.get()), blockTexture(ModBlocks.STRIPPED_AZALEA_LOG.get()));
        blockItem(ModBlocks.STRIPPED_AZALEA_WOOD);
        blockWithItem(ModBlocks.AZALEA_PLANKS);
        stairsBlock(ModBlocks.AZALEA_STAIRS.get(), blockTexture(ModBlocks.AZALEA_PLANKS.get()));
        blockItem(ModBlocks.AZALEA_STAIRS);
        slabBlock(ModBlocks.AZALEA_SLAB.get(), blockTexture(ModBlocks.AZALEA_PLANKS.get()), blockTexture(ModBlocks.AZALEA_PLANKS.get()));
        blockItem(ModBlocks.AZALEA_SLAB);
        buttonBlock(ModBlocks.AZALEA_BUTTON.get(), blockTexture(ModBlocks.AZALEA_PLANKS.get()));
        pressurePlateBlock(ModBlocks.AZALEA_PRESSURE_PLATE.get(), blockTexture(ModBlocks.AZALEA_PLANKS.get()));
        blockItem(ModBlocks.AZALEA_PRESSURE_PLATE);
        fenceBlock(ModBlocks.AZALEA_FENCE.get(), blockTexture(ModBlocks.AZALEA_PLANKS.get()));
        fenceGateBlock(ModBlocks.AZALEA_FENCE_GATE.get(), blockTexture(ModBlocks.AZALEA_PLANKS.get()));
        blockItem(ModBlocks.AZALEA_FENCE_GATE);
        doorBlockWithRenderType(ModBlocks.AZALEA_DOOR.get(), modLoc("block/azalea_door_bottom"), modLoc("block/azalea_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.AZALEA_TRAPDOOR.get(), modLoc("block/azalea_trapdoor"), true, "cutout");
        blockItem(ModBlocks.AZALEA_TRAPDOOR, "_bottom");
        signBlock(ModBlocks.AZALEA_STANDING_SIGN.get(), ModBlocks.AZALEA_WALL_SIGN.get(), modLoc("block/azalea_sign"));
        hangingSignBlock(ModBlocks.AZALEA_CEILING_HANGING_SIGN.get(), ModBlocks.AZALEA_WALL_HANGING_SIGN.get(), modLoc("block/azalea_hanging_sign"));
        //endregion

        //region Orange wood set
        leavesBlock(ModBlocks.ORANGE_LEAVES);
        logBlock((RotatedPillarBlock) ModBlocks.ORANGE_LOG.get());
        blockItem(ModBlocks.ORANGE_LOG);
        logBlock((RotatedPillarBlock) ModBlocks.STRIPPED_ORANGE_LOG.get());
        blockItem(ModBlocks.STRIPPED_ORANGE_LOG);
        axisBlock((RotatedPillarBlock) ModBlocks.ORANGE_WOOD.get(), blockTexture(ModBlocks.ORANGE_LOG.get()), blockTexture(ModBlocks.ORANGE_LOG.get()));
        blockItem(ModBlocks.ORANGE_WOOD);
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_ORANGE_WOOD.get(), blockTexture(ModBlocks.STRIPPED_ORANGE_LOG.get()), blockTexture(ModBlocks.STRIPPED_ORANGE_LOG.get()));
        blockItem(ModBlocks.STRIPPED_ORANGE_WOOD);
        saplingBlock(ModBlocks.ORANGE_SAPLING);
        simpleBlockWithItem(ModBlocks.POTTED_ORANGE_SAPLING.get(), models().singleTexture("potted_orange_sapling", ResourceLocation.fromNamespaceAndPath("minecraft","flower_pot_cross"), "plant", blockTexture(ModBlocks.ORANGE_SAPLING.get())).renderType("cutout"));
        blockWithItem(ModBlocks.ORANGE_PLANKS);
        stairsBlock(ModBlocks.ORANGE_STAIRS.get(), blockTexture(ModBlocks.ORANGE_PLANKS.get()));
        blockItem(ModBlocks.ORANGE_STAIRS);
        slabBlock(ModBlocks.ORANGE_SLAB.get(), blockTexture(ModBlocks.ORANGE_PLANKS.get()), blockTexture(ModBlocks.ORANGE_PLANKS.get()));
        blockItem(ModBlocks.ORANGE_SLAB);
        buttonBlock(ModBlocks.ORANGE_BUTTON.get(), blockTexture(ModBlocks.ORANGE_PLANKS.get()));
        pressurePlateBlock(ModBlocks.ORANGE_PRESSURE_PLATE.get(), blockTexture(ModBlocks.ORANGE_PLANKS.get()));
        blockItem(ModBlocks.ORANGE_PRESSURE_PLATE);
        fenceBlock(ModBlocks.ORANGE_FENCE.get(), blockTexture(ModBlocks.ORANGE_PLANKS.get()));
        fenceGateBlock(ModBlocks.ORANGE_FENCE_GATE.get(), blockTexture(ModBlocks.ORANGE_PLANKS.get()));
        blockItem(ModBlocks.ORANGE_FENCE_GATE);
        doorBlockWithRenderType(ModBlocks.ORANGE_DOOR.get(), modLoc("block/orange_door_bottom"), modLoc("block/orange_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.ORANGE_TRAPDOOR.get(), modLoc("block/orange_trapdoor"), true, "cutout");
        blockItem(ModBlocks.ORANGE_TRAPDOOR, "_bottom");
        signBlock(ModBlocks.ORANGE_STANDING_SIGN.get(), ModBlocks.ORANGE_WALL_SIGN.get(), modLoc("block/orange_sign"));
        hangingSignBlock(ModBlocks.ORANGE_CEILING_HANGING_SIGN.get(), ModBlocks.ORANGE_WALL_HANGING_SIGN.get(), modLoc("block/orange_hanging_sign"));
        //endregion

        //region Pear wood set
        leavesBlock(ModBlocks.PEAR_LEAVES);
        logBlock((RotatedPillarBlock) ModBlocks.PEAR_LOG.get());
        blockItem(ModBlocks.PEAR_LOG);
        logBlock((RotatedPillarBlock) ModBlocks.STRIPPED_PEAR_LOG.get());
        blockItem(ModBlocks.STRIPPED_PEAR_LOG);
        axisBlock((RotatedPillarBlock) ModBlocks.PEAR_WOOD.get(), blockTexture(ModBlocks.PEAR_LOG.get()), blockTexture(ModBlocks.PEAR_LOG.get()));
        blockItem(ModBlocks.PEAR_WOOD);
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_PEAR_WOOD.get(), blockTexture(ModBlocks.STRIPPED_PEAR_LOG.get()), blockTexture(ModBlocks.STRIPPED_PEAR_LOG.get()));
        blockItem(ModBlocks.STRIPPED_PEAR_WOOD);
        saplingBlock(ModBlocks.PEAR_SAPLING);
        simpleBlockWithItem(ModBlocks.POTTED_PEAR_SAPLING.get(), models().singleTexture("potted_pear_sapling", ResourceLocation.fromNamespaceAndPath("minecraft","flower_pot_cross"), "plant", blockTexture(ModBlocks.PEAR_SAPLING.get())).renderType("cutout"));
        blockWithItem(ModBlocks.PEAR_PLANKS);
        stairsBlock(ModBlocks.PEAR_STAIRS.get(), blockTexture(ModBlocks.PEAR_PLANKS.get()));
        blockItem(ModBlocks.PEAR_STAIRS);
        slabBlock(ModBlocks.PEAR_SLAB.get(), blockTexture(ModBlocks.PEAR_PLANKS.get()), blockTexture(ModBlocks.PEAR_PLANKS.get()));
        blockItem(ModBlocks.PEAR_SLAB);
        buttonBlock(ModBlocks.PEAR_BUTTON.get(), blockTexture(ModBlocks.PEAR_PLANKS.get()));
        pressurePlateBlock(ModBlocks.PEAR_PRESSURE_PLATE.get(), blockTexture(ModBlocks.PEAR_PLANKS.get()));
        blockItem(ModBlocks.PEAR_PRESSURE_PLATE);
        fenceBlock(ModBlocks.PEAR_FENCE.get(), blockTexture(ModBlocks.PEAR_PLANKS.get()));
        fenceGateBlock(ModBlocks.PEAR_FENCE_GATE.get(), blockTexture(ModBlocks.PEAR_PLANKS.get()));
        blockItem(ModBlocks.PEAR_FENCE_GATE);
        doorBlockWithRenderType(ModBlocks.PEAR_DOOR.get(), modLoc("block/pear_door_bottom"), modLoc("block/pear_door_top"), "solid");
        trapdoorBlockWithRenderType(ModBlocks.PEAR_TRAPDOOR.get(), modLoc("block/pear_trapdoor"), true, "solid");
        blockItem(ModBlocks.PEAR_TRAPDOOR, "_bottom");
        signBlock(ModBlocks.PEAR_STANDING_SIGN.get(), ModBlocks.PEAR_WALL_SIGN.get(), modLoc("block/pear_sign"));
        hangingSignBlock(ModBlocks.PEAR_CEILING_HANGING_SIGN.get(), ModBlocks.PEAR_WALL_HANGING_SIGN.get(), modLoc("block/pear_hanging_sign"));
        //endregion

        //region Flowers
        simpleBlockWithItem(ModBlocks.POTTED_CYAN_ROSE.get(), models().singleTexture("potted_cyan_rose", ResourceLocation.fromNamespaceAndPath("minecraft","flower_pot_cross"), "plant", blockTexture(ModBlocks.CYAN_ROSE.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.POTTED_PEONIA.get(), models().singleTexture("potted_peonia", ResourceLocation.fromNamespaceAndPath("minecraft","flower_pot_cross"), "plant", blockTexture(ModBlocks.PEONIA.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.POTTED_ROSE.get(), models().singleTexture("potted_rose", ResourceLocation.fromNamespaceAndPath("minecraft","flower_pot_cross"), "plant", blockTexture(ModBlocks.ROSE.get())).renderType("cutout"));
        //endregion
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("ultimateedition:block/" + deferredBlock.getId().getPath()));
    }
    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("ultimateedition:block/" + deferredBlock.getId().getPath() + appendix));
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void leavesBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), models().leaves(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())));
    }
    private void untintedLeavesBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), models().singleTexture(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), ResourceLocation.parse("minecraft:block/leaves"), "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void saplingBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(), models().cross(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }
}