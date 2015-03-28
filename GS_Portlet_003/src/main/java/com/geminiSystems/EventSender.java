/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geminiSystems;

import java.io.IOException;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.xml.namespace.QName;

/**
 *
 * @author GGobozov
 */
public class EventSender extends GenericPortlet {

    @Override
    public void processAction(ActionRequest request, ActionResponse response) throws PortletException, IOException {
        if (request.getParameter("submit_event") != null) {
            QName qname = new QName("http:gemini.com/events", "Message");
            Message msg = new Message();
            msg.setText(request.getParameter("text"));
            response.setEvent(qname, msg);
        }

        if (request.getParameter("submit_public") != null){
            String text = request.getParameter("text");
            response.setRenderParameter("public", text);
        }
    }

    @Override
    public void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException {
        response.setContentType("text/html");
        PortletRequestDispatcher dispatcher =
                getPortletContext().getRequestDispatcher("/WEB-INF/jsp/sender.jsp");
        dispatcher.include(request, response);
    }
}
