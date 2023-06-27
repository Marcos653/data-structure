import java.util.*;

class Jogo {
    private Map<String, Integer> jogadores = new HashMap<>();

    public void adicionarJogador(String nome, Integer pontos) {
        jogadores.put(nome, pontos);
    }

    public void removerJogador(String nome) {
        jogadores.remove(nome);
    }

    public void listarJogadores() {
        jogadores.entrySet()
            .stream()
            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
            .forEach(entry -> 
                System.out.println("Jogador: " + entry.getKey() + ", pontos: " + entry.getValue()));
    }

    public void atualizarPontuacaoJogador(String nomeJogador, Integer novaPontuacao) {
        if (jogadores.containsKey(nomeJogador)) {
            jogadores.put(nomeJogador, novaPontuacao);
        } else {
            System.out.println("Jogador " + nomeJogador + " não encontrado.");
        }
    }

    public void jogadorVencedor() {
        Optional<Map.Entry<String, Integer>> jogadorOpt = jogadores.entrySet()
            .stream()
            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
            .findFirst();

        if (jogadorOpt.isPresent()) {
            Map.Entry<String, Integer> jogador = jogadorOpt.get();
            System.out.println("Jogador vencedor: " + jogador.getKey() + ", pontos: " + jogador.getValue());
        } else {
            System.out.println("Não há jogadores.");
        }
    }
}

public class HashMapJogo {
    public static void main(String[] args) {
        Jogo jogo = new Jogo();

        jogo.adicionarJogador("Marcos", 100);
        jogo.adicionarJogador("Ingrid", 1);

        jogo.atualizarPontuacaoJogador("Ingrid", 20);

        jogo.listarJogadores();
        jogo.jogadorVencedor();
    }
}
