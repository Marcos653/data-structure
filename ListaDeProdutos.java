import java.math.BigDecimal;

public class ListaDeProdutos {

    public static void main(String[] args) {
        ProdutosLista produtosLista = new ProdutosLista();

        produtosLista.adicionarProduto("maçã", "2", BigDecimal.valueOf(15));
        produtosLista.adicionarProduto("uva", "3", BigDecimal.valueOf(30));
        produtosLista.adicionarProduto("pera", "4", BigDecimal.valueOf(18));
        produtosLista.adicionarProduto("abacaxi", "5", BigDecimal.valueOf(25));
        produtosLista.adicionarProduto("manga", "6", BigDecimal.valueOf(10));
        produtosLista.adicionarProduto("laranja", "7", BigDecimal.valueOf(8));

        produtosLista.atualizarProduto("7", BigDecimal.valueOf(80));
        produtosLista.removerProduto("2");
        produtosLista.listarProdutos();
        produtosLista.buscarProduto("3");
    }
}

class Produto {
    public String nome;
    public String codigo;
    public BigDecimal quantidade;
    public Produto produtoAnterior;
    public Produto proximoProduto;
    
    public Produto(String nome, String codigo, BigDecimal quantidade) {
        this.nome = nome;
        this.codigo = codigo;
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Produto [nome=" + nome + ", codigo=" + codigo + ", quantidade=" + quantidade + "]";
    }
}

class ProdutosLista {
    public Produto head;
    public Produto tail;

    public void adicionarProduto(String nome, String codigo, BigDecimal quantidade) {
        Produto produto = new Produto(nome, codigo, quantidade);

        if (this.head == null) {
            this.head = produto;
            this.tail = produto;
        }

        else {
            this.tail.proximoProduto = produto;
            produto.produtoAnterior = this.tail;
            this.tail = produto;
        }
    }

    public void listarProdutos() {
        if (this.head == null) {
            System.out.println("Não há produtos");
        } else {
            Produto produtoAtual = this.head;

            while (produtoAtual != null) {
                if (produtoAtual != null) {
                    if (produtoAtual.produtoAnterior == null) {
                        System.out.println("head: " + produtoAtual.toString() +
                            " proximo produto: " + produtoAtual.proximoProduto.toString());

                        produtoAtual = produtoAtual.proximoProduto;
                    } else if (produtoAtual.proximoProduto == null) {
                        System.out.println("tail: " + produtoAtual.toString() +
                            " produto anterior: " + produtoAtual.produtoAnterior.toString());

                        break;
                    }

                    System.out.println("produto anterior: " + produtoAtual.produtoAnterior.toString() +
                        " produto atual: " + produtoAtual.toString() +
                        " proximo produto: " + produtoAtual.proximoProduto.toString());

                    produtoAtual = produtoAtual.proximoProduto;
                    
                }
            }
        }
    }

    public void removerProduto(String codigo) {
        if (this.head == null) {
            System.out.println("Não há produtos");
            return;
        }

        if (this.head.codigo.equals(codigo)) {
            this.head = this.head.proximoProduto;
            
            if (this.head != null) {
                this.head.produtoAnterior = null;
            } else {
                this.tail = null;
            }
            return;
        }

        Produto produtoAtual = this.head;

        while (produtoAtual != null && produtoAtual.proximoProduto != null) {
            if (produtoAtual.proximoProduto.codigo.equals(codigo)) {
                Produto produtoASerRemovido = produtoAtual.proximoProduto;
                produtoAtual.proximoProduto = produtoASerRemovido.proximoProduto;
                if (produtoAtual.proximoProduto != null) {
                    produtoAtual.proximoProduto.produtoAnterior = produtoAtual;
                } else {
                    this.tail = produtoAtual;
                }
                return;
            }
            produtoAtual = produtoAtual.proximoProduto;
        }

        System.out.println("Produto não encontrado.");
    }

    public void atualizarProduto(String codigo, BigDecimal quantidade) {
        if (this.head == null) {
            System.out.println("Não há produtos");
        } else {
            Produto produtoAtual = this.head;

            while (produtoAtual != null) {
                if (produtoAtual.codigo.equals(codigo)) {
                    produtoAtual.quantidade = quantidade;
                    System.out.println(produtoAtual.toString());
                }

                produtoAtual = produtoAtual.proximoProduto;
            }
        }
    }

    public void buscarProduto(String codigo) {
        if (this.head == null) {
            System.out.println("Não há produtos");
        } else {
            Produto produtoAtual = this.head;

            while (produtoAtual != null) {
                if (produtoAtual.codigo.equals(codigo)) {
                    
                    System.out.println(produtoAtual.toString());
                }

                produtoAtual = produtoAtual.proximoProduto;
            }
        }
    }

    @Override
    public String toString() {
        return "ProdutosLista [head=" + head + ", tail=" + tail + "]";
    }
}
