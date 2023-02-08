# Árvores

## 1 Árvore Binária de Busca
### 1.1 Propriedades
- Cada nó deve ter no máximo 2 filhos;
- O filho esquerdo de um nó sempre é menor que o próprio nó;
- O filho direito de um nó sempre é maior que o próprio nó;

### 1.2 Operações
#### Inserção
1. Se o valor a ser inserido for maior que o nó atual, ir para a direita, se for menor, ir para a esquerda;
2. Se o nó atual for vazio, criar um novo nó com o valor a ser inserido;

#### Deleção
1. Se o valor a ser removido for maior que o nó atual, ir para a direita, se for menor, ir para a esquerda;
2. Se o nó a ser removido for encotrado e não possuir uma folha, fazer seu pai apontar para null;
3. Se o nó a ser removido for encontrado e possuir apenas um 1 filho, fazer seu pai apontar para seu filho;
4. Se o nó a ser removido for encontrado e possuir 2 filhos, primeiro é preciso encotrar o menor nó da sua sub-árvore direita, que seria seu sucessor em ordem. Depois é necessário substituir o nó atual pelo seu sucessor e remover o sucessor de sua posição original;
## 2 Árvore Rubro-Negra
### 2.1 Propriedades
- Extende as propriedades na árvore binária de busca;
- Todo nó deve ser preto ou vermelho;
- A raiz é sempre preta;
- Toda folha (NIL) é preta;
- Um nó vermelho só pode ter filhos pretos;
- Para cada nó, qualquer caminho desse nó até uma de duas folhas (NILs) deve conter o mesmo número de nós pretos;

### 2.2 Operações
#### 2.2.1 Inserção
- Se a árvore estiver vazia, basta criar um nó raiz de cor preta;
- Se a árvore não estiver vazia, basta inserir o novo nó como uma folha de cor vermelha;
- Se o pai de um nó recém inserido for vermelho, basta verificar a cor do irmão do nó pai:
    - Se o irmão for vermelho, mudar a cor do nó pai e do irmão, e se o nó avo não for a raiz, mudar a cor do avo também;
    - Se o irmão for preto ou nulo, realizar as rotaçoes apropriadas e recolorir;
        - A rotação a ser feita depende do caminho do nó inserido até o seu avo;

## 3 Árvore AVL
### 3.1 Propriedades
- Extende as propriedades na árvore binária de busca;
- Cada nó é associado a um fator de balanceamento que é calculado a partir da subtração da altura da sub-árvore direita pela sub-árvore esquerda;
    - Se o fator de balanceamento é -1, a sub-árvore direita é maior que a esquerda em um nível;
    - Se o fator de balanceamento é 1, a sub-árvore esquerda é maior que a direita em um nível;
    - Se o fator de balanceamento é 0, a sub-árvore esquerda é tem tamanho igual a sub-árvore direita;
    - Se o fator de balancemaneot é < -1 ou > 1, a árvore deve ser rebalanceada;

### 3.2 Operações
#### 3.2.1 Inserção
1. Percorrer a árvore até encontrar um nó vazio e inserir o novo nó, da mesma forma que em uma árvore binária de busca;
2. Verificar o fator de balanceamento para cada nó, subindo recursivamente;
3. Se o fator de balanceamento for > 1 e o filho esquerdo do nó atual for maior que o nó inserido, rotacionar o filho esquerdo para a esquerda, senão, rotacionar o nó atual para a direita;
4. Se o fator de balanceamento for < -1 e o filho direito do nó atual for menor que o nó inserido, rotacionar o filho direito para a direita, senão, rotacionar o nó atual para a esquerda;

#### 3.2.2 Deleção
1. Varrer a árvore até encontrar o nó e remove-lo da mesma forma quem em uma árvore binária de busca;
2. Verificar fator de balancemanto para cada nó, subindo recursivamente;
3. Se o fator de balanceamento do nó atual e do seu filho esquerdo forem, respectivamente, > 1 e => 0, rotacionar para a direita, senão, rotacionar para a esquerda e depois para a direita;
4. Se o fator de balanceamento do nó atual e do seu fillho direito forem, respectivamente, < -1 e <= 0, rotacionar para a esquerda, senão, rotacionar para a direita e depois a para esquerda;   

## 4 Árvore B
### 4.1 Propriedades
- Para cada nó, as chaves são armazenadas em ordem crescente;
- Se n é a ordem da árvore: 
    - Então cada nó deve conter no máximo n - 1 chaves;
    - Então cada nó, com exceção da raiz, deve possui no máximo n filhos e no mínimo teto(n/2) filhos;  
- A raíz deve conter no mínimo 2 filhos e 1 chave;
- Se um nó interno tem k filhos, entao deve conter no mínimo teto(m/2) - 1 chaves;
- Todas as folhas devem estar no mesmo nível;
- Se n >= 1, então para qualquer n-chave de altura h e grau mínimo >= 2, h >= logt (n+1)/2

### 4.2 Operações
#### 4.2.1 Inserção
1. Varrer a árvore até encontrar a folha apropriada para a inserção. A chave a ser inserido deve ser comparado com as chaves de cada nó, seguindo o mesmo príncipio da árvore binária de busca ao passar para o próximo nó;
2. Se a folha contém menos do que n - 1 chaves, inserir a nova chave em ordem crescente;
3. Senão, inserir a chave em ordem crescente, dividir o nó ao meio, criando dois novos nós, e subir o elemento mediano para o nó pai do nó atual;
4. Se o nó pai infringir a propriedade da árvore, repetir o passo 3;

#### 4.2.2 Deleção
1. Varrer a árvore até encontrar a chave que se deseja remover;
2. Se a chave a ser removida se encontrar em uma folha;
3. Se a folha possuir mais que o mínimo de chaves, simplesmente remover a chave;
4. Se a folha possuir menos que o mínimo de chaves:
5. Se o primo esquerdo conter mais que o mínimo de chaves, subir sua maior chave para o nó pai e substituir a chave removida pela chave pai do nó pai;
6. Se o primo direito conter mais que o mínimo de chaves, subir sua menor chave para o nó pai e substituir a chave removida pela chave pai do nó pai;
7. Se nenhum dos primos tiver mais que o mínimo de chaves, criar um novo nó unindo um dos primos ao nó em que a chave foi removido e descer a chave pai;
8. Se o no pai infringir a propriedade da árvore, repetir o processo 4 em diante;
9. Se a chave a ser removida se encontrar em um nó interno;
10. Se o filho esquerdo tiver mais que o mínimo de chaves, substituir a chave removido pelo seu predecessor no filho esquerdo;
11. Se o filho direito tiver mais que o mínimo de chaves, substituir a chave removido pelo seu sucessor no filho direito;
11. Se nenhum dos filhos tiver mais que o mínimo de chaves, unir os dois filhos;

### Aplicações
- Otimizar o tempo de acesso a memória secundária (arquivos de sistema e bancos de dados);
    - Consequencia do maior número de chaves que cada nó da árvore pode armazenar, o que reduz a altura da árvore e aumenta a velocidade de operaçoes como inserçao e deleçao;