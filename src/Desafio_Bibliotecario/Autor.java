package Desafio_Bibliotecario;

import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Autor {
     private String nomeAutor;


    void cadastrarAutor(){
        setNomeAutor ( JOptionPane.showInputDialog(null,"Qual nome do Autor?" ));
    }

    public String getNomeAutor() {
        return this.nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

     void listaAutores() {
    ArrayList<Autor> autores = new ArrayList<Autor>();
    String menu = "1 - Cadastrar Autor \n"
               +  "2 - Escolher autor já cadastrado";

    int op = 0;
    do{op = Integer.parseInt(JOptionPane.showInputDialog(null, menu));
    
    if(op == 1){
    Autor a = new Autor();
    a.cadastrarAutor();
    autores.add(a);
    }

    if(op ==2){
        String todos = "Autores cadastrados \n \n";
        for (Autor a : autores) {
            todos += a.exibirAutor();
        }
        JOptionPane.showMessageDialog(null, todos);

    }
     
    }while(op ==3);
}

String exibirAutor(){
    return getNomeAutor();
    }  
}




/*
A classe "Autor" deve ter os seguintes atributos: nome do autor (String), lista de
livros escritos pelo autor (agregação de instâncias da classe "Livro").
 */