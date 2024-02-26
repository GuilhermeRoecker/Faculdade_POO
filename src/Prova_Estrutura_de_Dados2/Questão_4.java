package Prova_Estrutura_de_Dados2;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Questão_4 {
    //4. Escreva um código Java que armazene código, nomeInserir e valor de salário (quantos que o usuário queira). Faça a ordenação pelo valor de salário utilizando a técnica Insertion Sort. 

    private static ArrayList<String> nomes = new ArrayList<String>();
    private static ArrayList<Integer> salarios = new ArrayList<Integer>();
    private static ArrayList<Integer> codigos = new ArrayList<Integer>();
    public static void main(String[] args) {
        int op;

        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha uma opção\n1 - cadastro \n2 - Visualizar lista"));

            switch (op) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                    listaSalarios();
                    break;
            }
        } while (op != 3);
    }

    public static void cadastrar() {
        String nome = JOptionPane.showInputDialog(null, "Insira um nome");
        String salarioStr = JOptionPane.showInputDialog("Insira um salário");
        String codigoStr = JOptionPane.showInputDialog("Insira um código");
        int salario = Integer.parseInt(salarioStr);
        int codigo = Integer.parseInt(codigoStr);
        nomes.add(nome);
        salarios.add(salario);
        codigos.add(codigo);
    }

    public static void listaSalarios() {
        ordenarPorSalario();
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < nomes.size(); i++) {
            resultado.append("Código: ").append(codigos.get(i)).append("\nNome: ").append(nomes.get(i)).append("\nSalário: ").append(salarios.get(i)).append("\n\n");
        }
        JOptionPane.showMessageDialog(null, resultado.toString());
    }

    public static void ordenarPorSalario() {
        for (int i = 1; i < salarios.size(); i++) {
            int salario = salarios.get(i);
            String nome = nomes.get(i);
            int codigo = codigos.get(i);
            int j = i - 1;

            while (j >= 0 && salarios.get(j) > salario) {
                salarios.set(j + 1, salarios.get(j));
                nomes.set(j + 1, nomes.get(j));
                codigos.set(j + 1, codigos.get(j));
                j = j - 1;
            }
            salarios.set(j + 1, salario);
            nomes.set(j + 1, nome);
            codigos.set(j + 1, codigo);
        }
    }
}