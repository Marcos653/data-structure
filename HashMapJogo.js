let _ = require('lodash')

class Jogo {
    constructor() {
        this.jogadores = new Map();
    }

    adicionarJogador(nome, pontos) {
        this.jogadores.set(nome, pontos);
    }

    removerJogador(nome) {
        this.jogadores.remove(nome);
    }

    listarJogadores() {
        let jogadoresArray = Array.from(this.jogadores, ([nome, pontos]) => ({nome, pontos}));
        jogadoresArray = _.orderBy(jogadoresArray, ['pontos'], ['desc']);

        jogadoresArray.forEach(jogador => {
            console.log("Jogador: " + jogador.nome + ", pontos: " + jogador.pontos);
        });
    }

    atualizarPontuacaoJogador(nomeJogador, novaPontuacao) {
        if (this.jogadores.has(nomeJogador)) {
            this.jogadores.set(nomeJogador, novaPontuacao);
        } else {
            console.log("Jogador " + nomeJogador + " não encontrado.");
        }
    }

    jogadorVencedor() {
        if (this.jogadores.size === 0) {
            console.log("Não há jogadores.");
            return;
        }
    
        var jogadorVencedor = Array.from(this.jogadores.entries()).sort((a, b) => b[1] - a[1])[0];
        
        console.log("Jogador vencedor: " + jogadorVencedor[0] + ", pontos: " + jogadorVencedor[1]);
    }     
}

let jogo = new Jogo();

jogo.adicionarJogador("Marcos", 100);
jogo.adicionarJogador("Ingrid", 1);
jogo.atualizarPontuacaoJogador("Ingrid", 20);
jogo.listarJogadores();
jogo.jogadorVencedor();