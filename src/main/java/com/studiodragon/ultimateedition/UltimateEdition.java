package com.studiodragon.ultimateedition;

import com.studiodragon.ultimateedition.block.ModBlocks;
import com.studiodragon.ultimateedition.entity.ModEntities;
import com.studiodragon.ultimateedition.entity.client.EversourceRenderer;
import com.studiodragon.ultimateedition.entity.client.LegendaryPigRenderer;
import com.studiodragon.ultimateedition.event.Dispenser;
import com.studiodragon.ultimateedition.item.ModItems;
import com.studiodragon.ultimateedition.loot.ModLootModifiers;
import com.studiodragon.ultimateedition.potion.ModPotions;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.*;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(UltimateEdition.MOD_ID)
public class UltimateEdition {
    public static final String MOD_ID = "ultimateedition";
    public static final Logger LOGGER = LogUtils.getLogger();

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public UltimateEdition(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        //ModEventBus registry
        NeoForge.EVENT_BUS.register(this);

        ModBlocks.register(modEventBus);
        ModEntities.register(modEventBus);
        ModItems.register(modEventBus);
        ModLootModifiers.register(modEventBus);
        ModPotions.register(modEventBus);

        modEventBus.addListener(this::addCreative);
        modEventBus.addListener(this::commonSetup);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            DispenserBlock.registerBehavior(Items.BONE_MEAL, new Dispenser());
            DispenserBlock.registerBehavior(Items.SHEARS, new Dispenser());
            //region Potted plants
            ((FlowerPotBlock) Blocks.FLOWER_POT)
                    .addPlant(ModBlocks.CYAN_ROSE.getId(),ModBlocks.POTTED_CYAN_ROSE);
            ((FlowerPotBlock) Blocks.FLOWER_POT)
                    .addPlant(ModBlocks.PEONIA.getId(),ModBlocks.POTTED_PEONIA);
            ((FlowerPotBlock) Blocks.FLOWER_POT)
                    .addPlant(ModBlocks.ROSE.getId(),ModBlocks.POTTED_ROSE);
            //region Saplings
            ((FlowerPotBlock) Blocks.FLOWER_POT)
                    .addPlant(ModBlocks.APPLE_SAPLING.getId(),ModBlocks.POTTED_APPLE_SAPLING);
            ((FlowerPotBlock) Blocks.FLOWER_POT)
                    .addPlant(ModBlocks.ORANGE_SAPLING.getId(),ModBlocks.POTTED_ORANGE_SAPLING);
            ((FlowerPotBlock) Blocks.FLOWER_POT)
                    .addPlant(ModBlocks.PEAR_SAPLING.getId(),ModBlocks.POTTED_PEAR_SAPLING);
            //endregion
            //endregion
        });
    }

    //Creative Tab registries
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            //region Apple building blocks
            event.insertAfter(Blocks.CHERRY_BUTTON.asItem().getDefaultInstance(),
                    ModBlocks.APPLE_LOG.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.APPLE_LOG.asItem().getDefaultInstance(),
                    ModBlocks.APPLE_WOOD.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.APPLE_WOOD.asItem().getDefaultInstance(),
                    ModBlocks.STRIPPED_APPLE_LOG.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.STRIPPED_APPLE_LOG.asItem().getDefaultInstance(),
                    ModBlocks.STRIPPED_APPLE_WOOD.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.STRIPPED_APPLE_WOOD.asItem().getDefaultInstance(),
                    ModBlocks.APPLE_PLANKS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.APPLE_PLANKS.asItem().getDefaultInstance(),
                    ModBlocks.APPLE_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.APPLE_STAIRS.asItem().getDefaultInstance(),
                    ModBlocks.APPLE_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.APPLE_SLAB.asItem().getDefaultInstance(),
                    ModBlocks.APPLE_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.APPLE_FENCE.asItem().getDefaultInstance(),
                    ModBlocks.APPLE_FENCE_GATE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.APPLE_FENCE_GATE.asItem().getDefaultInstance(),
                    ModBlocks.APPLE_DOOR.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.APPLE_DOOR.asItem().getDefaultInstance(),
                    ModBlocks.APPLE_TRAPDOOR.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.APPLE_TRAPDOOR.asItem().getDefaultInstance(),
                    ModBlocks.APPLE_PRESSURE_PLATE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.APPLE_PRESSURE_PLATE.asItem().getDefaultInstance(),
                    ModBlocks.APPLE_BUTTON.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            //endregion

            //region Pear building blocks
            event.insertAfter(ModBlocks.APPLE_BUTTON.asItem().getDefaultInstance(),
                    ModBlocks.PEAR_LOG.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.PEAR_LOG.asItem().getDefaultInstance(),
                    ModBlocks.PEAR_WOOD.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.PEAR_WOOD.asItem().getDefaultInstance(),
                    ModBlocks.STRIPPED_PEAR_LOG.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.STRIPPED_PEAR_LOG.asItem().getDefaultInstance(),
                    ModBlocks.STRIPPED_PEAR_WOOD.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.STRIPPED_PEAR_WOOD.asItem().getDefaultInstance(),
                    ModBlocks.PEAR_PLANKS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.PEAR_PLANKS.asItem().getDefaultInstance(),
                    ModBlocks.PEAR_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.PEAR_STAIRS.asItem().getDefaultInstance(),
                    ModBlocks.PEAR_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.PEAR_SLAB.asItem().getDefaultInstance(),
                    ModBlocks.PEAR_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.PEAR_FENCE.asItem().getDefaultInstance(),
                    ModBlocks.PEAR_FENCE_GATE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.PEAR_FENCE_GATE.asItem().getDefaultInstance(),
                    ModBlocks.PEAR_DOOR.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.PEAR_DOOR.asItem().getDefaultInstance(),
                    ModBlocks.PEAR_TRAPDOOR.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.PEAR_TRAPDOOR.asItem().getDefaultInstance(),
                    ModBlocks.PEAR_PRESSURE_PLATE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.PEAR_PRESSURE_PLATE.asItem().getDefaultInstance(),
                    ModBlocks.PEAR_BUTTON.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            //endregion

            //region Orange building blocks
            event.insertAfter(ModBlocks.PEAR_BUTTON.asItem().getDefaultInstance(),
                    ModBlocks.ORANGE_LOG.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.ORANGE_LOG.asItem().getDefaultInstance(),
                    ModBlocks.ORANGE_WOOD.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.ORANGE_WOOD.asItem().getDefaultInstance(),
                    ModBlocks.STRIPPED_ORANGE_LOG.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.STRIPPED_ORANGE_LOG.asItem().getDefaultInstance(),
                    ModBlocks.STRIPPED_ORANGE_WOOD.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.STRIPPED_ORANGE_WOOD.asItem().getDefaultInstance(),
                    ModBlocks.ORANGE_PLANKS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.ORANGE_PLANKS.asItem().getDefaultInstance(),
                    ModBlocks.ORANGE_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.ORANGE_STAIRS.asItem().getDefaultInstance(),
                    ModBlocks.ORANGE_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.ORANGE_SLAB.asItem().getDefaultInstance(),
                    ModBlocks.ORANGE_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.ORANGE_FENCE.asItem().getDefaultInstance(),
                    ModBlocks.ORANGE_FENCE_GATE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.ORANGE_FENCE_GATE.asItem().getDefaultInstance(),
                    ModBlocks.ORANGE_DOOR.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.ORANGE_DOOR.asItem().getDefaultInstance(),
                    ModBlocks.ORANGE_TRAPDOOR.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.ORANGE_TRAPDOOR.asItem().getDefaultInstance(),
                    ModBlocks.ORANGE_PRESSURE_PLATE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.ORANGE_PRESSURE_PLATE.asItem().getDefaultInstance(),
                    ModBlocks.ORANGE_BUTTON.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            //endregion

            //region Azalea building blocks
            event.insertAfter(ModBlocks.ORANGE_BUTTON.asItem().getDefaultInstance(),
                    ModBlocks.AZALEA_LOG.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.AZALEA_LOG.asItem().getDefaultInstance(),
                    ModBlocks.AZALEA_WOOD.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.AZALEA_WOOD.asItem().getDefaultInstance(),
                    ModBlocks.STRIPPED_AZALEA_LOG.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.STRIPPED_AZALEA_LOG.asItem().getDefaultInstance(),
                    ModBlocks.STRIPPED_AZALEA_WOOD.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.STRIPPED_AZALEA_WOOD.asItem().getDefaultInstance(),
                    ModBlocks.AZALEA_PLANKS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.AZALEA_PLANKS.asItem().getDefaultInstance(),
                    ModBlocks.AZALEA_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.AZALEA_STAIRS.asItem().getDefaultInstance(),
                    ModBlocks.AZALEA_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.AZALEA_SLAB.asItem().getDefaultInstance(),
                    ModBlocks.AZALEA_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.AZALEA_FENCE.asItem().getDefaultInstance(),
                    ModBlocks.AZALEA_FENCE_GATE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.AZALEA_FENCE_GATE.asItem().getDefaultInstance(),
                    ModBlocks.AZALEA_DOOR.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.AZALEA_DOOR.asItem().getDefaultInstance(),
                    ModBlocks.AZALEA_TRAPDOOR.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.AZALEA_TRAPDOOR.asItem().getDefaultInstance(),
                    ModBlocks.AZALEA_PRESSURE_PLATE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.AZALEA_PRESSURE_PLATE.asItem().getDefaultInstance(),
                    ModBlocks.AZALEA_BUTTON.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            //endregion

            event.insertAfter(Blocks.BRICK_WALL.asItem().getDefaultInstance(),
                    ModBlocks.PLASTER.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }

        if (event.getTabKey() == CreativeModeTabs.COLORED_BLOCKS) {
            event.insertBefore(Blocks.TERRACOTTA.asItem().getDefaultInstance(),
                    ModBlocks.PLASTER.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }

        //if (event.getTabKey() == CreativeModeTabs.COMBAT) {}

        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.insertBefore(Items.APPLE.getDefaultInstance(),
                    ModItems.ACORN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.ACORN.get().getDefaultInstance(),
                    ModItems.ROASTED_ACORN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.ROASTED_ACORN.get().getDefaultInstance(),
                    ModItems.PINE_NUTS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.PINE_NUTS.get().getDefaultInstance(),
                    ModItems.ROASTED_PINE_NUTS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.ROASTED_PINE_NUTS.get().getDefaultInstance(),
                    ModItems.SKY_FRUIT.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.SKY_FRUIT.get().getDefaultInstance(),
                    ModItems.POD.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.POD.get().getDefaultInstance(),
                    ModItems.DARK_ACORN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.DARK_ACORN.get().getDefaultInstance(),
                    ModItems.ROASTED_DARK_ACORN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.ROASTED_DARK_ACORN.get().getDefaultInstance(),
                    ModItems.CHERRIES.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.insertAfter(Items.ENCHANTED_GOLDEN_APPLE.getDefaultInstance(),
                    ModItems.PEAR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.PEAR.get().getDefaultInstance(),
                    ModItems.ORANGE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }

        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.insertAfter(Items.CHERRY_HANGING_SIGN.getDefaultInstance(),
                    ModItems.APPLE_SIGN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.APPLE_SIGN.get().getDefaultInstance(),
                    ModItems.APPLE_HANGING_SIGN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.APPLE_HANGING_SIGN.get().getDefaultInstance(),
                    ModItems.PEAR_SIGN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.PEAR_SIGN.get().getDefaultInstance(),
                    ModItems.PEAR_HANGING_SIGN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.PEAR_HANGING_SIGN.get().getDefaultInstance(),
                    ModItems.ORANGE_SIGN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.ORANGE_SIGN.get().getDefaultInstance(),
                    ModItems.ORANGE_HANGING_SIGN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.ORANGE_HANGING_SIGN.get().getDefaultInstance(),
                    ModItems.AZALEA_SIGN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.AZALEA_SIGN.get().getDefaultInstance(),
                    ModItems.AZALEA_HANGING_SIGN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }

        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.insertAfter(Items.STICK.getDefaultInstance(),
                    ModItems.PINECONE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.PINECONE.get().getDefaultInstance(),
                    ModItems.CATKIN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }

        if(event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.insertAfter(Blocks.CHERRY_LOG.asItem().getDefaultInstance(),
                    ModBlocks.APPLE_LOG.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
            event.insertAfter(ModBlocks.APPLE_LOG.asItem().getDefaultInstance(),
                    ModBlocks.PEAR_LOG.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
            event.insertAfter(ModBlocks.PEAR_LOG.asItem().getDefaultInstance(),
                    ModBlocks.ORANGE_LOG.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
            event.insertAfter(ModBlocks.ORANGE_LOG.asItem().getDefaultInstance(),
                    ModBlocks.AZALEA_LOG.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);

            event.insertAfter(Blocks.CHERRY_SAPLING.asItem().getDefaultInstance(),
                    ModBlocks.APPLE_SAPLING.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.APPLE_SAPLING.asItem().getDefaultInstance(),
                    ModBlocks.PEAR_SAPLING.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.PEAR_SAPLING.asItem().getDefaultInstance(),
                    ModBlocks.ORANGE_SAPLING.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.insertAfter(Blocks.OAK_LEAVES.asItem().getDefaultInstance(),
                    ModBlocks.FLOWERING_OAK_LEAVES.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.SPRUCE_LEAVES.asItem().getDefaultInstance(),
                    ModBlocks.FLOWERING_SPRUCE_LEAVES.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.BIRCH_LEAVES.asItem().getDefaultInstance(),
                    ModBlocks.FLOWERING_BIRCH_LEAVES.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.JUNGLE_LEAVES.asItem().getDefaultInstance(),
                    ModBlocks.FLOWERING_JUNGLE_LEAVES.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.ACACIA_LEAVES.asItem().getDefaultInstance(),
                    ModBlocks.FLOWERING_ACACIA_LEAVES.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.DARK_OAK_LEAVES.asItem().getDefaultInstance(),
                    ModBlocks.FLOWERING_DARK_OAK_LEAVES.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.CHERRY_LEAVES.asItem().getDefaultInstance(),
                    ModBlocks.FLOWERING_CHERRY_LEAVES.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.insertAfter(ModBlocks.FLOWERING_CHERRY_LEAVES.asItem().getDefaultInstance(),
                    ModBlocks.APPLE_LEAVES.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.APPLE_LEAVES.asItem().getDefaultInstance(),
                    ModBlocks.FLOWERING_APPLE_LEAVES.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.FLOWERING_APPLE_LEAVES.asItem().getDefaultInstance(),
                    ModBlocks.PEAR_LEAVES.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.PEAR_LEAVES.asItem().getDefaultInstance(),
                    ModBlocks.FLOWERING_PEAR_LEAVES.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.FLOWERING_PEAR_LEAVES.asItem().getDefaultInstance(),
                    ModBlocks.ORANGE_LEAVES.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.ORANGE_LEAVES.asItem().getDefaultInstance(),
                    ModBlocks.FLOWERING_ORANGE_LEAVES.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.insertAfter(Blocks.FLOWERING_AZALEA_LEAVES.asItem().getDefaultInstance(),
                    ModBlocks.PINECONE_BLOCK.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.insertBefore(Blocks.ROSE_BUSH.asItem().getDefaultInstance(),
                    ModBlocks.ROSE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.ROSE_BUSH.asItem().getDefaultInstance(),
                    ModBlocks.CYAN_ROSE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertBefore(Blocks.PEONY.asItem().getDefaultInstance(),
                    ModBlocks.PEONIA.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }

        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.insertAfter(Items.CHERRY_CHEST_BOAT.getDefaultInstance(),
                    ModItems.APPLE_BOAT.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.APPLE_BOAT.get().getDefaultInstance(),
                    ModItems.APPLE_CHEST_BOAT.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.APPLE_CHEST_BOAT.get().getDefaultInstance(),
                    ModItems.PEAR_BOAT.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.PEAR_BOAT.get().getDefaultInstance(),
                    ModItems.PEAR_CHEST_BOAT.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.PEAR_CHEST_BOAT.get().getDefaultInstance(),
                    ModItems.ORANGE_BOAT.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.ORANGE_BOAT.get().getDefaultInstance(),
                    ModItems.ORANGE_CHEST_BOAT.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.ORANGE_CHEST_BOAT.get().getDefaultInstance(),
                    ModItems.AZALEA_BOAT.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.AZALEA_BOAT.get().getDefaultInstance(),
                    ModItems.AZALEA_CHEST_BOAT.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.insertBefore(Items.WIND_CHARGE.getDefaultInstance(),
                    ModItems.EVERSOURCE_CROWN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }

        //if (event.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {}

        if (event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            event.insertAfter(Items.CHICKEN_SPAWN_EGG.asItem().getDefaultInstance(),
                    ModItems.EVERSOURCE_SPAWN_EGG.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }

    //Event Bus subscribers
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @EventBusSubscriber(modid = MOD_ID, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLCommonSetupEvent event) {
            EntityRenderers.register(ModEntities.EVERSOURCE.get(), EversourceRenderer::new);
            EntityRenderers.register(ModEntities.LEGENDARY_PIG.get(), LegendaryPigRenderer::new);
        }

        //region Flowering Leaves color tinter
        //region Blocks
        @SubscribeEvent
        public static void registerBlockColors(RegisterColorHandlersEvent.Block event) {
            for (var holder : ModBlocks.BLOCKS.getEntries()) {
                Block block = holder.get();
                if (block instanceof LeavesBlock) {
                    event.register((state, reader, pos, tintIndex) -> {
                        Block leavesBlock = state.getBlock();
                        if (reader != null && pos != null) {
                            if (leavesBlock == ModBlocks.FLOWERING_SPRUCE_LEAVES.get()) {
                                return FoliageColor.getEvergreenColor();
                            } else if (leavesBlock == ModBlocks.FLOWERING_BIRCH_LEAVES.get()) {
                                return FoliageColor.getBirchColor();
                            } else if (leavesBlock == ModBlocks.APPLE_LEAVES.get() || leavesBlock == ModBlocks.FLOWERING_APPLE_LEAVES.get() ||
                                    leavesBlock == ModBlocks.PEAR_LEAVES.get() || leavesBlock == ModBlocks.FLOWERING_PEAR_LEAVES.get() ||
                                    leavesBlock == ModBlocks.ORANGE_LEAVES.get() || leavesBlock == ModBlocks.FLOWERING_ORANGE_LEAVES.get()) {
                                return 0x8db600;
                            }
                            return BiomeColors.getAverageFoliageColor(reader, pos);
                        }
                        return 0x48b518;
                    }, block);
                }
            }
        }
        //endregion

        //region Items
        @SubscribeEvent
        public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
            for (var holder : ModBlocks.BLOCKS.getEntries()) {
                Block block = holder.get();
                if (block instanceof LeavesBlock) {
                    event.register((stack, tintIndex) -> {
                        Block leavesBlock = Block.byItem(stack.getItem());
                        if (leavesBlock == ModBlocks.FLOWERING_SPRUCE_LEAVES.get()) {
                            return FoliageColor.getEvergreenColor();
                        } else if (leavesBlock == ModBlocks.FLOWERING_BIRCH_LEAVES.get()) {
                            return FoliageColor.getBirchColor();
                        } else if (leavesBlock == ModBlocks.APPLE_LEAVES.get() || leavesBlock == ModBlocks.FLOWERING_APPLE_LEAVES.get() ||
                                leavesBlock == ModBlocks.PEAR_LEAVES.get() || leavesBlock == ModBlocks.FLOWERING_PEAR_LEAVES.get() ||
                                leavesBlock == ModBlocks.ORANGE_LEAVES.get() || leavesBlock == ModBlocks.FLOWERING_ORANGE_LEAVES.get()) {
                            return 0x8db600;
                        }
                        return 0x48b518;
                    }, block);
                }
            }
        }
        //endregion
        //endregion
    }
}