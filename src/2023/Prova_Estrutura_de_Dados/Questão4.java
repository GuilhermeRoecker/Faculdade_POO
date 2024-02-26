package Prova_Estrutura_de_Dados;

import java.util.Stack;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Questão4 {
    public static void main(String[] args) {
        Stack<String> musicas = new Stack<String>();

    musicas.push("Livin' on a Prayer");
    musicas.push("Losing My Religion");
    musicas.push("Black in Black");
    musicas.push("Circles");
    musicas.push("Roxanne");
    musicas.push("Fly");
    musicas.push(JOptionPane.showInputDialog(null, "Insira o nome de uma musica"));
    musicas.push(JOptionPane.showInputDialog(null, "Insira o nome de uma musica"));

                String todos = "Musicas: \n \n";
                while (!musicas.isEmpty()) {
                    todos += musicas.pop() + "\n";
                }
                JOptionPane.showMessageDialog(null, todos);
    }
}
    
