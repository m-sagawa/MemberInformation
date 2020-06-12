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
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update-servlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
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
		String member = (String)session.getAttribute("member");
		String message = null;

		String name = request.getParameter("name");
		String ag = request.getParameter("age");
		String ye = request.getParameter("year");
		String mo = request.getParameter("month");
		String da = request.getParameter("day");

		if(name == "" || ag == "" || ye == "" || mo == "" || da == "") {
			message = "入力されていない項目があります";
		}else {

			try {
				int age = Integer.parseInt(ag);
				int year = Integer.parseInt(ye);
				int month = Integer.parseInt(mo);
				int day = Integer.parseInt(da);

				Bean memberBean = new Bean();

				memberBean.setMember(member);
				memberBean.setName(name);
				memberBean.setAge(age);
				memberBean.setYear(year);
				memberBean.setMonth(month);
				memberBean.setDay(day);

				Dao dao = new Dao();
				message = dao.Update(memberBean);

			}catch(NumberFormatException e){
				message = "入力された値が不正です";
			}
		}

		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("Update.jsp");
		rd.forward(request, response);
	}

}
