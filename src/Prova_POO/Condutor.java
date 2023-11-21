package Prova_POO;

import javax.swing.JOptionPane;

public class Condutor extends Pessoas {
	private String Embriagado;

	// Metodo para cadastro de condutor
	// Chama metodo Pai de cadastro de pessoas
	// e adiciona a pergunta se esta embriagado S/N
	public void cadastraCondutor() {
		boolean inputValido = false;

		do {
			try {
				super.cadastraPessoas();

				String embriagadoInput = JOptionPane.showInputDialog(null, "O condutor está embriagado? S/N");
				setEmbriagado(validarEmbriaguez(embriagadoInput));

				inputValido = true;
			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		} while (!inputValido);
	}

	// Construtor de Condutor
	public Condutor() {
	}

	public Condutor(String nome, int idade, String sexo, String embriagado) {
		super(nome, idade, sexo);
		Embriagado = embriagado;
	}

	// Converte construtor em String
	@Override
	public String toString() {
		return super.toString() + "\nMotorista esta Embriagado? " + Embriagado;
	}

	// Gets and Setters
	public String getEmbriagado() {
		return Embriagado;
	}

	public void setEmbriagado(String embriagado) {
		Embriagado = embriagado;
	}

	private String validarEmbriaguez(String embriagadoInput) {
		String embriagadoFormatado = embriagadoInput.trim().toUpperCase();

		if (embriagadoFormatado.equals("S") || embriagadoFormatado.equals("N")) {
			return embriagadoFormatado;
		} else {
			throw new IllegalArgumentException(
					"Resposta inválida para embriaguez. Insira 'S' para Sim ou 'N' para Não.");
		}
	}

}
