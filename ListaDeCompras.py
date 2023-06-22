class ListaDeCompras:
    def __init__(self):
        self.itens = []
        self.quantidades = []

    def adicionar_item(self, item, quantidade):
        if not item or quantidade <= 0:
            print("Erro: quantidade deve ser um número positivo e item deve ser válido.")
            return

        self.itens.append(item)
        self.quantidades.append(quantidade)

    def remover_item(self, item):
        if item not in self.itens:
            print("Erro: item não encontrado.")
            return

        index = self.itens.index(item)
        del self.itens[index]
        del self.quantidades[index]

    def listar_itens(self):
        for item, quantidade in zip(self.itens, self.quantidades):
            print(f"Item: {item}, Quantidade: {quantidade}")


if __name__ == "__main__":
    lista = ListaDeCompras()

    while True:
        print("1 para adicionar item, 2 para remover item, 3 para listar itens, qualquer outra tecla para sair")
        opcao = input()

        if opcao == '1':
            item = input("Digite o nome do item: ")
            quantidade = int(input("Digite a quantidade: "))
            lista.adicionar_item(item, quantidade)
        elif opcao == '2':
            item = input("Digite o nome do item a ser removido: ")
            lista.remover_item(item)
        elif opcao == '3':
            lista.listar_itens()
        else:
            break
