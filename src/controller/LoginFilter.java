package controller;

import domain.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter", urlPatterns = "/*")
public class LoginFilter implements Filter {

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String uri = ((HttpServletRequest) req).getRequestURI();
        if (uri.equalsIgnoreCase("/login") || uri.equalsIgnoreCase("/")) {
            chain.doFilter(req, resp);
        } else {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            if (user == null) {
                String message = "Login First !!!";
                request.setAttribute("msg", message);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else
                chain.doFilter(req, resp);

        }

    }

    public void init(FilterConfig config) throws ServletException {


    }

}
