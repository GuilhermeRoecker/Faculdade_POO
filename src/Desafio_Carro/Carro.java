package Desafio_Carro;
import javax.swing.JOptionPane;


public class Carro {
    String carro;
    String fabricante;
    String cor;
    String modelo;
    int ano;


    void Cadasto(){
        carro = JOptionPane.showInputDialog(null, "Qual o nome do carro?");
        fabricante = JOptionPane.showInputDialog(null, "Qual o nome a fabricante do carro?");
        cor = JOptionPane.showInputDialog(null, "Qual a cor do carro?");
        ano = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual o ano do carro?"));         
    }

String exibirCarros(){
    return carro + "\n Fabricante: " + fabricante + "\n Cor: " + cor + "\n Ano: " + ano + "\n\n";
    }  
}