package br.edu.ifpb.Monitoria.Service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.ifpb.Monitoria.DAO.GeneralDAO;
import br.edu.ifpb.Monitoria.DAO.UsuarioDAO;

/**
 * Servlet implementation class procuraMonitor
 */
@WebServlet("/procuraMonitor")
public class procuraMonitor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public procuraMonitor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		GeneralDAO bd = new GeneralDAO ();
		UsuarioDAO user = new UsuarioDAO ();
		
		bd.abrirConexao();
		
		String aux = request.getParameter("monitor");
				
		String horario = user.procurarUsuario(aux);
		
		
		request.setAttribute("horario", horario);
		request.setAttribute("monitr", aux);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("horario.jsp");
		
		dispatcher.forward(request, response);
		
		bd.fecharConexao();
		
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
