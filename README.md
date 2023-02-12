# Árvores

## 1 Árvore Binária de Busca
![image](https://user-images.githubusercontent.com/67767706/217406548-c8bc019f-a264-4196-9dc6-aa7ecd2eb72f.png)

### 1.1 Propriedades
- Cada nó deve ter no máximo 2 filhos;
- O filho esquerdo de um nó sempre é menor que o próprio nó;
- O filho direito de um nó sempre é maior que o próprio nó;

### 1.2 Operações
#### Inserção
- Inserir o novo nó como uma folha;

#### Deleção
- Se o nó for uma folha, basta remove-lo;
- Se o nó possuir apenas um 1 filho, basta fazer seu pai apontar para seu filho;
- Se o nó  possuir 2 filhos:
    - Encotrar seu sucessor na sub-árvore direita. 
    - Subtitui-lo por seu sucessor e remover o sucessor de sua posição original;
## 2 Árvore Rubro-Negra
![image](https://user-images.githubusercontent.com/67767706/217406468-7c7f60e4-8445-4c7e-81c2-258f83d82669.png)

### 2.1 Propriedades
- Extende as propriedades na árvore binária de busca;
- Todo nó deve ser preto ou vermelho;
- A raiz é sempre preta;
- Toda folha (NIL) é preta;
- Um nó vermelho só pode ter filhos pretos;
- Para cada nó, qualquer caminho desse nó até uma de duas folhas (NILs) deve conter o mesmo número de nós pretos;

### 2.2 Operações
#### 2.2.1 Inserção
- Caso 1: Se a árvore estiver vazia, basta criar um nó raiz de cor preta;
- Caso 2: Se a árvore não estiver vazia, basta inserir o novo nó como uma folha de cor vermelha;
    - Se o pai de um nó recém inserido for vermelho, basta verificar a cor do irmão do nó pai:
        - Se o irmão for vermelho, mudar a cor do nó pai e do irmão, e se o nó avo não for a raiz, mudar a cor do avo também;
            - ![image](https://user-images.githubusercontent.com/67767706/218329435-c7057e07-c5db-49ad-bb89-dd5f443f5b47.png)
            - ![image](https://user-images.githubusercontent.com/67767706/218329467-1ec2a312-ca62-4d59-bbaf-f2cf407a57c2.png)


- Caso 3: Se o irmão for preto ou nulo, realizar as rotaçoes apropriadas e recolorir;
    - Caso 3A: O elemento que entrou é filho ESQUERDO e o irmão do seu nó pai(tio) preto está na DIREITA
        - OBS: Filho DIREITA - Tio Esquerda se aplica também  
        - ![image](https://user-images.githubusercontent.com/67767706/218330176-2efc12fa-fbea-4ac9-83d8-75205a07fdf5.png)


    - Caso 3B: O elemento que entrou é filho DIREITO e o irmão do nó pai (tio) preto está na DIREITA
        - OBS: Filho Esquerda - Tio Esquerda se aplica também 
    - A rotação a ser feita depende do caminho do nó inserido até o seu avo;

#### 2.2.2 Deleção
- Se nó a ser removido possuir cor vermelha:
    - Se for uma folha, basta remove-lo;
    - Se possuir 1 filho, substitu-lo por seu filho;
    - Se possuir 2 filhos, substitui-lo por seu sucessor na árvore direita;
- Se o nó for preto:
    - Se possuir 1 filho, substitui-lo pelo seu filho;
    - Se possuir 2 filhos, substitui-lo pelo seu sucessor na árvore direita.
    - Se o filho for um NIL, temos um problema de "duplo preto";
        - Se o irmao for preto e possuir filhos pretos:
            - Se o pai do nó for preto, torna-lo "duplo preto"
            - Se o pai do nó for vermelho, torna-lo preto;
            - Tornar o irmão vermelho;
        - Se o irmao for preto e possuir 1 filho vermelho próximo do duplo preto:
            - Tornar o filho do irmao preto;
            - Tornar o irmao vermelho;
            - Rotacionar o irmao na direçao oposta do "duplo preto";
        - Se o irmao for preto e possuir 1 filho vermelho distante do duplo preto:
            - Trocar a cor do pai pela do irmao;
            - Rotacionar o pai na direçao do "duplo preto";
            - Tornar o "duplo preto" preto;
            - Tornar o antigo filho vermelho preto; 
        - Se o irmao for vermelho:
            - Se o pai for preto, torna-lo vermelho;
            - Tornar o irmao preto;
            - Rotacionar o pai na direçao do "duplo preto";
- Se a raiz for "duplo preta", basta torna-la preta;

### 2.3 Aplicações
- Kernel do linux;

### Árvore Rubro-Negra caída para esquerda LLRB
   - Possuí as mesmas propriedades que a Árvore Rubro-Negra tradicional
   - Propriedade extra: se um nó é vermelho, então ele é o filho ESQUERDO do seu pai
   - Trás uma implementação mais simples: os nós vermelhos são sempre os filhos à esquerda
   - Sua implementação corresponde a implementação de uma árvore 2-3, se considerarmos que o nó "vermelho" sempre será o "menor" de um nó contendo "dois valores" e "três sub-árvores
   - Balancear esta árvore equivale a balancear uma árvore 2-3, que é mais simples do que uma AVL tree ou rubro-negra convencional
###  
## 3 Árvore AVL
![image](https://user-images.githubusercontent.com/67767706/217406798-d0797b02-4bc7-46ce-88bb-10ed1064d2f0.png)

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

## 4 Árvore Rubro-Negra vs Árvore AVL
- O balanceamento na Árvore Rubro-Negra é menos rígido, o que facilita tarefas que priorizem a inserção ou remoção;
- Por possuir um balanceamento mais rígido, a Árvore AVL facilita terefas que priorizem a busca;

## 5 Árvore B
![image](https://user-images.githubusercontent.com/67767706/217406986-e69c1592-d471-4234-a95f-75422a463412.png)

### 5.1 Propriedades
- Para cada nó, as chaves são armazenadas em ordem crescente;
- Se n é a ordem da árvore: 
    - Então cada nó deve conter no máximo n - 1 chaves;
    - Então cada nó, com exceção da raiz, deve possui no máximo n filhos e no mínimo teto(n/2) filhos;  
- A raíz deve conter no mínimo 2 filhos e 1 chave;
- Se um nó interno tem k filhos, entao deve conter no mínimo teto(m/2) - 1 chaves;
- Todas as folhas devem estar no mesmo nível;
- Se n >= 1, então para qualquer n-chave de altura h e grau mínimo >= 2, h >= logt (n+1)/2

### 5.2 Operações
#### 5.2.1 Inserção
1. Varrer a árvore até encontrar a folha apropriada para a inserção. A chave a ser inserido deve ser comparado com as chaves de cada nó, seguindo o mesmo príncipio da árvore binária de busca ao passar para o próximo nó;
2. Se a folha contém menos do que n - 1 chaves, inserir a nova chave em ordem crescente;
3. Senão, inserir a chave em ordem crescente, dividir o nó ao meio, criando dois novos nós, e subir o elemento mediano para o nó pai do nó atual;
4. Se o nó pai infringir a propriedade da árvore, repetir o passo 3;

#### 5.2.2 Deleção
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

### 5.3 Aplicações
- Otimizar o tempo de acesso a memória secundária (arquivos de sistema e bancos de dados);
    - Consequencia do maior número de chaves que cada nó da árvore pode armazenar, o que reduz a altura da árvore e aumenta a velocidade de operaçoes como inserçao e deleçao;
