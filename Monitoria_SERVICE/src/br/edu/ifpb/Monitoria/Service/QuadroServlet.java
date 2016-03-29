package br.edu.ifpb.Monitoria.Service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class QuadroServlet
 */
@WebServlet("/quadroServlet")
public class QuadroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuadroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/*
		 * Consulta do bd aqui
		 * */

		System.out.println("here");
		
		ArrayList <String> monitores = new ArrayList<String>();
		ArrayList <String> disciplinas = new ArrayList<String>();		
		ArrayList<ArrayList> quadro = new ArrayList<ArrayList>();
		
		monitores.add("Laís");
		monitores.add("Myllena");
		
		disciplinas.add("Algoritmos");
		disciplinas.add("Matemática");
		
		System.out.println("here");
		
		quadro.add(monitores);
		quadro.add(disciplinas);
		
		HttpSession session = request.getSession();
		session.setAttribute("quadro", quadro);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Quadro.jsp");
		dispatcher.forward(request, response);
		
	}

}
