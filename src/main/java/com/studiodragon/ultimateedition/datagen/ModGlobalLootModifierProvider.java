package com.studiodragon.ultimateedition.datagen;

import com.studiodragon.ultimateedition.UltimateEdition;
import com.studiodragon.ultimateedition.item.ModItems;
import com.studiodragon.ultimateedition.loot.AddItemModifier;
import com.studiodragon.ultimateedition.loot.RemoveItemModifier;
import com.studiodragon.ultimateedition.loot.RemoveTaggedItemsModifier;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.*;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;

import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, UltimateEdition.MOD_ID);
    }

    @Override
    protected void start() {
        LootItemBlockStatePropertyCondition.Builder oakLeavesCondition = LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.OAK_LEAVES);
        LootItemBlockStatePropertyCondition.Builder birchLeavesCondition = LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.BIRCH_LEAVES);
        LootItemBlockStatePropertyCondition.Builder spruceLeavesCondition = LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.SPRUCE_LEAVES);
        LootItemBlockStatePropertyCondition.Builder jungleLeavesCondition = LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.JUNGLE_LEAVES);
        LootItemBlockStatePropertyCondition.Builder acaciaLeavesCondition = LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.ACACIA_LEAVES);
        LootItemBlockStatePropertyCondition.Builder darkOakLeavesCondition = LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DARK_OAK_LEAVES);
        LootItemBlockStatePropertyCondition.Builder cherryLeavesCondition = LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.CHERRY_LEAVES);

        this.add("add_acorn",
                new AddItemModifier(
                        new LootItemCondition[] {
                                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.OAK_LEAVES).build(),
                                LootItemRandomChanceCondition.randomChance(0.2f).build()
                        },
                        ModItems.ACORN.get()
                )
        );
        this.add("add_catkin",
                new AddItemModifier(
                        new LootItemCondition[] {
                                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.BIRCH_LEAVES).build(),
                                LootItemRandomChanceCondition.randomChance(0.2f).build()
                        },
                        ModItems.CATKIN.get()
                )
        );
        this.add("add_pinecone",
                new AddItemModifier(
                        new LootItemCondition[] {
                                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.SPRUCE_LEAVES).build(),
                                LootItemRandomChanceCondition.randomChance(0.2f).build()
                        },
                        ModItems.PINECONE.get()
                )
        );
        this.add("add_jungle",
                new AddItemModifier(
                        new LootItemCondition[] {
                                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.JUNGLE_LEAVES).build(),
                                LootItemRandomChanceCondition.randomChance(0.2f).build()
                        },
                        ModItems.SKY_FRUIT.get()
                )
        );
        this.add("add_pod",
                new AddItemModifier(
                        new LootItemCondition[] {
                                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.ACACIA_LEAVES).build(),
                                LootItemRandomChanceCondition.randomChance(0.2f).build()
                        },
                        ModItems.POD.get()
                )
        );
        this.add("add_dark_acorn",
                new AddItemModifier(
                        new LootItemCondition[] {
                                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DARK_OAK_LEAVES).build(),
                                LootItemRandomChanceCondition.randomChance(0.2f).build()
                        },
                        ModItems.DARK_ACORN.get()
                )
        );
        this.add("add_cherries",
                new AddItemModifier(
                        new LootItemCondition[] {
                                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.CHERRY_LEAVES).build(),
                                LootItemRandomChanceCondition.randomChance(0.2f).build()
                        },
                        ModItems.CHERRIES.get()
                )
        );

        LootItemCondition[] anyTreeTypeCondition = new LootItemCondition[] {
                AnyOfCondition.anyOf(
                        oakLeavesCondition,
                        birchLeavesCondition,
                        spruceLeavesCondition,
                        jungleLeavesCondition,
                        acaciaLeavesCondition,
                        darkOakLeavesCondition,
                        cherryLeavesCondition
                ).build()
        };
        this.add("remove_saplings",
                new RemoveTaggedItemsModifier(anyTreeTypeCondition, ItemTags.SAPLINGS)
        );

        LootItemCondition[] oakTypeCondition = new LootItemCondition[] {
                AnyOfCondition.anyOf(oakLeavesCondition, darkOakLeavesCondition).build()
        };
        this.add("remove_apple",
                new RemoveItemModifier(oakTypeCondition, Items.APPLE)
        );
    }
}