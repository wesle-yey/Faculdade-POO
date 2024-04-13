package Livro;

public class Autor {
    String nome;
    String email;
    String cpf;

    void mostrarDetalhes() {
        String mensagem= "Mostrando detalhes do Autor";
        System.out.println(mensagem);
        System.out.println(nome);
        System.out.println(email);
        System.out.println(cpf);
    }
}
