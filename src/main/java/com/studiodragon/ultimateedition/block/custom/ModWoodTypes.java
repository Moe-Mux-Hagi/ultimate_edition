package com.studiodragon.ultimateedition.block.custom;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModWoodTypes {
    public static final BlockSetType APPLE_WOOD_SET = new BlockSetType(ResourceLocation.fromNamespaceAndPath("ultimateedition", "apple").toString());
    public static final BlockSetType AZALEA_WOOD_SET = new BlockSetType(ResourceLocation.fromNamespaceAndPath("ultimateedition", "azalea").toString());
    public static final BlockSetType ORANGE_WOOD_SET = new BlockSetType(ResourceLocation.fromNamespaceAndPath("ultimateedition", "orange").toString());
    public static final BlockSetType PEAR_WOOD_SET = new BlockSetType(ResourceLocation.fromNamespaceAndPath("ultimateedition", "pear").toString());

    public static final WoodType APPLE = WoodType.register(new WoodType((ResourceLocation.fromNamespaceAndPath("ultimateedition", "apple")).toString(), APPLE_WOOD_SET));
    public static final WoodType AZALEA = WoodType.register(new WoodType((ResourceLocation.fromNamespaceAndPath("ultimateedition", "azalea")).toString(), AZALEA_WOOD_SET));
    public static final WoodType ORANGE = WoodType.register(new WoodType((ResourceLocation.fromNamespaceAndPath("ultimateedition", "orange")).toString(), ORANGE_WOOD_SET));
    public static final WoodType PEAR = WoodType.register(new WoodType((ResourceLocation.fromNamespaceAndPath("ultimateedition", "pear")).toString(), PEAR_WOOD_SET));
}