package Desafio_Condominio;

import javax.swing.JOptionPane;

public class Apartamento {
        
    private String nomeProprietario;
    private String bloco;
    private int numeroAp;
    private int mtQuad;

    public void cadastraAp() {
        setNomeProprietario(JOptionPane.showInputDialog(null, "Qual o nome do proprietário?"));
        setBloco(JOptionPane.showInputDialog(null, "Qual o Bloco do Apartamento?"));
        setNumeroAp(Integer.parseInt(JOptionPane.showInputDialog(null, "Qual é o número do Apartamento?")));
        setMtQuad(Integer.parseInt(JOptionPane.showInputDialog(null, "Qual o tamanho do Apartamento em metros²?")));
    }

    public String getNomeProprietario() {
        return nomeProprietario;
    }

    public void setNomeProprietario(String nomeProprietario) {
        this.nomeProprietario = nomeProprietario;
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    public int getNumeroAp() {
        return numeroAp;
    }

    public void setNumeroAp(int numeroAp) {
        this.numeroAp = numeroAp;
    }

    public int getMtQuad() {
        return mtQuad;
    }

    public void setMtQuad(int mtQuad) {
        this.mtQuad = mtQuad;
    }

    public int calculaValor() {
        return getMtQuad() * 5;
    }

    public String exibirAp() {
        return "Nome do proprietário: " + getNomeProprietario() + "\n" +
               "Número do Apartamento: " + getNumeroAp() + "\n" +
               "Bloco: " + getBloco() + "\n" +
               "Tamanho: " + getMtQuad() + "m² \n" +
               "Valor do Aluguel: " + calculaValor() + "\n\n";
    }
}
