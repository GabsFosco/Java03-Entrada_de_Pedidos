package entities;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class Cliente {

	private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private String nome;
	private String email;
	private LocalDate nascimento;
	
	public Cliente(String nome, String email, String nascimento) {
		this.nome = nome;
		this.email = email;
		this.nascimento = LocalDate.parse(nascimento, fmt);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNascimento() {
		return fmt.format(nascimento);
	}

	@Override
	public String toString() {
		return getNome() + " (" + getNascimento() + ") - " + getEmail();
	}
	
}
