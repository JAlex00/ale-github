package srv;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DocenteDao;

/**
 * Servlet implementation class DocenteSrv
 */
@WebServlet("/DocenteSrv")
public class DocenteSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocenteSrv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String operazione = request.getParameter("operazione");
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String id = request.getParameter("idDocente");
		String colonna = request.getParameter("colonna");
		String nuovo = request.getParameter("nuovo");
		
		DocenteDao dd = new DocenteDao();
		
		if((operazione.compareTo("inserisci"))==0) {
			
			dd.inserisci(nome, cognome);
			response.getWriter().append("inserito: "+nome+", "+cognome+"... ");
		}
		
		else if((operazione.compareTo("cancella"))==0) {
			
			dd.cancella(Integer.valueOf(id));
			response.getWriter().append("cancellato docente: "+id+"... ");
		}
		
		else if((operazione.compareTo("aggiorna"))==0) {
			
			dd.aggiorna((Integer.valueOf(id)), colonna, nuovo);
			response.getWriter().append("aggiornato docente "+id+" a "+nuovo+"... ");
		}
		
		else {
			
			dd.stampaTutto();
			response.getWriter().append("Visualizza stampa su terminale ... ");
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pages/Done.html");
 		dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
