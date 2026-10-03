package com.studiodragon.ultimateedition.entity.custom;

import com.studiodragon.ultimateedition.entity.ModEntities;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EversourceEntity extends Animal {
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    public float flap;
    public float flapSpeed;
    public float oFlapSpeed;
    public float oFlap;
    public float flapping = 1.0F;
    private float nextFlap = 1.0F;
    public int eggTime;
    public int eggRarity;
    ResourceLocation spawnEggLootTable;

    public EversourceEntity(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
    }

    //regionBase AI goals
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.4));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0F));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.0F, stack -> stack.is(Items.GOLD_BLOCK), false));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0F));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class,6.0F));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
    }
    //endregion

    //region Attributes
    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 40.0F)
                .add(Attributes.MOVEMENT_SPEED, 0.25F)
                .add(Attributes.FOLLOW_RANGE, 6.0F);

    }
    //endregion

    //region Flapping + Egglaying (taken from Chicken java class)
    public void aiStep() {
        super.aiStep();
        this.oFlap = this.flap;
        this.oFlapSpeed = this.flapSpeed;
        this.flapSpeed += (this.onGround() ? -1.0F : 4.0F) * 0.3F;
        this.flapSpeed = Mth.clamp(this.flapSpeed, 0.0F, 1.0F);
        if (!this.onGround() && this.flapping < 1.0F) {
            this.flapping = 1.0F;
        }

        this.flapping *= 0.9F;
        Vec3 vec3 = this.getDeltaMovement();
        if (!this.onGround() && vec3.y < (double)0.0F) {
            this.setDeltaMovement(vec3.multiply(1.0F, 0.6, 1.0F));
        }

        this.flap += this.flapping * 2.0F;
        if (!this.level().isClientSide && this.level() instanceof ServerLevel serverLevel && this.isAlive() && !this.isBaby() && --this.eggTime <= 0) {
            this.eggRarity = this.random.nextInt(10000);

            if (eggRarity < 5) {
                spawnEggLootTable = ResourceLocation.fromNamespaceAndPath("ultimateedition", "gameplay/eversource_eggs/mythical_eggs");
                this.playSound(SoundEvents.CHICKEN_DEATH, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.4F + 2.0F);
                this.playSound(SoundEvents.EXPERIENCE_ORB_PICKUP, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
            } else if (eggRarity < 100) {
                spawnEggLootTable = ResourceLocation.fromNamespaceAndPath("ultimateedition", "gameplay/eversource_eggs/legendary_eggs");
                this.playSound(SoundEvents.CHICKEN_DEATH, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
            } else if (eggRarity < 500) {
                spawnEggLootTable = ResourceLocation.fromNamespaceAndPath("ultimateedition", "gameplay/eversource_eggs/epic_eggs");
                this.playSound(SoundEvents.CHICKEN_HURT, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
            } else if (eggRarity < 2000) {
                spawnEggLootTable = ResourceLocation.fromNamespaceAndPath("ultimateedition", "gameplay/eversource_eggs/rare_eggs");
            } else if (eggRarity < 5000) {
                spawnEggLootTable = ResourceLocation.fromNamespaceAndPath("ultimateedition", "gameplay/eversource_eggs/uncommon_eggs");
            } else {
                spawnEggLootTable = ResourceLocation.fromNamespaceAndPath("ultimateedition", "gameplay/eversource_eggs/common_eggs");
            }
            LootParams lootParams = new LootParams.Builder(serverLevel)
                    .withParameter(LootContextParams.ORIGIN, this.position())
                    .withParameter(LootContextParams.THIS_ENTITY, this)
                    .create(LootContextParamSets.EMPTY);
            LootTable lootTable = serverLevel.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, spawnEggLootTable));
            List<ItemStack> randomDrops = lootTable.getRandomItems(lootParams);
            this.playSound(SoundEvents.CHICKEN_EGG, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
            this.gameEvent(GameEvent.ENTITY_PLACE);
            for (ItemStack generatedStack : randomDrops) {
                this.spawnAtLocation(generatedStack);
            }
            this.eggTime = this.random.nextInt(60) + 60;
        }

    }

    protected boolean isFlapping() {
        return this.flyDist > this.nextFlap;
    }

    protected void onFlap() {
        this.nextFlap = this.flyDist + this.flapSpeed / 2.0F;
    }
    //endregion

    //region Food
    @Override
    public boolean isFood(ItemStack stack) {
        return stack.is(Items.GOLD_BLOCK);
    }
    //endregion

    //region Baby
    @Nullable
    @Override
    public AgeableMob getBreedOffspring(@NotNull ServerLevel level, @NotNull AgeableMob otherParent) {
        return ModEntities.EVERSOURCE.get().create(level);
    }
    //endregion

    //region Animations
    private void setupAnimationState() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 20;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide()) {
            this.setupAnimationState();
        }
    }
    //endregion

    //region Sounds
    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return SoundEvents.CHICKEN_AMBIENT;
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(@NotNull DamageSource damageSource) {
        return SoundEvents.CHICKEN_HURT;
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return SoundEvents.CHICKEN_DEATH;
    }
    //endregion

    //region Loot
    @Override
    protected @NotNull ResourceKey<LootTable> getDefaultLootTable() {
        return ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath("ultimateedition", "entities/eversource"));
    }
    //endregion
}