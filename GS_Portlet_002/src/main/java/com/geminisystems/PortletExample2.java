package com.geminisystems;

import javax.portlet.GenericPortlet;
import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderResponse;
import javax.portlet.PortletException;
import java.io.IOException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.WindowState;

/**
 * PortletExample2 Portlet Class
 */
public class PortletExample2 extends GenericPortlet {

    public static final String KEY_EMAIL = "email";
    public static final String KEY_PASSWORD = "password";
    public static final String TEXT = "text";
    public static final String SUBMIT = "submit";
    public static final String SUBMIT_TEXT = "submit_text";
    public static final String CUSTOM_MODE = "config";
    private static final PortletMode CUSTOM_CONFIG_MODE = new PortletMode("config");

    @Override
    public void init() throws PortletException {
        super.init();
    }

    @Override
    public void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException {
        response.setContentType("text/html");
        PortletRequestDispatcher dispatcher =
                getPortletContext().getRequestDispatcher("/WEB-INF/jsp/PortletExample2_view.jsp");
        dispatcher.include(request, response);
    }

    @Override
    public void doEdit(RenderRequest request, RenderResponse response) throws PortletException, IOException {
        response.setContentType("text/html");

        PortletPreferences prefs = request.getPreferences();
        String email = prefs.getValue(KEY_EMAIL, "");
        String password = prefs.getValue(KEY_PASSWORD, "");
        request.setAttribute(KEY_EMAIL, email);
        request.setAttribute(KEY_PASSWORD, password);

        PortletRequestDispatcher dispatcher =
                getPortletContext().getRequestDispatcher("/WEB-INF/jsp/PortletExample2_edit.jsp");
        dispatcher.include(request, response);
    }

    @Override
    public void doHelp(RenderRequest request, RenderResponse response) throws PortletException, IOException {
        response.setContentType("text/html");
        PortletRequestDispatcher dispatcher =
                getPortletContext().getRequestDispatcher("/WEB-INF/jsp/PortletExample2_help.jsp");
        dispatcher.include(request, response);
    }

    @Override
    public void processAction(ActionRequest request, ActionResponse response) throws PortletException, IOException {


        PortletPreferences prefs = request.getPreferences();

        if (request.getParameter(SUBMIT) != null) {
            String newEmail = request.getParameter(KEY_EMAIL);
            String newPassword = request.getParameter(KEY_PASSWORD);
            prefs.setValue(KEY_EMAIL, newEmail);
            prefs.setValue(KEY_PASSWORD, newPassword);
            prefs.store();
            response.setPortletMode(PortletMode.VIEW);
        }

        if (request.getParameter(SUBMIT_TEXT) != null) {
            System.out.println("Sending text: ");
            System.out.println(request.getParameter(TEXT));
            System.out.println("To email : " + prefs.getValue(KEY_EMAIL, ""));

        }



    }

    @Override
    protected void doDispatch(RenderRequest request, RenderResponse response) throws PortletException, IOException {
        if (!WindowState.MINIMIZED.equals(request.getWindowState())) {
            PortletMode mode = request.getPortletMode();
            if (CUSTOM_CONFIG_MODE.equals(mode)) {
                doCustomConfigure(request, response);
                return;
            }
        }
        super.doDispatch(request, response);
    }

    protected void doCustomConfigure(RenderRequest request, RenderResponse response) throws PortletException, IOException {
        response.setContentType("text/html");
        PortletRequestDispatcher dispatcher =
                getPortletContext().getRequestDispatcher("/WEB-INF/jsp/PortletExample2_config.jsp");
        dispatcher.include(request, response);
    }
}
