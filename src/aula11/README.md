# Arvores
- Sao estruturas que armazenam os elementos de maneira hierarquica.
- Semelhante a uma **arvore genealogica**: descendentes e ascendentes.
- Algumas definicoes:
1. O `No` do topo se chama **raiz**;
2. Com excessao da raiz, cada `No` possui: 
- Um **pai**;
- Zero ou mais **filhos**.

## Definicao formal:
- Uma arvore T e um conjunto de `Nos` que armazenam elementos em relacionamentos **pai-filho** com as seguintes propriedades:
- Se T nao e **vazia**, ela tem um `No` especial chamado **raiz** de T que nao tem pai.
- Cada `No v` de T diferente da raiz tem um unico `No` **pai w**. Todo `No` com pai w e **filho** de w.
- **Irmaos**: `Nos` filhos do mesmo pai.
- **No externo (ou folha)**: que nao tem filhos.
- **No interno**: que tem um ou mais filhos.
- **u seria ancestral de v** se u=v, ou u e ancestral do pai de v.
- **v seria descendente de u** se u for ancestral de v.
- **Sub-arvore de T enraizada ao No v** e a arvore que consiste em todos os descendentes de v em T (incluindo o proprio v).

## Arestas e Caminho
- **Aresta**: um par de `Nos` (u,v) tal que u seja pai de v ou vice-versa.
- **Caminho**: e uma sequencia de `Nos` tais que quaisquer dois `Nos` consecutivos da sequencia foram uma aresta.

## Altura e Profundidade
- **Altura de um `No v`**: se v e `No` externo, entao a altura de v e 0. Senao, a altura e 1 mais a altura maxima dos filhos de v.
- **Altura de uma arvore nao vazia**: altura da raiz.
- **Profundidade de um `No v`**: se v for a raiz, entao a profundidade de v e 0. Senao, e 1 mais a profundidade do pai de v.

## Arvore Ordenada
- Define que existe uma ordem linear definida para os filhos de cada `No`, ou seja, se e possivel identificar os filhos de um `No` como sendo o primeiro, segundo e assim por diante.
- Tal ordenacao normalmente e desenhada organizando-se os irmaos da esquerda para a direita, de acordo com a relacao entre os mesmos.

## Tipos de Caminhamentos em Árvores
- Os caminhamentos em arvores definem a ordem em que os nos sao visitadis. Eles podem ser realizados de forma **recursiva** ou **iterativa**, dependendo da implementacao.

### Caminhamento prefixado de uma arvore T (Pre-ordem):
- Neste caminhamento, a visita aos nos segue a seguinte ordem:
1. **Visitar a raiz** do `No` atual.
2. Percorrer **recursvivamente** as subarvores da raiz, da esquerda para a direita (se houver ordem entre os filhos).
> Ordem de visitacao: Raiz -> Subarvore Esquerda -> Subarvore Direita
```shell
       A
     /   \
    B     C
   / \   / \
  D   E F   G
```
- **Ordem prefixada: A → B → D → E → C → F → G**

### Caminhamento posfixado de uma arvore T (Pos-ordem):
- No caminhamento posfixado, a visita segue esta ordem:
1. Percorrer **recursivamente** as subarvores da raiz, da esquerda para a direita (se houver ordem entre os filhos).
2. **Visitar a raiz** do `No` atual.
> Ordem de visitacao: Subarvore Esquerda -> Subarvore Direita -> Raiz
```shell
       A
     /   \
    B     C
   / \   / \
  D   E F   G
```
- **Ordem pos-fixada: D → E → B → F → G → C → A**

### Caminhamento Interfixado (In-ordem)
- No caminhamento interfixado (aplicado especialmente em arvores binarias), a visitacao segue esta ordem:
1. Percorrer **recursivamente** a **subarvore esquerda** do `No` atual.
2. **Visitar a raiz** do `No` atual.
3. Percorrer **recursivamente** a **subarvore direita**.
> Ordem de visitacao: Subarvore Esquerda -> Raiz -> Subarvore Direita
```shell
       A
     /   \
    B     C
   / \   / \
  D   E F   G
```
- **Ordem interfixada sera: D → B → E → A → F → C → G**

### Resumo dos Caminhamentos:
| Tipo de Caminhamento | Ordem de Visitação            |
|-----------------------|-------------------------------|
| Prefixado (Pré-ordem) | Raiz → Esquerda → Direita     |
| Interfixado (In-ordem)| Esquerda → Raiz → Direita     |
| Pós-fixado (Pós-ordem)| Esquerda → Direita → Raiz     |
