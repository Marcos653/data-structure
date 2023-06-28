class Produto {
    constructor(id, nome, quantidade) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
    }

    toString() {
        return `Produto [id=${this.id}, nome=${this.nome}, quantidade=${this.quantidade}]`;
    }
}

class Node {
    constructor(produto) {
        this.produto = produto;
        this.direita = null;
        this.esquerda = null;
    }

    toString() {
        return `Node [produto=${this.produto.toString()}]`;
    }
}

class ArvoreProduto {
    constructor() {
        this.raiz = null;
    }

    adicionarProduto(id, nome, quantidade) {
        let produto = new Produto(id, nome, quantidade);

        if (this.raiz == null) {
            this.raiz = new Node(produto);
        } else {
            this._adicionarProdutoParaFolhas(produto, this.raiz);
        }
    }

    _adicionarProdutoParaFolhas(produto, node) {
        if (produto.id < node.produto.id) {
            if (node.esquerda == null) {
                node.esquerda = new Node(produto);
            } else {
                this._adicionarProdutoParaFolhas(produto, node.esquerda);
            }
        }
        else if (produto.id > node.produto.id) {
            if (node.direita == null) {
                node.direita = new Node(produto);
            } else {
                this._adicionarProdutoParaFolhas(produto, node.direita);
            }
        }
        else {
            node.produto = produto;
        }
    }

    buscarProduto(id) {
        let nodeEncontrado = this._buscarProdutoFolhas(id, this.raiz);
        if(nodeEncontrado == null) {
            console.log(`Produto com id ${id} não encontrado.`);
        } else {
            console.log(`Produto encontrado: ${nodeEncontrado.produto.toString()}`);
        }
    }

    _buscarProdutoFolhas(id, node) {
        if (node == null) {
            return null;
        }

        if (id === node.produto.id) {
            return node;
        }

        else if (id < node.produto.id) {
            return this._buscarProdutoFolhas(id, node.esquerda);
        } else {
            return this._buscarProdutoFolhas(id, node.direita);
        }
    }
}


let arvore = new ArvoreProduto();

arvore.adicionarProduto(1, "Camiseta", 10);
arvore.adicionarProduto(2, "Vestido", 20);
arvore.adicionarProduto(3, "Tenis", 5);

arvore.buscarProduto(1);
