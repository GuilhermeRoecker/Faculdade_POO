package Prova_Estrutura_de_Dados2;

import javax.swing.JOptionPane;

public class Questão_2 {
    // 2.Escreva o algoritmo de ordenação Selection Sort para ordenar 8 números.
    public static void main(String[] args) {
        String Resultado = "";
        int [] vetor = new int[8];
        for(int i=0; i < vetor.length; i ++){
            vetor[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o " + (i + 1 )+ "º valor"));
        }

        //Selection Sort
        int posicao_menor, aux;
        for(int i=0; i < vetor.length; i++){
        posicao_menor = i;
        for(int j = i+1; j < vetor.length; j ++){
            if(vetor[j]  < vetor[posicao_menor]){
                posicao_menor = j;
            }
        }
        aux = vetor [posicao_menor];
        vetor[posicao_menor] = vetor[i];
        vetor[i] = aux;
        }
        
        
        for(int i=0; i < vetor.length; i ++){
           Resultado  += vetor[i] + "\n";
        }
        JOptionPane.showMessageDialog(null, "Lista Ordenada: \n" + Resultado);
    }

}
