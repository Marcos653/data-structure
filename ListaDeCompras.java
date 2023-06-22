import java.util.ArrayList;
import java.util.Scanner;

public class ListaDeCompras {
    private ArrayList<String> itens;
    private ArrayList<Integer> quantidades;

    public ListaDeCompras() {
        this.itens = new ArrayList<String>();
        this.quantidades = new ArrayList<Integer>();
    }

    public void adicionarItem(String item, int quantidade) {
        if (quantidade <= 0 || item == null || item.isEmpty()) {
            System.out.println("Erro: quantidade deve ser um número positivo e item deve ser válido.");
            return;
        }
        
        this.itens.add(item);
        this.quantidades.add(quantidade);
    }

    public void removerItem(String item) {
        int index = this.itens.indexOf(item);
        
        if (index == -1) {
            System.out.println("Erro: item não encontrado.");
            return;
        }
        
        this.itens.remove(index);
        this.quantidades.remove(index);
    }

    public void listarItens() {
        for (int i = 0; i < this.itens.size(); i++) {
            System.out.println("Item: " + this.itens.get(i) + ", Quantidade: " + this.quantidades.get(i));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaDeCompras lista = new ListaDeCompras();

        String continuar = "s";
        while (continuar.equalsIgnoreCase("s")) {
            System.out.println("1 para adicionar item, 2 para remover item, 3 para listar itens");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                System.out.println("Digite o nome do item:");
                String item = scanner.nextLine();
                System.out.println("Digite a quantidade:");
                int quantidade = scanner.nextInt();
                scanner.nextLine();
                lista.adicionarItem(item, quantidade);
            } else if (opcao == 2) {
                System.out.println("Digite o nome do item a ser removido:");
                String item = scanner.nextLine();
                lista.removerItem(item);
            } else if (opcao == 3) {
                lista.listarItens();
            }

            System.out.println("Deseja continuar? (s/n)");
            continuar = scanner.nextLine();
        }

        scanner.close();
    }
}
