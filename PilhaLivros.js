class Livro {
    constructor(titulo, numeroPaginas) {
        this.titulo = titulo
        this.numeroPaginas = numeroPaginas
    }

    toString() {
        return "Livro [titulo=" + this.titulo + ", numeroPaginas=" + this.numeroPaginas + "]";
    }
}

class PilhasDeLivros {
    constructor() {
        this.livros = []
    }

    adicionarLivro(titulo, numeroPaginas) {
        let livro = new Livro(titulo, numeroPaginas)

        this.livros.push(livro)
    }

    removerLivro() {
        this.livros.pop()
    }

    livroDoTopo() {
        return this.livros[this.livros.length - 1].toString()
    }

    listarLivros() {
        this.livros.forEach(livro => console.log(livro))
    }
}

let pilhasDeLivros = new PilhasDeLivros()

pilhasDeLivros.adicionarLivro("O Senhor dos Anéis", 1200)
pilhasDeLivros.adicionarLivro("1984", 326)
pilhasDeLivros.adicionarLivro("O Pequeno Príncipe", 96)
pilhasDeLivros.adicionarLivro("Duna", 896)

pilhasDeLivros.removerLivro()

console.log(pilhasDeLivros.livroDoTopo() + " Livro do topo")

pilhasDeLivros.listarLivros()