package com.studiodragon.ultimateedition.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.studiodragon.ultimateedition.UltimateEdition;
import com.studiodragon.ultimateedition.entity.custom.EversourceEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

public class EversourceModel<T extends EversourceEntity> extends HierarchicalModel<T> {

    public static final ModelLayerLocation LAYER_LOCATION =
            new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(UltimateEdition.MOD_ID, "eversource"), "main");

    //Copy model data from the text inside the Blockbench exported .JAVA file (ignore first 8 lines)
    private final ModelPart head;
    private final ModelPart rightLeg;
    private final ModelPart leftLeg;
    private final ModelPart rightWing;
    private final ModelPart leftWing;
    private final ModelPart body;

    public EversourceModel(ModelPart root) {
        this.body = root.getChild("body");
        this.head = root.getChild("head");
        this.rightLeg = root.getChild("rightLeg");
        this.leftLeg = root.getChild("leftLeg");
        this.rightWing = root.getChild("rightWing");
        this.leftWing = root.getChild("leftWing");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -5.0F, -2.0F, 4.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(14, 0).addBox(-2.0F, -3.0F, -4.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(14, 4).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(24, 23).addBox(-2.0F, -8.5F, -2.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.25F))
                .texOffs(44, 0).addBox(-3.0F, -6.0F, -2.0F, 6.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(24, 30).addBox(-2.0F, -10.0F, -1.5F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 14.0F, -4.0F));

        PartDefinition rightLeg = partdefinition.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(26, 0).addBox(-2.0F, -5.0F, -1.0F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 24.0F, -1.0F));

        PartDefinition leftLeg = partdefinition.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(26, 0).addBox(-2.0F, -5.0F, -1.0F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 24.0F, -1.0F));

        PartDefinition rightWing = partdefinition.addOrReplaceChild("rightWing", CubeListBuilder.create().texOffs(24, 13).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 13.0F, -3.0F));

        PartDefinition leftWing = partdefinition.addOrReplaceChild("leftWing", CubeListBuilder.create().texOffs(24, 13).addBox(0.0F, 0.0F, 0.0F, 1.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 13.0F, -3.0F));

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(38, 26).addBox(-1.5F, -0.5F, -8.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 17.0F, 3.0F));

        PartDefinition tail_r1 = body.addOrReplaceChild("tail_r1", CubeListBuilder.create().texOffs(38, 9).addBox(0.0F, 0.0F, 0.0F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition body_r1 = body.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(0, 9).addBox(-5.0F, -8.0F, -1.0F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 26).addBox(-5.0F, -8.0F, -1.0F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(2.0F, 1.0F, 1.0F, 1.5708F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 40);
    }

    @Override
    public void setupAnim(@NotNull EversourceEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);
        this.rightLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leftLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.rightWing.zRot = ageInTicks;
        this.leftWing.zRot = -ageInTicks;
        //this.animateWalk(EversourceAnimations.EVERSOURCE_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        //this.animate(entity.idleAnimationState,EversourceAnimations.EVERSOURCE_IDLE, ageInTicks, 1f);
    }

    //Head rotation (?)
    private void applyHeadRotation(float headYaw, float headPitch) {
        headYaw = Mth.clamp(headYaw, -30f, 30f);
        headPitch = Mth.clamp(headPitch, -25f, 45);

        this.head.yRot = headYaw * ((float)Math.PI / 180f);
        this.head.xRot = headPitch * ((float)Math.PI / 180f);
    }

    @Override
    public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        head.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        rightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        leftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        rightWing.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        leftWing.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public @NotNull ModelPart root() {
        return body;
    }
}