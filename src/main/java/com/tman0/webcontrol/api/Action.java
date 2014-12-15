package com.tman0.webcontrol.api;

import org.spongepowered.api.Game;

/**
 * @author tman0
 * @version 12.15.2014
 */
public abstract class Action
{
    public abstract Object run(Game game, Object data); // TODO: Once a JSON serializer is decided, this should take and return JSON objects.
}
