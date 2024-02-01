package net.quack95.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.quack95.Catnip;
import net.quack95.block.custom.MeowBlock;

public class ModBlocks {
    public static final Block CATNIP_BLOCK = registerBlock("catnip_block",
            new Block(FabricBlockSettings.copyOf(Blocks.DIRT)));
    public static final Block CATNIP_ORE = registerBlock("catnip_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE).requiresTool().strength(2f),
                    UniformIntProvider.create(2, 5)));
    public static final Block DEEPSLATE_CATNIP_ORE = registerBlock("deepslate_catnip_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE).requiresTool().strength(4f),
                    UniformIntProvider.create(2, 5)));

    public static final Block MEOW_BLOCK = registerBlock("meow_block",
            new MeowBlock(FabricBlockSettings.copyOf(Blocks.NOTE_BLOCK)));


    // helper methods
    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Catnip.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(Catnip.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        Catnip.LOGGER.info("Registering mod blocks for "+Catnip.MOD_ID);

    }
}
