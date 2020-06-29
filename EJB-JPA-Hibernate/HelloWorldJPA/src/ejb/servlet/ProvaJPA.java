package ejb.servlet;

import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ejb.HWRemote;
import model.Utente;

/**
 * Servlet implementation class ProvaJPA
 */
@WebServlet("/ProvaJPA")
public class ProvaJPA extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	@Resource(mappedName = "java:jboss/exported/HelloWorldJPA/HelloWorldEJB!ejb.HWRemote")
	private  HWRemote bs;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProvaJPA() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String eta = request.getParameter("eta");
		
		Utente u = new Utente();
		u.setId(Integer.valueOf(id));
		u.setNome(nome);
		u.setCognome(cognome);
		u.setEta(Integer.valueOf(eta));
		
		bs.inser(u);
		
		//bs.stampa1(Integer.valueOf(id));
		
		//bs.stampa2();
		
		//bs.del(Integer.valueOf(id));
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ProvaJPA.jsp");
 		dispatcher.forward(request,response);
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
