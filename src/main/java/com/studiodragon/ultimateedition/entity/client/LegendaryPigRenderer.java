package com.studiodragon.ultimateedition.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.studiodragon.ultimateedition.UltimateEdition;
import com.studiodragon.ultimateedition.entity.custom.LegendaryPigEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class LegendaryPigRenderer extends MobRenderer<LegendaryPigEntity, LegendaryPigModel<LegendaryPigEntity>> {
    public LegendaryPigRenderer(EntityRendererProvider.Context context) {
        super(context, new LegendaryPigModel<>(context.bakeLayer(LegendaryPigModel.LAYER_LOCATION)), 0.7F);
    }

    //Get texture
    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull LegendaryPigEntity legendaryPigEntity) {
        return ResourceLocation.fromNamespaceAndPath(UltimateEdition.MOD_ID, "textures/entity/legendary_pig/temperate_legendary_pig.png");
    }

    @Override
    public void render(LegendaryPigEntity entity, float entityYaw, float partialTicks, @NotNull PoseStack poseStack, @NotNull MultiBufferSource buffer, int packedLight) {
        //Baby renderer
        if (entity.isBaby()) {
            poseStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            poseStack.scale(1, 1, 1);
        }
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}