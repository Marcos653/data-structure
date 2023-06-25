class Pedido {
    constructor(numero, nome, prato) {
        this.numero = numero;
        this.nome = nome;
        this.prato = prato;
    }

    toString() {
        return "Pedido [numero=" + this.numero + ", nome=" + this.nome + ", prato=" + this.prato + "]";
    }
}

class FilaDePedidos {
    constructor() {
        this.pedidos = [];
    }

    adicionarPedido(numero, nome, prato) {
        let pedido = new Pedido(numero, nome, prato);

        this.pedidos.push(pedido);
    }

    removePedido() {
        if (this.pedidos.length < 1) {
            console.log("Não tem pedido");
        }

        this.pedidos.shift()
    }

    listaPedidos() {
        if (this.pedidos.length < 1) {
            console.log("Não tem pedido");
        }

        this.pedidos
            .forEach(pedido => console.log(pedido));
    }
}

let filaDePedidos = new FilaDePedidos();

filaDePedidos.adicionarPedido(0, "marcos", "pizza");
filaDePedidos.adicionarPedido(1, "anna", "lasagna");
filaDePedidos.adicionarPedido(2, "lucas", "spaghetti");
filaDePedidos.adicionarPedido(3, "isabella", "ravioli");
filaDePedidos.adicionarPedido(4, "sophia", "carbonara");

filaDePedidos.removePedido();
filaDePedidos.listaPedidos();
