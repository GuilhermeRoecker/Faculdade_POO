package Prova_Estrutura_de_Dados;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Questão3 {
    public static void main(String[] args) {
        ArrayList<String> nomes = new ArrayList<String>();

        nomes.add(JOptionPane.showInputDialog( "Insira um nome:"));
        nomes.add(JOptionPane.showInputDialog( "Insira um nome:"));
        nomes.add(JOptionPane.showInputDialog( "Insira um nome:"));
        nomes.add(JOptionPane.showInputDialog( "Insira um nome:"));
        nomes.add(JOptionPane.showInputDialog( "Insira um nome:"));

        int novoNome=  Integer.parseInt(JOptionPane.showInputDialog(null,"Insira uma posição a ser alterada: \nExemplo: Posição 2"));

        if (novoNome >= 0 && novoNome < nomes.size()) {
                    String nm = JOptionPane.showInputDialog(null, "Qual o novo nome?");
                    nomes.set(novoNome, nm);
                } else {
                    JOptionPane.showMessageDialog(null, "Posição inválida. Digite uma posição dentro do intervalo.");
                }

        String todos = "Nomes \n\n";
        for(String nm: nomes ){
            todos += nm +"\n";
        } JOptionPane.showMessageDialog(null, todos);
    }
}
