import java.util.LinkedList;

public class FilaPedidos {
    
    public static void main(String[] args) {
        FilaDePedidos filaDePedidos = new FilaDePedidos();

        filaDePedidos.adicionarPedido(0, "marcos", "pizza");
        filaDePedidos.adicionarPedido(1, "anna", "lasagna");
        filaDePedidos.adicionarPedido(2, "lucas", "spaghetti");
        filaDePedidos.adicionarPedido(3, "isabella", "ravioli");
        filaDePedidos.adicionarPedido(4, "sophia", "carbonara");

        filaDePedidos.removePedido();
        filaDePedidos.listaPedidos();
    }
}

class Pedido {
    int numero;
    String nome;
    String prato;

    public Pedido(int numero, String nome, String prato) {
        this.numero = numero;
        this.nome = nome;
        this.prato = prato;
    }

    @Override
    public String toString() {
        return "Pedido [numero=" + numero + ", nome=" + nome + ", prato=" + prato + "]";
    }
}


class FilaDePedidos {
    LinkedList<Pedido> pedidos = new LinkedList<>();

    public void adicionarPedido(int numero, String nome, String prato) {
        Pedido pedido = new Pedido(numero, nome, prato);

        pedidos.add(pedido);
    }

    public void removePedido() {
        if (pedidos.size() < 1) {
            System.out.println("Não tem pedido");
        }

        pedidos.pop();
    }

    public void listaPedidos() {
        if (pedidos.size() < 1) {
            System.out.println("Não tem pedido");
        }

        pedidos
            .stream()
            .forEach(System.out::println);
    }
}
