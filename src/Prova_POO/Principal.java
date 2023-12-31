package Prova_POO;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Principal {
	public static void main(String[] args) {

		ArrayList<Acidente> acidentes = new ArrayList<Acidente>();
		ArrayList<Rodovia> rodovias = new ArrayList<Rodovia>();

		String menu = "1 - Cadastrar rodovias \n" +
				"2 - Cadastrar acidentes \n" +
				"3 - Listar Acidentes com condutores embreagados \n" +
				"4 - Listar a quantidade de acidentes por periculosidade \n" +
				"5 - Veiculos de cargas envolvidos em acidentes \n" +
				"6 - Rodovia com mais bicicletas envolvias em acidentes \n" +
				"7 - Rodovia com mais acidentes fatais \n" +
				"8 - Quantidade de Veiculos novos em acidentes \n" +
				"9 - Acientes em rodovias durante o carnaval \n" +
				"10 - Sair do aplicativo";

		int op = 0;
		do {
			String input = JOptionPane.showInputDialog(null, menu);

			if (input == null || input.trim().isEmpty()) {
				continue;
			}
			try {
				op = Integer.parseInt(input);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Por favor, insira um número válido.");
				continue;
			}

			switch (op) {

				case 1:
					Rodovia r = new Rodovia();
					r.CadastraRodovia();
					rodovias.add(r);
					break;

				case 2:
					Acidente a = new Acidente();
					a.CadastrarAcidente(rodovias);
					acidentes.add(a);
					break;

				case 3:
					String Resultado = "";
					int numAcidente = 1;

					for (Acidente a1 : acidentes) {
						if (a1.embragado().equalsIgnoreCase("S") || a1.cargaEmbreagado().equalsIgnoreCase("S")
								|| a1.bikeEmbreagado().equalsIgnoreCase("s")) {
							Resultado += "No " + numAcidente + "º Acididente condutor estava embreagado \n";
						}
						numAcidente++;
					}
					if (Resultado.isEmpty()) {
						Resultado = "Não houveram acidentes cadastrados com condutores embreagados.";
					}
					JOptionPane.showMessageDialog(null, Resultado);
					break;

				case 4:
					JOptionPane.showMessageDialog(null, Acidente.obterContagemPorGrau());
					break;

				case 5:
					String resultadoEhDeCarga = "";

					for (Acidente a3 : acidentes) {
						String veiculosDeCargaLista = a3.VeiculosDeCargaLista();
						if (!veiculosDeCargaLista.isEmpty()) {
							resultadoEhDeCarga += veiculosDeCargaLista + "\n";
						}
					}
					if (resultadoEhDeCarga.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Não há veículos de carga envolvidos em acidentes.");
					} else {
						JOptionPane.showMessageDialog(null, resultadoEhDeCarga.trim() + "\n\n");
					}
					break;

				case 6:
					Rodovia rodoviaComMaisBicicletas = Acidente.obterRodoviaComMaisBicicletas(acidentes, rodovias);
					if (rodoviaComMaisBicicletas != null) {
						JOptionPane.showMessageDialog(null, "Rodovia com mais bicicletas envolvidas em acidentes: " +
								rodoviaComMaisBicicletas.getCod() + " - " + rodoviaComMaisBicicletas.getSigla());
					} else {
						JOptionPane.showMessageDialog(null,
								"Nenhuma rodovia encontrada com bicicletas envolvidas em acidentes.");
					}
					break;

				case 7:
					Rodovia rodoviaMaisAcidentesFatais = Acidente.obterRodoviaComMaisAcidentesFatais(acidentes,
							rodovias);

					if (rodoviaMaisAcidentesFatais != null) {
						JOptionPane.showMessageDialog(null, "Rodovia com mais acidentes fatais: " +
								rodoviaMaisAcidentesFatais.getCod() + " - " + rodoviaMaisAcidentesFatais.getSigla());
					} else {
						JOptionPane.showMessageDialog(null, "Nenhuma rodovia encontrada com acidentes fatais.");
					}

					break;

				case 8:
					int totalDeCarros = 0;
					for (Acidente a8 : acidentes) {
						totalDeCarros = a8.qtdCarrosNovos(acidentes);
					}
					JOptionPane.showMessageDialog(null,
							"Total acidentes envolvendo veiculos novos é de: " + totalDeCarros);
					break;

				case 9:
					String rodoviasCarnaval = "";
					for (Acidente a9 : acidentes) {
						rodoviasCarnaval = a9.obterRodoviasComAcidentesNoCarnaval(acidentes, rodovias);
					}
					JOptionPane.showMessageDialog(null,
							"Rodovias que registraram acidentes no carnaval (fevereiro):\n" + rodoviasCarnaval);
					break;

			}

		} while (op != 10);

	}
}
