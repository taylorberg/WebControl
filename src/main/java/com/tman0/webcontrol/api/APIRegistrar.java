package com.tman0.webcontrol.api;

import com.tman0.webcontrol.exceptions.ActionAlreadyExistsException;
import com.tman0.webcontrol.exceptions.NoSuchActionException;

import java.util.Hashtable;

/**
 * @author tman0
 * @version 12.15.2014
 */
public class APIRegistrar
{
    private Hashtable<String, Action> actions = new Hashtable<String, Action>();

    /**
     * Returns the Action given its name.
     *
     * @param actionName The fully-qualified Action name. i.e. wc.chat.send
     * @return The Action requested.
     */
    public Action getAction(String actionName)
    {
        return actions.get(actionName);
    }

    /**
     * Convenience method to get an Action given a URL.
     *
     * @param path The fully-qualified URL of the Action. i.e. /wc/chat/send. Leading slash is optional.
     * @return The Action requested.
     */
    public Action getActionFromPath(String path)
    {
        String thePath = path;
        if (path.charAt(0) == '/') thePath = path.substring(1); // Delete the leading slash if it exists
        thePath = thePath.replaceAll("/", ".").trim();

        return getAction(thePath);
    }

    /**
     * Registers an Action so that it may be called over the web API.
     *
     * @param actionName The fully-qualified Action name. i.e. wc.chat.send
     * @param action     The Action to register
     * @return true if success, false if failure
     * @throws com.tman0.webcontrol.exceptions.ActionAlreadyExistsException if the Action has already been registered.
     */
    public boolean registerAction(String actionName, Action action) throws ActionAlreadyExistsException
    {
        if (actions.containsKey(actionName)) throw new ActionAlreadyExistsException(actionName);

        actions.put(actionName, action);
        return true;
    }

    /**
     * Unregisters an Action so that it can no longer be called over the web API.
     *
     * @param actionName The fully-qualified Action name. i.e. wc.chat.send
     * @return true if success, false if failure
     * @throws com.tman0.webcontrol.exceptions.NoSuchActionException if the Action does not exist or has not been registered.
     */
    public boolean unregisterAction(String actionName) throws NoSuchActionException
    {
        // TODO: Some kind of security so that plugins can't unregister other plugins' Actions
        if (!actions.containsKey(actionName)) throw new NoSuchActionException(actionName);

        actions.remove(actionName);
        return true;
    }
}
