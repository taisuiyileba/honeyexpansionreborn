package com.spiteful_raccoon.honeyexpansionreborn;

import com.spiteful_raccoon.honeyexpansionreborn.init.BlockInit;
import com.spiteful_raccoon.honeyexpansionreborn.init.ItemInit;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

@Mod(HoneyExpansion.MOD_ID)
public class HoneyExpansion {
    public static final String MOD_ID = "honeyexpansionreborn";

    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    public static final RegistryObject<CreativeModeTab> HONEYEXPANSION_TAB = CREATIVE_TABS.register("honeyexpansionreborn",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.honeyexpansionreborn"))
                    .icon(() -> new ItemStack(ItemInit.HONEY_BERRIES.get()))
                    .displayItems((parameters, output) -> {
                        output.accept(ItemInit.HONEY_BERRIES.get());
                        output.accept(ItemInit.SLICE_OF_HONEY_CAKE.get());
                        output.accept(ItemInit.HONEY_COOKIE_SAUSAGE.get());
                        output.accept(ItemInit.PANCAKE.get());
                        output.accept(ItemInit.HONEY_PANCAKE.get());
                        output.accept(BlockInit.HONEY_CAKE.get());
                        output.accept(BlockInit.HONEY_BRICKS.get());
                        output.accept(BlockInit.HONEY_BRICK_SLAB.get());
                        output.accept(BlockInit.HONEY_BRICK_STAIRS.get());
                        output.accept(BlockInit.CHISELED_HONEY_BRICKS.get());
                        output.accept(BlockInit.HONEY_BRICK_WALL.get());
                    })
                    .build());

    public HoneyExpansion() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ItemInit.ITEMS.register(modEventBus);
        BlockInit.BLOCKS.register(modEventBus);
        CREATIVE_TABS.register(modEventBus);
    }
}
