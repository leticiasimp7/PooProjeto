public class Usuario {
		private String email;
		private String senha;
		private String nome;
		private String profissao;
		private int idade;
		private int id;
		
		
		public Usuario(){
			
		}
		
		
		public Usuario(String e, String s,String n, String p, int i){
			setEmail(e);
			setSenha(s);
			setNome(n);
			setProfissao(p);
			setIdade(i);
		}
		
		public Usuario(int idPessoa, String nomePessoa, int idadePessoa) {
			
		}

		
		public void setEmail(String email){
			this.email=email;
		}
		public String getEmail(){
			return this.email;
		}
		
		public void setSenha(String senha){
			this.senha=senha;
		}
		
		public String getSenha(){
			return this.senha;
		}
		
		public void setNome(String nome){
			this.nome=nome;
		}
		public String getNome(){
			return this.nome;
		}
		
		public void setProfissao (String profissao){
			this.profissao=profissao;
		}
		public String getProfissao() {
			return this.profissao;
		}
		public void setIdade(int idade) {
			this.idade=idade;
		}
		
		public int getIdade(){
			return this.idade;
		}
		public void setId(int id) {
			this.id=id;
		}
		public int getId() {
			return this.id;
		}
			
}