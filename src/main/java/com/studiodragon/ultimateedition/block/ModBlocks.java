package com.studiodragon.ultimateedition.block;

import com.studiodragon.ultimateedition.UltimateEdition;
import com.studiodragon.ultimateedition.block.custom.*;
import com.studiodragon.ultimateedition.item.ModItems;
import com.studiodragon.ultimateedition.worldgen.tree.ModTreeGrowers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(UltimateEdition.MOD_ID);

    //region Apple wood set
    public static final DeferredBlock<Block> APPLE_LEAVES = registerBlock("apple_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 30;
                }
            }
    );
    public static final DeferredBlock<Block> FLOWERING_APPLE_LEAVES = registerBlock("flowering_apple_leaves",
            () -> new FloweringLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)) {
                @Override
                public Item getFruit() {
                    return Items.APPLE;
                }
            }
    );
    public static final DeferredBlock<Block> APPLE_LOG = registerBlock("apple_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG))
    );
    public static final DeferredBlock<Block> STRIPPED_APPLE_LOG = registerBlock("stripped_apple_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG))
    );
    public static final DeferredBlock<Block> APPLE_WOOD = registerBlock("apple_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD))
    );
    public static final DeferredBlock<Block> STRIPPED_APPLE_WOOD = registerBlock("stripped_apple_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD))
    );

    public static final DeferredBlock<Block> APPLE_SAPLING = registerBlock("apple_sapling",
            () -> new SaplingBlock(ModTreeGrowers.APPLE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING))
    );
    public static final DeferredBlock<Block> POTTED_APPLE_SAPLING = BLOCKS.register("potted_apple_sapling",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.APPLE_SAPLING, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_OAK_SAPLING))
    );

    public static final DeferredBlock<Block> APPLE_PLANKS = registerBlock("apple_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 5;
                }
            }
    );
    public static final DeferredBlock<StairBlock> APPLE_STAIRS = registerBlock("apple_stairs",
            () -> new StairBlock(ModBlocks.APPLE_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS)) {
                @Override
                public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 5;
                }
            }
    );
    public static final DeferredBlock<SlabBlock> APPLE_SLAB = registerBlock("apple_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB)) {
                @Override
                public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 5;
                }
            }
    );
    public static final DeferredBlock<PressurePlateBlock> APPLE_PRESSURE_PLATE = registerBlock("apple_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE))
    );
    public static final DeferredBlock<ButtonBlock> APPLE_BUTTON = registerBlock("apple_button",
            () -> new ButtonBlock(BlockSetType.OAK, 20, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON))
    );
    public static final DeferredBlock<FenceBlock> APPLE_FENCE = registerBlock("apple_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)) {
                @Override
                public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 5;
                }
            }
    );
    public static final DeferredBlock<FenceGateBlock> APPLE_FENCE_GATE = registerBlock("apple_fence_gate",
            () -> new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)) {
                @Override
                public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 5;
                }
            }
    );
    public static final DeferredBlock<DoorBlock> APPLE_DOOR = registerBlock("apple_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR)) {
                @Override
                public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 5;
                }
            }
    );
    public static final DeferredBlock<TrapDoorBlock> APPLE_TRAPDOOR = registerBlock("apple_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR)) {
                @Override
                public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 5;
                }
            }
    );
    public static final DeferredBlock<StandingSignBlock> APPLE_STANDING_SIGN = BLOCKS.register("apple_sign",
            () -> new StandingSignBlock(ModWoodTypes.APPLE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN))
    );
    public static final DeferredBlock<WallSignBlock> APPLE_WALL_SIGN = BLOCKS.register("apple_wall_sign",
            () -> new WallSignBlock(ModWoodTypes.APPLE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN))
    );
    public static final DeferredBlock<CeilingHangingSignBlock> APPLE_CEILING_HANGING_SIGN = BLOCKS.register("apple_hanging_sign",
            () -> new CeilingHangingSignBlock(ModWoodTypes.APPLE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN))
    );
    public static final DeferredBlock<WallHangingSignBlock> APPLE_WALL_HANGING_SIGN = BLOCKS.register("apple_wall_hanging_sign",
            () -> new WallHangingSignBlock(ModWoodTypes.APPLE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN))
    );
    //endregion

    //region Azalea wood set
    public static final DeferredBlock<Block> AZALEA_LOG = registerBlock("azalea_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG))
    );
    public static final DeferredBlock<Block> STRIPPED_AZALEA_LOG = registerBlock("stripped_azalea_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG))
    );
    public static final DeferredBlock<Block> AZALEA_WOOD = registerBlock("azalea_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD))
    );
    public static final DeferredBlock<Block> STRIPPED_AZALEA_WOOD = registerBlock("stripped_azalea_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD))
    );
    public static final DeferredBlock<Block> AZALEA_PLANKS = registerBlock("azalea_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 5;
                }
            }
    );
    public static final DeferredBlock<StairBlock> AZALEA_STAIRS = registerBlock("azalea_stairs",
            () -> new StairBlock(ModBlocks.AZALEA_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS)) {
                @Override
                public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 5;
                }
            }
    );
    public static final DeferredBlock<SlabBlock> AZALEA_SLAB = registerBlock("azalea_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB)) {
                @Override
                public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 5;
                }
            }
    );
    public static final DeferredBlock<PressurePlateBlock> AZALEA_PRESSURE_PLATE = registerBlock("azalea_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE))
    );
    public static final DeferredBlock<ButtonBlock> AZALEA_BUTTON = registerBlock("azalea_button",
            () -> new ButtonBlock(BlockSetType.OAK, 20, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON))
    );
    public static final DeferredBlock<FenceBlock> AZALEA_FENCE = registerBlock("azalea_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)) {
                @Override
                public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 5;
                }
            }
    );
    public static final DeferredBlock<FenceGateBlock> AZALEA_FENCE_GATE = registerBlock("azalea_fence_gate",
            () -> new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)) {
                @Override
                public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 5;
                }
            }
    );
    public static final DeferredBlock<DoorBlock> AZALEA_DOOR = registerBlock("azalea_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR)) {
                @Override
                public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 5;
                }
            }
    );
    public static final DeferredBlock<TrapDoorBlock> AZALEA_TRAPDOOR = registerBlock("azalea_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR)) {
                @Override
                public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 5;
                }
            }
    );
    public static final DeferredBlock<StandingSignBlock> AZALEA_STANDING_SIGN = BLOCKS.register("azalea_sign",
            () -> new StandingSignBlock(ModWoodTypes.AZALEA, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN))
    );
    public static final DeferredBlock<WallSignBlock> AZALEA_WALL_SIGN = BLOCKS.register("azalea_wall_sign",
            () -> new WallSignBlock(ModWoodTypes.AZALEA, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN))
    );
    public static final DeferredBlock<CeilingHangingSignBlock> AZALEA_CEILING_HANGING_SIGN = BLOCKS.register("azalea_hanging_sign",
            () -> new CeilingHangingSignBlock(ModWoodTypes.AZALEA, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN))
    );
    public static final DeferredBlock<WallHangingSignBlock> AZALEA_WALL_HANGING_SIGN = BLOCKS.register("azalea_wall_hanging_sign",
            () -> new WallHangingSignBlock(ModWoodTypes.AZALEA, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN))
    );
    //endregion

    //region Flowering leaves (vanilla trees)
    public static final DeferredBlock<Block> FLOWERING_ACACIA_LEAVES = registerBlock("flowering_acacia_leaves",
            () -> new FloweringLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_LEAVES)) {
                @Override
                public Item getFruit() {
                    return ModItems.POD.get();
                }
            }
    );
    public static final DeferredBlock<Block> FLOWERING_BIRCH_LEAVES = registerBlock("flowering_birch_leaves",
            () -> new FloweringLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_LEAVES)) {
                @Override
                public Item getFruit() {
                    return ModItems.CATKIN.get();
                }
            }
    );
    public static final DeferredBlock<Block> FLOWERING_CHERRY_LEAVES = registerBlock("flowering_cherry_leaves",
            () -> new FloweringLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_LEAVES)) {
                @Override
                public Item getFruit() {
                    return ModItems.CHERRIES.get();
                }
            }
    );
    public static final DeferredBlock<Block> FLOWERING_DARK_OAK_LEAVES = registerBlock("flowering_dark_oak_leaves",
            () -> new FloweringLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_LEAVES)) {
                @Override
                public Item getFruit() {
                    return ModItems.DARK_ACORN.get();
                }
            }
    );

    public static final DeferredBlock<Block> FLOWERING_JUNGLE_LEAVES = registerBlock("flowering_jungle_leaves",
            () -> new FloweringLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES)) {
                @Override
                public Item getFruit() {
                    return ModItems.SKY_FRUIT.get();
                }
            }
    );

    public static final DeferredBlock<Block> FLOWERING_OAK_LEAVES = registerBlock("flowering_oak_leaves",
            () -> new FloweringLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)) {
                @Override
                public Item getFruit() {
                    return ModItems.ACORN.get();
                }
            }
    );

    public static final DeferredBlock<Block> FLOWERING_SPRUCE_LEAVES = registerBlock("flowering_spruce_leaves",
            () -> new FloweringLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)) {
                @Override
                public Item getFruit() {
                    return ModItems.PINECONE.get();
                }
            }
    );
    //endregion

    //region Flowers
    public static final DeferredBlock<Block> CYAN_ROSE = registerBlock("cyan_rose",
            () -> new FlowerBlock(MobEffects.HEALTH_BOOST, 1, BlockBehaviour.Properties.of()
                    .instabreak()
                    .mapColor(MapColor.PLANT)
                    .noCollission()
                    .offsetType(BlockBehaviour.OffsetType.XZ)
                    .pushReaction(PushReaction.DESTROY)
                    .sound(SoundType.GRASS)
            )
    );
    public static final DeferredBlock<Block> POTTED_CYAN_ROSE = BLOCKS.register("potted_cyan_rose",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.CYAN_ROSE, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_POPPY)
            )
    );

    public static final DeferredBlock<Block> PEONIA = registerBlock("peonia",
            () -> new FlowerBlock(MobEffects.HEALTH_BOOST, 1, BlockBehaviour.Properties.of()
                    .instabreak()
                    .mapColor(MapColor.PLANT)
                    .noCollission()
                    .offsetType(BlockBehaviour.OffsetType.XZ)
                    .pushReaction(PushReaction.DESTROY)
                    .sound(SoundType.GRASS)
            )
    );
    public static final DeferredBlock<Block> POTTED_PEONIA = BLOCKS.register("potted_peonia",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.PEONIA, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_POPPY)
            )
    );

    public static final DeferredBlock<Block> ROSE = registerBlock("rose",
            () -> new FlowerBlock(MobEffects.HEALTH_BOOST, 1, BlockBehaviour.Properties.of()
                    .instabreak()
                    .mapColor(MapColor.PLANT)
                    .noCollission()
                    .offsetType(BlockBehaviour.OffsetType.XZ)
                    .pushReaction(PushReaction.DESTROY)
                    .sound(SoundType.GRASS)
            )
    );
    public static final DeferredBlock<Block> POTTED_ROSE = BLOCKS.register("potted_rose",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.ROSE, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_POPPY)
            )
    );
    //endregion

    //region Orange wood set
    public static final DeferredBlock<Block> ORANGE_LEAVES = registerBlock("orange_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 30;
                }
            }
    );
    public static final DeferredBlock<Block> FLOWERING_ORANGE_LEAVES = registerBlock("flowering_orange_leaves",
            () -> new FloweringLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)) {
                @Override
                public Item getFruit() {
                    return ModItems.ORANGE.get();
                }
            }
    );
    public static final DeferredBlock<Block> ORANGE_LOG = registerBlock("orange_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG))
    );
    public static final DeferredBlock<Block> STRIPPED_ORANGE_LOG = registerBlock("stripped_orange_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG))
    );
    public static final DeferredBlock<Block> ORANGE_WOOD = registerBlock("orange_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD))
    );
    public static final DeferredBlock<Block> STRIPPED_ORANGE_WOOD = registerBlock("stripped_orange_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD))
    );

    public static final DeferredBlock<Block> ORANGE_SAPLING = registerBlock("orange_sapling",
            () -> new SaplingBlock(ModTreeGrowers.ORANGE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING))
    );
    public static final DeferredBlock<Block> POTTED_ORANGE_SAPLING = BLOCKS.register("potted_orange_sapling",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.ORANGE_SAPLING, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_OAK_SAPLING))
    );

    public static final DeferredBlock<Block> ORANGE_PLANKS = registerBlock("orange_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 5;
                }
            }
    );
    public static final DeferredBlock<StairBlock> ORANGE_STAIRS = registerBlock("orange_stairs",
            () -> new StairBlock(ModBlocks.ORANGE_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS)) {
                @Override
                public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 5;
                }
            }
    );
    public static final DeferredBlock<SlabBlock> ORANGE_SLAB = registerBlock("orange_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB)) {
                @Override
                public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 5;
                }
            }
    );
    public static final DeferredBlock<PressurePlateBlock> ORANGE_PRESSURE_PLATE = registerBlock("orange_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE))
    );
    public static final DeferredBlock<ButtonBlock> ORANGE_BUTTON = registerBlock("orange_button",
            () -> new ButtonBlock(BlockSetType.OAK, 20, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON))
    );
    public static final DeferredBlock<FenceBlock> ORANGE_FENCE = registerBlock("orange_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)) {
                @Override
                public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 5;
                }
            }
    );
    public static final DeferredBlock<FenceGateBlock> ORANGE_FENCE_GATE = registerBlock("orange_fence_gate",
            () -> new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)) {
                @Override
                public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 5;
                }
            }
    );
    public static final DeferredBlock<DoorBlock> ORANGE_DOOR = registerBlock("orange_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR)) {
                @Override
                public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 5;
                }
            }
    );
    public static final DeferredBlock<TrapDoorBlock> ORANGE_TRAPDOOR = registerBlock("orange_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR)) {
                @Override
                public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 5;
                }
            }
    );
    public static final DeferredBlock<StandingSignBlock> ORANGE_STANDING_SIGN = BLOCKS.register("orange_sign",
            () -> new StandingSignBlock(ModWoodTypes.ORANGE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN))
    );
    public static final DeferredBlock<WallSignBlock> ORANGE_WALL_SIGN = BLOCKS.register("orange_wall_sign",
            () -> new WallSignBlock(ModWoodTypes.ORANGE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN))
    );
    public static final DeferredBlock<CeilingHangingSignBlock> ORANGE_CEILING_HANGING_SIGN = BLOCKS.register("orange_hanging_sign",
            () -> new CeilingHangingSignBlock(ModWoodTypes.ORANGE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN))
    );
    public static final DeferredBlock<WallHangingSignBlock> ORANGE_WALL_HANGING_SIGN = BLOCKS.register("orange_wall_hanging_sign",
            () -> new WallHangingSignBlock(ModWoodTypes.ORANGE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN))
    );
    //endregion

    //region Pear wood set
    public static final DeferredBlock<Block> PEAR_LEAVES = registerBlock("pear_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 30;
                }
            }
    );
    public static final DeferredBlock<Block> FLOWERING_PEAR_LEAVES = registerBlock("flowering_pear_leaves",
            () -> new FloweringLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)) {
                @Override
                public Item getFruit() {
                    return ModItems.PEAR.get();
                }
            }
    );
    public static final DeferredBlock<Block> PEAR_LOG = registerBlock("pear_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG))
    );
    public static final DeferredBlock<Block> STRIPPED_PEAR_LOG = registerBlock("stripped_pear_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG))
    );
    public static final DeferredBlock<Block> PEAR_WOOD = registerBlock("pear_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD))
    );
    public static final DeferredBlock<Block> STRIPPED_PEAR_WOOD = registerBlock("stripped_pear_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD))
    );

    public static final DeferredBlock<Block> PEAR_SAPLING = registerBlock("pear_sapling",
            () -> new SaplingBlock(ModTreeGrowers.PEAR, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING))
    );
    public static final DeferredBlock<Block> POTTED_PEAR_SAPLING = BLOCKS.register("potted_pear_sapling",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.PEAR_SAPLING, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_OAK_SAPLING))
    );

    public static final DeferredBlock<Block> PEAR_PLANKS = registerBlock("pear_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 5;
                }
            }
    );
    public static final DeferredBlock<StairBlock> PEAR_STAIRS = registerBlock("pear_stairs",
            () -> new StairBlock(ModBlocks.PEAR_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS)) {
                @Override
                public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 5;
                }
            }
    );
    public static final DeferredBlock<SlabBlock> PEAR_SLAB = registerBlock("pear_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB)) {
                @Override
                public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 5;
                }
            }
    );
    public static final DeferredBlock<PressurePlateBlock> PEAR_PRESSURE_PLATE = registerBlock("pear_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE))
    );
    public static final DeferredBlock<ButtonBlock> PEAR_BUTTON = registerBlock("pear_button",
            () -> new ButtonBlock(BlockSetType.OAK, 20, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON))
    );
    public static final DeferredBlock<FenceBlock> PEAR_FENCE = registerBlock("pear_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)) {
                @Override
                public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 5;
                }
            }
    );
    public static final DeferredBlock<FenceGateBlock> PEAR_FENCE_GATE = registerBlock("pear_fence_gate",
            () -> new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)) {
                @Override
                public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 5;
                }
            }
    );
    public static final DeferredBlock<DoorBlock> PEAR_DOOR = registerBlock("pear_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR)) {
                @Override
                public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 5;
                }
            }
    );
    public static final DeferredBlock<TrapDoorBlock> PEAR_TRAPDOOR = registerBlock("pear_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR)) {
                @Override
                public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 5;
                }
            }
    );
    public static final DeferredBlock<StandingSignBlock> PEAR_STANDING_SIGN = BLOCKS.register("pear_sign",
            () -> new StandingSignBlock(ModWoodTypes.PEAR, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN))
    );
    public static final DeferredBlock<WallSignBlock> PEAR_WALL_SIGN = BLOCKS.register("pear_wall_sign",
            () -> new WallSignBlock(ModWoodTypes.PEAR, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN))
    );
    public static final DeferredBlock<CeilingHangingSignBlock> PEAR_CEILING_HANGING_SIGN = BLOCKS.register("pear_hanging_sign",
            () -> new CeilingHangingSignBlock(ModWoodTypes.PEAR, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN))
    );
    public static final DeferredBlock<WallHangingSignBlock> PEAR_WALL_HANGING_SIGN = BLOCKS.register("pear_wall_hanging_sign",
            () -> new WallHangingSignBlock(ModWoodTypes.PEAR, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN))
    );
    //endregion

    public static final DeferredBlock<Block> PINECONE_BLOCK = registerBlock("pinecone_block",
            () -> new PineconeBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BROWN)
                    .strength(1f)
                    .sound(SoundType.WOOD)
            )
    );

    public static final DeferredBlock<Block> PLASTER = registerBlock("plaster",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.TERRACOTTA_WHITE)
                    .requiresCorrectToolForDrops()
                    .strength(2f)
                    .sound(SoundType.STONE)
            )
    );

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}