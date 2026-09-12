package com.studiodragon.ultimateedition.datagen;

import com.studiodragon.ultimateedition.UltimateEdition;
import com.studiodragon.ultimateedition.block.ModBlocks;
import com.studiodragon.ultimateedition.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {
        //Smeltable ingredients tags
        List<ItemLike> ACORN_ROASTABLES = List.of(ModItems.ACORN);
        List<ItemLike> DARK_ACORN_ROASTABLES = List.of(ModItems.DARK_ACORN);
        List<ItemLike> IRON_SMELTABLES = List.of(Blocks.RAW_IRON_BLOCK);
        List<ItemLike> PINE_NUTS_ROASTABLES = List.of(ModItems.PINE_NUTS);

        //Crafting (shaped)
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PINECONE_BLOCK.get())
                .pattern("PPP")
                .pattern("PPP")
                .pattern("PPP")
                .define('P', ModItems.PINECONE.get())
                .unlockedBy("has_pinecone", has(ModItems.PINECONE)).save(recipeOutput);

        //Crafting (shapeless)
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PINE_NUTS.get())
                .requires(ModItems.PINECONE)
                .unlockedBy("has_pinecone", has(ModItems.PINECONE)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PINECONE.get(), 9)
                .requires(ModBlocks.PINECONE_BLOCK)
                .unlockedBy("has_pinecone_block", has(ModBlocks.PINECONE_BLOCK)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.PLASTER.get(), 8)
                .requires(Blocks.CLAY, 4)
                .requires(Blocks.SAND, 4)
                .unlockedBy("has_clay", has(Blocks.CLAY)).save(recipeOutput);

        //Smelting
        oreSmelting(recipeOutput, ACORN_ROASTABLES, RecipeCategory.FOOD, ModItems.ROASTED_ACORN, 0.35f, 200, "roasted_acorn");
        oreSmelting(recipeOutput, DARK_ACORN_ROASTABLES, RecipeCategory.FOOD, ModItems.ROASTED_DARK_ACORN, 0.35f, 200, "roasted_dark_acorn");
        //oreSmelting(recipeOutput, IRON_SMELTABLES, RecipeCategory.MISC, Blocks.IRON_BLOCK, 7, 1600, "iron_block");
        oreSmelting(recipeOutput, PINE_NUTS_ROASTABLES, RecipeCategory.FOOD, ModItems.ROASTED_PINE_NUTS, 0.35f, 200, "roasted_pine_nuts");

        //Blasting
        //oreBlasting(recipeOutput, IRON_SMELTABLES, RecipeCategory.MISC, Blocks.IRON_BLOCK, 7, 800, "iron_block");

        //Smoking
        oreSmoking(recipeOutput, ACORN_ROASTABLES, RecipeCategory.FOOD, ModItems.ROASTED_ACORN, 0.35f, 100, "roasted_acorn");
        oreSmoking(recipeOutput, DARK_ACORN_ROASTABLES, RecipeCategory.FOOD, ModItems.ROASTED_DARK_ACORN, 0.35f, 100, "roasted_dark_acorn");
        oreSmoking(recipeOutput, PINE_NUTS_ROASTABLES, RecipeCategory.FOOD, ModItems.ROASTED_PINE_NUTS, 0.35f, 100, "roasted_pine_nuts");

        //Campfire Smoking
        oreCampfireCooking(recipeOutput, ACORN_ROASTABLES, RecipeCategory.FOOD, ModItems.ROASTED_ACORN, 0, 600, "roasted_acorn");
        oreCampfireCooking(recipeOutput, DARK_ACORN_ROASTABLES, RecipeCategory.FOOD, ModItems.ROASTED_DARK_ACORN, 0.35f, 600, "roasted_dark_acorn");
        oreCampfireCooking(recipeOutput, PINE_NUTS_ROASTABLES, RecipeCategory.FOOD, ModItems.ROASTED_PINE_NUTS, 0, 600, "roasted_pine_nuts");
    }

    //Smelting recipes path rerouter to Mod ID
    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smelting_");
    }
    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting_");
    }
    protected static void oreSmoking(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMOKING_RECIPE, SmokingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smoking_");
    }
    protected static void oreCampfireCooking(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.CAMPFIRE_COOKING_RECIPE, CampfireCookingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_campfire_cooking_");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for (ItemLike itemLike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemLike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory)
                    .group(pGroup)
                    .unlockedBy(getHasName(itemLike), has(itemLike))
                    .save(recipeOutput, UltimateEdition.MOD_ID + ":" + getItemName(pResult) + pRecipeName + getItemName(itemLike));
        }
    }
}