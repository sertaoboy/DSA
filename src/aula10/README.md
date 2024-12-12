# Complexidade
- **Tempo de execucao de um algoritmo**;
- Muitos algoritmos transformam uma entrada em uma saida.
- Geralmente o tempo de um algoritmo aumenta de acordo com o tamanho da entrada.
- Nosso estudo de complexidade foca sempre no pior caso:
1. Facil de determinar;
2. E quando ha uma melhora para o pior caso, os demais sao afetados.
- Porque o estudo da Complexidade?
- Escolher entre varios algoritmos o mais eficiente;
- Desenvolver algoritmos mais eficientes;
- Complexidade Computacional: torna possivel determinar se a definicao de determinado algoritmo e viavel.

## Algoritmos e Funcoes
- Todo algoritmo define uma funcao matematica `f(n) = # de instrucoes`;
- Exemplo:
```java
void algoritmo1(int n) {
    int contador = 0;
    for(int i = 0; i < n;i++){ // o laco sera executado n vezes
        contador++;
    }
} 
```
> O algoritmo acima leva _n_ passos para terminar.
```java
void algoritmo2(int n) {
    int contador = 0;
    for (int i =0; i < n; i++) { // o laco sera executado n vezes
        for(int j = 0; j < n; j++) { // o laco sera executado n vezes
            contador ++;
        }
    }
}
```
> O algoritmo acima leva _n * n_ passos para terminar.
```java
void algoritmo3(int n) {
    int contador = 0;
    for(int i = 0; i < n; i++) { // o laco sera executado n vezes
        for(int j = 0; j < n; j++) { // o laco sera executado n vezes
            for(int k = 0; k < n; k++) { // o laco sera executado n vezes
                contador ++;
            }
        }
    }
}
```
> O algoritmo acima leva _n * n * n_ para terminar.
- Qual algoritmo voce escolheria?
- Basta olhar na funcao definida por cada algoritmo. A funcao de um algoritmo define o melhor algoritmo para um dado problema.
- Fatores: tempo de processamento, memoria, acessos a disco, largura de banda, entre outros.
- No nosso estudo iremos considerar unicamente o tempo de processamento.
- A pratica de se reduzir um algoritmo a uma funcao matematica denomina-se _analise de complexidade de algoritmos_.

## Funcoes mais comuns: em ordem crescente de eficiencia para pior desempenho
| Função         | Notação Big-O        | Tipo de Crescimento                | Exemplos de Algoritmos        |
|----------------|----------------------|------------------------------------|-------------------------------|
| Constante      | O(1)                | Constante                          | Acesso direto em array        |
| Logarítmica    | O(log n)            | Lenta                              | Busca binária                 |
| Linear         | O(n)                | Proporcional                       | Busca em lista não ordenada   |
| Linearítmica   | O(n log n)          | Ligeiramente mais rápida que O(n²) | Merge sort, Quick sort        |
| Quadrática     | O(n²)               | Crescimento exponencial            | Bubble sort, Selection sort   |
| Cúbica         | O(n³)               | Muito mais lenta                   | Algoritmos de matriz          |
| Exponencial    | O(2ⁿ)               | Explosivo                          | Problemas NP-completos        |
| Fatorial       | O(n!)               | Extremo                            | Permutações e combinações     |



## Estudo experimental
- Escrever o programa implementando o algoritmo.
- Executar o programa com diferentes entradas de dados.
- Usar o metodo `System.currentTimeMilis()` para obter o tempo de execucao do programa.

### Limitacoes do experimento
- E necessario implementar o algoritmo, que podera demandar muito tempo.
- Resultados nao indicam o tempo de execucao de entradas nao testadas.
- Para comparar dois programas, o mesmo ambiente de hardware e software (SO) devem ser usados.


