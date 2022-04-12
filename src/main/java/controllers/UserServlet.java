package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import Dao.UserDao;
import Entities.User;
import Untils.EncryptUntil;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet({ "/users/index", "/users/create", "/users/store", "/users/edit", "/users/update", "/users/delete",
		"/users/show", })
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;

	public UserServlet() {
		super();
		this.userDao = new UserDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		if (uri.contains("index")) {
			this.index(request, response);
		} else if(uri.contains("create")) {
			this.create(request, response);
		} else if( uri.contains("delete") ) {
			this.delete(request , response );
		}else if( uri.contains("edit")) {
			this.edit(request, response);
		}
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI() ;
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		if( uri.contains("store")) {
			this.store(request, response);
		}else if( uri.contains("update")) {
			this.update(request, response);
		}
	}

	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> list = this.userDao.findAll();

		request.setAttribute("list", list);
		request.setAttribute("view", "/views/users/admin/index.jsp");
		request.getRequestDispatcher("/views/Layout.jsp").forward(request, response);
	}

	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("view", "/views/users/admin/create.jsp");
		request.getRequestDispatcher("/views/Layout.jsp").forward(request, response);
	}
	
	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt( request.getParameter("id"));
		User user = this.userDao.findById(id) ;
		
		request.setAttribute( "user", user);
		request.setAttribute("view", "/views/users/admin/edit.jsp");
		request.getRequestDispatcher("/views/Layout.jsp").forward(request, response);
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id = Integer.parseInt( request.getParameter("id"));
			User userOld = this.userDao.findById(id) ;
			User user = new User() ;
			BeanUtils.populate(user, request.getParameterMap() );
			user.setPassword(userOld.getPassword());
			
			this.userDao.edit(user);
			response.sendRedirect("/PH13751_LeMinhThuy_Lab5.1/users/index");
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/PH13751_LeMinhThuy_Lab5.1/users/edit");
		}
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id = Integer.parseInt( request.getParameter("id"));
			System.out.println(id);
			User user = this.userDao.findById(id) ;
			this.userDao.delete(user);
			response.sendRedirect("/PH13751_LeMinhThuy_Lab5.1/users/index");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession() ;
		try {
			User user = new User();
			BeanUtils.populate(user, request.getParameterMap() );
			user.setPassword(  EncryptUntil.encry( request.getParameter("password")));
			this.userDao.create(user);
			session.setAttribute( "message", "Thêm mới thành công");
			response.sendRedirect("/PH13751_LeMinhThuy_Lab5.1/users/index");
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute( "error", "Thêm mới thất bại");
			response.sendRedirect("/PH13751_LeMinhThuy_Lab5.1/users/create");
		}
	}
	

}
