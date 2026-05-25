package com.mqh9007.neomcdrcommandreg;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import com.mqh9007.neomcdrcommandreg.command.MCDRCommandSetup;

@Mod(NeoMCDRCommandReg.MODID)
public class NeoMCDRCommandReg {
    public static final String MODID = "mcdrcommandneoforge";
    public static final Logger LOGGER = LogUtils.getLogger();

    public NeoMCDRCommandReg(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        LOGGER.info("NeoMCDRCommandReg common setup");
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        MCDRCommandSetup.registerCommand(event.getServer().getCommands().getDispatcher());
        LOGGER.info("MCDR commands registered");
    }
}