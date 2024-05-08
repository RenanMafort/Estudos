package br.com.dev.maratonajsf.bean.filter;


import br.com.dev.maratonajsf.bean.login.LoginBean;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Renan on 19/01/2023.
 */
public class LoginFilter implements Filter {
    @Inject
    private LoginBean loginBean;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        String url= req.getRequestURL().toString();
        System.out.println(url);
        if (url.contains("/restricted") &&  loginBean.getEstudante() == null){
            res.sendRedirect(req.getServletContext().getContextPath() + "/login.xhtml");
            System.out.println(url);

        }else {
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
