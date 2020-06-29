package srv;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FrequenzeDao;

/**
 * Servlet implementation class FrequenzeSrv
 */
@WebServlet("/FrequenzeSrv")
public class FrequenzeSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrequenzeSrv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String operazione = request.getParameter("operazione");
		String idCorso = request.getParameter("idCorso");
		String idStudente = request.getParameter("idStudente");
		String colonna = request.getParameter("colonna");
		String nuovo = request.getParameter("nuovo");
		String id = request.getParameter("id");
		
		FrequenzeDao fd = new FrequenzeDao();
		
		if((operazione.compareTo("inserisci"))==0) {
			
			fd.inserisci(Integer.valueOf(idCorso), Integer.valueOf(idStudente));
			response.getWriter().append("inserito idCorso: "+idCorso+" e idStudente: "+idStudente+"... ");
		}
		
		else if((operazione.compareTo("cancella"))==0) {
			
			fd.cancella(Integer.valueOf(id));
			response.getWriter().append("cancellata frequenza: "+id+"... ");
		}
		
		else if((operazione.compareTo("aggiorna"))==0) {
			
			fd.aggiorna((Integer.valueOf(id)), colonna, nuovo);
			response.getWriter().append("aggiornato: "+id+" a "+nuovo+"... ");
		}
		
		else {
			
			fd.stampaTutto();
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
