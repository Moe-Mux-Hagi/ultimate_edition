package com.studiodragon.ultimateedition.event;

import com.studiodragon.ultimateedition.block.ModBlocks;
import com.studiodragon.ultimateedition.potion.ModPotions;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.network.protocol.game.ClientboundLevelEventPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BlockEntityTypeAddBlocksEvent;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.event.level.LevelEvent;
import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

@EventBusSubscriber
public class ModEvents {

    //region Add block entities
    @SubscribeEvent
    public static void onBlockEntityAddBlocks(BlockEntityTypeAddBlocksEvent event) {
        event.modify(BlockEntityType.SIGN,
                ModBlocks.APPLE_STANDING_SIGN.get(),
                ModBlocks.APPLE_WALL_SIGN.get(),
                ModBlocks.AZALEA_STANDING_SIGN.get(),
                ModBlocks.AZALEA_WALL_SIGN.get(),
                ModBlocks.ORANGE_STANDING_SIGN.get(),
                ModBlocks.ORANGE_WALL_SIGN.get(),
                ModBlocks.PEAR_STANDING_SIGN.get(),
                ModBlocks.PEAR_WALL_SIGN.get()
        );
        event.modify(BlockEntityType.HANGING_SIGN,
                ModBlocks.APPLE_CEILING_HANGING_SIGN.get(),
                ModBlocks.APPLE_WALL_HANGING_SIGN.get(),
                ModBlocks.AZALEA_CEILING_HANGING_SIGN.get(),
                ModBlocks.AZALEA_WALL_HANGING_SIGN.get(),
                ModBlocks.ORANGE_CEILING_HANGING_SIGN.get(),
                ModBlocks.ORANGE_WALL_HANGING_SIGN.get(),
                ModBlocks.PEAR_CEILING_HANGING_SIGN.get(),
                ModBlocks.PEAR_WALL_HANGING_SIGN.get()
        );
    }
    //endregion

    //region Add potion recipe
    @SubscribeEvent
    public static void onBrewingRecipeRegister(RegisterBrewingRecipesEvent event) {
        PotionBrewing.Builder builder = event.getBuilder();

        //builder.addMix(Potions.AWKWARD, Items.SHULKER_SHELL, ModPotions.SKYBREACHER_POTION);
    }
    //endregion

    //region Sky dimension travel
    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        Player eventEntity = event.getEntity();

        if (!eventEntity.level().isClientSide()) {
            execute(event, eventEntity.level(), eventEntity.getX(), eventEntity.getY(), eventEntity.getZ(), eventEntity);
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        execute(null, world, x, y, z, entity);
    }

    private static void execute(Event event, LevelAccessor world, double x, double y, double z, Entity skyTraveller) {
        if (skyTraveller == null)
            return;
        //region Sky -> Overworld
        if ((skyTraveller.level().dimension()) == ResourceKey.create(Registries.DIMENSION,
                ResourceLocation.fromNamespaceAndPath("ultimateedition", "sky")) && skyTraveller.getY() <= 320) {
            {
                skyTraveller.teleportTo(x, y, z);
                if (skyTraveller instanceof ServerPlayer serverPlayer)
                    serverPlayer.connection.teleport(x, y, z, skyTraveller.getYRot(), skyTraveller.getXRot());
            }
            if (skyTraveller instanceof ServerPlayer player && !player.level().isClientSide()) {
                ResourceKey<Level> destinationType = Level.OVERWORLD;
                if (player.level().dimension() == destinationType)
                    return;
                ServerLevel nextLevel = player.server.getLevel(destinationType);
                if (nextLevel != null) {
                    player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
                    player.teleportTo(nextLevel, player.getX(), player.getY(), player.getZ(), player.getYRot(), player.getXRot());
                    player.connection.send(new ClientboundPlayerAbilitiesPacket(player.getAbilities()));
                    for (MobEffectInstance effectInstance : player.getActiveEffects())
                        player.connection.send(new ClientboundUpdateMobEffectPacket(player.getId(), effectInstance, true));
                    player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
                }
            }
        }
        //endregion

        //region Overworld -> Sky
        if ((skyTraveller.level().dimension()) == ResourceKey.create(Registries.DIMENSION,
                ResourceLocation.fromNamespaceAndPath("minecraft", "overworld")) && skyTraveller.getY() >= 328) {
            {
                skyTraveller.teleportTo(x, y, z);
                if (skyTraveller instanceof ServerPlayer serverPlayer)
                    serverPlayer.connection.teleport(x, y, z, skyTraveller.getYRot(), skyTraveller.getXRot());
            }
            if (skyTraveller instanceof ServerPlayer player && !player.level().isClientSide()) {
                ResourceKey<Level> destinationType = ResourceKey.create(Registries.DIMENSION, ResourceLocation.fromNamespaceAndPath("ultimateedition", "sky"));
                if (player.level().dimension() == destinationType)
                    return;
                ServerLevel nextLevel = player.server.getLevel(destinationType);
                if (nextLevel != null) {
                    player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
                    player.teleportTo(nextLevel, player.getX(), player.getY(), player.getZ(), player.getYRot(), player.getXRot());
                    player.connection.send(new ClientboundPlayerAbilitiesPacket(player.getAbilities()));
                    for (MobEffectInstance effectInstance : player.getActiveEffects())
                        player.connection.send(new ClientboundUpdateMobEffectPacket(player.getId(), effectInstance, true));
                    player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
                }
            }
        }
        //endregion
    }
    //endregion

    //region Sky dimension worldgen
    @SubscribeEvent
    public static void onLevelCreate(LevelEvent.CreateSpawnPosition event) {
        if (event.getLevel() instanceof ServerLevel serverLevel) {
            StructureTemplate skyIsland = serverLevel.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("ultimateedition", "sky_island"));
            skyIsland.placeInWorld(serverLevel, new BlockPos(-1, 381, -2), new BlockPos(-1, 381, -2), new StructurePlaceSettings()
                    .setRotation(Rotation.NONE)
                    .setMirror(Mirror.NONE)
                    .setIgnoreEntities(false), serverLevel.random, 3);
        }
    }
    //endregion
}