package com.studiodragon.ultimateedition.datagen;

import com.studiodragon.ultimateedition.UltimateEdition;
import com.studiodragon.ultimateedition.block.ModBlocks;
import com.studiodragon.ultimateedition.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, UltimateEdition.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //region Fruits (vanilla trees)
        basicItem(ModItems.ACORN.get());
        basicItem(ModItems.CATKIN.get());
        basicItem(ModItems.CHERRIES.get());
        basicItem(ModItems.DARK_ACORN.get());
        basicItem(ModItems.PINECONE.get());
        basicItem(ModItems.POD.get());
        basicItem(ModItems.SKY_FRUIT.get());
        //endregion

        //region Misc food
        basicItem(ModItems.PINE_NUTS.get());
        basicItem(ModItems.ROASTED_ACORN.get());
        basicItem(ModItems.ROASTED_DARK_ACORN.get());
        basicItem(ModItems.ROASTED_PINE_NUTS.get());
        //endregion

        //region Apple items
        basicItem(ModItems.APPLE_BOAT.get());
        basicItem(ModItems.APPLE_CHEST_BOAT.get());
        basicItem(ModBlocks.APPLE_DOOR.get().asItem());
        basicItem(ModItems.APPLE_SIGN.get());
        basicItem(ModItems.APPLE_HANGING_SIGN.get());
        buttonItem(ModBlocks.APPLE_BUTTON, ModBlocks.APPLE_PLANKS);
        fenceItem(ModBlocks.APPLE_FENCE, ModBlocks.APPLE_PLANKS);
        saplingItem(ModBlocks.APPLE_SAPLING);
        //endregion

        //region Azalea items
        basicItem(ModItems.AZALEA_BOAT.get());
        basicItem(ModItems.AZALEA_CHEST_BOAT.get());
        basicItem(ModBlocks.AZALEA_DOOR.get().asItem());
        basicItem(ModItems.AZALEA_SIGN.get());
        basicItem(ModItems.AZALEA_HANGING_SIGN.get());
        buttonItem(ModBlocks.AZALEA_BUTTON, ModBlocks.AZALEA_PLANKS);
        fenceItem(ModBlocks.AZALEA_FENCE, ModBlocks.AZALEA_PLANKS);
        //endregion

        //region Orange items
        basicItem(ModItems.ORANGE.get());
        basicItem(ModItems.ORANGE_BOAT.get());
        basicItem(ModItems.ORANGE_CHEST_BOAT.get());
        basicItem(ModBlocks.ORANGE_DOOR.get().asItem());
        basicItem(ModItems.ORANGE_SIGN.get());
        basicItem(ModItems.ORANGE_HANGING_SIGN.get());
        buttonItem(ModBlocks.ORANGE_BUTTON, ModBlocks.ORANGE_PLANKS);
        fenceItem(ModBlocks.ORANGE_FENCE, ModBlocks.ORANGE_PLANKS);
        saplingItem(ModBlocks.ORANGE_SAPLING);
        //endregion

        //region Pear items
        basicItem(ModItems.PEAR.get());
        basicItem(ModItems.PEAR_BOAT.get());
        basicItem(ModItems.PEAR_CHEST_BOAT.get());
        basicItem(ModBlocks.PEAR_DOOR.get().asItem());
        basicItem(ModItems.PEAR_SIGN.get());
        basicItem(ModItems.PEAR_HANGING_SIGN.get());
        buttonItem(ModBlocks.PEAR_BUTTON, ModBlocks.PEAR_PLANKS);
        fenceItem(ModBlocks.PEAR_FENCE, ModBlocks.PEAR_PLANKS);
        saplingItem(ModBlocks.PEAR_SAPLING);
        //endregion

        withExistingParent(ModItems.EVERSOURCE_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }

    public void buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory")).texture("texture", ResourceLocation.fromNamespaceAndPath(UltimateEdition.MOD_ID, "block/" + baseBlock.getId().getPath()));
    }

    public void fenceItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory")).texture("texture", ResourceLocation.fromNamespaceAndPath(UltimateEdition.MOD_ID, "block/" + baseBlock.getId().getPath()));
    }

    public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory")).texture("wall", ResourceLocation.fromNamespaceAndPath(UltimateEdition.MOD_ID, "block/" + baseBlock.getId().getPath()));
    }

    private ItemModelBuilder saplingItem(DeferredBlock<Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0", ResourceLocation.fromNamespaceAndPath(UltimateEdition.MOD_ID, "block/" + item.getId().getPath()));
    }
}