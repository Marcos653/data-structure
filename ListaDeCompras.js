const readline = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout
  });
  
  class ListaDeCompras {
    constructor() {
      this.itens = [];
      this.quantidades = [];
    }
  
    adicionarItem(item, quantidade) {
      if (!item || quantidade <= 0) {
        console.log("Erro: quantidade deve ser um número positivo e item deve ser válido.");
        return;
      }
  
      this.itens.push(item);
      this.quantidades.push(quantidade);
    }
  
    removerItem(item) {
      const index = this.itens.indexOf(item);
  
      if (index === -1) {
        console.log("Erro: item não encontrado.");
        return;
      }
  
      this.itens.splice(index, 1);
      this.quantidades.splice(index, 1);
    }
  
    listarItens() {
      for (let i = 0; i < this.itens.length; i++) {
        console.log(`Item: ${this.itens[i]}, Quantidade: ${this.quantidades[i]}`);
      }
    }
  }
  
  const lista = new ListaDeCompras();
  
  function main() {
    readline.question("1 para adicionar item, 2 para remover item, 3 para listar itens, qualquer outra tecla para sair\n", opcao => {
      if (opcao === '1') {
        readline.question("Digite o nome do item:\n", item => {
          readline.question("Digite a quantidade:\n", quantidade => {
            lista.adicionarItem(item, parseInt(quantidade));
            main();
          });
        });
      } else if (opcao === '2') {
        readline.question("Digite o nome do item a ser removido:\n", item => {
          lista.removerItem(item);
          main();
        });
      } else if (opcao === '3') {
        lista.listarItens();
        main();
      } else {
        readline.close();
      }
    });
  }
  
  main();
  