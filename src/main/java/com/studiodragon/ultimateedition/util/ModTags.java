package com.studiodragon.ultimateedition.util;

import com.studiodragon.ultimateedition.UltimateEdition;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> FLOWERING_LEAVES =
                //net.minecraft.tags.TagKey.create(net.minecraft.core.registries.Registries.BLOCK, net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ultimateedition", "flowering_leaves"));
                createTag("flowering_leaves");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(UltimateEdition.MOD_ID, name));
        }
    }

    public static class Entities {
        public static final TagKey<EntityType<?>> EVERSOURCE_CROWNABLES = createTag("eversource_crownables");

        private static TagKey<EntityType<?>> createTag(String name) {
            return TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(UltimateEdition.MOD_ID, name));
        }
    }

    public static class Items {
        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(UltimateEdition.MOD_ID, name));
        }
    }
}