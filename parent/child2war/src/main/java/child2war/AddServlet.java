package child2war;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		int i = Integer.parseInt(req.getParameter("val1"));
		int j = Integer.parseInt(req.getParameter("val2"));
		System.out.println(i + j);
		res.getWriter().println(i+j);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		doGet(req, res);
	}
}
