package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.model.CarroDAO;
import br.com.model.IPVA;

/**
 * Servlet implementation class ProjetoFinalIPVAServlet
 */
@WebServlet("/ProjetoFinalIPVAServlet")
public class ProjetoFinalIPVAServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CarroDAO CarroDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjetoFinalIPVAServlet() {
        super();
        // TODO Auto-generated constructor stub
        this.CarroDAO = new CarroDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String optionIPVA = request.getParameter("optionIPVA");
		
		if (optionIPVA == null) {
			optionIPVA = "qualquer coisa";
		}
		
		switch(optionIPVA) {
		case ("insertIPVA"):
			consultarIPVA(request, response);
		break;
		case ("updateIPVA"):
			IPVAAtualizados(request, response);
		break;
		case ("ipvaUpdate"):
			atualizarIPVA(request, response);
		break;
		case ("ipvaDelete"):
			deletarIPVA(request, response);
		break;
		case ("ipvaInsert"):
			inserirIPVA(request, response);
		break;
		default:
			IPVAconsultar(request, response);
		}
	}
	
	private void consultarIPVA(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("formIPVA.jsp").forward(request, response);
	}
	
	private void IPVAAtualizados(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Integer id = Integer.parseInt(request.getParameter("id"));
		IPVA ipva = this.CarroDAO.consultarIPVA(id);
		request.setAttribute("ipva", ipva);
		request.getRequestDispatcher("formIPVA.jsp").forward(request, response);
	}
	
	private void inserirIPVA(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Integer ano = Integer.parseInt(request.getParameter("ano"));
		if ((ano != null)) {
			if (!ano.equals("")){
				IPVA ipva = new IPVA(ano);
				this.CarroDAO.inserirIPVA(ipva);
			}
		}
		response.sendRedirect("ProjetoFinalIPVAServlet");
	}
	
	private void IPVAconsultar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setAttribute("listaIpva", this.CarroDAO.IPVAconsultar());
		request.getRequestDispatcher("indexIPVA.jsp").forward(request, response);
	}
	
	private void deletarIPVA(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id1 = request.getParameter("id");
		if (id1 != null) {
			Integer id = Integer.parseInt(id1);
			this.CarroDAO.deletarIPVA(id);
		}
		response.sendRedirect("ProjetoFinalIPVAServlet");
	}
	
	private void atualizarIPVA(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer ano = Integer.parseInt(request.getParameter("ano"));
		String id1 = request.getParameter("id");
		if ((ano != null) && (id1 != null)) {
			if (!ano.equals("") && !id1.equals("")){
				Integer id = Integer.parseInt(id1);
				IPVA ipva = new IPVA(ano);
				ipva.setId(id);
				this.CarroDAO.alterarIPVA(ipva);
			}
		}
		response.sendRedirect("ProjetoFinalIPVAServlet");
	}

}
