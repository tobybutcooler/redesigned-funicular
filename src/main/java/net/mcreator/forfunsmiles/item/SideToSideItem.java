
package net.mcreator.forfunsmiles.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.util.ITooltipFlag;

import net.mcreator.forfunsmiles.procedures.SideToSideRightClickedInAirProcedure;
import net.mcreator.forfunsmiles.procedures.SideToSideItemIsCraftedsmeltedProcedure;
import net.mcreator.forfunsmiles.itemgroup.FunsiesItemGroup;
import net.mcreator.forfunsmiles.ForfunsmilesModElements;

import java.util.List;
import java.util.Collections;

@ForfunsmilesModElements.ModElement.Tag
public class SideToSideItem extends ForfunsmilesModElements.ModElement {
	@ObjectHolder("forfunsmiles:side_to_side")
	public static final Item block = null;

	public SideToSideItem(ForfunsmilesModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, ForfunsmilesModElements.sounds.get(new ResourceLocation("forfunsmiles:revenge")),
					new Item.Properties().group(FunsiesItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("side_to_side");
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("A song to play when you're back in the mine."));
		}

		@Override
		public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
			ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
			ItemStack itemstack = ar.getResult();
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();

			SideToSideRightClickedInAirProcedure.executeProcedure(Collections.EMPTY_MAP);
			return ar;
		}

		@Override
		public void onCreated(ItemStack itemstack, World world, PlayerEntity entity) {
			super.onCreated(itemstack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();

			SideToSideItemIsCraftedsmeltedProcedure.executeProcedure(Collections.EMPTY_MAP);
		}
	}
}
