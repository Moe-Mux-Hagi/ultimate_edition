package com.studiodragon.ultimateedition.worldgen.tree;

import com.studiodragon.ultimateedition.UltimateEdition;
import com.studiodragon.ultimateedition.worldgen.ModConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower APPLE = new TreeGrower(UltimateEdition.MOD_ID + ":apple",
            Optional.empty(), Optional.of(ModConfiguredFeatures.APPLE_KEY), Optional.empty()
    );

    public static final TreeGrower ORANGE = new TreeGrower(UltimateEdition.MOD_ID + ":orange",
            Optional.empty(), Optional.of(ModConfiguredFeatures.ORANGE_KEY), Optional.empty()
    );

    public static final TreeGrower PEAR = new TreeGrower(UltimateEdition.MOD_ID + ":pear",
            Optional.empty(), Optional.of(ModConfiguredFeatures.PEAR_KEY), Optional.empty()
    );
}
