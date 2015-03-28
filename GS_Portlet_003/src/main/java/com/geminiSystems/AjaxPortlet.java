/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.geminiSystems;

import java.io.IOException;
import java.io.Writer;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

/**
 *
 * @author GGobozov
 */
public class AjaxPortlet extends GenericPortlet {

    @Override
    protected void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException {
        response.setContentType("text/html");
        PortletRequestDispatcher dispatcher =
                getPortletContext().getRequestDispatcher("/WEB-INF/jsp/ajax.jsp");
        dispatcher.include(request, response);
    }

    @Override
    public void serveResource(ResourceRequest request, ResourceResponse response) throws PortletException, IOException {
        String text = request.getParameter("text");
        if (text != null){
            Writer w = response.getWriter();
            w.write(text);
        }
    }



}
