package com.spiteful_raccoon.honeyexpansionreborn.init;

import com.spiteful_raccoon.honeyexpansionreborn.HoneyExpansion;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BlockInit {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(HoneyExpansion.MOD_ID);

    public static final DeferredBlock<CakeBlock> HONEY_CAKE = registerBlock("honey_cake",
            () -> new CakeBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_YELLOW)
                    .strength(0.5F, 0.5F)
                    .sound(SoundType.WOOL)),
            () -> new Item.Properties().stacksTo(1));

    public static final DeferredBlock<Block> HONEY_BRICKS = registerBlock("honey_bricks",
            () -> new Block(honeyBrickProperties()));

    public static final DeferredBlock<SlabBlock> HONEY_BRICK_SLAB = registerBlock("honey_brick_slab",
            () -> new SlabBlock(honeyBrickProperties()));

    public static final DeferredBlock<StairBlock> HONEY_BRICK_STAIRS = registerBlock("honey_brick_stairs",
            () -> new StairBlock(HONEY_BRICKS.get().defaultBlockState(), honeyBrickProperties()));

    public static final DeferredBlock<Block> CHISELED_HONEY_BRICKS = registerBlock("chiseled_honey_bricks",
            () -> new Block(honeyBrickProperties()));

    public static final DeferredBlock<WallBlock> HONEY_BRICK_WALL = registerBlock("honey_brick_wall",
            () -> new WallBlock(honeyBrickProperties()));

    private static BlockBehaviour.Properties honeyBrickProperties() {
        return BlockBehaviour.Properties.of()
                .mapColor(MapColor.COLOR_YELLOW)
                .strength(1.5F, 6.0F)
                .sound(SoundType.STONE)
                .requiresCorrectToolForDrops();
    }

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        return registerBlock(name, block, Item.Properties::new);
    }

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block, Supplier<Item.Properties> itemProperties) {
        DeferredBlock<T> registeredBlock = BLOCKS.register(name, block);
        ItemInit.ITEMS.register(name, () -> new BlockItem(registeredBlock.get(), itemProperties.get()));
        return registeredBlock;
    }
}
