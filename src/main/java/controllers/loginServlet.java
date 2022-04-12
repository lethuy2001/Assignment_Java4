package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.UserDao;
import Entities.User;
import Untils.EncryptUntil;

/**
 * Servlet implementation class login
 */
@WebServlet("/loginSL")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao userDao ;
       

    public loginServlet() {
        super();
        userDao = new UserDao();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/Login.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = request.getParameter("email"),
			pwd = request.getParameter("password");

		System.out.println(email + "-" + pwd);
		User user = this.userDao.findByEmail(email);
		boolean check = EncryptUntil.check( pwd , user.getPassword()) ;
		System.out.println(check);
		
		if (check == true) {
			// Đăng nhập thành công
			session.setAttribute("user", user);
			System.out.println("Ta là siêu nhân");
			session.setAttribute("success", "Đăng nhập thành công" );
			response.sendRedirect("/PH13751_LeMinhThuy_Lab5.1/users/index");
		} else {
			session.setAttribute("error", "Đăng nhập thất bại" );	
		}
		
	}

}
