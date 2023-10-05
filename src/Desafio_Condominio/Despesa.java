package Desafio_Condominio;

import javax.swing.JOptionPane;

public class Despesa {
    
    private String nomeDespesa;
    private String mes;
    private int ano;
    private double valor;
    
    public void cadastraDespesa(){
        setNomeDespesa(JOptionPane.showInputDialog(null, "Qual é a despesa?"));
        setMes(JOptionPane.showInputDialog(null, "Qual o mês?"));
        setAno(Integer.parseInt(JOptionPane.showInputDialog(null, "Qual o ano?")));
        setValor(Integer.parseInt(JOptionPane.showInputDialog(null, "Qual o valor?")));
    }
    
    
    
    public String getNomeDespesa() {
        return nomeDespesa;
    }

    public void setNomeDespesa(String nomeDespesa) {
        this.nomeDespesa = nomeDespesa;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
