package com.objis.dofilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.objis.dofilter.entity.Item;

/**
 * Servlet implementation class FilmController
 */
@WebFilter(filterName = "/submitFilm", 
urlPatterns={"/submitFilm"})
public class FilmController extends HttpServlet implements Filter {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FilmController() {
        super();
    }
	
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {

		try{
			HttpServletRequest hreq = null;
			HttpServletResponse hresp = null;
			
			if (arg0 instanceof HttpServletRequest) hreq = (HttpServletRequest) arg0;
			if (arg1 instanceof HttpServletResponse) hresp = (HttpServletResponse) arg1;
			
			Boolean authenticated = (Boolean) hreq.getSession().getAttribute("authenticated");
			
			if (authenticated == null || !authenticated) {
				hresp.sendRedirect(hresp.encodeRedirectUrl("/Module8Seance12/login.jsp"));
				return;
			}
			
			arg2.doFilter(hreq, hresp);
		} catch(Throwable e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Item item = new Item();
//		item.setAuthor(request.getParameter("filmauthor"));
//		item.setTitle(request.getParameter("fimltitle"));
		System.out.println("jksfdkjsfdjk");
	}

	
}
