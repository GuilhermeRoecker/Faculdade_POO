package Prova_POO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JOptionPane;

public class Acidente {

	Rodovia rodovia;
	Veiculos veiculo;
	private int fatal;
	private int feridos;
	private String mes;
	private int qt;
	private int rodoviaAcidente;
	private String nomeRodovia = "";
	private String ehDeCarga;
	private static int alto = 0;
	private static int medio = 0;
	private static int baixo = 0;
	private String contaAcidente = "";
	private String ehBike = "";
	private int totalPessoasEnvolvidas = 0;

	ArrayList<Veiculos> veiculos = new ArrayList<>();
	ArrayList<VeiculosDeCarga> veiculosDeCargas = new ArrayList<>();
	ArrayList<Bicicleta> bicicleta = new ArrayList<>();

	public void CadastrarAcidente(ArrayList<Rodovia> rodovias) {

		// Percorre o array de rodovias para exibir as ja cadastradas
		// para que o usuario escolha em qual ocorreu o acidente
		for (Rodovia r : rodovias) {
			nomeRodovia += r.getCod() + " - " + r.getSigla().toUpperCase() + " - Risco: " + r.getGrau() + "\n";
		}

		// Pede para o usuario selecionar em qual rodovia da Lista exibida
		// em que ocorreu o acidente e valida se ela existe
		do {
			try {
				rodoviaAcidente = Integer
						.parseInt(JOptionPane.showInputDialog(
								"Qual rodovia ocorreu o acidente? \nSelecione pelo codigo  \n " + nomeRodovia));
				if (!codigoRodoviaValido(rodovias, rodoviaAcidente)) {
					throw new NumberFormatException();
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Código de rodovia inválido. Por favor, insira um código válido.");
			}
		} while (!codigoRodoviaValido(rodovias, rodoviaAcidente));

		// Pergunta quantos veiculos foram envolvidos para se utilizar no cadastra
		// veiculo
		// e se são de carga, se sim qual a quantidade para subtrair de veiculo
		do {
			try {
				qt = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantidade de Veículos envolvidos?"));
				if (qt < 1) {
					JOptionPane.showMessageDialog(null, "A quantidade de veículos deve ser no mínimo 1.");
					qt = -1; // Define um valor inválido para repetir o loop
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Por favor, insira um número válido.");
				qt = -1; // Define um valor inválido para repetir o loop
			}
		} while (qt == -1);

		for (int q = 1; q <= qt; q++) {

			ehDeCarga = JOptionPane.showInputDialog(null, "O veiculo é de carga? S/N");
			if (ehDeCarga.equalsIgnoreCase("s")) {
				VeiculosDeCarga Vc = new VeiculosDeCarga();
				Vc.cadastraVeiculosDeCarga();
				veiculosDeCargas.add(Vc);
			}

			// Se o vaiculo não for de carga ira perguntar se é Bicicleta
			if (ehDeCarga.equalsIgnoreCase("n")) {
				ehBike = JOptionPane.showInputDialog(null, "O veiculo é uma bicicleta? S/N");

				if (ehBike.equalsIgnoreCase("S")) {
					Bicicleta b1 = new Bicicleta();
					b1.cadastraBicicleta();
					bicicleta.add(b1);
				}
				if (ehBike.equalsIgnoreCase("N")) {
					Veiculos v = new Veiculos();
					v.cadastraVeiculos();
					veiculos.add(v);
				}
			}
		}

		for (Veiculos veiculo : veiculos) {
			totalPessoasEnvolvidas += veiculo.getQtdPessoas();
		}

		for (VeiculosDeCarga veiculoCarga : veiculosDeCargas) {
			totalPessoasEnvolvidas += veiculoCarga.getQtdPessoas();
		}

		for (Bicicleta bike : bicicleta) {
			totalPessoasEnvolvidas += bike.getQtdPessoas();
		}

		do {
			try {
				setFatal(Integer.parseInt(JOptionPane.showInputDialog(null, "Quantidade de vítimas fatais?")));

				if (getFatal() > totalPessoasEnvolvidas) {
					JOptionPane.showMessageDialog(null,
							"Quantidade de vítimas fatais não pode ser maior que a quantidade total de pessoas nos veículos.");
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Por favor, insira um número válido.");
			}
		} while (getFatal() > totalPessoasEnvolvidas);

		do {
			try {
				setFeridos(Integer.parseInt(JOptionPane.showInputDialog(null, "Quantidade de vítimas feridas?")));

				if (getFeridos() + getFatal() > totalPessoasEnvolvidas) {
					JOptionPane.showMessageDialog(null,
							"A soma de vítimas fatais e feridas não pode ser maior que a quantidade total de pessoas nos veículos.");
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Por favor, insira um número válido.");
			}
		} while (getFeridos() + getFatal() > totalPessoasEnvolvidas);

		String[] mesesValidos = { "janeiro", "fevereiro", "março", "abril", "maio", "junho", "julho", "agosto",
				"setembro", "outubro", "novembro", "dezembro" };
		do {
			setMes(JOptionPane.showInputDialog(null, "Qual é o mês?"));
			if (!mesValido(getMes(), mesesValidos)) {
				JOptionPane.showMessageDialog(null, "Mês inválido. Por favor, insira um mês válido.");
			}
		} while (!mesValido(getMes(), mesesValidos));
		for (Rodovia r : rodovias) {
			if (r.getCod() == rodoviaAcidente) {
				this.rodovia = r;

				// Adiciona +1 para cada acidente registrado naquea via
				String grauLowerCase = rodovia.getGrau().toLowerCase();
				if ("alto".equals(grauLowerCase)) {
					alto++;
				} else if ("medio".equals(grauLowerCase)) {
					medio++;
				} else if ("baixo".equals(grauLowerCase)) {
					baixo++;
				}

				break;

			}
		}
	}

	// Construtor de rodovovia
	public Acidente(int fatal, int feridos, String mes, int qt) {
		this.fatal = fatal;
		this.feridos = feridos;
		this.mes = mes;
		this.qt = qt;
		this.rodovia = new Rodovia();
	}

	public Acidente() {
	}

	public void listaEmbriagado() {
	}

	// Verificar se o codigo da rodovia existem dentro do array
	private boolean codigoRodoviaValido(ArrayList<Rodovia> rodovias, int codigo) {
		for (Rodovia r : rodovias) {
			if (r.getCod() == codigo) {
				return true; // O código é válido
			}
		}
		return false; // O código não é válido
	}

	public String embragado() {
		for (Veiculos e : veiculos) {
			return e.estaEmbrigado();
		}
		return "n";
	}

	public String cargaEmbreagado() {
		for (VeiculosDeCarga e1 : veiculosDeCargas) {
			return e1.estaEmbrigado();
		}
		return "n";
	}

	public String bikeEmbreagado() {
		for (Bicicleta e2 : bicicleta) {
			return e2.estaEmbrigado();
		}
		return "n";
	}

	public String VeiculosDeCargaLista() {
		StringBuilder resultadoEhDeCarga = new StringBuilder();

		for (VeiculosDeCarga VC : veiculosDeCargas) {
			resultadoEhDeCarga.append(VC.toString()).append("\n");
		}

		return resultadoEhDeCarga.toString().trim(); // Trim para remover espaços em branco extras
	}

	public static String obterContagemPorGrau() {
		return "Acidentes com grau de periculosidade alto: " + alto + "\n" +
				"Acidentes com grau de periculosidade medio: " + medio + "\n" +
				"Acidentes com grau de periculosidade baixo: " + baixo;
	}

	public static Rodovia obterRodoviaComMaisBicicletas(ArrayList<Acidente> acidentes, ArrayList<Rodovia> rodovias) {
		int maxBicicletas = 0;
		Rodovia rodoviaMaisBicicletas = null;

		for (Rodovia rodovia : rodovias) {
			int bicicletasEnvolvidas = contarBicicletasEnvolvidas(rodovia.getCod(), acidentes);

			if (bicicletasEnvolvidas > maxBicicletas) {
				maxBicicletas = bicicletasEnvolvidas;
				rodoviaMaisBicicletas = rodovia;
			}
		}

		if (rodoviaMaisBicicletas == null) {
			JOptionPane.showMessageDialog(null, "Nenhuma rodovia encontrada com bicicletas envolvidas em acidentes.");
		}

		return rodoviaMaisBicicletas;
	}

	private static int contarBicicletasEnvolvidas(int codRodovia, ArrayList<Acidente> acidentes) {
		int count = 0;

		for (Acidente acidente : acidentes) {
			if (acidente.getRodovia().getCod() == codRodovia) {
				for (Bicicleta bicicleta : acidente.bicicleta) {
					count += bicicleta.getQtdPessoas();
				}
			}
		}

		return count;
	}

	public static Rodovia obterRodoviaComMaisAcidentesFatais(ArrayList<Acidente> acidentes,
			ArrayList<Rodovia> rodovias) {
		int maxAcidentesFatais = 0;
		Rodovia rodoviaMaisAcidentesFatais = null;

		for (Rodovia rodovia : rodovias) {
			int acidentesFatais = contarAcidentesFatais(rodovia.getCod(), acidentes);
			if (acidentesFatais > maxAcidentesFatais) {
				maxAcidentesFatais = acidentesFatais;
				rodoviaMaisAcidentesFatais = rodovia;
			}
		}

		return rodoviaMaisAcidentesFatais;
	}

	private static int contarAcidentesFatais(int codRodovia, ArrayList<Acidente> acidentes) {
		int count = 0;
		for (Acidente acidente : acidentes) {
			if (acidente.getRodovia().getCod() == codRodovia && acidente.getFatal() > 0) {
				count++;
			}
		}
		return count;
	}

	public int qtdCarrosNovos(ArrayList<Acidente> acidentes) {
		int acidentesComCarrosNovos = 0;

		for (Acidente acidente : acidentes) {
			boolean acidenteContado = false;

			for (Veiculos v : acidente.veiculos) {
				if (v.getAno() >= 2013) {
					if (!acidenteContado) {
						acidentesComCarrosNovos++;
						acidenteContado = true;
					}
					break;
				}
			}

			if (!acidenteContado) {
				for (VeiculosDeCarga v1 : acidente.veiculosDeCargas) {
					if (v1.getAno() >= 2013) {
						acidentesComCarrosNovos++;
						acidenteContado = true;
						break;
					}
				}
			}

			if (!acidenteContado) {
				for (Bicicleta v3 : acidente.bicicleta) {
					if (v3.getAno() >= 2013) {
						acidentesComCarrosNovos++;
						break;
					}
				}
			}
		}

		return acidentesComCarrosNovos;
	}

	public static String obterRodoviasComAcidentesNoCarnaval(ArrayList<Acidente> acidentes,
			ArrayList<Rodovia> rodovias) {
		Set<Integer> codigosRodoviasComAcidentes = new HashSet<>();

		for (Acidente acidente : acidentes) {
			if (acidente.getMes().equalsIgnoreCase("fevereiro")) {
				codigosRodoviasComAcidentes.add(acidente.getRodovia().getCod());
			}
		}

		if (codigosRodoviasComAcidentes.isEmpty()) {
			return "Nenhuma rodovia registrou acidentes no carnaval.";
		} else {
			StringBuilder resultado = new StringBuilder();
			for (int codRodovia : codigosRodoviasComAcidentes) {
				for (Rodovia rodovia : rodovias) {
					if (rodovia.getCod() == codRodovia) {
						resultado.append(codRodovia).append(" - ").append(rodovia.getSigla()).append("\n");
						break;
					}
				}
			}
			return resultado.toString();
		}
	}

	private boolean mesValido(String mes, String[] mesesValidos) {
		for (String mesValido : mesesValidos) {
			if (mes.equalsIgnoreCase(mesValido)) {
				return true;
			}
		}
		return false;
	}

	// Gets and Setters
	public int getFatal() {
		return fatal;
	}

	public void setFatal(int fatal) {
		this.fatal = fatal;
	}

	public int getFeridos() {
		return feridos;
	}

	public void setFeridos(int feridos) {
		this.feridos = feridos;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public int getQt() {
		return qt;
	}

	public void setQt(int qt) {
		this.qt = qt;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public int getMedio() {
		return medio;
	}

	public void setMedio(int medio) {
		this.medio = medio;
	}

	public int getBaixo() {
		return baixo;
	}

	public void setBaixo(int baixo) {
		this.baixo = baixo;
	}

	public String getContaAcidente() {
		return contaAcidente;
	}

	public Rodovia getRodovia() {
		return rodovia;
	}

	public void setRodovia(Rodovia rodovia) {
		this.rodovia = rodovia;
	}

	public void setContaAcidente(String contaAcidente) {
		this.contaAcidente = contaAcidente;
	}

	public String getSigla() {
		return null;
	}

}