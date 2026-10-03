package com.studiodragon.ultimateedition.datagen;

import com.studiodragon.ultimateedition.UltimateEdition;
import com.studiodragon.ultimateedition.block.ModBlocks;
import com.studiodragon.ultimateedition.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
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
        //region Cooking
        //region Cookable ingredients tags
        List<ItemLike> ACORN_COOKABLES = List.of(ModItems.ACORN);
        List<ItemLike> CHARCOAL_COOKABLES = List.of(ModItems.SKY_FRUIT);
        //List<ItemLike> COPPER_COOKABLES = List.of(Blocks.RAW_COPPER_BLOCK);
        List<ItemLike> DARK_ACORN_COOKABLES = List.of(ModItems.DARK_ACORN);
        //List<ItemLike> GOLD_COOKABLES = List.of(Blocks.RAW_GOLD_BLOCK);
        //List<ItemLike> IRON_COOKABLES = List.of(Blocks.RAW_IRON_BLOCK);
        List<ItemLike> PINE_NUTS_COOKABLES = List.of(ModItems.PINE_NUTS);
        //endregion

        //region Smelting
        oreSmelting(recipeOutput, ACORN_COOKABLES, RecipeCategory.FOOD, ModItems.ROASTED_ACORN, 0.35f, 200, "roasted_acorn");
        oreSmelting(recipeOutput, DARK_ACORN_COOKABLES, RecipeCategory.FOOD, ModItems.ROASTED_DARK_ACORN, 0.5f, 200, "roasted_dark_acorn");
        oreSmelting(recipeOutput, PINE_NUTS_COOKABLES, RecipeCategory.FOOD, ModItems.ROASTED_PINE_NUTS, 0.35f, 200, "roasted_pine_nuts");
        //oreSmelting(recipeOutput, COPPER_COOKABLES, RecipeCategory.MISC, Blocks.COPPER_BLOCK, 7, 1600, "copper_block");
        //oreSmelting(recipeOutput, GOLD_COOKABLES, RecipeCategory.MISC, Blocks.GOLD_BLOCK, 10, 1600, "gold_block");
        //oreSmelting(recipeOutput, IRON_COOKABLES, RecipeCategory.MISC, Blocks.IRON_BLOCK, 7, 1600, "iron_block");
        oreSmelting(recipeOutput, CHARCOAL_COOKABLES, RecipeCategory.MISC, Items.CHARCOAL, 0.35f, 200, "charcoal");
        //endregion

        //region Blasting
        //oreBlasting(recipeOutput, COPPER_COOKABLES, RecipeCategory.MISC, Blocks.COPPER_BLOCK, 7, 800, "copper_block");
        //oreBlasting(recipeOutput, GOLD_COOKABLES, RecipeCategory.MISC, Blocks.GOLD_BLOCK, 10, 800, "gold_block");
        //oreBlasting(recipeOutput, IRON_COOKABLES, RecipeCategory.MISC, Blocks.IRON_BLOCK, 7, 800, "iron_block");
        //endregion

        //region Smoking
        oreSmoking(recipeOutput, ACORN_COOKABLES, RecipeCategory.FOOD, ModItems.ROASTED_ACORN, 0.35f, 100, "roasted_acorn");
        oreSmoking(recipeOutput, DARK_ACORN_COOKABLES, RecipeCategory.FOOD, ModItems.ROASTED_DARK_ACORN, 0.5f, 100, "roasted_dark_acorn");
        oreSmoking(recipeOutput, PINE_NUTS_COOKABLES, RecipeCategory.FOOD, ModItems.ROASTED_PINE_NUTS, 0.35f, 100, "roasted_pine_nuts");
        //endregion

        //region Campfire Smoking
        oreCampfireCooking(recipeOutput, ACORN_COOKABLES, ModItems.ROASTED_ACORN, 0, "roasted_acorn");
        oreCampfireCooking(recipeOutput, DARK_ACORN_COOKABLES, ModItems.ROASTED_DARK_ACORN, 0.15f, "roasted_dark_acorn");
        oreCampfireCooking(recipeOutput, PINE_NUTS_COOKABLES, ModItems.ROASTED_PINE_NUTS, 0, "roasted_pine_nuts");
        //endregion
        //endregion

        //region Crafting
        //region Builders
        buttonBuilder(ModBlocks.APPLE_BUTTON.get(), Ingredient.of(ModBlocks.APPLE_PLANKS)).group("wooden_button")
                .unlockedBy("has_apple_planks", has(ModBlocks.APPLE_PLANKS)).save(recipeOutput);
        buttonBuilder(ModBlocks.AZALEA_BUTTON.get(), Ingredient.of(ModBlocks.AZALEA_PLANKS)).group("wooden_button")
                .unlockedBy("has_azalea_planks", has(ModBlocks.AZALEA_PLANKS)).save(recipeOutput);
        buttonBuilder(ModBlocks.ORANGE_BUTTON.get(), Ingredient.of(ModBlocks.ORANGE_PLANKS)).group("wooden_button")
                .unlockedBy("has_orange_planks", has(ModBlocks.ORANGE_PLANKS)).save(recipeOutput);
        buttonBuilder(ModBlocks.PEAR_BUTTON.get(), Ingredient.of(ModBlocks.PEAR_PLANKS)).group("wooden_button")
                .unlockedBy("has_pear_planks", has(ModBlocks.PEAR_PLANKS)).save(recipeOutput);

        chestBoat(recipeOutput, ModItems.APPLE_CHEST_BOAT.get(), ModItems.APPLE_BOAT);
        chestBoat(recipeOutput, ModItems.AZALEA_CHEST_BOAT.get(), ModItems.AZALEA_BOAT);
        chestBoat(recipeOutput, ModItems.ORANGE_CHEST_BOAT.get(), ModItems.ORANGE_BOAT);
        chestBoat(recipeOutput, ModItems.PEAR_CHEST_BOAT.get(), ModItems.PEAR_BOAT);

        doorBuilder(ModBlocks.APPLE_DOOR.get(), Ingredient.of(ModBlocks.APPLE_PLANKS)).group("wooden_door")
                .unlockedBy("has_apple_planks", has(ModBlocks.APPLE_PLANKS)).save(recipeOutput);
        doorBuilder(ModBlocks.AZALEA_DOOR.get(), Ingredient.of(ModBlocks.AZALEA_PLANKS)).group("wooden_door")
                .unlockedBy("has_azalea_planks", has(ModBlocks.AZALEA_PLANKS)).save(recipeOutput);
        doorBuilder(ModBlocks.ORANGE_DOOR.get(), Ingredient.of(ModBlocks.ORANGE_PLANKS)).group("wooden_door")
                .unlockedBy("has_orange_planks", has(ModBlocks.ORANGE_PLANKS)).save(recipeOutput);
        doorBuilder(ModBlocks.PEAR_DOOR.get(), Ingredient.of(ModBlocks.PEAR_PLANKS)).group("wooden_door")
                .unlockedBy("has_pear_planks", has(ModBlocks.PEAR_PLANKS)).save(recipeOutput);

        fenceBuilder(ModBlocks.APPLE_FENCE.get(), Ingredient.of(ModBlocks.APPLE_PLANKS)).group("wooden_fence")
                .unlockedBy("has_apple_planks", has(ModBlocks.APPLE_PLANKS)).save(recipeOutput);
        fenceBuilder(ModBlocks.AZALEA_FENCE.get(), Ingredient.of(ModBlocks.AZALEA_PLANKS)).group("wooden_fence")
                .unlockedBy("has_azalea_planks", has(ModBlocks.AZALEA_PLANKS)).save(recipeOutput);
        fenceBuilder(ModBlocks.ORANGE_FENCE.get(), Ingredient.of(ModBlocks.ORANGE_PLANKS)).group("wooden_fence")
                .unlockedBy("has_orange_planks", has(ModBlocks.ORANGE_PLANKS)).save(recipeOutput);
        fenceBuilder(ModBlocks.PEAR_FENCE.get(), Ingredient.of(ModBlocks.PEAR_PLANKS)).group("wooden_fence")
                .unlockedBy("has_pear_planks", has(ModBlocks.PEAR_PLANKS)).save(recipeOutput);

        fenceGateBuilder(ModBlocks.APPLE_FENCE_GATE.get(), Ingredient.of(ModBlocks.APPLE_PLANKS)).group("wooden_fence_gate")
                .unlockedBy("has_apple_planks", has(ModBlocks.APPLE_PLANKS)).save(recipeOutput);
        fenceGateBuilder(ModBlocks.AZALEA_FENCE_GATE.get(), Ingredient.of(ModBlocks.AZALEA_PLANKS)).group("wooden_fence_gate")
                .unlockedBy("has_azalea_planks", has(ModBlocks.AZALEA_PLANKS)).save(recipeOutput);
        fenceGateBuilder(ModBlocks.ORANGE_FENCE_GATE.get(), Ingredient.of(ModBlocks.ORANGE_PLANKS)).group("wooden_fence_gate")
                .unlockedBy("has_orange_planks", has(ModBlocks.ORANGE_PLANKS)).save(recipeOutput);
        fenceGateBuilder(ModBlocks.PEAR_FENCE_GATE.get(), Ingredient.of(ModBlocks.PEAR_PLANKS)).group("wooden_fence_gate")
                .unlockedBy("has_pear_planks", has(ModBlocks.PEAR_PLANKS)).save(recipeOutput);

        hangingSign(recipeOutput, ModItems.APPLE_HANGING_SIGN.get(), ModBlocks.STRIPPED_APPLE_LOG);
        hangingSign(recipeOutput, ModItems.AZALEA_HANGING_SIGN.get(), ModBlocks.STRIPPED_AZALEA_LOG);
        hangingSign(recipeOutput, ModItems.ORANGE_HANGING_SIGN.get(), ModBlocks.STRIPPED_ORANGE_LOG);
        hangingSign(recipeOutput, ModItems.PEAR_HANGING_SIGN.get(), ModBlocks.STRIPPED_PEAR_LOG);

        pressurePlateBuilder(RecipeCategory.REDSTONE, ModBlocks.APPLE_PRESSURE_PLATE.get(), Ingredient.of(ModBlocks.APPLE_PLANKS)).group("wooden_pressure_plate")
                .unlockedBy("has_apple_planks", has(ModBlocks.APPLE_PLANKS)).save(recipeOutput);
        pressurePlateBuilder(RecipeCategory.REDSTONE, ModBlocks.AZALEA_PRESSURE_PLATE.get(), Ingredient.of(ModBlocks.AZALEA_PLANKS)).group("wooden_pressure_plate")
                .unlockedBy("has_azalea_planks", has(ModBlocks.AZALEA_PLANKS)).save(recipeOutput);
        pressurePlateBuilder(RecipeCategory.REDSTONE, ModBlocks.ORANGE_PRESSURE_PLATE.get(), Ingredient.of(ModBlocks.ORANGE_PLANKS)).group("wooden_pressure_plate")
                .unlockedBy("has_orange_planks", has(ModBlocks.ORANGE_PLANKS)).save(recipeOutput);
        pressurePlateBuilder(RecipeCategory.REDSTONE, ModBlocks.PEAR_PRESSURE_PLATE.get(), Ingredient.of(ModBlocks.PEAR_PLANKS)).group("wooden_pressure_plate")
                .unlockedBy("has_pear_planks", has(ModBlocks.PEAR_PLANKS)).save(recipeOutput);

        signBuilder(ModItems.APPLE_SIGN.get(), Ingredient.of(ModBlocks.APPLE_PLANKS)).group("wooden_sign")
                .unlockedBy("has_apple_planks", has(ModBlocks.APPLE_PLANKS)).save(recipeOutput);
        signBuilder(ModItems.AZALEA_SIGN.get(), Ingredient.of(ModBlocks.AZALEA_PLANKS)).group("wooden_sign")
                .unlockedBy("has_azalea_planks", has(ModBlocks.AZALEA_PLANKS)).save(recipeOutput);
        signBuilder(ModItems.ORANGE_SIGN.get(), Ingredient.of(ModBlocks.ORANGE_PLANKS)).group("wooden_sign")
                .unlockedBy("has_orange_planks", has(ModBlocks.ORANGE_PLANKS)).save(recipeOutput);
        signBuilder(ModItems.PEAR_SIGN.get(), Ingredient.of(ModBlocks.PEAR_PLANKS)).group("wooden_sign")
                .unlockedBy("has_pear_planks", has(ModBlocks.PEAR_PLANKS)).save(recipeOutput);

        slabBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.APPLE_SLAB.get(), Ingredient.of(ModBlocks.APPLE_PLANKS)).group("wooden_slab")
                .unlockedBy("has_apple_planks", has(ModBlocks.APPLE_PLANKS)).save(recipeOutput);
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AZALEA_SLAB.get(), Ingredient.of(ModBlocks.AZALEA_PLANKS)).group("wooden_slab")
                .unlockedBy("has_azalea_planks", has(ModBlocks.AZALEA_PLANKS)).save(recipeOutput);
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ORANGE_SLAB.get(), Ingredient.of(ModBlocks.ORANGE_PLANKS)).group("wooden_slab")
                .unlockedBy("has_orange_planks", has(ModBlocks.ORANGE_PLANKS)).save(recipeOutput);
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PEAR_SLAB.get(), Ingredient.of(ModBlocks.PEAR_PLANKS)).group("wooden_slab")
                .unlockedBy("has_pear_planks", has(ModBlocks.PEAR_PLANKS)).save(recipeOutput);

        stairBuilder(ModBlocks.APPLE_STAIRS.get(), Ingredient.of(ModBlocks.APPLE_PLANKS)).group("wooden_stairs")
                .unlockedBy("has_apple_planks", has(ModBlocks.APPLE_PLANKS)).save(recipeOutput);
        stairBuilder(ModBlocks.AZALEA_STAIRS.get(), Ingredient.of(ModBlocks.AZALEA_PLANKS)).group("wooden_stairs")
                .unlockedBy("has_azalea_planks", has(ModBlocks.AZALEA_PLANKS)).save(recipeOutput);
        stairBuilder(ModBlocks.ORANGE_STAIRS.get(), Ingredient.of(ModBlocks.ORANGE_PLANKS)).group("wooden_stairs")
                .unlockedBy("has_orange_planks", has(ModBlocks.ORANGE_PLANKS)).save(recipeOutput);
        stairBuilder(ModBlocks.PEAR_STAIRS.get(), Ingredient.of(ModBlocks.PEAR_PLANKS)).group("wooden_stairs")
                .unlockedBy("has_pear_planks", has(ModBlocks.PEAR_PLANKS)).save(recipeOutput);

        trapdoorBuilder(ModBlocks.APPLE_TRAPDOOR.get(), Ingredient.of(ModBlocks.APPLE_PLANKS)).group("wooden_trapdoor")
                .unlockedBy("has_apple_planks", has(ModBlocks.APPLE_PLANKS)).save(recipeOutput);
        trapdoorBuilder(ModBlocks.AZALEA_TRAPDOOR.get(), Ingredient.of(ModBlocks.AZALEA_PLANKS)).group("wooden_trapdoor")
                .unlockedBy("has_azalea_planks", has(ModBlocks.AZALEA_PLANKS)).save(recipeOutput);
        trapdoorBuilder(ModBlocks.ORANGE_TRAPDOOR.get(), Ingredient.of(ModBlocks.ORANGE_PLANKS)).group("wooden_trapdoor")
                .unlockedBy("has_orange_planks", has(ModBlocks.ORANGE_PLANKS)).save(recipeOutput);
        trapdoorBuilder(ModBlocks.PEAR_TRAPDOOR.get(), Ingredient.of(ModBlocks.PEAR_PLANKS)).group("wooden_trapdoor")
                .unlockedBy("has_pear_planks", has(ModBlocks.PEAR_PLANKS)).save(recipeOutput);

        woodenBoat(recipeOutput, ModItems.APPLE_BOAT, ModBlocks.APPLE_PLANKS);
        woodenBoat(recipeOutput, ModItems.AZALEA_BOAT, ModBlocks.AZALEA_PLANKS);
        woodenBoat(recipeOutput, ModItems.ORANGE_BOAT, ModBlocks.ORANGE_PLANKS);
        woodenBoat(recipeOutput, ModItems.PEAR_BOAT, ModBlocks.PEAR_PLANKS);

        woodFromLogs(recipeOutput, ModBlocks.APPLE_WOOD, ModBlocks.APPLE_LOG);
        woodFromLogs(recipeOutput, ModBlocks.STRIPPED_APPLE_WOOD, ModBlocks.STRIPPED_APPLE_LOG);
        woodFromLogs(recipeOutput, ModBlocks.AZALEA_WOOD, ModBlocks.AZALEA_LOG);
        woodFromLogs(recipeOutput, ModBlocks.STRIPPED_AZALEA_WOOD, ModBlocks.STRIPPED_AZALEA_LOG);
        woodFromLogs(recipeOutput, ModBlocks.ORANGE_WOOD, ModBlocks.ORANGE_LOG);
        woodFromLogs(recipeOutput, ModBlocks.STRIPPED_ORANGE_WOOD, ModBlocks.STRIPPED_ORANGE_LOG);
        woodFromLogs(recipeOutput, ModBlocks.PEAR_WOOD, ModBlocks.PEAR_LOG);
        woodFromLogs(recipeOutput, ModBlocks.STRIPPED_PEAR_WOOD, ModBlocks.STRIPPED_PEAR_LOG);
        //endregion

        //region Shaped
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.PEONY)
                .pattern("PP")
                .pattern("PP")
                .define('P', ModBlocks.PEONIA.get())
                .unlockedBy("has_peonia", has(ModBlocks.PEONIA)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.ROSE_BUSH)
                .pattern("RR")
                .pattern("RR")
                .define('R', ModBlocks.ROSE.get())
                .unlockedBy("has_rose", has(ModBlocks.ROSE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PINECONE_BLOCK.get())
                .pattern("PPP")
                .pattern("PPP")
                .pattern("PPP")
                .define('P', ModItems.PINECONE.get())
                .unlockedBy("has_pinecone", has(ModItems.PINECONE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.SPAWNER)
                .pattern("###")
                .pattern("#C#")
                .pattern("#X#")
                .define('#', Blocks.IRON_BARS)
                .define('C', ModItems.EVERSOURCE_CROWN.get())
                .define('X', Items.BLAZE_POWDER)
                .unlockedBy("has_eversource_crown", has(ModItems.EVERSOURCE_CROWN)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.TRIAL_SPAWNER)
                .pattern("TCT")
                .pattern("CSC")
                .pattern("TCT")
                .define('T', Blocks.TUFF_BRICKS)
                .define('C', Blocks.COPPER_BLOCK)
                .define('S', Blocks.SPAWNER)
                .unlockedBy("has_spawner", has(Blocks.SPAWNER)).save(recipeOutput);
        //endregion

        //region Shapeless
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.APPLE_PLANKS.get(), 4).group("planks")
                .requires(ModBlocks.APPLE_LOG)
                .unlockedBy("has_apple_log", has(ModBlocks.APPLE_LOG)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.CYAN_DYE)
                .requires(ModBlocks.CYAN_ROSE)
                .unlockedBy("has_cyan_rose", has(ModBlocks.CYAN_ROSE)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.PEONIA.get(), 4)
                .requires(Blocks.PEONY)
                .unlockedBy("has_peony", has(Blocks.PEONY)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PINE_NUTS.get())
                .requires(ModItems.PINECONE)
                .unlockedBy("has_pinecone", has(ModItems.PINECONE)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PINECONE.get(), 9)
                .requires(ModBlocks.PINECONE_BLOCK)
                .unlockedBy("has_pinecone_block", has(ModBlocks.PINECONE_BLOCK)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.PINK_DYE)
                .requires(ModBlocks.PEONIA)
                .unlockedBy("has_peonia", has(ModBlocks.PEONIA)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PLASTER.get(), 8)
                .requires(Blocks.CLAY, 4)
                .requires(Blocks.SAND, 4)
                .unlockedBy("has_clay", has(Blocks.CLAY)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.RED_DYE)
                .requires(ModBlocks.ROSE)
                .unlockedBy("has_rose", has(ModBlocks.ROSE)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.ROSE.get(), 4)
                .requires(Blocks.ROSE_BUSH)
                .unlockedBy("has_rose_bush", has(Blocks.ROSE_BUSH)).save(recipeOutput);
        //endregion
        //endregion
    }

    //Smelting recipes path rerouter to Mod ID
    protected static void oreSmelting(@NotNull RecipeOutput recipeOutput, List<ItemLike> pIngredients, @NotNull RecipeCategory pCategory, @NotNull ItemLike pResult, float pExperience, int pCookingTime, @NotNull String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smelting_");
    }
    protected static void oreBlasting(@NotNull RecipeOutput recipeOutput, List<ItemLike> pIngredients, @NotNull RecipeCategory pCategory, @NotNull ItemLike pResult, float pExperience, int pCookingTime, @NotNull String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting_");
    }
    protected static void oreSmoking(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMOKING_RECIPE, SmokingRecipe::new, pIngredients, RecipeCategory.FOOD, pResult, pExperience, pCookingTime, pGroup, "_from_smoking_");
    }
    protected static void oreCampfireCooking(RecipeOutput recipeOutput, List<ItemLike> pIngredients, ItemLike pResult, float pExperience, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.CAMPFIRE_COOKING_RECIPE, CampfireCookingRecipe::new, pIngredients, RecipeCategory.FOOD, pResult, pExperience, 600, pGroup, "_from_campfire_cooking_");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(@NotNull RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, @NotNull AbstractCookingRecipe.Factory<T> factory, List<ItemLike> pIngredients, @NotNull RecipeCategory pCategory, @NotNull ItemLike pResult, float pExperience, int pCookingTime, @NotNull String pGroup, String pRecipeName) {
        for (ItemLike itemLike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemLike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory)
                    .group(pGroup)
                    .unlockedBy(getHasName(itemLike), has(itemLike))
                    .save(recipeOutput, UltimateEdition.MOD_ID + ":" + getItemName(pResult) + pRecipeName + getItemName(itemLike));
        }
    }
}