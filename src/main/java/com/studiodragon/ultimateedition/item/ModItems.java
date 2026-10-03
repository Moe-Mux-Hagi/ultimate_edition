package com.studiodragon.ultimateedition.item;

import com.studiodragon.ultimateedition.ModEnumParams;
import com.studiodragon.ultimateedition.UltimateEdition;
import com.studiodragon.ultimateedition.block.ModBlocks;
import com.studiodragon.ultimateedition.entity.ModEntities;
import com.studiodragon.ultimateedition.item.custom.EversourceCrownItem;
import com.studiodragon.ultimateedition.world.level.item.FruitItem;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.studiodragon.ultimateedition.block.ModBlocks.*;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(UltimateEdition.MOD_ID);

    //region Boats
    public static final DeferredItem<BoatItem> APPLE_BOAT = ITEMS.register("apple_boat",
            () -> new BoatItem(false, ModEnumParams.APPLE_BOAT_TYPE.getValue(), new Item.Properties()
                    .stacksTo(1)));
    public static final DeferredItem<BoatItem> APPLE_CHEST_BOAT = ITEMS.register("apple_chest_boat",
            () -> new BoatItem(true, ModEnumParams.APPLE_BOAT_TYPE.getValue(), new Item.Properties()
                    .stacksTo(1)));

    public static final DeferredItem<BoatItem> AZALEA_BOAT = ITEMS.register("azalea_boat",
            () -> new BoatItem(false, ModEnumParams.AZALEA_BOAT_TYPE.getValue(), new Item.Properties()
                    .stacksTo(1)));
    public static final DeferredItem<BoatItem> AZALEA_CHEST_BOAT = ITEMS.register("azalea_chest_boat",
            () -> new BoatItem(true, ModEnumParams.AZALEA_BOAT_TYPE.getValue(), new Item.Properties()
                    .stacksTo(1)));

    public static final DeferredItem<BoatItem> ORANGE_BOAT = ITEMS.register("orange_boat",
            () -> new BoatItem(false, ModEnumParams.ORANGE_BOAT_TYPE.getValue(), new Item.Properties()
                    .stacksTo(1)));
    public static final DeferredItem<BoatItem> ORANGE_CHEST_BOAT = ITEMS.register("orange_chest_boat",
            () -> new BoatItem(true, ModEnumParams.ORANGE_BOAT_TYPE.getValue(), new Item.Properties()
                    .stacksTo(1)));

    public static final DeferredItem<BoatItem> PEAR_BOAT = ITEMS.register("pear_boat",
            () -> new BoatItem(false, ModEnumParams.PEAR_BOAT_TYPE.getValue(), new Item.Properties()
                    .stacksTo(1)));
    public static final DeferredItem<BoatItem> PEAR_CHEST_BOAT = ITEMS.register("pear_chest_boat",
            () -> new BoatItem(true, ModEnumParams.PEAR_BOAT_TYPE.getValue(), new Item.Properties()
                    .stacksTo(1)));
    //endregion

    //region Food
    public static final DeferredItem<Item> ROASTED_ACORN = ITEMS.register("roasted_acorn",
            () -> new Item(new Item.Properties()
                    .food(ModFoodProperties.ROASTED_NUT)));
    public static final DeferredItem<Item> ROASTED_DARK_ACORN = ITEMS.register("roasted_dark_acorn",
            () -> new Item(new Item.Properties()
                    .food(ModFoodProperties.ROASTED_NUT)));
    public static final DeferredItem<Item> ROASTED_PINE_NUTS = ITEMS.register("roasted_pine_nuts",
            () -> new Item(new Item.Properties()
                    .food(ModFoodProperties.ROASTED_NUT)));
    //endregion

    //region Fruits
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
    public static final DeferredItem<Item> ORANGE = ITEMS.register("orange",
            () -> new FruitItem(new Item.Properties()
                    .food(ModFoodProperties.APPLE)) {
                @Override
                protected Block getSapling() {
                    return ModBlocks.ORANGE_SAPLING.get();
                }
            });
    public static final DeferredItem<Item> PEAR = ITEMS.register("pear",
            () -> new FruitItem(new Item.Properties()
                    .food(ModFoodProperties.APPLE)) {
                @Override
                protected Block getSapling() {
                    return ModBlocks.PEAR_SAPLING.get();
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
    //endregion

    //region Signs
    public static final DeferredItem<SignItem> APPLE_SIGN = ITEMS.register("apple_sign",
            () -> new SignItem((new Item.Properties())
                    .stacksTo(16), APPLE_STANDING_SIGN.get(), APPLE_WALL_SIGN.get()
            )
    );
    public static final DeferredItem<HangingSignItem> APPLE_HANGING_SIGN = ITEMS.register("apple_hanging_sign",
            () -> new HangingSignItem(APPLE_CEILING_HANGING_SIGN.get(), APPLE_WALL_HANGING_SIGN.get(), (new Item.Properties())
                    .stacksTo(16)
            )
    );

    public static final DeferredItem<SignItem> AZALEA_SIGN = ITEMS.register("azalea_sign",
            () -> new SignItem((new Item.Properties())
                    .stacksTo(16), AZALEA_STANDING_SIGN.get(), AZALEA_WALL_SIGN.get()
            )
    );
    public static final DeferredItem<HangingSignItem> AZALEA_HANGING_SIGN = ITEMS.register("azalea_hanging_sign",
            () -> new HangingSignItem(AZALEA_CEILING_HANGING_SIGN.get(), AZALEA_WALL_HANGING_SIGN.get(), (new Item.Properties())
                    .stacksTo(16)
            )
    );

    public static final DeferredItem<SignItem> ORANGE_SIGN = ITEMS.register("orange_sign",
            () -> new SignItem((new Item.Properties())
                    .stacksTo(16), ORANGE_STANDING_SIGN.get(), ORANGE_WALL_SIGN.get()
            )
    );
    public static final DeferredItem<HangingSignItem> ORANGE_HANGING_SIGN = ITEMS.register("orange_hanging_sign",
            () -> new HangingSignItem(ORANGE_CEILING_HANGING_SIGN.get(), ORANGE_WALL_HANGING_SIGN.get(), (new Item.Properties())
                    .stacksTo(16)
            )
    );

    public static final DeferredItem<SignItem> PEAR_SIGN = ITEMS.register("pear_sign",
            () -> new SignItem((new Item.Properties())
                    .stacksTo(16), PEAR_STANDING_SIGN.get(), PEAR_WALL_SIGN.get()
            )
    );
    public static final DeferredItem<HangingSignItem> PEAR_HANGING_SIGN = ITEMS.register("pear_hanging_sign",
            () -> new HangingSignItem(PEAR_CEILING_HANGING_SIGN.get(), PEAR_WALL_HANGING_SIGN.get(), (new Item.Properties())
                    .stacksTo(16)
            )
    );
    //endregion

    //region Misc
    public static final DeferredItem<Item> EVERSOURCE_CROWN = ITEMS.register("eversource_crown",
            () -> new EversourceCrownItem(new Item.Properties()
                    .rarity(Rarity.EPIC)
                    .fireResistant()));

    public static final DeferredItem<Item> EVERSOURCE_SPAWN_EGG = ITEMS.register("eversource_spawn_egg",
            () -> new DeferredSpawnEggItem(ModEntities.EVERSOURCE, 0xFFFFFF, 0xFF0000,
                    new Item.Properties()));
    //endregion

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}