package com.studiodragon.ultimateedition.worldgen;

import com.studiodragon.ultimateedition.UltimateEdition;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_APPLE_TREE = registerKey("add_apple_tree");
    public static final ResourceKey<BiomeModifier> ADD_ORANGE_TREE = registerKey("add_orange_tree");
    public static final ResourceKey<BiomeModifier> ADD_PEAR_TREE = registerKey("add_pear_tree");

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_APPLE_TREE, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(
                        biomes.getOrThrow(Biomes.FOREST),
                        biomes.getOrThrow(Biomes.FLOWER_FOREST),
                        biomes.getOrThrow(Biomes.WINDSWEPT_FOREST)
                ),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.APPLE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));

        context.register(ADD_ORANGE_TREE, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(
                        biomes.getOrThrow(Biomes.JUNGLE),
                        biomes.getOrThrow(Biomes.SPARSE_JUNGLE)
                ),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.ORANGE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));

        context.register(ADD_PEAR_TREE, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(
                        biomes.getOrThrow(Biomes.CHERRY_GROVE),
                        biomes.getOrThrow(Biomes.WINDSWEPT_FOREST),
                        biomes.getOrThrow(Biomes.SPARSE_JUNGLE)
                ),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.PEAR_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(UltimateEdition.MOD_ID, name));
    }
}
