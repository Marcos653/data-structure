class Jogo:
    def __init__(self):
        self.jogadores = dict()

    def adicionarJogador(self, nome, pontos):
        self.jogadores[nome] = pontos

    def removerJogador(self, nome):
        if nome in self.jogadores:
            del self.jogadores[nome]

    def listarJogadores(self):
        jogadoresOrdenados = sorted(self.jogadores.items(), key=lambda jogador: jogador[1], reverse=True)
        for jogador in jogadoresOrdenados:
            print("Jogador: {}, pontos: {}".format(jogador[0], jogador[1]))

    def atualizarPontuacaoJogador(self, nomeJogador, novaPontuacao):
        if nomeJogador in self.jogadores:
            self.jogadores[nomeJogador] = novaPontuacao
        else:
            print("Jogador {} não encontrado.".format(nomeJogador))

    def jogadorVencedor(self):
        if not self.jogadores:
            print("Não há jogadores.")
            return

        jogadorVencedor = max(self.jogadores.items(), key=lambda jogador: jogador[1])
        print("Jogador vencedor: {}, pontos: {}".format(jogadorVencedor[0], jogadorVencedor[1]))


jogo = Jogo()
jogo.adicionarJogador("Marcos", 100)
jogo.adicionarJogador("Ingrid", 1)
jogo.atualizarPontuacaoJogador("Ingrid", 20)
jogo.listarJogadores()
jogo.jogadorVencedor()
