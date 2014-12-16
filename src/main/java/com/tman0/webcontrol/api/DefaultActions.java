package com.tman0.webcontrol.api;

import com.tman0.webcontrol.WebControl;
import com.tman0.webcontrol.actions.TestActions;

/**
 * Created by tman0 on December.15.
 */
public class DefaultActions
{
    public static void registerDefaultActions()
    {
        APIRegistrar registrar = WebControl.getRegistrar();

        TestActions.register(registrar);

    }
}
