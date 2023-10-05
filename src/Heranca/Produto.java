package Heranca;

public class Produto {
    protected String nome;
    protected int preco;

    public boolean ehCaro(){
        return preco > 5000;
    }
}
