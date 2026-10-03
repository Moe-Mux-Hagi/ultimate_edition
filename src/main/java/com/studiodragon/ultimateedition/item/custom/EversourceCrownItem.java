package com.studiodragon.ultimateedition.item.custom;

import com.studiodragon.ultimateedition.entity.ModEntities;
import com.studiodragon.ultimateedition.entity.custom.EversourceEntity;
import com.studiodragon.ultimateedition.entity.custom.LegendaryPigEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class EversourceCrownItem extends Item {
    public EversourceCrownItem(Properties properties) {
        super(properties);
    }

    //Use Eversource Crown...
    @Override
    public @NotNull InteractionResult interactLivingEntity(@NotNull ItemStack stack, Player player, @NotNull LivingEntity interactionTarget, @NotNull InteractionHand usedHand) {
        Level level = player.level();
        //region ...on Crownable
        if (interactionTarget instanceof Chicken || interactionTarget instanceof Pig) {
            LivingEntity entityToSpawn = null;

            //region ...on Chicken
            if (interactionTarget instanceof Chicken chicken) {
                if (level instanceof ServerLevel serverLevel) {
                    entityToSpawn = ModEntities.EVERSOURCE.get().spawn(serverLevel, BlockPos.containing(chicken.getX(), chicken.getY(), chicken.getZ()), MobSpawnType.MOB_SUMMONED);
                }
            }
            //endregion

            //region ...on Pig
            if (interactionTarget instanceof Pig pig) {
                if (level instanceof ServerLevel serverLevel) {
                    entityToSpawn = ModEntities.LEGENDARY_PIG.get().spawn(serverLevel, BlockPos.containing(pig.getX(), pig.getY(), pig.getZ()), MobSpawnType.MOB_SUMMONED);
                }
            }
            //endregion

            if (level instanceof ServerLevel serverLevel) {
                //region Visual effects
                LightningBolt lightning = EntityType.LIGHTNING_BOLT.create(level);
                if (lightning != null) {
                    lightning.moveTo(interactionTarget.getX(), interactionTarget.getY(), interactionTarget.getZ());
                    lightning.setVisualOnly(true);
                    level.addFreshEntity(lightning);
                }
                serverLevel.sendParticles(ParticleTypes.SOUL, (interactionTarget.getX()), (interactionTarget.getY()), (interactionTarget.getZ()), 200, 1, 3, 1, 1);
                serverLevel.sendParticles(ParticleTypes.LARGE_SMOKE, (interactionTarget.getX()), (interactionTarget.getY()), (interactionTarget.getZ()), 500, 3, 3, 3, 1);
                //endregion

                assert entityToSpawn != null;
                entityToSpawn.setYRot(interactionTarget.getYRot());
                entityToSpawn.setYBodyRot(interactionTarget.getYRot());
                entityToSpawn.setYHeadRot(interactionTarget.getYRot());
                entityToSpawn.setXRot(interactionTarget.getXRot());
                interactionTarget.discard();
                stack.consume(1, player);
            }
        }
        //endregion

        //region ...on Crowned
        else if (interactionTarget instanceof EversourceEntity || interactionTarget instanceof LegendaryPigEntity) {
            if (level instanceof ServerLevel serverLevel) {
                serverLevel.sendParticles(ParticleTypes.SMOKE, (interactionTarget.getX()), (interactionTarget.getY()), (interactionTarget.getZ()), 10, 0.25, 1, 0.25, 0.1);
            }
        }
        //endregion

        //region ...on else
        else {
            interactionTarget.igniteForSeconds(15f);
        }
        //endregion
        return InteractionResult.SUCCESS;
    }
}