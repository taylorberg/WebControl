package com.tman0.webcontrol.net;

import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import org.slf4j.Logger;
import org.spongepowered.api.Game;

/**
 * This class handles all requests to the API server.
 * @author tman0
 * @version 12.15.2014
 */
public class APIRequestHandler implements HttpHandler
{
    Game game;
    Logger logger;

    public APIRequestHandler(Game theGame, Logger theLogger)
    {
        game = theGame;
        logger = theLogger;
    }

    @Override
    public void handleRequest(HttpServerExchange httpServerExchange)
    {
        // TODO: Security


    }
}
