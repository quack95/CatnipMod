package net.quack95.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.quack95.Catnip;
import net.quack95.block.ModBlocks;
import net.quack95.item.custom.CatnipDetectorItem;

public class ModItemGroups {
    public static final ItemGroup CATNIP_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Catnip.MOD_ID, "catnip"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable("itemgroup.catnip"))
                    .icon(() -> new ItemStack(ModItems.EDIBLE_CATNIP))
                    .entries((displayContext, entries) -> {
                        //items
                        entries.add(ModItems.COOKED_CATNIP);
                        entries.add(ModItems.RAW_CATNIP);
                        entries.add(ModItems.SUSPICIOUS_CATNIP);
                        entries.add(ModItems.EDIBLE_CATNIP);
                        entries.add(ModItems.CATNIP_DETECTOR);
                        entries.add(ModItems.CATNIP_EMBER);
                        entries.add(ModItems.HARDENED_CATNIP);
                        entries.add(ModItems.CATNIP_SHARD);

                        entries.add(ModItems.CATNIP_SWORD);
                        entries.add(ModItems.CATNIP_AXE);
                        entries.add(ModItems.CATNIP_SHOVEL);
                        entries.add(ModItems.CATNIP_HOE);
                        entries.add(ModItems.CATNIP_PICKAXE);

                        // blocks
                        entries.add(ModBlocks.CATNIP_BLOCK);
                        entries.add(ModBlocks.CATNIP_ORE);
                        entries.add(ModBlocks.DEEPSLATE_CATNIP_ORE);
                        entries.add(ModBlocks.MEOW_BLOCK);
                        entries.add(ModBlocks.SCRATCHING_TRAPDOOR);
                        entries.add(ModBlocks.SCRATCHING_BUTTON);
                        entries.add(ModBlocks.SCRATCHING_DOOR);
                        entries.add(ModBlocks.SCRATCHING_FENCE);
                        entries.add(ModBlocks.SCRATCHING_SLAB);
                        entries.add(ModBlocks.SCRATCHING_FENCE_GATE);
                        entries.add(ModBlocks.SCRATCHING_STAIRS);
                        entries.add(ModBlocks.SCRATCHING_PRESSURE_PLATE);
                        entries.add(ModBlocks.SCRATCHING_WALL);
                        entries.add(ModBlocks.SCRATCHING_BLOCK);

                    })
                    .build());



    public static void registerItemGroups() {
        Catnip.LOGGER.info("Registering item groups for "+Catnip.MOD_ID);
    }
}
