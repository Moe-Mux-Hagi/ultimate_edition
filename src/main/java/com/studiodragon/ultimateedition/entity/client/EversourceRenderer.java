package com.studiodragon.ultimateedition.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.studiodragon.ultimateedition.UltimateEdition;
import com.studiodragon.ultimateedition.entity.custom.EversourceEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

public class EversourceRenderer extends MobRenderer<EversourceEntity, EversourceModel<EversourceEntity>> {
    public EversourceRenderer(EntityRendererProvider.Context context) {
        super(context, new EversourceModel<>(context.bakeLayer(EversourceModel.LAYER_LOCATION)), 0.3F);
    }

    //Get texture
    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull EversourceEntity eversourceEntity) {
        return ResourceLocation.fromNamespaceAndPath(UltimateEdition.MOD_ID, "textures/entity/eversource/temperate_eversource.png");
    }

    @Override
    public void render(EversourceEntity entity, float entityYaw, float partialTicks, @NotNull PoseStack poseStack, @NotNull MultiBufferSource buffer, int packedLight) {
        //Baby renderer
        if (entity.isBaby()) {
            poseStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            poseStack.scale(1, 1, 1);
        }
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    @Override
    protected float getBob(EversourceEntity livingBase, float partialTick) {
        float f = Mth.lerp(partialTick, livingBase.oFlap, livingBase.flap);
        float f1 = Mth.lerp(partialTick, livingBase.oFlapSpeed, livingBase.flapSpeed);
        return (Mth.sin(f) + 1.0F) * f1;
    }
}