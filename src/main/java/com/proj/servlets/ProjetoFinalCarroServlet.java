package com.proj.servlets;

import br.com.model.Carro;
import br.com.model.CarroDAO;
import br.com.model.IPVA;
import controller.ProjetoFinalIPVAServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProjetoFinalCarroServlet
 */
@WebServlet("/ProjetoFinalCarroServlet")
public class ProjetoFinalCarroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CarroDAO CarroDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjetoFinalCarroServlet() {
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
		String option = request.getParameter("option");

		if (option == null) {
			option = "qualquer coisa";
		}
		

		
		switch(option) {
			case ("insertForm"):
				consultarCarro(request, response);
			break;
			case ("updateForm"):
				carrosAtualizados(request, response);
			break;
			case ("update"):
				atualizar(request, response);
			break;
			case ("delete"):
				deletar(request, response);
			break;
			case ("insert"):
				inserir(request, response);
			break;
			default:
				consultar(request, response);
//				pagaIPVA(request, response);
		}
		
//		
	}
	
	
	private void consultarCarro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("form.jsp").forward(request, response);
	}
	
	private void carrosAtualizados(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Integer id = Integer.parseInt(request.getParameter("id"));
		Carro carro = this.CarroDAO.consultarCarro(id);
		request.setAttribute("carro", carro);
		request.getRequestDispatcher("form.jsp").forward(request, response);
	}
	
	private void inserir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String modelo = request.getParameter("modelo");
		Integer ano = Integer.parseInt(request.getParameter("ano"));
		if ((modelo != null) && (ano != null)) {
			if (!modelo.equals("")){
				Carro carro = new Carro(modelo, ano);
				this.CarroDAO.inserir(carro);
			}
		}
		response.sendRedirect("ProjetoFinalCarroServlet");
	}
	
	private void consultar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setAttribute("carros", this.CarroDAO.consultar());
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	private void deletar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id1 = request.getParameter("id");
		if (id1 != null) {
			Integer id = Integer.parseInt(id1);
			this.CarroDAO.deletar(id);
		}
		response.sendRedirect("ProjetoFinalCarroServlet");
	}
	
	private void atualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String modelo = request.getParameter("modelo");
		Integer ano = Integer.parseInt(request.getParameter("ano"));
		String id1 = request.getParameter("id");
		if ((modelo != null) && (ano != null) && (id1 != null)) {
			if (!modelo.equals("")){
				Integer id = Integer.parseInt(id1);
				Carro carro = new Carro(modelo, ano);
				carro.setId(id);
				this.CarroDAO.alterar(carro);
			}
		}
		response.sendRedirect("ProjetoFinalCarroServlet");
	}
	
	
//	private String pagaIPVA(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Carro carro = new Carro();
//		IPVA ipva = new IPVA();
//		
//		String pagaIPVA = request.getParameter("pagaIPVA");
//		String paga = "Paga IPVA";
//		String naoPaga = "Não paga IPVA";
//		
//		
//			if(carro.getId() <= ipva.getId()) {
//				return paga;
//			}else {
//				return naoPaga;
//			}
//		
//		
//	}

}
