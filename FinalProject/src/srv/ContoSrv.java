package srv;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import clientRest.PutClient;
import clientRest.PostClient;

/**
 * Servlet implementation class ContoSrv
 */
@WebServlet("/ContoSrv")
public class ContoSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContoSrv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		
		String op = request.getParameter("op");
		String idConto = request.getParameter("idConto");
		String mov = request.getParameter("mov");
		
		PutClient pc = new PutClient();
		PostClient poc = new PostClient();
		
		if((op.compareTo("Nuovo"))==0) {
			
			try {
				
				poc.createConto(Integer.valueOf(idConto));
		
			}catch(Exception e) {
			
				System.out.println("input non valido");
			
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pagesCONTO/Error.html");
				dispatcher.forward(request,response);
			}
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pagesCONTO/Done.html");
			dispatcher.forward(request,response);
			
		}
		
		else {
			
			try {
			
				pc.UpdateConto(op, Integer.valueOf(idConto), Double.valueOf(mov));
		
			}catch(Exception e) {
			
				System.out.println("input non valido");
			
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pagesCONTO/Error.html");
				dispatcher.forward(request,response);
			}
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pagesCONTO/Done.html");
			dispatcher.forward(request,response);
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
