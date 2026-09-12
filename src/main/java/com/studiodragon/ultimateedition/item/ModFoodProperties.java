package com.studiodragon.ultimateedition.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties APPLE = new FoodProperties.Builder()
            .nutrition(4)
            .saturationModifier(2.4f).build();

    public static final FoodProperties BERRY = new FoodProperties.Builder()
            .nutrition(2)
            .saturationModifier(0.4f).build();

    public static final FoodProperties NUT = new FoodProperties.Builder()
            .nutrition(1)
            .saturationModifier(0.5f).build();

    public static final FoodProperties DARK_ACORN = new FoodProperties.Builder()
            .nutrition(1)
            .saturationModifier(0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.DARKNESS, 200), 0.65f).build();

    public static final FoodProperties POD = new FoodProperties.Builder()
            .nutrition(1)
            .saturationModifier(0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.HARM, 20), 0.4f).build();

    public static final FoodProperties ROASTED_NUT = new FoodProperties.Builder()
            .nutrition(4)
            .saturationModifier(1).build();

    public static final FoodProperties SKY_FRUIT = new FoodProperties.Builder()
            .nutrition(1)
            .saturationModifier(0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.HEAL, 20), 0.2f)
            .effect(() -> new MobEffectInstance(MobEffects.HARM, 20), 0.2f).build();

}
