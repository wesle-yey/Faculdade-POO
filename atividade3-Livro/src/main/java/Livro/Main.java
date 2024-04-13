package Livro;

public class Main {

    public static void main(String[] args) {

        Autor autor= new Autor();
        autor.nome= "Rodrigo Turini";
        autor.email= "rodrigo.turini@caelum.com.br";
        autor.cpf = "123.456.789.10";


        Livro livro = new Livro();
        livro.nome= "Java 8 Prático";
        livro.descricao = "Novos recursos da linguagem";
        livro.valor= 59.90;
        livro.isbm= "978-85-66250-46-6";
        livro.autor= autor;

        livro.mostrarDetalhes();

        Autor outroAutor= new Autor();
        outroAutor.nome= "Paulo Silveira";
        outroAutor.email= "paulo.silveira@caelum.com.br";
        outroAutor.cpf = "123.456.789.10";

        Livro outroLivro = new Livro();
        outroLivro.nome= "Lógica de programação";
        outroLivro.descricao = "Crie seus primeiros programas";
        outroLivro.valor= 59.90;
        outroLivro.isbm= "978-85-66250-22-0";
        outroLivro.autor= outroAutor;

        outroLivro.mostrarDetalhes();


    }

}
