package com.studiodragon.ultimateedition;

import com.studiodragon.ultimateedition.block.ModBlocks;
import com.studiodragon.ultimateedition.item.ModItems;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Items;
import net.neoforged.fml.common.asm.enumextension.EnumProxy;

public class ModEnumParams {
    //region Boat Type
    public static final EnumProxy<Boat.Type> APPLE_BOAT_TYPE = new EnumProxy<>(
            Boat.Type.class, ModBlocks.APPLE_PLANKS, "ultimateedition:apple", ModItems.APPLE_BOAT, ModItems.APPLE_CHEST_BOAT, Items.STICK, false
    );
    public static final EnumProxy<Boat.Type> AZALEA_BOAT_TYPE = new EnumProxy<>(
            Boat.Type.class, ModBlocks.AZALEA_PLANKS, "ultimateedition:azalea", ModItems.AZALEA_BOAT, ModItems.AZALEA_CHEST_BOAT, Items.STICK, false
    );
    public static final EnumProxy<Boat.Type> ORANGE_BOAT_TYPE = new EnumProxy<>(
            Boat.Type.class, ModBlocks.ORANGE_PLANKS, "ultimateedition:orange", ModItems.ORANGE_BOAT, ModItems.ORANGE_CHEST_BOAT, Items.STICK, false
    );
    public static final EnumProxy<Boat.Type> PEAR_BOAT_TYPE = new EnumProxy<>(
            Boat.Type.class, ModBlocks.PEAR_PLANKS, "ultimateedition:pear", ModItems.PEAR_BOAT, ModItems.PEAR_CHEST_BOAT, Items.STICK, false
    );
    //endregion
}