package srv;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CorsiDao;

/**
 * Servlet implementation class CorsiSrv
 */
@WebServlet("/CorsiSrv")
public class CorsiSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CorsiSrv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String operazione = request.getParameter("operazione");
		String descrizione = request.getParameter("descrizione");
		String id = request.getParameter("idCorsi");
		String colonna = request.getParameter("colonna");
		String nuovo = request.getParameter("nuovo");
		
		CorsiDao cd = new CorsiDao();
		
		if((operazione.compareTo("inserisci"))==0) {
			
			cd.inserisci(descrizione);
			response.getWriter().append("inserito: "+descrizione+"... ");
		}
		
		else if((operazione.compareTo("cancella"))==0) {
			
			cd.cancella(Integer.valueOf(id));
			response.getWriter().append("cancellato corso: "+id+"... ");
		}
		
		else if((operazione.compareTo("aggiorna"))==0) {
			
			cd.aggiorna((Integer.valueOf(id)), colonna, nuovo);
			response.getWriter().append("aggiornato corso "+id+" a "+nuovo+"... ");
		}
		
		else {
			
			cd.stampaTutto();
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
