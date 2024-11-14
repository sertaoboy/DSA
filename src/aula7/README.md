# Lista Encadeada
- Ha algumas particularidades da lista encadeada em relacao aos metodos.

## Insercao
### Insercao no inicio:
- Para um determinado `novoNo` que queremos adicionar no indice `0` da lista, devemos realizar as seguintes ideias;
- Caso a lista esteja preenchida (`if cabeca != null`):
1. Apontamos este `novoNo.proximo` como referencia para o `cabeca`;
2. Por fim, atribuimos ao `cabeca` este `novoNo`;
- Caso a lista esteja vazia, simplesmente atribuimos o `cabeca` ao `novoNo`
### Insercao no final:
- Para o `novoNo` ser adicionado ao final da lista vamos considerar o atributo `cauda` onde este seja uma referencia para o ultimo `No` da nossa lista;
- Com isso, podemos referenciar o `proximo` de `cauda` para este `novoNo`;
- Por default, o `novoNo.proximo` ira apontar para `null`.
### Insercao atraves do indice
- Considerando que desejamos adicionar um `novoNo` a um determinado indice;
- Teremos que iterar na lista ate o **`No` anterior a esse indice** que chamaremos de `noAnteriorInsercao`;
- `noAnteriorInsercao` representa o `No` cujo indice seja **menor** que o indice no qual estamos querendo inserir;
- Alem disso, podemos criar um `No` de referencia para o `No` em que ja esteja no indice desejado; seria como um "backup";
- Chamaremos ele de `noPosteriorInsercao`;
- Partindo dessa ideia, podemos concluir entao que:
1. `noPosteriorInsercao = noAnteriorInsercao.proximo`
2. `noAnteriorInsercao.proximo = novoNo`;
3. `novoNo.proximo = noPosteriorInsercao`.

## Remocao
### Remocao atraves do indice
- Considerando que queremos remover um `No` de indice `1`;
- Criaremos uma variavel de referencia `noRemovido` para apontar ao `No` de indice `1`;
- Como vimos no topico anterior podemos definir uma nova variavel de referencia `noAnteriorRemocao` e atribuir a referencia `proximo` deste para o proximo `No` depois do `noRemovido` (no caso o `No` de indice `2`);
- Conclui-se entao:
1. `noRemovido = noAnteriorRemocao.proximo`;
2. `noAnteriorRemocao.proximo = noRemovido.proximo`;
3. `noRemovido.proximo = null`;
- Com isso, o Garbage Collector identifica que `noRemovido` nao esta sendo mais usado como referencias ou atraves de referencias, e o mata da memoria;