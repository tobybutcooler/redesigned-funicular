
package net.mcreator.forfunsmiles.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.client.util.ITooltipFlag;

import net.mcreator.forfunsmiles.itemgroup.FunsiesItemGroup;
import net.mcreator.forfunsmiles.ForfunsmilesModElements;

import java.util.List;

@ForfunsmilesModElements.ModElement.Tag
public class WoodntshovelItem extends ForfunsmilesModElements.ModElement {
	@ObjectHolder("forfunsmiles:woodntshovel")
	public static final Item block = null;

	public WoodntshovelItem(ForfunsmilesModElements instance) {
		super(instance, 3);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ShovelItem(new IItemTier() {
			public int getMaxUses() {
				return 1;
			}

			public float getEfficiency() {
				return 0f;
			}

			public float getAttackDamage() {
				return -1.5f;
			}

			public int getHarvestLevel() {
				return 0;
			}

			public int getEnchantability() {
				return 0;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 1, 4f, new Item.Properties().group(FunsiesItemGroup.tab)) {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("You're grabbing it from the wrong end!"));
			}
		}.setRegistryName("woodntshovel"));
	}
}
