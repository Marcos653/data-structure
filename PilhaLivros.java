import java.util.Stack;

class Livro {
    String titulo;
    Integer numeroPaginas;

    public Livro(String titulo, Integer numeroPaginas) {
        this.titulo = titulo;
        this.numeroPaginas = numeroPaginas; 
    }

    @Override
    public String toString() {
        return "Livro [titulo=" + titulo + ", numeroPaginas=" + numeroPaginas + "]";
    }
}

class PilhasDeLivros {
    Stack<Livro> livros = new Stack<>();

    public void adicionarLivro(String titulo, Integer numeroPaginas) {
        Livro livro = new Livro(titulo, numeroPaginas);

        livros.push(livro);
    }

    public void removerLivro() {
        livros.pop();
    }

    public String livroDoTopo() {
        return livros.peek().toString();
    }

    public void listarLivros() {
        livros.stream().forEach(System.out::println);
    }
}

public class PilhaLivros {
    public static void main(String[] args) {
        PilhasDeLivros pilhasDeLivros = new PilhasDeLivros();

        pilhasDeLivros.adicionarLivro("O Senhor dos Anéis", 1200);
        pilhasDeLivros.adicionarLivro("1984", 326);
        pilhasDeLivros.adicionarLivro("O Pequeno Príncipe", 96);
        pilhasDeLivros.adicionarLivro("Duna", 896);
        pilhasDeLivros.removerLivro();

        System.out.println(pilhasDeLivros.livroDoTopo() + " Livro do topo");

        pilhasDeLivros.listarLivros(); 
    }
}