package entities;

public class Contato implements Comparable<Contato> {
	
	private String nome;
	private String telefone;
	private String email;
	
	public Contato(String nome) {
		this.nome = nome;
	}
	
	public Contato(String nome, String telefone, String email) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Email: " + this.getEmail() + "\n"
			+  "Telefone: " + this.getTelefone() + "\n"
			+  "Nome: " + this.getNome() + "\n";
	}
	
	@Override
    public int compareTo(Contato cliente) {
        return nome.compareTo(cliente.nome);
    }
}
