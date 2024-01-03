package com.newjumper.spacedustry.datagen.data;

import com.google.common.collect.ImmutableList;
import com.newjumper.spacedustry.Spacedustry;
import com.newjumper.spacedustry.content.SpacedustryBlocks;
import com.newjumper.spacedustry.content.SpacedustryItems;
import com.newjumper.spacedustry.datagen.data.recipes.ConstructingRecipeBuilder;
import com.newjumper.spacedustry.datagen.data.recipes.ManufacturingRecipeBuilder;
import com.newjumper.spacedustry.util.SpacedustryTags;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Consumer;

public class SpacedustryRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private final ImmutableList<ItemLike> ALUMINUM_ORES = ImmutableList.of(SpacedustryBlocks.ALUMINUM_ORE.get(), SpacedustryBlocks.DEEPSLATE_ALUMINUM_ORE.get());
    private final ImmutableList<ItemLike> LITHIUM_ORES = ImmutableList.of(SpacedustryBlocks.LITHIUM_ORE.get(), SpacedustryBlocks.DEEPSLATE_LITHIUM_ORE.get());
    private final ImmutableList<ItemLike> MOLYBDENITE_ORES = ImmutableList.of(SpacedustryBlocks.MOLYBDENITE_ORE.get(), SpacedustryBlocks.DEEPSLATE_MOLYBDENITE_ORE.get());
    private final ImmutableList<ItemLike> NICKEL_ORES = ImmutableList.of(SpacedustryBlocks.NICKEL_ORE.get(), SpacedustryBlocks.DEEPSLATE_NICKEL_ORE.get());
    private final ImmutableList<ItemLike> SILICON_ORES = ImmutableList.of(SpacedustryBlocks.SILICON_ORE.get());
    private final ImmutableList<ItemLike> TUNGSTEN_ORES = ImmutableList.of(SpacedustryBlocks.TUNGSTEN_ORE.get(), SpacedustryBlocks.DEEPSLATE_TUNGSTEN_ORE.get());

    public SpacedustryRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, SpacedustryBlocks.MOON_STONE_BRICKS.get(), 4).define('#', SpacedustryBlocks.COBBLED_MOON_STONE.get()).pattern("##").pattern("##").unlockedBy("has_cobbled_moon_stone", has(SpacedustryBlocks.COBBLED_MOON_STONE.get())).save(pWriter);

        nineBlockStorage(SpacedustryItems.RAW_ALUMINUM.get(), SpacedustryBlocks.RAW_ALUMINUM_BLOCK.get(), pWriter);
        nineBlockStorage(SpacedustryItems.ALUMINUM_INGOT.get(), SpacedustryBlocks.ALUMINUM_BLOCK.get(), pWriter);
        nineBlockStorage(SpacedustryItems.RAW_LITHIUM.get(), SpacedustryBlocks.RAW_LITHIUM_BLOCK.get(), pWriter);
        nineBlockStorage(SpacedustryItems.LITHIUM_INGOT.get(), SpacedustryBlocks.LITHIUM_BLOCK.get(), pWriter);
        nineBlockStorage(SpacedustryItems.MOLYBDENITE.get(), SpacedustryBlocks.RAW_MOLYBDENITE_BLOCK.get(), pWriter);
        nineBlockStorage(SpacedustryItems.MOLYBDENUM_INGOT.get(), SpacedustryBlocks.MOLYBDENUM_BLOCK.get(), pWriter);
        nineBlockStorage(SpacedustryItems.RAW_NICKEL.get(), SpacedustryBlocks.RAW_NICKEL_BLOCK.get(), pWriter);
        nineBlockStorage(SpacedustryItems.NICKEL_INGOT.get(), SpacedustryBlocks.NICKEL_BLOCK.get(), pWriter);
        nineBlockStorage(SpacedustryItems.RAW_SILICON.get(), SpacedustryBlocks.RAW_SILICON_BLOCK.get(), pWriter);
        nineBlockStorage(SpacedustryItems.SILICON.get(), SpacedustryBlocks.SILICON_BLOCK.get(), pWriter);
        nineBlockStorage(SpacedustryItems.RAW_TUNGSTEN.get(), SpacedustryBlocks.RAW_TUNGSTEN_BLOCK.get(), pWriter);
        nineBlockStorage(SpacedustryItems.TUNGSTEN_INGOT.get(), SpacedustryBlocks.TUNGSTEN_BLOCK.get(), pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, SpacedustryBlocks.SALT_BLOCK.get()).define('#', SpacedustryItems.SALT.get()).pattern("##").pattern("##").unlockedBy("has_salt", has(SpacedustryItems.SALT.get())).save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, SpacedustryBlocks.CONSTRUCTOR.get())
                .define('A', SpacedustryTags.Items.INGOTS_ALUMINUM).define('S', SpacedustryTags.Items.INGOTS_SILICON).define('G', Tags.Items.GLASS).define('C', Tags.Items.STORAGE_BLOCKS_COAL).define('M', SpacedustryTags.Items.INGOTS_MOLYBDENUM)
                .pattern("ASA").pattern("GCG").pattern("MAM")
                .unlockedBy("has_aluminum", has(SpacedustryTags.Items.INGOTS_ALUMINUM)).unlockedBy("has_molybdenum", has(SpacedustryTags.Items.INGOTS_MOLYBDENUM)).save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, SpacedustryBlocks.MANUFACTURER.get())
                .define('T', SpacedustryTags.Items.INGOTS_TUNGSTEN).define('D', SpacedustryItems.DURALUMIN_ALLOY.get()).define('G', Tags.Items.GLASS).define('R', Tags.Items.STORAGE_BLOCKS_REDSTONE).define('S', SpacedustryTags.Items.INGOTS_STEEL)
                .pattern("TDT").pattern("GRG").pattern("SSS")
                .unlockedBy("has_duralumin", has(SpacedustryItems.DURALUMIN_ALLOY.get())).save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, SpacedustryBlocks.ROCKET_ASSEMBLER.get())
                .define('B', SpacedustryItems.BULNITE_ALLOY.get()).define('G', Tags.Items.GLASS).define('D', Tags.Items.GEMS_DIAMOND).define('A', Blocks.ANVIL).define('S', SpacedustryTags.Items.INGOTS_STEEL).define('V', SpacedustryItems.SUPER_ALLOY.get())
                .pattern("BGB").pattern("DAD").pattern("SVS")
                .unlockedBy("has_bulnite", has(SpacedustryItems.BULNITE_ALLOY.get())).unlockedBy("has_super", has(SpacedustryItems.SUPER_ALLOY.get())).save(pWriter);


        smelting(SpacedustryBlocks.COBBLED_MOON_STONE.get(), RecipeCategory.BUILDING_BLOCKS, SpacedustryBlocks.MOON_STONE.get(),0.2f, pWriter);

        oreSmelting(ALUMINUM_ORES, SpacedustryItems.ALUMINUM_INGOT.get(), 2.8f, "aluminum_ingot", pWriter);
        oreSmelting(LITHIUM_ORES, SpacedustryItems.LITHIUM_INGOT.get(), 3f, "lithium_ingot", pWriter);
        oreSmelting(MOLYBDENITE_ORES, SpacedustryItems.MOLYBDENUM_INGOT.get(), 3f, "molybdenum_ingot", pWriter);
        oreSmelting(NICKEL_ORES, SpacedustryItems.NICKEL_INGOT.get(), 3f, "nickel_ingot", pWriter);
        oreSmelting(SILICON_ORES, SpacedustryItems.SILICON.get(), 3f, "silicon", pWriter);
        oreSmelting(TUNGSTEN_ORES, SpacedustryItems.TUNGSTEN_INGOT.get(), 4f, "tungsten_ingot", pWriter);

        oreBlasting(ALUMINUM_ORES, SpacedustryItems.ALUMINUM_INGOT.get(), 2.8f, "aluminum_ingot", pWriter);
        oreBlasting(LITHIUM_ORES, SpacedustryItems.LITHIUM_INGOT.get(), 3f, "lithium_ingot", pWriter);
        oreBlasting(MOLYBDENITE_ORES, SpacedustryItems.MOLYBDENUM_INGOT.get(), 3f, "molybdenum_ingot", pWriter);
        oreBlasting(NICKEL_ORES, SpacedustryItems.NICKEL_INGOT.get(), 3f, "nickel_ingot", pWriter);
        oreBlasting(SILICON_ORES, SpacedustryItems.SILICON.get(), 3f, "silicon", pWriter);
        oreBlasting(TUNGSTEN_ORES, SpacedustryItems.TUNGSTEN_INGOT.get(), 4f, "tungsten_ingot", pWriter);


        stonecuttingRecipe(SpacedustryBlocks.MOON_STONE_BRICKS.get(), SpacedustryBlocks.COBBLED_MOON_STONE.get(), pWriter);


        new ConstructingRecipeBuilder(SpacedustryItems.BULNITE_ALLOY.get(), 1)
                .requires(SpacedustryTags.Items.INGOTS_ALUMINUM).requires(SpacedustryTags.Items.INGOTS_LITHIUM)
                .unlockedBy("has_aluminum", has(SpacedustryTags.Items.INGOTS_ALUMINUM)).unlockedBy("has_lithium", has(SpacedustryTags.Items.INGOTS_LITHIUM)).save(pWriter);

        new ConstructingRecipeBuilder(SpacedustryItems.COBALT_ALLOY.get(), 1)
                .requires(Tags.Items.INGOTS_COPPER).requires(SpacedustryTags.Items.INGOTS_NICKEL)
                .unlockedBy("has_copper", has(Tags.Items.INGOTS_COPPER)).unlockedBy("has_nickel", has(SpacedustryTags.Items.INGOTS_NICKEL)).save(pWriter);

        new ConstructingRecipeBuilder(SpacedustryItems.DURALUMIN_ALLOY.get(), 1)
                .requires(SpacedustryTags.Items.INGOTS_ALUMINUM).requires(Tags.Items.INGOTS_COPPER)
                .unlockedBy("has_aluminum", has(SpacedustryTags.Items.INGOTS_ALUMINUM)).unlockedBy("has_copper", has(Tags.Items.INGOTS_COPPER)).save(pWriter);

        new ConstructingRecipeBuilder(SpacedustryItems.STEEL_ALLOY.get(), 1)
                .requires(Items.COAL).requires(Tags.Items.INGOTS_IRON)
                .unlockedBy("has_coal", has(Items.COAL)).unlockedBy("has_iron", has(Tags.Items.INGOTS_IRON)).save(pWriter);

        new ConstructingRecipeBuilder(SpacedustryItems.SUPER_ALLOY.get(), 1)
                .requires(SpacedustryTags.Items.INGOTS_MOLYBDENUM).requires(SpacedustryTags.Items.INGOTS_NICKEL)
                .unlockedBy("has_molybdenum", has(SpacedustryTags.Items.INGOTS_MOLYBDENUM)).unlockedBy("has_nickel", has(SpacedustryTags.Items.ORES_NICKEL)).save(pWriter);


        new ManufacturingRecipeBuilder(SpacedustryItems.BULNITE_PLATE.get(), 1)
                .requires(SpacedustryItems.BULNITE_ALLOY.get(), 2)
                .unlockedBy("has_bulnite", has(SpacedustryItems.BULNITE_ALLOY.get())).save(pWriter);

        new ManufacturingRecipeBuilder(SpacedustryItems.AEROGRADE_PLATE.get(), 1)
                .requires(SpacedustryItems.STEEL_ALLOY.get()).requires(SpacedustryItems.DURALUMIN_ALLOY.get())
                .unlockedBy("has_steel", has(SpacedustryItems.STEEL_ALLOY.get())).unlockedBy("has_duralumin", has(SpacedustryItems.DURALUMIN_ALLOY.get())).save(pWriter);
    }

    private void nineBlockStorage(ItemLike unpacked, ItemLike packed, Consumer<FinishedRecipe> writer) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, unpacked, 9).requires(packed).group(getItemName(unpacked)).unlockedBy(getHasName(packed), has(packed)).save(writer, new ResourceLocation(Spacedustry.MOD_ID, getItemName(unpacked)));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, packed).define('#', unpacked).pattern("###").pattern("###").pattern("###").group(getItemName(packed)).unlockedBy(getHasName(unpacked), has(unpacked)).save(writer, new ResourceLocation(Spacedustry.MOD_ID, getItemName(packed)));
    }

    private void smelting(ItemLike ingredient, RecipeCategory category, ItemLike result, float experience, Consumer<FinishedRecipe> writer) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ingredient), category, result, experience, 200).unlockedBy(getHasName(ingredient), has(ingredient)).save(writer);
    }

    private void oreSmelting(List<ItemLike> ingredients, ItemLike result, float experience, String group, Consumer<FinishedRecipe> writer) {
        for(ItemLike item : ingredients) SimpleCookingRecipeBuilder.smelting(Ingredient.of(item), RecipeCategory.MISC, result, experience, 200).group(group).unlockedBy(getHasName(item), has(item)).save(writer, new ResourceLocation(Spacedustry.MOD_ID, getItemName(result) + "_from_smelting_" + getItemName(item)));
    }

    private void oreBlasting(List<ItemLike> ingredients, ItemLike result, float experience, String group, Consumer<FinishedRecipe> writer) {
        for(ItemLike item : ingredients) SimpleCookingRecipeBuilder.blasting(Ingredient.of(item), RecipeCategory.MISC, result, experience, 100).group(group).unlockedBy(getHasName(item), has(item)).save(writer, new ResourceLocation(Spacedustry.MOD_ID, getItemName(result) + "_from_blasting_" + getItemName(item)));
    }

    private void stonecuttingRecipe(ItemLike result, ItemLike ingredient, Consumer<FinishedRecipe> writer) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ingredient), RecipeCategory.BUILDING_BLOCKS, result, 1).unlockedBy(getHasName(ingredient), has(ingredient)).save(writer, new ResourceLocation(Spacedustry.MOD_ID, getConversionRecipeName(result, ingredient) + "_stonecutting"));
    }
}
