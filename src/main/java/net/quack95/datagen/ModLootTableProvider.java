package net.quack95.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.quack95.block.ModBlocks;
import net.quack95.item.ModItems;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.CATNIP_ORE, catnipLikeOreDrops(ModBlocks.CATNIP_ORE, ModItems.RAW_CATNIP));
        addDrop(ModBlocks.DEEPSLATE_CATNIP_ORE, catnipLikeOreDrops(ModBlocks.DEEPSLATE_CATNIP_ORE, ModItems.RAW_CATNIP));
    }

    public LootTable.Builder catnipLikeOreDrops(Block drop, Item item) {
        return BlockLootTableGenerator.dropsWithSilkTouch(drop, (LootPoolEntry.Builder)this.applyExplosionDecay(drop,
                ((LeafEntry.Builder) ItemEntry.builder(Items.RAW_COPPER)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider
                                .create(2.0f, 5.0f)))).apply(ApplyBonusLootFunction
                        .oreDrops(Enchantments.FORTUNE))));
    }
}
