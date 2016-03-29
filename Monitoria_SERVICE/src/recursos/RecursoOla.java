package recursos;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.edu.ifpb.Monitoria.DAO.UsuarioDAO;
import br.edu.ifpb.Monitoria.Entidades.Cliente;

@Path("services")
public class RecursoOla {

	private static Logger logger = LogManager.getLogger(RecursoOla.class);

	@POST
	@Path("/get-byname")
	@Consumes("application/json")
	@Produces("application/json")
	public List<Cliente> findUserByName(Cliente user) {
	
		logger.info("/get-byname: " + user.getNome());

		String fullName = user.getNome().trim().toUpperCase();

		List<Cliente> users = UsuarioDAO.getByName(fullName);
		logger.info("Participants: " + users.size() + "[" + users + "]");

		return users;
		
	}

	@GET
	public String digaOla(@QueryParam("parametro") String parametro) {
		return "Olá Mundo! <br/> O parâmetro de \"Query\"enviado foi: " + parametro;
	}


}