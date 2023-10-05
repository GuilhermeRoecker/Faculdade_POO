package Desafio_Condominio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;


public class Condominio {
        public static void main(String[] args) {
        
		ArrayList<Apartamento> apartamentos = new ArrayList<Apartamento>();
		ArrayList<Despesa> despesas = new ArrayList<Despesa>();
		
		String menu = "1 - Cadastrar Apartamento \n"
				    + "2 - Exibir todos os Apartamentos cadastrados \n"
				    + "3 - Cadastrar Despesas \n"
				    + "4 - Ver despesas \n"
                    + "5 - Despesas por apartamento \n"
				    + "10 - Sair";
        	
        int op = 0;

        do{
            op = Integer.parseInt(JOptionPane.showInputDialog(null, menu));

            //Cadastrar Apartamentos
            if(op == 1){
                Apartamento ap = new Apartamento();
                ap.cadastraAp();
                apartamentos.add(ap);
            }
            
            //Listar todos os apartamentos
            if(op == 2){
                String todosAp = "Apartamentos cadastrados: \n \n";
                for (Apartamento ap: apartamentos){
                 todosAp += ap.exibirAp();
                } JOptionPane.showMessageDialog(null, todosAp);
            }

            // Cadastar Despesas
            if (op == 3){
                Despesa desp = new Despesa();
                desp.cadastraDespesa();
                despesas.add(desp);
            }
            // Solicitar o mês e o ano para pesquisa
            if (op == 4) {
                
               int QdtApartamento=0;
                for(Apartamento ap: apartamentos){
                    QdtApartamento++;
                }
                System.out.println(QdtApartamento);

            }   
        }while (op !=10);
    }
    
}
