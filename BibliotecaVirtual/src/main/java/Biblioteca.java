import java.util.ArrayList;
import java.util.List;


public class Biblioteca {
    private final List<Livro> livros= new ArrayList<>();
    private final List<Livro> livrosEmprestados= new ArrayList<>();

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void removerLivro(Livro livro) {
        livros.remove(livro);
    }

    /*public List<Livro> buscarLivrosPorTitulo(String titulo) {
        // Implementar lógica de busca
    }

    public List<Livro> buscarLivrosPorAutor(String autor) {
        // Implementar lógica de busca
    }

     */

    public void marcarComoEmprestado(Livro livro) {
        livro.setEmprestado(true);
        livrosEmprestados.add(livro);
    }

    public void marcarComoDevolvido(Livro livro) {
        try {
            if (livro.isEmprestado()) {
                livrosEmprestados.remove(livro);
                livro.setEmprestado(false);
            }
        } catch (RuntimeException Exception) {

        }
    }


    public List<Livro> listarLivros() {
        return livros;
    }

}

