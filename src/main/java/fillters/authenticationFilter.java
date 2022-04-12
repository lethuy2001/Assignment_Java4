package fillters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entities.User;

/**
 * Servlet Filter implementation class authenticationFilter
 */
@WebFilter(
		urlPatterns = {
			"/users/*"	,
		}
)
public class authenticationFilter implements Filter {

	public authenticationFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) request ;
        HttpServletResponse httpRepon = (HttpServletResponse) response ;
        HttpSession session = httpReq.getSession() ;
        User user = (User) session.getAttribute("user") ;
        
        if( user == null ) {
        	httpRepon.sendRedirect("/PH13751_LeMinhThuy_Lab5.1/loginSL");
        	return ;
        }
 		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
