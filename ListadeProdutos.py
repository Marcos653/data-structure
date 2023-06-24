class Produto:
    def __init__(self, nome, codigo, quantidade):
        self.nome = nome
        self.codigo = codigo
        self.quantidade = quantidade
        self.produtoAnterior = None
        self.proximoProduto = None

    def __str__(self):
        return f"Produto [nome={self.nome}, codigo={self.codigo}, quantidade={self.quantidade}]"


class ProdutosLista:
    def __init__(self):
        self.head = None
        self.tail = None

    def adicionarProduto(self, nome, codigo, quantidade):
        produto = Produto(nome, codigo, quantidade)

        if self.head is None:
            self.head = produto
            self.tail = produto
        else:
            self.tail.proximoProduto = produto
            produto.produtoAnterior = self.tail
            self.tail = produto

    def listarProdutos(self):
        if self.head is None:
            print("Não há produtos")
        else:
            produtoAtual = self.head

            while produtoAtual is not None:
                if produtoAtual.proximoProduto is None:
                    print(f"tail: {produtoAtual} produto anterior: {produtoAtual.produtoAnterior}")
                    break
                elif produtoAtual.produtoAnterior is None:
                    print(f"head: {produtoAtual} proximo produto: {produtoAtual.proximoProduto}")
                else:
                    print(f"produto anterior: {produtoAtual.produtoAnterior} produto atual: {produtoAtual} proximo produto: {produtoAtual.proximoProduto}")

                produtoAtual = produtoAtual.proximoProduto

    def removerProduto(self, codigo):
        if self.head is None:
            print("Não há produtos")
            return

        if self.head.codigo == codigo:
            self.head = self.head.proximoProduto

            if self.head is not None:
                self.head.produtoAnterior = None
            else:
                self.tail = None
            return

        produtoAtual = self.head

        while produtoAtual is not None and produtoAtual.proximoProduto is not None:
            if produtoAtual.proximoProduto.codigo == codigo:
                produtoASerRemovido = produtoAtual.proximoProduto
                produtoAtual.proximoProduto = produtoASerRemovido.proximoProduto

                if produtoAtual.proximoProduto is not None:
                    produtoAtual.proximoProduto.produtoAnterior = produtoAtual
                else:
                    self.tail = produtoAtual
                return
            produtoAtual = produtoAtual.proximoProduto

        print("Produto não encontrado.")

    def atualizarProduto(self, codigo, quantidade):
        if self.head is None:
            print("Não há produtos")
        else:
            produtoAtual = self.head

            while produtoAtual is not None:
                if produtoAtual.codigo == codigo:
                    produtoAtual.quantidade = quantidade
                    print(produtoAtual)

                produtoAtual = produtoAtual.proximoProduto

    def buscarProduto(self, codigo):
        if self.head is None:
            print("Não há produtos")
        else:
            produtoAtual = self.head

            while produtoAtual is not None:
                if produtoAtual.codigo == codigo:
                    print(produtoAtual)

                produtoAtual = produtoAtual.proximoProduto


produtosLista = ProdutosLista()
produtosLista.adicionarProduto("maçã", "2", 15)
produtosLista.adicionarProduto("uva", "3", 30)
produtosLista.adicionarProduto("pera", "4", 18)
produtosLista.adicionarProduto("abacaxi", "5", 25)
produtosLista.adicionarProduto("manga", "6", 10)
produtosLista.adicionarProduto("laranja", "7", 8)

produtosLista.atualizarProduto("7", 80)
produtosLista.removerProduto("2")
produtosLista.listarProdutos()
produtosLista.buscarProduto("3")
