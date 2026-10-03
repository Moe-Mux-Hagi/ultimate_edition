package com.studiodragon.ultimateedition.potion;

import com.studiodragon.ultimateedition.UltimateEdition;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(BuiltInRegistries.POTION, UltimateEdition.MOD_ID);

    public static final Holder<Potion> SKYBREACHER_POTION = POTIONS.register("skybreacher_potion",
            () -> new Potion(new MobEffectInstance(MobEffects.LEVITATION, 850, 9), new MobEffectInstance(MobEffects.SLOW_FALLING, 1100, 2))
    );

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}