import java.util.Arrays;

public class teste {
    public static void main(String[] args) {
    int[] lista = {5, 3, 0, 4, 2, 1};
    System.out.println(Arrays.toString(lista));
    
    for (int i = 1; i < lista.length; i++) {
      int temp = lista[i];
      int j = i - 1;
      while (j >= 0 && temp < lista[j]) {
        lista[j + 1] = lista[j];
        j = j - 1;
      }
      lista[j + 1] = temp;
        }System.out.println(Arrays.toString(lista));
    }
}
