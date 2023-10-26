package Prova_Estrutura_de_Dados;

import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JOptionPane;
public class Pilha {  
public static void main(String[] args) {
    Stack<String> musicas = new Stack<String>();

    musicas.add(0, "Livin' on a Prayer");
    musicas.add(1, "Losing My Religion");
    musicas.add(2, "Black in Black");
    musicas.add(3, "Circles");
    musicas.add(4, "Roxanne");
    musicas.add(5, "Fly");
    musicas.add(6, JOptionPane.showInputDialog(null, "Insira o nome de uma musica"));
    musicas.add(7, JOptionPane.showInputDialog(null, "Insira o nome de uma musica"));

                String todos = "Musicas: \n \n";
                for (String a : musicas) {
                    todos += a + "\n";
                }
                JOptionPane.showMessageDialog(null, todos);

    }
}

