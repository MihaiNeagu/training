package victor.first;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import victor.first.domain.User;
import victor.first.domain.UserService;

public class CatreJsp extends HttpServlet {
	
	private UserService service = new UserService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.getParameter("p1")
		User user = service.getUserById(1l);
		req.setAttribute("user", user);
		req.getRequestDispatcher("/WEB-INF/views/hello.jsp").forward(req, resp);
	}
}
