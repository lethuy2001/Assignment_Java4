package Dao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entities.Category;
import Entities.User;

/**
 * Servlet implementation class Catagories
 * @param <User>
 */
@WebServlet("/Catagories")
public class Catagories<User> extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDao userDao ;
    private categoryDao categoryDao ;
	
    public Catagories() {
        super();
        this.userDao = new UserDao();
        this.categoryDao = new categoryDao() ;
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> dsUser =  (List<User>) this.userDao.findAll() ;

		request.setAttribute("dsUser", dsUser);
		request.setAttribute("view", "/views/users/category/create.jsp");
		request.getRequestDispatcher("/views/Layout.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		Category category = new Category();
		String name = request.getParameter("ten");
		int id = Integer.parseInt(request.getParameter("user_id"));

		User user = (User) userDao.findById(id);

		category.setTen(name);
		category.setUser((Entities.User) user);
		
		try {
		     this.categoryDao.create(category) ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("/PH13751_LeMinhThuy_Lab5.1/Catagories");
	}

}
