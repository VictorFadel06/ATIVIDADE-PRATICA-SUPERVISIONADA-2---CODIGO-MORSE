import java.util.Scanner;

public class ArvoreBinariaMorse {
    private Node raiz;

    public void inicializar() {
        raiz = new Node("");
    }

    // ('.' = esquerda, '-' = direita)
    public void inserir(String codigo, String caractere) {
        if (raiz == null) {
            inicializar();
        }
        Node atual = raiz;
        int i = 0;
        while (i < codigo.length()) {
            char s = codigo.charAt(i);
            if (s == '.') {
                if (atual.esquerda == null) {
                    atual.esquerda = new Node("");
                }
                atual = atual.esquerda;
            } else if (s == '-') {
                if (atual.direita == null) {
                    atual.direita = new Node("");
                }
                atual = atual.direita;
            } else {
                // Ignora 
            }
            i = i + 1;
        }
        atual.caractere = caractere;
    }

    // Busca pelo caractere 
    public String buscar(String codigo) {
        if (raiz == null) {
            return "";
        }
        Node atual = raiz;
        int i = 0;
        while (i < codigo.length()) {
            char s = codigo.charAt(i);
            if (s == '.') {
                atual = atual.esquerda;
            } else if (s == '-') {
                atual = atual.direita;
            } else {
                // caractere inválido 
                return "";
            }
            i = i + 1;
            if (atual == null) {
                return "";
            }
        }
        if (atual.caractere == null) return "";
        return atual.caractere;
    }

    // Remove um caractere e o define como vazio
    public void remover(String codigo) {
        if (raiz == null) return;
        Node atual = raiz;
        int i = 0;
        while (i < codigo.length()) {
            char s = codigo.charAt(i);
            if (s == '.') {
                atual = atual.esquerda;
            } else if (s == '-') {
                atual = atual.direita;
            } else {
                return; 
            }
            i = i + 1;
            if (atual == null) return;
        }
        
        atual.caractere = "";
    }

    // Exibe a árvore(pré-ordem) 
    public void exibir() {
        exibirRec(raiz, 0, "");
    }

    private void exibirRec(Node nodo, int nivel, String caminho) {
        if (nodo == null) return;
        // Imprime indentação
        int j = 0;
        String esp = "";
        while (j < nivel) {
            esp = esp + "   "; // 3 espaços por nível
            j = j + 1;
        }
        String valor = nodo.caractere;
        if (valor == null) valor = "";
        System.out.println(esp + "(" + caminho + ") " + valor);
        // esquerda = ponto, adicionar "." ao caminho
        exibirRec(nodo.esquerda, nivel + 1, caminho + ".");
        // direita = traço, adicionar "-" ao caminho
        exibirRec(nodo.direita, nivel + 1, caminho + "-");
    }

    
    public String traduzirMensagem(String mensagem) {
        String resultado = "";
        String token = "";
        int i = 0;
        while (i < mensagem.length()) {
            char c = mensagem.charAt(i);
            if (c == ' ') {
                // fim de um código: traduzir token
                if (token.length() > 0) {
                    String r = buscar(token);
                    if (r.equals("")) {
                        resultado = resultado + "?";
                    } else {
                        resultado = resultado + r;
                    }
                    token = "";
                } else {
                    // espaço repetido: ignora
                }
            } else if (c == '/') {
                // separador de palavra
                
                if (token.length() > 0) {
                    String r = buscar(token);
                    if (r.equals("")) {
                        resultado = resultado + "?";
                    } else {
                        resultado = resultado + r;
                    }
                    token = "";
                }
                // adiciona espaço entre palavras
                resultado = resultado + " ";
            } else {
                // caractere do código ('.' ou '-'), concatena ao token
                token = token + c;
            }
            i = i + 1;
        }
        // se token remanescente
        if (token.length() > 0) {
            String r = buscar(token);
            if (r.equals("")) {
                resultado = resultado + "?";
            } else {
                resultado = resultado + r;
            }
        }
        return resultado;
    }

    
    public void inserirTodos() {
        inserir(".-", "A");
        inserir("-...", "B");
        inserir("-.-.", "C");
        inserir("-..", "D");
        inserir(".", "E");
        inserir("..-.", "F");
        inserir("--.", "G");
        inserir("....", "H");
        inserir("..", "I");
        inserir(".---", "J");
        inserir("-.-", "K");
        inserir(".-..", "L");
        inserir("--", "M");
        inserir("-.", "N");
        inserir("---", "O");
        inserir(".--.", "P");
        inserir("--.-", "Q");
        inserir(".-.", "R");
        inserir("...", "S");
        inserir("-", "T");
        inserir("..-", "U");
        inserir("...-", "V");
        inserir(".--", "W");
        inserir("-..-", "X");
        inserir("-.--", "Y");
        inserir("--..", "Z");

      
        inserir("-----", "0");
        inserir(".----", "1");
        inserir("..---", "2");
        inserir("...--", "3");
        inserir("....-", "4");
        inserir(".....", "5");
        inserir("-....", "6");
        inserir("--...", "7");
        inserir("---..", "8");
        inserir("----.", "9");
    }

    
    public void inserirViaTerminal() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o código Morse (ex: ... ):");
        String codigo = sc.nextLine();
        System.out.println("Digite o caractere correspondente (ex: S):");
        String c = sc.nextLine();
        inserir(codigo, c);
    }

    
    public void buscarViaTerminal() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o código Morse para buscar:");
        String codigo = sc.nextLine();
        String r = buscar(codigo);
        if (r.equals("")) {
            System.out.println("Não encontrado para o código: " + codigo);
        } else {
            System.out.println("Resultado: " + r);
        }
    }

    
    public void removerViaTerminal() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o código Morse para remover:");
        String codigo = sc.nextLine();
        remover(codigo);
        System.out.println("Removido (se existia) o código: " + codigo);
    }

  
    public void traduzirViaTerminal() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a mensagem em Morse (sep. por espaços; separa palavras com '/'): ");
        String m = sc.nextLine();
        String r = traduzirMensagem(m);
        System.out.println("Tradução: " + r);
    }
}
