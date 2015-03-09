package ru.tsystems.eCare.controller;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by sevasan on 3/7/2015.
 */
@WebFilter(urlPatterns = "/secure/*", dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD})
public class SessionFilter implements Filter {
    private final static Logger logger = Logger.getLogger(SessionFilter.class);

    public void init(FilterConfig config) throws ServletException {
        logger.info("SessionFilter initialized.");
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        HttpSession session = request.getSession(false);
        String uri = request.getRequestURI();
        logger.debug("Request for: " + uri);

        if (null == session) {
            logger.debug("Request denied: null session.");
            response.sendRedirect(request.getContextPath() + "/LoginPage.jsp");
            return;
        } else {
            if (session.getAttribute("currentUser") == null) {
                logger.debug("Request denied: unauthorised access attempt.");
                response.sendRedirect(request.getContextPath() + "/LoginPage.jsp");
                return;
            } else {
                chain.doFilter(req, resp);
            }
        }
    }
}
