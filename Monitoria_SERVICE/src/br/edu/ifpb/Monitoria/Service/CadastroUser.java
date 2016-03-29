package br.edu.ifpb.Monitoria.Service;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.google.gson.Gson;

import br.edu.ifpb.Monitoria.DAO.UsuarioDAO;
import br.edu.ifpb.Monitoria.Entidades.Cliente;

@Path("cadastro")
public class CadastroUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CadastroUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	protected void cadastro(String stringJSON) throws IOException {

		Cliente cliente = new Cliente();
		Gson gson = new Gson();
		
		cliente = gson.fromJson(stringJSON, Cliente.class);

		UsuarioDAO user = new UsuarioDAO();

		user.insereUsuario(cliente);
	}

}