package com.newjumper.spacedustry.datagen.data.recipes;

import com.newjumper.spacedustry.block.SpacedustryBlocks;
import com.newjumper.spacedustry.item.SpacedustryItems;
import com.newjumper.spacedustry.util.SpacedustryTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class CraftingRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public CraftingRecipeProvider(DataGenerator gen) {
        super(gen);
    }

    @Override
    protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(SpacedustryBlocks.SALT_BLOCK.get()).define('#', SpacedustryItems.SALT.get()).pattern("##").pattern("##").unlockedBy("has_salt", has(SpacedustryItems.SALT.get())).save(consumer);

        ShapedRecipeBuilder.shaped(SpacedustryBlocks.CONSTRUCTOR.get())
                .define('A', SpacedustryTags.Items.INGOTS_ALUMINUM)
                .define('S', SpacedustryTags.Items.INGOTS_SILICON)
                .define('G', Tags.Items.GLASS)
                .define('C', Tags.Items.STORAGE_BLOCKS_COAL)
                .define('M', SpacedustryTags.Items.INGOTS_MOLYBDENUM)
                .pattern("ASA")
                .pattern("GCG")
                .pattern("MAM")
                .unlockedBy("has_aluminum", has(SpacedustryTags.Items.INGOTS_ALUMINUM))
                .unlockedBy("has_molybdenum", has(SpacedustryTags.Items.INGOTS_MOLYBDENUM)).save(consumer);
        ShapedRecipeBuilder.shaped(SpacedustryBlocks.MANUFACTURER.get())
                .define('T', SpacedustryTags.Items.INGOTS_TUNGSTEN)
                .define('D', SpacedustryItems.DURALUMIN_ALLOY.get())
                .define('G', Tags.Items.GLASS)
                .define('R', Tags.Items.STORAGE_BLOCKS_REDSTONE)
                .define('S', SpacedustryTags.Items.INGOTS_STEEL)
                .pattern("TDT")
                .pattern("GRG")
                .pattern("SSS")
                .unlockedBy("has_duralumin", has(SpacedustryItems.DURALUMIN_ALLOY.get())).save(consumer);
        ShapedRecipeBuilder.shaped(SpacedustryBlocks.ROCKET_ASSEMBLER.get())
                .define('B', SpacedustryItems.BURLAM_ALLOY.get())
                .define('G', Tags.Items.GLASS)
                .define('D', Tags.Items.GEMS_DIAMOND)
                .define('A', Blocks.ANVIL)
                .define('S', SpacedustryTags.Items.INGOTS_STEEL)
                .define('V', SpacedustryItems.SUPER_ALLOY.get())
                .pattern("BGB")
                .pattern("DAD")
                .pattern("SVS")
                .unlockedBy("has_burlam", has(SpacedustryItems.BURLAM_ALLOY.get()))
                .unlockedBy("has_super", has(SpacedustryItems.SUPER_ALLOY.get())).save(consumer);
    }

    @NotNull
    @Override
    public String getName() {
        return "Crafting Recipes";
    }
}
