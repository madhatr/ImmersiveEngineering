package blusunrize.immersiveengineering.common.util.compat.jei.blastfurnace;

import blusunrize.immersiveengineering.common.IEContent;
import blusunrize.immersiveengineering.common.blocks.stone.BlockTypes_StoneDevices;
import blusunrize.immersiveengineering.common.util.compat.jei.IERecipeCategory;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import mezz.jei.util.Log;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class BlastFurnaceRecipeCategory extends IERecipeCategory
{
	public static ResourceLocation background = new ResourceLocation("immersiveengineering:textures/gui/blastFurnace.png");

	public BlastFurnaceRecipeCategory(IGuiHelper helper)
	{
		super("blastfurnace","gui.immersiveengineering.blastFurnace", helper.createDrawable(background, 8,8, 142, 65), BlastFurnaceRecipeWrapper.class, new ItemStack(IEContent.blockStoneDevice,1,BlockTypes_StoneDevices.BLAST_FURNACE.getMeta()), new ItemStack(IEContent.blockStoneDevice,1,BlockTypes_StoneDevices.BLAST_FURNACE_ADVANCED.getMeta()));
	}

	@Override
	@Deprecated
	public void setRecipe(IRecipeLayout recipeLayout, IRecipeWrapper recipeWrapper)
	{

	}
	@Override
	public void setRecipe(IRecipeLayout recipeLayout, IRecipeWrapper recipeWrapper, IIngredients ingredients)
	{
		IGuiItemStackGroup guiItemStacks = recipeLayout.getItemStacks();
		guiItemStacks.init(0, true, 43, 8);
		guiItemStacks.init(1, false, 103, 8);
		guiItemStacks.init(2, false, 103, 44);
		if(recipeWrapper instanceof BlastFurnaceRecipeWrapper)
		{
			BlastFurnaceRecipeWrapper recipe = (BlastFurnaceRecipeWrapper) recipeWrapper;
			guiItemStacks.set(0, ingredients.getInputs(ItemStack.class).get(0));
			guiItemStacks.set(1, recipe.getSmeltingOutput());
			guiItemStacks.set(2, recipe.getSlagOutput());
		}
		else
			Log.error("Unknown recipe wrapper type: {}", recipeWrapper);
	}
}