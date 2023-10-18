package Banco;

import javax.swing.JOptionPane;

public class Conta {
    private int nunConta;
    private int agencia;
    private String nomeCorrentista;
    private int saldoConta;

    public void cadastrarConta(){
        setNunConta(Integer.parseInt(JOptionPane.showInputDialog(null, "Qual o numero da conta?")));
        setAgencia(Integer.parseInt(JOptionPane.showInputDialog(null, "Qual o numero a agendcia?")));
        setNomeCorrentista(JOptionPane.showInputDialog(null, "Qual o nome do Correntista?"));
        setSaldoConta(Integer.parseInt(JOptionPane.showInputDialog(null, "Qual o saldo inicial da conta?")));
    }

    public void  depositarConta(){
        int depositoConta;

        depositoConta = Integer.parseInt(JOptionPane.showInputDialog("Qual o valor a ser depositado?"));
        setSaldoConta(getSaldoConta() + depositoConta);
    }

    public void sacarConta(){
        int saqueConta;

        saqueConta= Integer.parseInt(JOptionPane.showInputDialog(null, "Qual o valor que sera sacado?"));
        setSaldoConta(getSaldoConta() - saqueConta);
    }

    public int getNunConta() {
        return this.nunConta;
    }

    public void setNunConta(int nunConta) {
        this.nunConta = nunConta;
    }

    public int getAgencia() {
        return this.agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public String getNomeCorrentista() {
        return this.nomeCorrentista;
    }

    public void setNomeCorrentista(String nomeCorrentista) {
        this.nomeCorrentista = nomeCorrentista;
    }

    public int getSaldoConta() {
        return this.saldoConta;
    }

    public void setSaldoConta(int saldoConta) {
        this.saldoConta = saldoConta;
    }


}
