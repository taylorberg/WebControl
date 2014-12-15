package com.tman0.webcontrol.exceptions;

/**
 * @author tman0
 * @version 12.15.2014
 */
public class ActionAlreadyExistsException extends Exception
{

    /**
     * @param action The Action which caused the Exception.
     */
    public ActionAlreadyExistsException(String action)
    {
        super("The action \"" + action + "\" already exists.");
        this.actionName = action;
    }

    private String actionName;

    /**
     * @return The name of the Action which caused the Exception.
     */
    public String getActionName()
    {
        return actionName;
    }
}
