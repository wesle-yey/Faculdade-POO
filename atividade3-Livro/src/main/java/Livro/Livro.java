package Livro;


public class Livro {

    String nome;
    String descricao;
    double valor;
    String isbm;
    Autor autor;

    void mostrarDetalhes() {
        String mensagem= "Mostrando detalhes do livro";
        System.out.println(mensagem);
        System.out.println(nome);
        System.out.println(descricao);
        System.out.println(valor);
        System.out.println(isbm);
        if (this.temAutor()) {
            autor.mostrarDetalhes();
        }
        System.out.println("--");
    }

    public void aplicaDescontoDe (double porcentagem) {
        this.valor -= this.valor * porcentagem;
    }

    boolean temAutor() {
        return this.autor != null;
    }
}
