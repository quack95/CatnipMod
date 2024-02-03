package net.quack95.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
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

    public static final Block SCRATCHING_BLOCK = registerBlock("scratching_block",
            new Block(FabricBlockSettings.copyOf(Blocks.BAMBOO_BLOCK)));

    // stairs, slabs, fences, buttons, stuff, stuff and more
    public static final Block SCRATCHING_STAIRS = registerBlock("scratching_stairs",
            new StairsBlock(Blocks.BAMBOO_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(Blocks.NOTE_BLOCK)));
    public static final Block SCRATCHING_SLAB = registerBlock("scratching_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.NOTE_BLOCK)));

    public static final Block SCRATCHING_BUTTON = registerBlock("scratching_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.NOTE_BLOCK), BlockSetType.BAMBOO, 10, true));
    public static final Block SCRATCHING_PRESSURE_PLATE = registerBlock("scratching_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.copyOf(Blocks.NOTE_BLOCK), BlockSetType.BAMBOO));

    public static final Block SCRATCHING_FENCE = registerBlock("scratching_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.NOTE_BLOCK)));
    public static final Block SCRATCHING_FENCE_GATE = registerBlock("scratching_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.NOTE_BLOCK), WoodType.BAMBOO));
    public static final Block SCRATCHING_WALL = registerBlock("scratching_wall",
            new WallBlock(FabricBlockSettings.copyOf(Blocks.NOTE_BLOCK)));

    public static final Block SCRATCHING_DOOR = registerBlock("scratching_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.NOTE_BLOCK), BlockSetType.BAMBOO));
    public static final Block SCRATCHING_TRAPDOOR = registerBlock("scratching_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.NOTE_BLOCK), BlockSetType.BAMBOO));
    //


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
