package Prova_Estrutura_de_Dados;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Questao2 {
    public static void main(String[] args) {
        ArrayList<String> nomes = new ArrayList<String>();

        nomes.add(JOptionPane.showInputDialog( "Insira um nome:"));
        nomes.add(JOptionPane.showInputDialog( "Insira um nome:"));
        nomes.add(JOptionPane.showInputDialog( "Insira um nome:"));
        nomes.add(JOptionPane.showInputDialog( "Insira um nome:"));
        nomes.add(JOptionPane.showInputDialog( "Insira um nome:"));
        nomes.add(JOptionPane.showInputDialog( "Insira um nome:"));
        nomes.add(JOptionPane.showInputDialog( "Insira um nome:"));

        String todos = "Nomes \n\n";
        for(String nm: nomes ){
            todos += nm +"\n";
        } JOptionPane.showMessageDialog(null, todos);
    }
}
