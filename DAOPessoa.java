import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

public class DAOPessoa {
	
	private Conexao conexao;
	
	public DAOPessoa() {
		// cria o objeto para conex�o com banco, por�m n�o o inicializa
		// a conex�o deve ser aberta e, consequentemente, fechada durante o envio de comandos
		// ao banco
		this.conexao = new Conexao();
	}
	
	public void criarUsuario(Usuario user) {
		// abrindo a conex�o com o BD
		conexao.conectar();
		

				Usuario  p = new Usuario ();

		try {
			// usando um PreparedStatement com valores externos como par�metros (representados pelo '?')
			PreparedStatement pst = conexao.getConexao().prepareStatement("insert into pessoas(nome,idade) values(?,?)");
			// os m�todos set devem ser escolhidos de acordo com os tipos dos atributos da entidade que est�
			// sendo acessada. A sequ�ncia � determinada por �ndices, iniciando do valor 1.
			pst.setString(1, p.getNome());
			pst.setInt(2, p.getIdade());
			// solicita��o da execu��o da query, ap�s seu preparo			pst.execute();
		} catch (SQLException e) {
		System.out.println("Erro: " + e.getMessage());
		} finally {
			// o banco deve ser desconectado, mesmo quando a exce��o � lan�ada
			conexao.desconectar();
		}
		
	}
	
	// busca de pessoas por seu c�digo de identifica��o no banco (id)
	public Usuario buscarUsuario(int id) {
		// abrindo a conex�o com o BD
		conexao.conectar();
		// busca utilizando o m�todo de consulta do objeto ConexaoBD
		ResultSet resultado = conexao.executarSQL("select * from pessoas where cod_pessoa = \'" + id + "\'");
		Usuario p = new Usuario();
		
		try {
			resultado.next();
			// os m�todos get devem ser escolhidos de acordo com os tipos dos atributos da entidade que est�
			// sendo acessada
			int idPessoa = resultado.getInt("cod_pessoa");
			String nomePessoa = resultado.getString("nome");
			int idadePessoa = resultado.getInt("idade");
			p.setId(idPessoa);
			p.setNome(nomePessoa);
			p.setIdade(idadePessoa);
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			// o banco deve ser desconectado, mesmo quando a exce��o � lan�ada
			conexao.desconectar();
		}
		return p;
	}
	
	public void excluirUsuario(int id) {
		// abrindo a conex�o com o BD
		conexao.conectar();
		
		try {
			PreparedStatement stm = conexao.getConexao().prepareStatement("delete from pessoas where cod_pessoa = \'" + id + "\'");
			stm.execute();
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			// o banco deve ser desconectado, mesmo quando a exce��o � lan�ada
			conexao.desconectar();
		}
	}

	public void editarPessoa(int id, String nome, int idade) {
		// abrindo a conex�o com o BD
		conexao.conectar();
		
		try {
			PreparedStatement stm = conexao.getConexao().prepareStatement("update pessoas set nome = ?, idade = ? "
					+ "where cod_pessoa = \'" + id + "\'");
			stm.setString(1, nome);
			stm.setInt(2, idade);
			stm.execute();
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			// o banco deve ser desconectado, mesmo quando a exce��o � lan�ada
			conexao.desconectar();
		}
	}
	
	public ArrayList<Usuario> verTodos() {
		ArrayList<Usuario> pessoas = new ArrayList<>();
		
		// abrindo a conex�o com o BD
		conexao.conectar();
		ResultSet resultado = conexao.executarSQL("select * from pessoas");
		
		try {
			// para iterar sobre os resultados de uma consulta, deve-se utilizar o m�todo next()
			while (resultado.next()) {
				int idPessoa = resultado.getInt("cod_pessoa");
				String nomePessoa = resultado.getString("nome");
				int idadePessoa = resultado.getInt("idade");
				pessoas.add(new Usuario(idPessoa, nomePessoa, idadePessoa));
			}
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			// o banco deve ser desconectado, mesmo quando a exce��o � lan�ada
			conexao.desconectar();
		}
		return pessoas;
	}

}


