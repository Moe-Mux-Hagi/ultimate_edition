package com.studiodragon.ultimateedition.block;

import com.studiodragon.ultimateedition.UltimateEdition;
import com.studiodragon.ultimateedition.block.custom.PineconeBlock;
import com.studiodragon.ultimateedition.item.ModItems;
import com.studiodragon.ultimateedition.world.level.block.FloweringLeavesBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(UltimateEdition.MOD_ID);

    //NB : if the block has its own Java class, write it as `() -> new [Block Java class]` if not, `() -> new Block`. Don't get fooled like last time, asshole

    public static final DeferredBlock<Block> FLOWERING_ACACIA_LEAVES = registerBlock(
            "flowering_acacia_leaves",
            () -> new FloweringLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_LEAVES)
            ) {
                @Override
                public Item getFruit() {
                    return ModItems.POD.get();
                }
            }
    );
    public static final DeferredBlock<Block> FLOWERING_BIRCH_LEAVES = registerBlock(
            "flowering_birch_leaves",
            () -> new FloweringLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_LEAVES)
            ) {
                @Override
                public Item getFruit() {
                    return ModItems.CATKIN.get();
                }
            }
    );
    public static final DeferredBlock<Block> FLOWERING_CHERRY_LEAVES = registerBlock(
            "flowering_cherry_leaves",
            () -> new FloweringLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_LEAVES)
            ) {
                @Override
                public Item getFruit() {
                    return ModItems.CHERRIES.get();
                }
            }
    );
    public static final DeferredBlock<Block> FLOWERING_DARK_OAK_LEAVES = registerBlock(
            "flowering_dark_oak_leaves",
            () -> new FloweringLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_LEAVES)
            ) {
                @Override
                public Item getFruit() {
                    return ModItems.DARK_ACORN.get();
                }
            }
    );

    public static final DeferredBlock<Block> FLOWERING_JUNGLE_LEAVES = registerBlock(
            "flowering_jungle_leaves",
            () -> new FloweringLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES)
            ) {
                @Override
                public Item getFruit() {
                    return ModItems.SKY_FRUIT.get();
                }
            }
    );

    public static final DeferredBlock<Block> FLOWERING_OAK_LEAVES = registerBlock(
            "flowering_oak_leaves",
            () -> new FloweringLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)
            ) {
                @Override
                public Item getFruit() {
                    return ModItems.ACORN.get();
                }
            }
    );

    public static final DeferredBlock<Block> FLOWERING_SPRUCE_LEAVES = registerBlock(
            "flowering_spruce_leaves",
            () -> new FloweringLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)
            ) {
                @Override
                public Item getFruit() {
                    return ModItems.PINECONE.get();
                }
            }
    );

    public static final DeferredBlock<Block> PINECONE_BLOCK = registerBlock(
            "pinecone_block",
            () -> new PineconeBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BROWN)
                    .strength(1f)
                    .sound(SoundType.WOOD)
            )
    );

    public static final DeferredBlock<Block> PLASTER = registerBlock(
            "plaster",
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