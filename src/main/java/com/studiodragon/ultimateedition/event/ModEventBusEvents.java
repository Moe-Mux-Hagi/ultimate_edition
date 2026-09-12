package com.studiodragon.ultimateedition.event;

import com.studiodragon.ultimateedition.UltimateEdition;
import com.studiodragon.ultimateedition.entity.ModEntities;
import com.studiodragon.ultimateedition.entity.client.EversourceModel;
import com.studiodragon.ultimateedition.entity.client.LegendaryPigModel;
import com.studiodragon.ultimateedition.entity.custom.EversourceEntity;
import com.studiodragon.ultimateedition.entity.custom.LegendaryPigEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = UltimateEdition.MOD_ID)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(EversourceModel.LAYER_LOCATION, EversourceModel::createBodyLayer);
        event.registerLayerDefinition(LegendaryPigModel.LAYER_LOCATION, LegendaryPigModel::createBodyLayer);

    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.EVERSOURCE.get(), EversourceEntity.createAttributes().build());
        event.put(ModEntities.LEGENDARY_PIG.get(), LegendaryPigEntity.createAttributes().build());
    }
}