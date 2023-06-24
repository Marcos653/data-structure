class Produto {
    constructor(nome, codigo, quantidade) {
        this.nome = nome;
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.produtoAnterior = null;
        this.proximoProduto = null;
    }

    toString() {
        return "Produto [nome=" + this.nome + ", codigo=" + this.codigo + ", quantidade=" + this.quantidade + "]";
    }
}

class ProdutosLista {
    constructor() {
        this.head = null;
        this.tail = null;
    }

    adicionarProduto(nome, codigo, quantidade) {
        let produto = new Produto(nome, codigo, quantidade);

        if (this.head === null) {
            this.head = produto;
            this.tail = produto;
        } else {
            this.tail.proximoProduto = produto;
            produto.produtoAnterior = this.tail;
            this.tail = produto;
        }
    }

    listarProdutos() {
        if (this.head === null) {
            console.log("Não há produtos");
        } else {
            let produtoAtual = this.head;
    
            while (produtoAtual !== null) {
                if (produtoAtual.produtoAnterior === null && produtoAtual.proximoProduto !== null) {
                    console.log("head: " + produtoAtual.toString() +
                        " proximo produto: " + produtoAtual.proximoProduto.toString());
                } else if (produtoAtual.proximoProduto === null) {
                    console.log("tail: " + produtoAtual.toString() +
                        " produto anterior: " + produtoAtual.produtoAnterior.toString());
                    break;
                } else {
                    console.log("produto anterior: " + produtoAtual.produtoAnterior.toString() +
                        " produto atual: " + produtoAtual.toString() +
                        " proximo produto: " + produtoAtual.proximoProduto.toString());
                }
    
                produtoAtual = produtoAtual.proximoProduto;
            }
        }
    }    

    removerProduto(codigo) {
        if (this.head === null) {
            console.log("Não há produtos");
            return;
        }

        if (this.head.codigo === codigo) {
            this.head = this.head.proximoProduto;
            
            if (this.head !== null) {
                this.head.produtoAnterior = null;
            } else {
                this.tail = null;
            }
            return;
        }

        let produtoAtual = this.head;

        while (produtoAtual !== null && produtoAtual.proximoProduto !== null) {
            if (produtoAtual.proximoProduto.codigo === codigo) {
                let produtoASerRemovido = produtoAtual.proximoProduto;
                produtoAtual.proximoProduto = produtoASerRemovido.proximoProduto;
                if (produtoAtual.proximoProduto !== null) {
                    produtoAtual.proximoProduto.produtoAnterior = produtoAtual;
                } else {
                    this.tail = produtoAtual;
                }
                return;
            }
            produtoAtual = produtoAtual.proximoProduto;
        }

        console.log("Produto não encontrado.");
    }

    atualizarProduto(codigo, quantidade) {
        if (this.head === null) {
            console.log("Não há produtos");
        } else {
            let produtoAtual = this.head;

            while (produtoAtual !== null) {
                if (produtoAtual.codigo === codigo) {
                    produtoAtual.quantidade = quantidade;
                    console.log(produtoAtual.toString());
                }

                produtoAtual = produtoAtual.proximoProduto;
            }
        }
    }

    buscarProduto(codigo) {
        if (this.head === null) {
            console.log("Não há produtos");
        } else {
            let produtoAtual = this.head;

            while (produtoAtual !== null) {
                if (produtoAtual.codigo === codigo) {
                    console.log(produtoAtual.toString());
                }

                produtoAtual = produtoAtual.proximoProduto;
            }
        }
    }
}

let produtosLista = new ProdutosLista();
produtosLista.adicionarProduto("maçã", "2", 15);
produtosLista.adicionarProduto("uva", "3", 30);
produtosLista.adicionarProduto("pera", "4", 18);
produtosLista.adicionarProduto("abacaxi", "5", 25);
produtosLista.adicionarProduto("manga", "6", 10);
produtosLista.adicionarProduto("laranja", "7", 8);

produtosLista.atualizarProduto("7", 80);
produtosLista.removerProduto("2");
produtosLista.listarProdutos();
produtosLista.buscarProduto("3");
