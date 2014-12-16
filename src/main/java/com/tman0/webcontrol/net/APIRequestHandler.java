package com.tman0.webcontrol.net;

import com.tman0.webcontrol.WebControl;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.slf4j.Logger;
import org.spongepowered.api.Game;

import java.io.InputStreamReader;

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
    public void handleRequest(HttpServerExchange exchange)
    {
        // TODO: Security

        String endpoint = exchange.getRequestPath();
        JSONObject data = new JSONObject();
        if (exchange.getRequestContentLength() >= 0 || exchange.getRequestMethod().equalToString("POST"))
        {
            InputStreamReader s = new InputStreamReader(exchange.getInputStream());
            data = (JSONObject) JSONValue.parse(s);
        }
        JSONObject result = WebControl.getRegistrar().getActionFromPath(endpoint).run(game, data);
    }
}
