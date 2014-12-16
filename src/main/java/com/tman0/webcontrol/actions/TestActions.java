package com.tman0.webcontrol.actions;

import com.tman0.webcontrol.api.APIRegistrar;
import com.tman0.webcontrol.api.Action;
import org.spongepowered.api.Game;
import org.spongepowered.api.text.message.Messages;

/**
 * @author tman0
 * @version 12.15.2014
 */
public class TestActions
{
    public static void register(APIRegistrar registrar)
    {
        registrar.registerAction("wc.test.helloworld", new Action()
        {
            @Override
            public Object run(Game game, Object data)
            {
                game.broadcastMessage(Messages.of("Hello, world!"));
                return null;
            }
        });
    }
}
