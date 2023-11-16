package Desafio_Jogador;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Principal_Time {
    public static void main(String[] args) {

        ArrayList<Time> times = new ArrayList<Time>();

        String menu = "1 - Cadastrar novo Time e Jogadores \n"
                    + "2 - Listar Jogador por time \n"
                    + "3 - Artilheiro do Campeonato \n"
                    + "4 - Verificar time com mais Gols \n"
                    + "5 - Encerrar Programa";

        int op = 0;

        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(null, menu));

            if(op ==1){
                Time t = new Time();
                t.CadastraTime();
                times.add(t);
            }

            if(op ==2){
                String escolheTime = JOptionPane.showInputDialog("Qual o time?");
                String todosJogadors= "Jogadors \n\n";
                for(Time t: times){
                        if(escolheTime.equalsIgnoreCase(escolheTime)){
                            todosJogadors += t.exibirJogador();
                        }
                }                
            }
        } while (op != 5);
    }
}
