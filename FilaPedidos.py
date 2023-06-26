from collections import deque

class Pedido:
    def __init__(self, numero, nome, prato) -> None:
        self.numero = numero
        self.nome = nome
        self.prato = prato

    def __str__(self):
        return f"Pedido [numero={self.numero}, nome={self.nome}, prato={self.prato}]"

class FilaDePedidos:
    def __init__(self) -> None:
        self.pedidos = deque([])

    def adicionarPedido(self, numero, nome, prato):
        pedido = Pedido(numero, nome, prato)

        self.pedidos.append(pedido)

    def removePedido(self):
        if len(self.pedidos) < 1:
            print("Não tem pedidos")

        self.pedidos.popleft()

    def listaPedidos(self):
        if len(self.pedidos) < 1:
            print("Não tem pedidos")

        for pedido in self.pedidos:
            print(pedido)


filaDePedidos = FilaDePedidos()

filaDePedidos.adicionarPedido(0, "marcos", "pizza")
filaDePedidos.adicionarPedido(1, "anna", "lasagna")
filaDePedidos.adicionarPedido(2, "lucas", "spaghetti")
filaDePedidos.adicionarPedido(3, "isabella", "ravioli")
filaDePedidos.adicionarPedido(4, "sophia", "carbonara")

filaDePedidos.removePedido()
filaDePedidos.listaPedidos()
