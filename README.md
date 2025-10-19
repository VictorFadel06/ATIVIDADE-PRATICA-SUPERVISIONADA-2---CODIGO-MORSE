# Árvore Binária - Código Morse

## Descrição
Implementação de uma árvore binária para representar o código Morse. Cada nó representa um caractere; o caminho da raiz até o nó descreve a sequência de pontos (.) e traços (-).

## Arquivos
- Nodo.java
- ArvoreBinariaMorse.java
- Main.java

## Regras respeitadas
- Apenas `String`, `int`, `float` e `Scanner` são utilizados.
- `length()` é utilizado somente em `String`.
- Não são usados arrays, listas, StringBuilder, exceptions, generics ou estruturas proibidas.
- Todas as letras de A-Z e números 0-9 são inseridos manualmente com `inserir()`.

## Como compilar
```bash
javac Nodo.java ArvoreBinariaMorse.java Main.java
```

## Como executar
```bash
java Main
```

## Funcionalidades do Menu
| Opção | Função |
|-------|--------|
| 1 | Inserir caractere manualmente (código Morse + caractere) |
| 2 | Buscar caractere pelo código Morse |
| 3 | Traduzir uma mensagem completa em Morse (separada por espaços, usar `/` entre palavras) |
| 4 | Remover um caractere da árvore (mantendo a estrutura) |
| 5 | Exibir a árvore hierarquicamente |
| 0 | Sair |

## Exemplo de código Morse aceito
- `...` → S  
- `---` → O  
- `... --- ...` → SOS  
- `... --- ... / .-` → SOS A

## Observações
- Para separar palavras no Morse, use `/` (barra).  
- Remover um nó não apaga seus filhos, apenas limpa o caractere.  
- O projeto segue rigorosamente as restrições do enunciado.

---

**Autor:**  
- Victor Valerio Fadel
