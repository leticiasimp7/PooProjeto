
import java.util.ArrayList;

public class Teste{

      public static void main(String []args){
    	  Conexao conexao = new Conexao();
    	  conexao.conectar();

    	  Usuario user = new Usuario();
    	  DAOPessoa pessoa = new DAOPessoa();
    	  Sistema sis = new Sistema();

    	  ArrayList<Usuario> users = sis.cadastrar();

   

       pessoa.criarUsuario(user);


     }

}