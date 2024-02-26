package Prova_Estrutura_de_Dados2;

import javax.swing.JOptionPane;

public class Questão_3 {
    // 3. Escreva o algoritmo de ordenação Insertion Sort para ordenar 10 datas

    public static void main(String[] args) {
        String[] datas = new String[10];

        for (int i = 0; i < 10; i++) {
            datas[i] = JOptionPane.showInputDialog("Insira a " + (i + 1) + "ª data no formato (DD/MM/AAAA)");
        }

        datasOrdenadas(datas);

        StringBuilder Resultado = new StringBuilder();
        for (String data : datas) {
            Resultado.append(data).append("\n");
        }

        JOptionPane.showMessageDialog(null, "Datas ordenadas:\n" + Resultado.toString());
    }

    public static void datasOrdenadas(String[] array) {
        for (int i = 1; i < array.length; i++) {
            String data = array[i];
            int j = i - 1;

            while (j >= 0 && array[j].compareTo(data) > 0) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = data;
        }

    }
}
