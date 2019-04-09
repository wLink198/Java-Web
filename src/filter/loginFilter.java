package filter;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class loginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse)  servletResponse;
        Cookie[] cookies = req.getCookies();
        boolean login = false;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("login")) {
                if (req.getRequestURI().equals("/login")) {
                    resp.sendRedirect("/hello");
                } else {
                    filterChain.doFilter(req, resp);
                }
                login = true;
            }
        }
        if (!login) {
            if (!req.getRequestURI().equals("/login")) {
                resp.sendRedirect("/login");
            } else {
                filterChain.doFilter(req, resp);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
