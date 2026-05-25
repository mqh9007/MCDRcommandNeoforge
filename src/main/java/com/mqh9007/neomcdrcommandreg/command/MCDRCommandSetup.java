package com.mqh9007.neomcdrcommandreg.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mqh9007.neomcdrcommandreg.NeoMCDRCommandReg;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;

public class MCDRCommandSetup {
    public static final org.slf4j.Logger LOGGER = NeoMCDRCommandReg.LOGGER;

    public static void registerCommand(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(
            Commands.literal("mcdr")
                .requires(source -> source.getEntity() == null)
                .then(
                    Commands.literal("register")
                        .then(
                            Commands.argument("data", StringArgumentType.greedyString())
                                .executes(new RegisterCommandHandler())
                        )
                )
        );
    }
}