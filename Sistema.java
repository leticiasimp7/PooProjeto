import java.util.ArrayList;
import java.util.Scanner;
public class Sistema {
	public ArrayList<Usuario> cadastrar() {

		Scanner leitor = new Scanner(System.in);

		System.out.println("Por favor, insira os seus dados: " + "\nNome ");

		String nome = leitor.next();
		System.out.println("Email: ");
		String email = leitor.next();
		System.out.println("Senha: ");
		String senha = leitor.next();
		System.out.println("idade: ");
		int idade = leitor.nextInt();
		String profissao = leitor.next();
		System.out.println("Profissao: ");


		Usuario usuario = new Usuario();

		
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setSenha(senha);
		usuario.setIdade(idade);		
		usuario.setProfissao(profissao);



		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

		usuarios.add(usuario);

		System.out.println(usuario.getNome() + "\n" + usuario.getEmail() + "\n" + usuario.getIdade() + usuario.getProfissao());	

		return usuarios;

	}
	
	
}
	
