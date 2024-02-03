package net.quack95.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import net.quack95.block.ModBlocks;
import net.quack95.item.ModItems;

import java.util.List;

public class ModRecipeProvider extends FabricRecipeProvider {
    public static final List<ItemConvertible> CATNIP_SMELTABLES = List.of(
            ModBlocks.CATNIP_ORE, ModBlocks.DEEPSLATE_CATNIP_ORE);
    public static final List<ItemConvertible> CATNIP_EDIBLES = List.of(
            ModItems.COOKED_CATNIP);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerSmelting(exporter, CATNIP_SMELTABLES, RecipeCategory.MISC, ModItems.RAW_CATNIP,
                0.7f, 200, "catnip");
        offerBlasting(exporter, CATNIP_SMELTABLES, RecipeCategory.MISC, ModItems.RAW_CATNIP,
                0.8f, 100, "catnip");

        offerSmelting(exporter, CATNIP_EDIBLES, RecipeCategory.MISC, ModItems.SUSPICIOUS_CATNIP,
                0.6f, 100, "catnip");
        offerBlasting(exporter, CATNIP_EDIBLES, RecipeCategory.MISC, ModItems.CATNIP_EMBER,
                0.5f, 100, "catnip");



        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.COOKED_CATNIP, RecipeCategory.DECORATIONS,
                ModBlocks.CATNIP_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.EDIBLE_CATNIP, 1)
                .pattern("   ")
                .pattern(" C ")
                .pattern(" # ")
                .input('C', ModItems.COOKED_CATNIP)
                .input('#', Items.BOWL)
                .criterion(hasItem(Items.BOWL), conditionsFromItem(Items.BOWL))
                .criterion(hasItem(ModItems.COOKED_CATNIP), conditionsFromItem(ModItems.COOKED_CATNIP))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.EDIBLE_CATNIP)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CATNIP_DETECTOR, 1)
                .pattern(" B ")
                .pattern(" B ")
                .pattern("BCB")
                .input('B', Items.IRON_INGOT)
                .input('C', ModItems.CATNIP_EMBER)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(ModItems.CATNIP_EMBER), conditionsFromItem(ModItems.CATNIP_EMBER))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CATNIP_DETECTOR)));

    }
}
