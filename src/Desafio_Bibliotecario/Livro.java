package Desafio_Bibliotecario;

import javax.swing.JOptionPane;

public class Livro {
    private String livro;

    void cadastraLivro(){
        setLivro (JOptionPane.showInputDialog(null, "Qual o titulo do livro"));
        String autor = JOptionPane.showInputDialog(null, "Qual o Autor");
        if(autor = )

    }

    public String getLivro() {
        return this.livro;
    }

    public void setLivro(String livro) {
        this.livro = livro;
    }

}




/*
 A classe "Livro" deve ter os seguintes atributos: título do livro (String), autor do
livro (instância da classe "Autor"), bibliotecário responsável pelo livro (instância
da classe "Bibliotecário").
 */