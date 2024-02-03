package net.quack95.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.quack95.block.ModBlocks;
import net.quack95.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CATNIP_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_CATNIP_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CATNIP_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MEOW_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RAW_CATNIP, Models.GENERATED);
        itemModelGenerator.register(ModItems.COOKED_CATNIP, Models.GENERATED);
        itemModelGenerator.register(ModItems.CATNIP_DETECTOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.CATNIP_EMBER, Models.GENERATED);
        itemModelGenerator.register(ModItems.EDIBLE_CATNIP, Models.GENERATED);
        itemModelGenerator.register(ModItems.SUSPICIOUS_CATNIP, Models.GENERATED);
    }
}
