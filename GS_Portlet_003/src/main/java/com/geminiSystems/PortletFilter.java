/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.geminiSystems;

import java.io.IOException;
import javax.portlet.PortletException;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.filter.RenderFilter;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.filter.ActionFilter;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.filter.EventFilter;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.filter.ResourceFilter;
import javax.portlet.filter.FilterChain;
import javax.portlet.filter.FilterConfig;
/**
 *
 * @author GGobozov
 */
public class PortletFilter implements RenderFilter, ActionFilter, EventFilter, ResourceFilter {

    private FilterConfig filterConfig = null;
    private int eventCount = 0;

    public void init(FilterConfig filterConfig) throws PortletException {
        this.filterConfig = filterConfig;
    }

    public void doFilter(RenderRequest renderRequest, RenderResponse renderResponse, FilterChain filterChain) throws IOException, PortletException {

        filterChain.doFilter(renderRequest, renderResponse);
    }

    public void doFilter(ActionRequest actionRequest, ActionResponse actionResponse, FilterChain filterChain) throws IOException, PortletException {

        filterChain.doFilter(actionRequest, actionResponse);
    }

    public void doFilter(EventRequest eventRequest, EventResponse eventResponse, FilterChain filterChain) throws IOException, PortletException {
        eventCount++;
        filterChain.doFilter(eventRequest, eventResponse);
        System.out.println("Total events = " + eventCount);
    }

    public void doFilter(ResourceRequest resourceRequest, ResourceResponse resourceResponse, FilterChain filterChain) throws IOException, PortletException {

        filterChain.doFilter(resourceRequest, resourceResponse);
    }

    public void destroy() {
    }

}
