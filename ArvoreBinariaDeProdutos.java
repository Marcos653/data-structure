class Produto {
    Integer id;
    String nome;
    Integer quantidade;
    
    public Produto(Integer id, String nome, Integer quantidade) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Produto [id=" + id + ", nome=" + nome + ", quantidade=" + quantidade + "]";
    }

    public Integer getId() {
        return id;
    }
}

class Node {
    Node direita;
    Node esquerda;
    Produto produto;

    public Node(Produto produto) {
        this.produto = produto;
    }

    @Override
    public String toString() {
        return "Node [produto=" + produto + "]";
    }
}

class ArvoreProduto {
    Node raiz;

    public void adicionarProduto(Integer id, String nome, Integer quantidade) {
        Produto produto = new Produto(id, nome, quantidade);

        if (raiz == null) {
            raiz = new Node(produto);
        } else {
            adicionarProdutoParaFolhas(produto, raiz);
        }
    }

    private void adicionarProdutoParaFolhas(Produto produto, Node node) {
        if (produto.id < node.produto.id) {
            if (node.esquerda == null) {
                node.esquerda = new Node(produto);
            } else {
                adicionarProdutoParaFolhas(produto, node.esquerda);
            }
        }
        else if (produto.id > node.produto.id) {
            if (node.direita == null) {
                node.direita = new Node(produto);
            } else {
                adicionarProdutoParaFolhas(produto, node.direita);
            }
        }
        else {
            node.produto = produto;
        }
    }

    public void buscarProduto(Integer id) {
        Node nodeEncontrado = buscarProdutoFolhas(id, raiz);
        if(nodeEncontrado == null) {
            System.out.println("Produto com id " + id + " não encontrado.");
        } else {
            System.out.println("Produto encontrado: " + nodeEncontrado.produto.toString());
        }
    }

    private Node buscarProdutoFolhas(Integer id, Node node) {
        if (node == null) {
            return null;
        }

        if (id.equals(node.produto.id)) {
            return node;
        }

        else if (id < node.produto.id) {
            return buscarProdutoFolhas(id, node.esquerda);
        } else {
            return buscarProdutoFolhas(id, node.direita);
        }
    }
}


public class ArvoreBinariaDeProdutos {

    public static void main(String[] args) {
        ArvoreProduto arvore = new ArvoreProduto();

        arvore.adicionarProduto(1, "Camiseta", 10);
        arvore.adicionarProduto(2, "Vestido", 20);
        arvore.adicionarProduto(3, "Tenis", 5);

        arvore.buscarProduto(1);
    }    
}
