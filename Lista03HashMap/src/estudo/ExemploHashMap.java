package estudo;

import java.util.HashMap;
import java.util.Map;


/*

Um HashMap em Java armazena dados no formato chave-valor (como um dicionário), 
onde cada chave é única e aponta para um valor específico, permitindo buscas muito rápidas.

Abaixo está uma classe didática e comentada que demonstra as operações principais:
 */



public class ExemploHashMap {
    public static void main(String[] args) {
        // 1. CRIAÇÃO: Map<TipoDaChave, TipoDoValor>
        // Exemplo: Associar o nome de um produto (String) ao seu preço (Double)
        Map<String, Double> estoquePrecos = new HashMap<>();

        // 2. INSERÇÃO (put): Adiciona pares de chave e valor
        estoquePrecos.put("Teclado", 150.00);
        estoquePrecos.put("Mouse", 80.50);
        estoquePrecos.put("Monitor", 899.90);

        // Chave duplicada NÃO cria novo item: ela sobrescreve o valor anterior
        estoquePrecos.put("Mouse", 95.00); 

        System.out.println("Mapa inicial: " + estoquePrecos);

        // 3. BUSCA (get): Recupera o valor informando a chave
        Double precoTeclado = estoquePrecos.get("Teclado");
        System.out.println("Preço do Teclado: R$ " + precoTeclado);

        // Busca segura (getOrDefault): evita retorno null se a chave não existir
        Double precoCadeira = estoquePrecos.getOrDefault("Cadeira", 0.0);
        System.out.println("Preço da Cadeira (não cadastrada): R$ " + precoCadeira);

        // 4. VERIFICAÇÃO (containsKey / containsValue)
        if (estoquePrecos.containsKey("Monitor")) {
            System.out.println("O produto 'Monitor' está cadastrado.");
        }

        // 5. REMOÇÃO (remove): Remove o par pela chave
        estoquePrecos.remove("Teclado");
        System.out.println("Após remover o Teclado: " + estoquePrecos);

        // 6. PERCORRENDO O MAPA (entrySet): Forma mais eficiente para ler chave e valor
        System.out.println("\n--- Lista de Produtos ---");
        for (Map.Entry<String, Double> item : estoquePrecos.entrySet()) {
            String produto = item.getKey();
            Double preco = item.getValue();
            System.out.printf("Produto: %-10s | Preço: R$ %.2f%n", produto, preco);
        }

        // 7. TAMANHO (size)
        System.out.println("\nTotal de itens cadastrados: " + estoquePrecos.size());
    }
    
    
    /*
    
Pontos-chave para lembrar:
    
Sem ordem garantida: 
Repare na saída que os itens não aparecem necessariamente na ordem em que foram inseridos. 
Se precisar manter a ordem de inserção, use LinkedHashMap.

Chaves únicas, valores repetidos: Você não pode ter dois "Mouse" no mesmo mapa, mas pode ter dois produtos diferentes com o mesmo preço (95.00).

Tipos primitivos: 
O HashMap só aceita objetos (classes wrapper), por isso usamos Double em vez de double, e Integer em vez de int.

     */
    
    
    
    
}
