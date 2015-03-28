package com.geminisystems;

import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderResponse;
import javax.portlet.PortletMode;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.AbstractController;
import org.springframework.web.portlet.mvc.Controller;

/**
 * PortletExample4 Portlet Class
 */
public class PortletExample4 implements Controller {

    @Override
    public void handleActionRequest(ActionRequest request, ActionResponse response) throws Exception {

    }

    @Override
    public ModelAndView handleRenderRequest(RenderRequest request, RenderResponse response) throws Exception {
        ModelAndView modelAndView = null;
        if (request.getPortletMode().equals(PortletMode.VIEW)) {
            modelAndView = new ModelAndView("PortletExample4_view");
            modelAndView.addObject("test", "I am spring portlet view!");
        }

        if (request.getPortletMode().equals(PortletMode.EDIT)) {
            modelAndView = new ModelAndView("PortletExample4_edit");
            modelAndView.addObject("test", "I am spring portlet edit!");
        }

        return modelAndView;
    }
}
