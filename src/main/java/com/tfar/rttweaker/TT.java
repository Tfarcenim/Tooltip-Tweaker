package com.tfar.rttweaker;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = TT.MODID, name = TT.NAME, version = TT.VERSION, clientSideOnly = true)
public class TT {
  public static final String MODID = "tooltiptweaker";
  public static final String NAME = "Tooltip Tweaker";
  public static final String VERSION = "@VERSION@";

  private static Logger logger;

  @Mod.EventHandler
  public void postInit(FMLPostInitializationEvent postEvent) {

    }
  }

