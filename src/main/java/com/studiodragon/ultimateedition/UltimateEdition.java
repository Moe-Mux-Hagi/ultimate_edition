package com.studiodragon.ultimateedition;

import com.studiodragon.ultimateedition.block.ModBlocks;
import com.studiodragon.ultimateedition.entity.ModEntities;
import com.studiodragon.ultimateedition.entity.client.EversourceRenderer;
import com.studiodragon.ultimateedition.entity.client.LegendaryPigRenderer;
import com.studiodragon.ultimateedition.event.Dispenser;
import com.studiodragon.ultimateedition.item.ModItems;
import com.studiodragon.ultimateedition.loot.ModLootModifiers;
import com.studiodragon.ultimateedition.world.level.block.FloweringLeavesBlock;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DispenserBlock;
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

//import static com.studiodragon.ultimateedition.item.ModItems.VANILLA_OVERRIDE;

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
        //VANILLA_OVERRIDE.register(modEventBus);

        //Register items to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            DispenserBlock.registerBehavior(Items.BONE_MEAL, new Dispenser());
            DispenserBlock.registerBehavior(Items.SHEARS, new Dispenser());
        });
    }

    //Creative Tab registries
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.PLASTER);
        }
        if(event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(ModItems.ACORN);
            event.accept(ModItems.DARK_ACORN);
            event.accept(ModItems.PINE_NUTS);
            event.accept(ModItems.POD);
            event.accept(ModItems.ROASTED_ACORN);
            event.accept(ModItems.ROASTED_DARK_ACORN);
            event.accept(ModItems.ROASTED_PINE_NUTS);
            event.accept(ModItems.SKY_FRUIT);
        }
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.CATKIN);
            event.accept(ModItems.PINECONE);

        }
        if(event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModBlocks.FLOWERING_ACACIA_LEAVES);
            event.accept(ModBlocks.FLOWERING_BIRCH_LEAVES);
            event.accept(ModBlocks.FLOWERING_CHERRY_LEAVES);
            event.accept(ModBlocks.FLOWERING_DARK_OAK_LEAVES);
            event.accept(ModBlocks.FLOWERING_JUNGLE_LEAVES);
            event.accept(ModBlocks.FLOWERING_OAK_LEAVES);
            event.accept(ModBlocks.FLOWERING_SPRUCE_LEAVES);
            event.accept(ModBlocks.PINECONE_BLOCK);
        }
        if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.EVERSOURCE_CROWN);
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

        //Flowering Leaves color tinter
        //Blocks
        @SubscribeEvent
        public static void registerBlockColors(RegisterColorHandlersEvent.Block event) {
            for (var holder : ModBlocks.BLOCKS.getEntries()) {
                Block block = holder.get();
                if (block instanceof FloweringLeavesBlock) {
                    event.register((state, reader, pos, tintIndex) -> {
                        Block leavesBlock = state.getBlock();
                        if (reader != null && pos != null) {
                            if (leavesBlock == ModBlocks.FLOWERING_SPRUCE_LEAVES.get()) {
                                return FoliageColor.getEvergreenColor();
                            } else if (leavesBlock == ModBlocks.FLOWERING_BIRCH_LEAVES.get()) {
                                return FoliageColor.getBirchColor();
                            }
                            return BiomeColors.getAverageFoliageColor(reader, pos);
                        }
                        return 0x48b518;
                    }, block);
                }
            }
        }
        //Items
        @SubscribeEvent
        public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
            for (var holder : ModBlocks.BLOCKS.getEntries()) {
                Block block = holder.get();
                if (block instanceof FloweringLeavesBlock) {
                    event.register((stack, tintIndex) -> {
                        Block leavesBlock = Block.byItem(stack.getItem());
                        if (leavesBlock == ModBlocks.FLOWERING_SPRUCE_LEAVES.get()) {
                            return FoliageColor.getEvergreenColor();
                        } else if (leavesBlock == ModBlocks.FLOWERING_BIRCH_LEAVES.get()) {
                            return FoliageColor.getBirchColor();
                        }
                        return 0x48b518;
                    }, block);
                }
            }
        }
    }
}