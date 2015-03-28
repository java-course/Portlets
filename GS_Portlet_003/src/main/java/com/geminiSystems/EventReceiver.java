package com.geminiSystems;
import javax.portlet.GenericPortlet;
import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderResponse;
import javax.portlet.PortletException;
import java.io.IOException;
import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletSession;

/**
 * PortletExample3 Portlet Class
 */
public class EventReceiver extends GenericPortlet {

    @Override
    public void processEvent(EventRequest request, EventResponse response) throws PortletException, IOException {
        Event event = request.getEvent();
        if (event.getName().equals("Message")) {
            Message msg = (Message) event.getValue();
            PortletSession ps = request.getPortletSession();
            ps.setAttribute("text", msg.getText());
        }
    }


    @Override
    public void processAction(ActionRequest request, ActionResponse response) throws PortletException,IOException {

    }
    
    @Override
    public void doView(RenderRequest request,RenderResponse response) throws PortletException,IOException {
        response.setContentType("text/html");
        PortletRequestDispatcher dispatcher =
        getPortletContext().getRequestDispatcher("/WEB-INF/jsp/receiver.jsp");
        dispatcher.include(request, response);
    }
    
}