package com.geminisystems;
import javax.portlet.GenericPortlet;
import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderResponse;
import javax.portlet.PortletException;
import java.io.IOException;
import javax.portlet.PortletRequestDispatcher;

/**
 * @author : Georgy Gobozov
 * @created : 25.04.13
 */
public class PortletExample extends GenericPortlet {

    @Override
    public void processAction(ActionRequest request, ActionResponse response) throws PortletException,IOException {

    }
    
    @Override
    public void doView(RenderRequest request,RenderResponse response) throws PortletException,IOException {


        response.setContentType("text/html");
        PortletRequestDispatcher dispatcher =
                getPortletContext().getRequestDispatcher("/WEB-INF/jsp/PortletExample1_view.jsp");
        dispatcher.include(request, response);
    }

    @Override
    public void doEdit(RenderRequest request,RenderResponse response) throws PortletException,IOException {
            response.setContentType("text/html");        
        PortletRequestDispatcher dispatcher =
        getPortletContext().getRequestDispatcher("/WEB-INF/jsp/PortletExample1_edit.jsp");
        dispatcher.include(request, response);
    }

    @Override
    public void doHelp(RenderRequest request, RenderResponse response) throws PortletException,IOException {

        response.setContentType("text/html");        
        PortletRequestDispatcher dispatcher =
        getPortletContext().getRequestDispatcher("/WEB-INF/jsp/PortletExample1_help.jsp");
        dispatcher.include(request, response);
    }
}