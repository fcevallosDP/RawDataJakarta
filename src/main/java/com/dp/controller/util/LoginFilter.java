
package com.dp.controller.util;

import com.dp.util.TblUsers;
import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
         
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String reqURI = req.getRequestURI();
        try{
            
            HttpSession ses = req.getSession();
            TblUsers user = (ses != null) ? (TblUsers) ses.getAttribute("SESVAR_Usuario") : null;
            if ( (ses != null && user != null) ){

                chain.doFilter(request, response);

            }else if(reqURI.contains("jakarta.faces.resource") || reqURI.indexOf("/login.xhtml") >= 0 || reqURI.indexOf("/public/") >= 0){
                chain.doFilter(request, response);
                
            }else{
                res.sendRedirect(req.getContextPath()+"/login.xhtml");
            }
                
                 
        }catch(Exception e){
             res.sendRedirect(req.getContextPath()+"/login.xhtml");
        }
    }

    @Override
    public void destroy() {
         
    }

}
