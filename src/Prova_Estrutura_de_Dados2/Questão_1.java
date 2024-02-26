package Prova_Estrutura_de_Dados2;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class Questão_1 {
    public static void main(String[] args) {

    //1. Escreva um código Java que contenha uma lista de 5 valores. Faça a ordenação pelo valor e código utilizando a técnica Bubble sort.        

    int[] lista = {345, 213, 568, 567, 359, 481};
  
        int n = lista.length;
        for (int i = 0; i < n-1; i++) {
          for (int j = 0; j < n-1-i; j++) {
            if (lista[j] > lista[j+1]) {
              int temp = lista[j];
              lista[j] = lista[j+1];
              lista[j+1] = temp;
              
            }
          }
        }
            JOptionPane.showMessageDialog(null, "Lista ordenada: " + Arrays.toString(lista));
    }
}
