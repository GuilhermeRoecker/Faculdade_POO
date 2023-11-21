package Desafio_Jogador;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Time {
    ArrayList<Jogador> jogadores = new ArrayList<Jogador>();

    protected String nomeTime;
    protected String continua =  "Deseja adocionar novos Jogadores? S/N";

    void CadastraTime(){
        setNomeTime(JOptionPane.showInputDialog("Qual o nome do time?"));
        do{
            Jogador j = new Jogador();
            j.CadastrarJogador();
            jogadores.add(j);
            JOptionPane.showInputDialog(continua);

        }while(!continua.equalsIgnoreCase("N"));
    }

  //  public Jogador exibirJogador(){
    //    return getNomeJogador() + "\n";
    //}

    public String getNomeTime() {
        return this.nomeTime;
    }

    public void setNomeTime(String nomeTime) {
        this.nomeTime = nomeTime;
    }

}