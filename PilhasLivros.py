class Livro:
    def __init__(self, titulo, numeroPaginas) -> None:
        self.titulo = titulo
        self.numeroPaginas = numeroPaginas

    def __str__(self):
        return f"Livro [titulo={self.titulo}, numeroPaginas={self.numeroPaginas}]" 
    
class PilhasDeLivros:
    def __init__(self) -> None:
        self.livros = []

    def adicionarLivro(self, titulo, numeroPaginas):
        livro = Livro(titulo, numeroPaginas)

        self.livros.append(livro)

    def removerLivro(self):
        self.livros.pop()

    def livroDoTopo(self):
        return self.livros[len(self.livros) - 1]
    
    def listarLivros(self):
        for livro in self.livros:
            print(livro)

pilhasDeLivros = PilhasDeLivros()

pilhasDeLivros.adicionarLivro("O Senhor dos Anéis", 1200)
pilhasDeLivros.adicionarLivro("1984", 326)
pilhasDeLivros.adicionarLivro("O Pequeno Príncipe", 96)
pilhasDeLivros.adicionarLivro("Duna", 896)

pilhasDeLivros.removerLivro()

print(pilhasDeLivros.livroDoTopo(), " Livro do topo")

pilhasDeLivros.listarLivros()