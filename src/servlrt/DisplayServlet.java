package servlrt;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Bean;
import dao.Dao;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/display-servlet")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		session.removeAttribute("member");
		String member = request.getParameter("member");
		String from = request.getParameter("from");
		String url = null;

		if(from.equals("delete")) {
			url = "Delete.jsp";
		}else if(from.contentEquals("update")) {
			url = "Update.jsp";
		}else {
			url = "test.jsp";
		}

		Dao dao = new Dao();
		Bean memberBean = dao.SelectMember(member);

		if(memberBean.getName() == null) {
			request.setAttribute("message", "該当する会員情報が見つかりません");
		}else {
			session.setAttribute("member", member);
			request.setAttribute("memberBean", memberBean);
		}

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}