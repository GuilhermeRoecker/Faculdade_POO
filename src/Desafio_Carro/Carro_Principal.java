package Desafio_Carro;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Carro_Principal {
    public static void main(String[] args) {
        ArrayList<Carro> carros = new ArrayList<Carro>();
        String menu = "1 - Cadastrar \n" 
        + "2 - Listar Todos os carros \n"
        + "3 - Lista por cor \n"
        + "4 - Lista por Marca \n" 
        + "5 - Lista por Ano \n"
        + "6 - Sair";

        int op = 0;
        do{
            op = Integer.parseInt(JOptionPane.showInputDialog(null, menu ));

            // Cadastro de carro
            if (op == 1){
                Carro c = new Carro();
                c.Cadasto();
                carros.add(c);
            }

            // Listagem de carros cadastrados
            if (op == 2 ){
                String todos = "Carros cadastrados \n \n";
                for (Carro c: carros){
                    todos += c.exibirCarros();
                }
                JOptionPane.showMessageDialog(null,todos);
            }

            // Pesquisa por cor
            if (op == 3){
              String selecionarCor = JOptionPane.showInputDialog(null, "Qual a cor?");
              String corSelecionada = " ";

              for (Carro c: carros){

                if(selecionarCor.equals(c.cor)){
                corSelecionada += c.exibirCarros();
                JOptionPane.showMessageDialog(null, corSelecionada);
                    }
                }
            }

            // Pesquisa por Marca
            if (op == 4){
             
                String selecionaMarca = JOptionPane.showInputDialog(null, "Qual a marca?");
                String MarcaSelecionada = " ";
                for (Carro c1: carros){

                    if(selecionaMarca.equals(c1.fabricante)){
                    MarcaSelecionada += c1.exibirCarros();
                    JOptionPane.showMessageDialog(null, MarcaSelecionada);
                }
              }
            }
            
            // Pesquisa por periodo de ano
            if(op == 5){
                int anoIni = Integer.parseInt(JOptionPane.showInputDialog(null , "Qual o ano Inicial?"));
                int anoFin = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual o ano final?"));
                int anoCarro = 0;
                for(Carro c2: carros){
                    if (anoCarro >= anoIni && anoCarro <= anoFin){
                        
                        JOptionPane.showMessageDialog(null, anoCarro);
                    }
 
                }
            }            
        }while (op != 6);

    }
}


