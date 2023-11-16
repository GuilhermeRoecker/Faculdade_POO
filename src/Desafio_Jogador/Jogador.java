package Desafio_Jogador;

import java.security.ProtectionDomain;

import javax.swing.JOptionPane;

public class Jogador {
    protected String nomeJogador;
    protected int numeroCamisa;
    protected int gols;

    void CadastrarJogador(){
        setNomeJogador(JOptionPane.showInputDialog("Qual o nome do jogador?"));
        setNumeroCamisa(Integer.parseInt(JOptionPane.showInputDialog("Qual o numero da camisa?")));
        setGols(Integer.parseInt(JOptionPane.showInputDialog("Quantos gols foram feitos?")));
    }

    public String getNomeJogador() {
        return this.nomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    public int getNumeroCamisa() {
        return this.numeroCamisa;
    }

    public void setNumeroCamisa(int numeroCamisa) {
        this.numeroCamisa = numeroCamisa;
    }

    public int getGols() {
        return this.gols;
    }

    public void setGols(int gols) {
        this.gols = gols;
    }
}
