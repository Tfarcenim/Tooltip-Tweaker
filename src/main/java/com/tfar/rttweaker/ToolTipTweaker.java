package com.tfar.rttweaker;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.commons.lang3.tuple.Pair;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.ArrayList;

import static com.tfar.rttweaker.TT.MODID;

@Mod.EventBusSubscriber(modid = MODID)
@SuppressWarnings("unused")
@ZenRegister
@ZenClass("mods.tt.TooltipTweaker")
public class ToolTipTweaker {

  public static ArrayList<String> tooltips = new ArrayList<>();
  public static ArrayList<Pair<ItemStack,String>> tooltipitems = new ArrayList<>();

  @ZenMethod
  public static void removeTooltip(String result) {
    tooltips.add(result);
  }

  @ZenMethod
  public static void removeTooltipFromItem(IItemStack istack, String tooltip){
    ItemStack stack = CraftTweakerMC.getItemStack(istack);
    Pair<ItemStack,String> pair = Pair.of(stack,tooltip);
    tooltipitems.add(pair);
  }


@SubscribeEvent
  public static void removeTooltip(ItemTooltipEvent e){
  ArrayList<String> tooltips = (ArrayList<String>) e.getToolTip();

  ArrayList<String> remove = new ArrayList<>();
  for (String tooltip : tooltips)
    if (ToolTipTweaker.tooltips.contains(tooltip))
      remove.add(tooltip);
  for (Pair<ItemStack,String> tooltipitem : tooltipitems)
    if (e.getItemStack().getItem() == tooltipitem.getLeft().getItem()
            && ToolTipTweaker.tooltipitems.contains(tooltipitem))
      remove.add(tooltipitem.getRight());
    tooltips.removeAll(remove);
  }
}





