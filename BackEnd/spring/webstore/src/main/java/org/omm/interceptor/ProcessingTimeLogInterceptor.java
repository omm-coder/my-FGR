package org.omm.interceptor;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class ProcessingTimeLogInterceptor
        implements HandlerInterceptor {

    private static final Logger LOGGER =
            Logger.getLogger(ProcessingTimeLogInterceptor.class);

    public boolean preHandle(HttpServletRequest req,
                             HttpServletResponse res,Object handler) {
        Long startTime = System.currentTimeMillis();
        req.setAttribute("startTime", startTime);

        return true;
    }

    public void postHandle(HttpServletRequest req,
                           HttpServletResponse res, Object handler,
                           ModelAndView modelAndView) {
        String queryString = req.getQueryString() == null ? "":
                "?"+req.getQueryString();
        String path = req.getRequestURL()+queryString;

        long startTime = (Long) req.getAttribute("startTime");
        long endTime = System.currentTimeMillis();

//        LOGGER.info(String.format("%s millisecond taken to " +
//                "process the request %s.",(endTime - startTime), path));
//        System.out.printf("%s millisecond taken to process the request %s.%n",
//                (endTime - startTime), path);
    }

    public void afterCompletion(HttpServletRequest req,
                                HttpServletResponse res,
                                Object handler, Exception exceptionIfAny){
        // NO operation.
    }




}
