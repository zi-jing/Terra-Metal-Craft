package com.osir.tmc;

import org.apache.logging.log4j.Logger;

import com.osir.tmc.command.TMCCommand;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid = Main.MODID, name = Main.NAME, version = Main.VERSION, dependencies = Main.DEPENDENCIED)
public class Main {
	public static final String MODID = "tmc";
	public static final String NAME = "Terra Metal Craft";
	public static final String VERSION = "1.3.2.1";
	public static final String DEPENDENCIED = "required-after:gregtech@[1.9.0.481,);required-after:cuckoolib";

	@Instance
	public static Main instance = new Main();

	@SidedProxy(clientSide = "com.osir.tmc.ClientProxy", serverSide = "com.osir.tmc.CommonProxy")
	public static CommonProxy proxy = new CommonProxy();

	private static Logger logger;

	public static Logger getLogger() {
		return logger;
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		logger = e.getModLog();
		proxy.preInit(e);
	}

	@EventHandler
	public void init(FMLInitializationEvent e) {
		proxy.init(e);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		proxy.postInit(e);
	}

	@EventHandler
	public void onServerLoad(FMLServerStartingEvent e) {
		e.registerServerCommand(new TMCCommand());
	}
}