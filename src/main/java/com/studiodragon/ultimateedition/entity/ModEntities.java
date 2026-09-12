package com.studiodragon.ultimateedition.entity;

import com.studiodragon.ultimateedition.UltimateEdition;
import com.studiodragon.ultimateedition.entity.custom.EversourceEntity;
import com.studiodragon.ultimateedition.entity.custom.LegendaryPigEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, UltimateEdition.MOD_ID);

    public static final Supplier<EntityType<EversourceEntity>> EVERSOURCE =
            ENTITY_TYPES.register("eversource", () -> EntityType.Builder.of(EversourceEntity::new, MobCategory.CREATURE)
                    .sized(0.4f, 0.7f)
                    .build("eversource"));

    public static final Supplier<EntityType<LegendaryPigEntity>> LEGENDARY_PIG =
            ENTITY_TYPES.register("legendary_pig", () -> EntityType.Builder.of(LegendaryPigEntity::new, MobCategory.CREATURE)
                    .sized(0.9f, 0.9f)
                    .build("legendary_pig"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}