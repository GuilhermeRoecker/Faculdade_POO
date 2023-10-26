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
                    + "6 - Trocar proprietario apartamento \n"
                    + "7 - Trocar Proprietario apartamento \n"
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
            
            //Fazer consulta por mes e ano
            if (op == 4) {
                
                //Solicitar o mês e o ano para pesquisa
                String mesEscolhido;
                int anoEscolhido;
                
                mesEscolhido= JOptionPane.showInputDialog(null, "Qual o mes?");
                anoEscolhido= Integer.parseInt(JOptionPane.showInputDialog(null, "Qual o ano?"));
                String resultadoConsulta = "Despesas do mes de: " + mesEscolhido + "do Ano de: " + anoEscolhido + "\n";

                //contabilizar apartamentos
                int qtdApartamento= 0;
                for(Apartamento ap: apartamentos){
                    qtdApartamento++;
                }
                
                //Solicitar dados para fazer a consulta por mes e ano
                for (Despesa desp: despesas){
                    if(mesEscolhido.equals(desp.getMes()) && anoEscolhido == desp.getAno()){
                        JOptionPane.showMessageDialog(null, resultadoConsulta +
                        "Conta de: " + desp.getNomeDespesa() + "\n" +
                        "Valor por Apartamento: " + (desp.getValor() / qtdApartamento));
                    }
                }
            }
            
            //Fazer consulta por Apartamento, mes e ano
            if(op == 5){
                String mesEscolhido;
                int anoEscolhido;
                int numeroApEscolhido;
                
                numeroApEscolhido = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual o Apartamento?"));
                mesEscolhido= JOptionPane.showInputDialog(null, "Qual o mes?");
                anoEscolhido= Integer.parseInt(JOptionPane.showInputDialog(null, "Qual o ano?"));
                String resultadoConsulta = "Despesas do mes de: " + mesEscolhido + " do Ano de: " + anoEscolhido + "\n";
                

                //contabilizar apartamentos
                int qtdApartamento=0;
                for(Apartamento ap: apartamentos){
                    qtdApartamento++;
                }
                
                //Solicitar dados para fazer a consulta por Apartamento, mes e ano
                for (Despesa desp: despesas){
                    for(Apartamento ap: apartamentos){

                        int valorAluguel = ap.calculaValor();
                        int valorDespesas= desp.getValor();
                        int resultadoValor =valorDespesas  / qtdApartamento + valorAluguel ;

                    if(mesEscolhido.equals(desp.getMes()) && anoEscolhido == desp.getAno() && numeroApEscolhido == ap.getNumeroAp()){
                        JOptionPane.showMessageDialog(null, resultadoConsulta +
                        "Proprietario: " + ap.getNomeProprietario() + "\n" +
                        "Conta de: " + desp.getNomeDespesa() + "\n" +
                        "Valor por Apartamento: " + resultadoValor );
                        }
                    }
                }
            }

            if(op ==6){

                for(Apartamento ap : apartamentos){

                String novoProprietario = JOptionPane.showInputDialog(null, "Qual o nome do novo proprietario?");
                int numeroApEscolhido = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual o numero do apartamento?"));
                String blocoApEscolhido = JOptionPane.showInputDialog(null, "Qual o bloco do apartamento?");

                if(numeroApEscolhido == ap.getNumeroAp() && blocoApEscolhido.equals(ap.getBloco())){
                    ap.setNomeProprietario(novoProprietario);
                    }
                }
            }

            if (op == 7) {
                int posicaoEscolhida = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual a posição do apartamento?"));
            
                if (posicaoEscolhida >= 0 && posicaoEscolhida < apartamentos.size()) {
                    String novoProprietario = JOptionPane.showInputDialog(null, "Qual o nome do novo proprietário?");
                    Apartamento ap = apartamentos.get(posicaoEscolhida);
                    ap.setNomeProprietario(novoProprietario);
                } else {
                    JOptionPane.showMessageDialog(null, "Posição inválida. Digite uma posição dentro do intervalo.");
                }
            }
        
            if (apartamentos.size() == 2) {
            apartamentos.remove(0); 
        }
    
        //Encera o programa    
        }while (op !=10);

    }
}