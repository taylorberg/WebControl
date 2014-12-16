package com.tman0.webcontrol.api;

import com.tman0.webcontrol.WebControl;
import com.tman0.webcontrol.actions.TestActions;

/**
 * @author tman0
 * @version 12.15.2014
 */
public class DefaultActions
{
    public static void registerDefaultActions()
    {
        APIRegistrar registrar = WebControl.getRegistrar();

        TestActions.register(registrar);

    }
}
