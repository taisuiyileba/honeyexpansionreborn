package com.spiteful_raccoon.honeyexpansionreborn.init;

import com.spiteful_raccoon.honeyexpansionreborn.HoneyExpansion;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, HoneyExpansion.MOD_ID);

    public static final RegistryObject<Item> HONEY_BERRIES = registerFood("honey_berries",
            new FoodProperties.Builder().nutrition(4).saturationMod(0.4F).build());

    public static final RegistryObject<Item> SLICE_OF_HONEY_CAKE = registerFood("slice_of_honey_cake",
            new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.1F)
                    .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 400, 0), 1.0F)
                    .alwaysEat()
                    .build());

    public static final RegistryObject<Item> HONEY_COOKIE_SAUSAGE = registerFood("honey_cookie_sausage",
            new FoodProperties.Builder().nutrition(4).saturationMod(0.3F).alwaysEat().build());

    public static final RegistryObject<Item> PANCAKE = registerFood("pancake",
            new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).build());

    public static final RegistryObject<Item> HONEY_PANCAKE = registerFood("honey_pancake",
            new FoodProperties.Builder().nutrition(5).saturationMod(0.5F).build());

    private static RegistryObject<Item> registerFood(String name, FoodProperties food) {
        return ITEMS.register(name, () -> new Item(new Item.Properties().food(food)));
    }
}
