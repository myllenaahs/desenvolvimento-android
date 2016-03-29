package br.edu.ifpb.Monitoria.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.Monitoria.Entidades.Cliente;
import br.edu.ifpb.Monitoria.Entidades.Usuario;

public class UsuarioDAO {

	static GeneralDAO bd = new GeneralDAO();

	static int aux = 0;
	static ResultSet rs;

	public UsuarioDAO() {
	}

	// Método para consulta de usuários no BD
	public boolean consultaUser(Usuario user) {

		bd.abrirConexao();

		System.out.print("Consulta SQL" + user.getLogin() + " " + user.getSenha());

		String sql = "SELECT u.nome " + "FROM USUARIO u " + "WHERE u.nome='" + user.getLogin() + "'" + "AND u.senha='"
				+ user.getSenha() + "'";

		try {
			Statement st = GeneralDAO.connection.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				if (rs == null) {
					aux = 0;
				} else {
					aux = 1;
				}
			}
			st.close();

		} catch (SQLException sqle) {
			System.out.println("Nao foi possivel realizar consulta");
			sqle.printStackTrace(System.err);
		} catch (NullPointerException npe) {
			System.out.println("Nao foi possivel realizar inserção");
			npe.printStackTrace(System.err);
		}

		bd.fecharConexao();

		if (aux == 0) {
			return false;
		} else {
			return true;
		}
	}

	public void insereUsuario(Cliente cliente) {

		try {

			bd.abrirConexao();
			Statement st = GeneralDAO.connection.createStatement();

			String sql = "INSERT INTO usuario (nome, disciplina, login, senha) " + "VALUES ('" + cliente.getNome()
					+ "','" + cliente.getDisciplina() + "','" + cliente.getLogin() + "','" + cliente.getSenha() + "')";

			st.executeUpdate(sql);

			st.close();
			bd.fecharConexao();
		} catch (SQLException sqle) {
			System.out.println("Nao foi possivel realizar inserção");
			sqle.printStackTrace(System.err);
		} catch (NullPointerException npe) {
			System.out.println("Nao foi possivel realizar inserção");
			npe.printStackTrace(System.err);
		}

	}

	public String procurarUsuario(String monitor) {

		String horario = "";

		bd.abrirConexao();

		String sql = "SELECT c.nome, c.horario " + "FROM CLIENTE c " + "WHERE c.disciplina='" + monitor + "'";

		try {
			Statement st = GeneralDAO.connection.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				if (rs == null) {
					horario = "Sem horário";
				} else {
					horario = rs.getString("horario");
				}
			}
			st.close();

		} catch (SQLException sqle) {
			System.out.println("Nao foi possivel realizar consulta");
			sqle.printStackTrace(System.err);
		} catch (NullPointerException npe) {
			System.out.println("Nao foi possivel realizar inserção");
			npe.printStackTrace(System.err);
		}

		bd.fecharConexao();

		return horario;

	}

	public static List<Cliente> getByName (String monitor) {

		bd.abrirConexao();
		
		List<Cliente> clientes = new ArrayList<Cliente> ();

		String sql = "SELECT c.nome, c.horario " + "FROM CLIENTE c " + "WHERE c.nome='" + monitor + "'";

		try {
			Statement st = GeneralDAO.connection.createStatement();
			rs = st.executeQuery(sql);
			
			
			Cliente cliente = new Cliente ();
			int i = 0;
			
			while (rs.next()) {
				cliente.setNome(rs.getString("c.nome"));
				cliente.setHorario(rs.getString("c.horario"));
				clientes.add(i,cliente);	
				i++;
			}
			st.close();

		} catch (SQLException sqle) {
			System.out.println("Nao foi possivel realizar consulta");
			sqle.printStackTrace(System.err);
		} catch (NullPointerException npe) {
			System.out.println("Nao foi possivel realizar inserção");
			npe.printStackTrace(System.err);
		}

		bd.fecharConexao();
		
		Cliente cliente1 = new Cliente ();
		cliente1.setNome("Myllena");
		cliente1.setDisciplina("Matematica");
		
		List<Cliente> clientes1 = new ArrayList<Cliente> ();
		clientes1.add(cliente1);

		return clientes1;

	}

}
