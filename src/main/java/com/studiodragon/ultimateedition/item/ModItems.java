package com.studiodragon.ultimateedition.item;

import com.studiodragon.ultimateedition.UltimateEdition;
import com.studiodragon.ultimateedition.entity.ModEntities;
import com.studiodragon.ultimateedition.item.custom.EversourceCrownItem;
import com.studiodragon.ultimateedition.world.level.item.FruitItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(UltimateEdition.MOD_ID);

    //Food
    public static final DeferredItem<Item> ROASTED_ACORN = ITEMS.register("roasted_acorn",
            () -> new Item(new Item.Properties()
                    .food(ModFoodProperties.ROASTED_NUT)));
    public static final DeferredItem<Item> ROASTED_DARK_ACORN = ITEMS.register("roasted_dark_acorn",
            () -> new Item(new Item.Properties()
                    .food(ModFoodProperties.ROASTED_NUT)));
    public static final DeferredItem<Item> ROASTED_PINE_NUTS = ITEMS.register("roasted_pine_nuts",
            () -> new Item(new Item.Properties()
                    .food(ModFoodProperties.ROASTED_NUT)));

    //Fruits
    public static final DeferredItem<Item> ACORN = ITEMS.register("acorn",
            () -> new FruitItem(new Item.Properties()
                    .food(ModFoodProperties.NUT)) {
                @Override
                protected Block getSapling() {
                    return Blocks.OAK_SAPLING;
                }
            });
    public static final DeferredItem<Item> CATKIN = ITEMS.register("catkin",
            () -> new FruitItem(new Item.Properties()) {
                @Override
                protected Block getSapling() {
                    return Blocks.BIRCH_SAPLING;
                }
            });
    public static final DeferredItem<Item> CHERRIES = ITEMS.register("cherries",
            () -> new FruitItem(new Item.Properties()
                    .food(ModFoodProperties.BERRY)) {
                @Override
                protected Block getSapling() {
                    return Blocks.CHERRY_SAPLING;
                }
            });
    public static final DeferredItem<Item> DARK_ACORN = ITEMS.register("dark_acorn",
            () -> new FruitItem(new Item.Properties()
                    .food(ModFoodProperties.DARK_ACORN)) {
                @Override
                protected Block getSapling() {
                    return Blocks.DARK_OAK_SAPLING;
                }
            });
    public static final DeferredItem<Item> PINECONE = ITEMS.register("pinecone",
            () -> new FruitItem(new Item.Properties()) {
                @Override
                protected Block getSapling() {
                    return Blocks.SPRUCE_SAPLING;
                }
            });
    public static final DeferredItem<Item> PINE_NUTS = ITEMS.register("pine_nuts",
            () -> new FruitItem(new Item.Properties()
                    .food(ModFoodProperties.NUT)) {
                @Override
                protected Block getSapling() {
                    return Blocks.SPRUCE_SAPLING;
                }
            });
    public static final DeferredItem<Item> POD = ITEMS.register("pod",
            () -> new FruitItem(new Item.Properties()
                    .food(ModFoodProperties.POD)) {
                @Override
                protected Block getSapling() {
                    return Blocks.ACACIA_SAPLING;
                }
            });
    public static final DeferredItem<Item> SKY_FRUIT = ITEMS.register("sky_fruit",
            () -> new FruitItem(new Item.Properties()
                    .food(ModFoodProperties.SKY_FRUIT)) {
                @Override
                protected Block getSapling() {
                    return Blocks.JUNGLE_SAPLING;
                }
            });

    //Misc
    public static final DeferredItem<Item> EVERSOURCE_CROWN = ITEMS.register("eversource_crown",
            () -> new EversourceCrownItem(new Item.Properties()
                    .rarity(Rarity.EPIC)));

    public static final DeferredItem<Item> EVERSOURCE_SPAWN_EGG = ITEMS.register("eversource_spawn_egg",
            () -> new DeferredSpawnEggItem(ModEntities.EVERSOURCE, 0xFFFFFF, 0xFF0000,
                    new Item.Properties()));

    //Apple override
    /*public static final DeferredRegister.Items VANILLA_OVERRIDE = DeferredRegister.createItems("minecraft");
    public static final DeferredItem<Item> APPLE = VANILLA_OVERRIDE.register("apple",
            () -> new FruitItem(new Item.Properties()
                    .food(ModFoodProperties.APPLE)) {
                @Override
                protected Block getSapling() {
            return Blocks.OAK_SAPLING;
        }
            });*/

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}