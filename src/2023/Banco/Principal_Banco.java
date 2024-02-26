package Banco;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import javafx.beans.property.IntegerProperty;

public class Principal_Banco {
    public static void main(String[] args) {
        ArrayList<Conta> contas = new ArrayList<Conta>();

            String menu = "Selecione o tipo de conta \n"
                        + "1 - Conta Corrente \n"
                        + "2 - Conta Especial \n"
                        + "3 - Conta Universitario \n"
                        + "4 - Sair";
        int op = 0;
        do{
            op = Integer.parseInt(JOptionPane.showInputDialog(menu));

            if(op ==1 ){
                int opContaCorrente =0;

                String menuContaCorrente = "Selecione a ação a ser realizada: \n"
                         + "1 - Cadastrar nova conta \n"
                         + "2 - Depositar em conta \n"
                         + "3 - Sacar dinheiro em conta \n"
                         + "4 - Realizar transferencia \n";

                do{
                    opContaCorrente = Integer.parseInt(JOptionPane.showInputDialog(menuContaCorrente));

                    //Criação de Novas Contas
                    if(opContaCorrente ==1){
                        Conta cC = new Conta();
                            cC.cadastrarConta();
                            contas.add(cC);
                        }
                    
                    //Deposito em conta
                    if(op ==2){
                        int numeroContaC = Integer.parseInt(JOptionPane.showInputDialog("Qual o numero da conta?"));
                        int agenciaContaC = Integer.parseInt(JOptionPane.showInputDialog("Qual a sua Agencia?"));
                        for(Conta cC: contas){
                        if(numeroContaC == cC.getNunConta() && agenciaContaC == cC.getAgencia()){
                                 cC.depositarConta();
                            }
                        }

                    }

                    }while (opContaCorrente != 5);
                }

            }while (op != 4);
        }
    }
