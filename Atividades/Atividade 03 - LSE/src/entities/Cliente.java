package entities;

public class Cliente implements Comparable<Cliente> {
	private String cpf;
	private String nome;
	private String telefone;
	private String email;
	
	public Cliente(String cpf) {
		this.cpf = cpf;
	}
	
	public Cliente(String cpf, String nome, String fone, String email) {
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = fone;
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFone() {
		return telefone;
	}

	public void setFone(String fone) {
		this.telefone = fone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Email: " + email + "\n"
			 + "Telefone: " + telefone + "\n"
			 + "Nome: " + nome + "\n";
	}
	
	@Override
	public int compareTo(Cliente cliente) {
		return this.cpf.compareTo(cliente.cpf);
	}
}