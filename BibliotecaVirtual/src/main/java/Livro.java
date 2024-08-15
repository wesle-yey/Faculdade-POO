public class Livro {
    private String isbn;
    private String nome;
    private String autor;
    private boolean emprestado;

    public Livro(String isbn, String nome, String autor, boolean emprestado) {
        this.isbn = isbn;
        this.nome = nome;
        this.autor= autor;
        this.emprestado= emprestado;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }
}

