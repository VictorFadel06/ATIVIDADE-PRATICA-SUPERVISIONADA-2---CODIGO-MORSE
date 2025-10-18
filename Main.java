import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArvoreBinariaMorse arv = new ArvoreBinariaMorse();
        arv.inicializar();
        arv.inserirTodos();

        Scanner sc = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("===== Árvore Morse =====");
            System.out.println("1 - Inserir caractere (digitar código e caractere)");
            System.out.println("2 - Buscar por código Morse");
            System.out.println("3 - Traduzir mensagem Morse (separar códigos por espaço; palavras com / )");
            System.out.println("4 - Remover caractere (pelo código)");
            System.out.println("5 - Exibir árvore (hierárquico)");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            String linha = sc.nextLine();
            // evitar NumberFormatException: convertemos manualmente sem try-catch usando lógica simples
            if (linha.length() == 0) {
                opcao = -1;
            } else {
                // tentar extrair um dígito inicial
                char ch = linha.charAt(0);
                if (ch >= '0' && ch <= '9') {
                    opcao = ch - '0';
                } else {
                    // se não for número, seta inválido
                    opcao = -1;
                }
            }

            if (opcao == 1) {
                arv.inserirViaTerminal();
            } else if (opcao == 2) {
                arv.buscarViaTerminal();
            } else if (opcao == 3) {
                arv.traduzirViaTerminal();
            } else if (opcao == 4) {
                arv.removerViaTerminal();
            } else if (opcao == 5) {
                System.out.println("Exibindo árvore (caminho = '.' ponto, '-' traço):");
                arv.exibir();
            } else if (opcao == 0) {
                System.out.println("Saindo...");
            } else {
                System.out.println("Opção inválida. Digite 0-5.");
            }

            System.out.println();
        }
    }
}

