package com.tman0.webcontrol;

import com.tman0.webcontrol.net.APIRequestHandler;

import io.undertow.Undertow;

import org.slf4j.Logger;

import org.spongepowered.api.Game;
import org.spongepowered.api.event.state.PreInitializationEvent;
import org.spongepowered.api.event.state.ServerStoppingEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.util.event.Subscribe;

import java.io.File;
import java.net.Inet4Address;

/**
 * Main class for the WebControl plugin.
 * @author tman0
 * @version 12.15.2014
 */
@Plugin(id = "webcontrol", name = "WebControl", version = "0.0.1-Alpha")
public class WebControl
{
    Game game;
    Logger logger;

    Undertow server;

    final int PORT = 25590;
    final String BIND_IP = "0.0.0.0";

    @Subscribe
    public void preInitialization(PreInitializationEvent event)
    {
        game = event.getGame();
        logger = event.getPluginLog();

        // TODO: Configuration

        logger.info("Starting API server on port %i", PORT);
        server = Undertow.builder()
                .addHttpListener(PORT, BIND_IP)
                .setHandler(new APIRequestHandler(game, logger))
                .build();
        server.start();

        logger.info("API server listening on port %i", PORT);
    }

    @Subscribe
    public void serverStop(ServerStoppingEvent event)
    {

    }
}