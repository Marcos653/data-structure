class Produto:
    def __init__(self, id, nome, quantidade):
        self.id = id
        self.nome = nome
        self.quantidade = quantidade

    def __str__(self):
        return f"Produto [id={self.id}, nome={self.nome}, quantidade={self.quantidade}]"

class Node:
    def __init__(self, produto):
        self.produto = produto
        self.direita = None
        self.esquerda = None

    def __str__(self):
        return f"Node [produto={str(self.produto)}]"

class ArvoreProduto:
    def __init__(self):
        self.raiz = None

    def adicionar_produto(self, id, nome, quantidade):
        produto = Produto(id, nome, quantidade)

        if self.raiz is None:
            self.raiz = Node(produto)
        else:
            self._adicionar_produto_para_folhas(produto, self.raiz)

    def _adicionar_produto_para_folhas(self, produto, node):
        if produto.id < node.produto.id:
            if node.esquerda is None:
                node.esquerda = Node(produto)
            else:
                self._adicionar_produto_para_folhas(produto, node.esquerda)
        elif produto.id > node.produto.id:
            if node.direita is None:
                node.direita = Node(produto)
            else:
                self._adicionar_produto_para_folhas(produto, node.direita)
        else:
            node.produto = produto

    def buscar_produto(self, id):
        node_encontrado = self._buscar_produto_folhas(id, self.raiz)
        if node_encontrado is None:
            print(f"Produto com id {id} não encontrado.")
        else:
            print(f"Produto encontrado: {str(node_encontrado.produto)}")

    def _buscar_produto_folhas(self, id, node):
        if node is None:
            return None

        if id == node.produto.id:
            return node
        elif id < node.produto.id:
            return self._buscar_produto_folhas(id, node.esquerda)
        else:
            return self._buscar_produto_folhas(id, node.direita)


arvore = ArvoreProduto()

arvore.adicionar_produto(1, "Camiseta", 10)
arvore.adicionar_produto(2, "Vestido", 20)
arvore.adicionar_produto(3, "Tenis", 5)

arvore.buscar_produto(1)
