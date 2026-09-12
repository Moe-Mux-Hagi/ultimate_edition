package com.studiodragon.ultimateedition.datagen;

import com.studiodragon.ultimateedition.UltimateEdition;
import com.studiodragon.ultimateedition.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, UltimateEdition.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.ACORN.get());
        basicItem(ModItems.CATKIN.get());
        basicItem(ModItems.CHERRIES.get());
        basicItem(ModItems.DARK_ACORN.get());
        basicItem(ModItems.PINE_NUTS.get());
        basicItem(ModItems.PINECONE.get());
        basicItem(ModItems.POD.get());
        basicItem(ModItems.ROASTED_ACORN.get());
        basicItem(ModItems.ROASTED_DARK_ACORN.get());
        basicItem(ModItems.ROASTED_PINE_NUTS.get());
        basicItem(ModItems.SKY_FRUIT.get());

        withExistingParent(ModItems.EVERSOURCE_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }
}