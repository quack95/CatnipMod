package net.quack95.item;

import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.quack95.Catnip;

import net.minecraft.registry.Registry;
import net.quack95.item.custom.CatnipDetectorItem;
import net.quack95.item.custom.ModFoods;

public class ModItems {
    public static final Item EDIBLE_CATNIP = registerItem("edible_catnip", new Item(new FabricItemSettings().food(ModFoods.EDIBLE_CATNIP)));
    public static final Item COOKED_CATNIP = registerItem("cooked_catnip", new Item(new FabricItemSettings()));
    public static final Item RAW_CATNIP = registerItem("raw_catnip", new Item(new FabricItemSettings()));
    public static final Item SUSPICIOUS_CATNIP = registerItem("suspicious_catnip", new Item(new FabricItemSettings().food(ModFoods.SUSPICIOUS_CATNIP)));
    public static final Item CATNIP_EMBER = registerItem("catnip_ember", new Item(new FabricItemSettings()));
    public static final Item HARDENED_CATNIP = registerItem("hardened_catnip", new Item(new FabricItemSettings()));
    public static final Item CATNIP_SHARD = registerItem("catnip_shard", new Item(new FabricItemSettings()));

    // tools & stuff
    public static final Item CATNIP_PICKAXE = registerItem("catnip_pickaxe",
            new PickaxeItem(ModToolMaterial.CATNIP_SHARD, 2, 2f, new FabricItemSettings()));
    public static final Item CATNIP_AXE = registerItem("catnip_axe",
            new AxeItem(ModToolMaterial.CATNIP_SHARD, 2, 6f, new FabricItemSettings()));
    public static final Item CATNIP_SHOVEL = registerItem("catnip_shovel",
            new ShovelItem(ModToolMaterial.CATNIP_SHARD, 1, 2f, new FabricItemSettings()));
    public static final Item CATNIP_SWORD = registerItem("catnip_sword",
            new SwordItem(ModToolMaterial.CATNIP_SHARD, 8, 4f, new FabricItemSettings()));
    public static final Item CATNIP_HOE = registerItem("catnip_hoe",
            new HoeItem(ModToolMaterial.CATNIP_SHARD, 3, 3f, new FabricItemSettings()));
    //
    public static final Item CATNIP_DETECTOR = registerItem("catnip_detector",
            new CatnipDetectorItem(new FabricItemSettings().maxDamage(50)));

    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries) {
        Catnip.LOGGER.info("Adding items to INGREDIENTS tab.");
        entries.add(COOKED_CATNIP);
        entries.add(RAW_CATNIP);
    }
    private static void addItemsToFoodItemsTabItemGroup(FabricItemGroupEntries entries) {
        Catnip.LOGGER.info("Adding items to FOOD_ITEMS tab.");
        entries.add(EDIBLE_CATNIP);
        entries.add(SUSPICIOUS_CATNIP);
    }

    private static Item registerItem(String name, Item item) {
        Item registeredItem = Registry.register(Registries.ITEM, new Identifier(Catnip.MOD_ID, name), item);
        Catnip.LOGGER.info("Registered item: " + name);
        return registeredItem;
    }

    public static void registerModItems() {
        Catnip.LOGGER.info("Registering mod items for " + Catnip.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::addItemsToFoodItemsTabItemGroup);
    }
}
