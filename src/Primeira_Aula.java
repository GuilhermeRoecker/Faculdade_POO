import javax.swing.*;
public class Primeira_Aula { 
    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantidade de pessoas?"));
        String nomes[] = new String[n];
        double pesos [] = new double[n];
        double alturas [] = new double[n];
        char sexos[] =new char[n];

        for(int i =0 ; i < n ; i++){
            nomes[i] = JOptionPane.showInputDialog(null, "Digite o nome da " + (i+1) + " pessoa");
            pesos[i] = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o peso de " + nomes[i]));
            alturas[i] = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite a altura de " + nomes[i]));
			sexos[i] = JOptionPane.showInputDialog("Digite o sexo de " + nomes[i]).toUpperCase().charAt(0);
		}

		String resultado = "";

		for (int i = 0; i < n; i++) {
			double imc = pesos[i] / (alturas[i] * alturas[i]);
			String avaliacao = "";
			if (sexos[i] == 'M') {
				if (imc < 20.7) {
					avaliacao = "Abaixo do peso";
				} else if (imc >= 20.7 && imc < 26.4) {
					avaliacao = "Peso ideal";
				} else if (imc >= 26.5 && imc < 27.8) {
					avaliacao = "Pouco acima do peso";
				} else if (imc >= 27.9 && imc < 31.1) {
					avaliacao = "Acima do peso";
				} else {
					avaliacao = "Obesidade";
				}
			} else if (sexos[i] == 'F') {
				if (imc < 19.1) {
					avaliacao = "Abaixo do peso";
				} else if (imc >= 19.1 && imc < 25.8) {
					avaliacao = "Peso ideal";
				} else if (imc >= 25.9 && imc < 27.3) {
					avaliacao = "Pouco acima do peso";
				} else if (imc >= 27.4 && imc < 32.3) {
					avaliacao = "Acima do peso";
				} else {
					avaliacao = "Obesidade";
				}
			}

			resultado += "Nome" + nomes[i] + "-IMC:" + imc + "-Avaliação:" + avaliacao+"\n";
		}
		JOptionPane.showMessageDialog(null, resultado);
	}
}

