
# CASOS DE USO EXPANDIDOS

## UC1. Registrar Venda

### FLUXO PRINCIPAL

- 1\. [IN] Cliente informa sua identificação.<br>
- 2\. [OUT] Sistema disponibiliza o carrinho e a possibilidade de compra.<br>
- 3\. [IN] Cliente informa o livro que deseja comprar.<br>
- 4\. [OUT] Sistema exibe o valor total da compra.<br>
- 5\. [IN] Cliente aceita o valor da compra.<br>
- 6\. [OUT] Sistema apresenta as opções de pagamento.<br>
- 7\. [IN] Cliente informa o meio de pagamento.<br>
- 8\. [OUT] Sistema solicita a confirmação de pagamento.<br>
- 9\. [IN] Cliente insere as informações e aceita o pagamento.<br>
- 10\. [OUT] Sistema confirma o pagamento e exibe a confirmação de compra.<br>

### EXCEÇÕES 

#### 1a Cliente não autenticado. 

### FLUXOS ALTERNATIVOS

#### Variante 2.1: Guardar no carrinho
- 2.1.1 [IN] Cliente decide guardar o livro no carrinho de compras.
- 2.1.2 [OUT] Sistema exibe confirmação de que o livro foi armazenado no carrinho.

#### Variante 2.2: Comprar livros do carrinho
- 2.2.1 [IN] Cliente escolhe comprar os livros armazenados no carrinho.
Avança para o passo 4 do fluxo principal.

#### Variante 

## UC2. Manter Avaliações

### FLUXO PRINCIPAL

- 1\. [IN] Cliente informa sua identificação.
- 2\. [OUT] Sistema exibe os livros comprados anteriormente e que não possuem avaliação feita pelo cliente.
- 3\. [IN] Cliente informa o livro para ser feita a avaliação.
- 4\. [OUT] Sistema exibe a interface de avaliação (nota de 1 a 5 estrelas, comentário).
- 5\. [IN] Cliente informa a nota e o comentário.
- 6\. [OUT] Sistema exibe a confirmação de que a avaliação foi efetuada.

### EXCEÇÕES 

### FLUXOS ALTERNATIVOS

## UC3. Consultar Catálogo

### FLUXO PRINCIPAL

- 1\. [IN] Cliente informa as opções para a consulta do catálogo (título, categorias);
- 2\. [OUT] Sistema exibe todos os livros que apresentam as características informadas pelo cliente de forma reduzida (capa e título);
- 3\. [IN] Cliente informa o livro desejado da consulta.
- 4\. [OUT] Sistema exibe as informações completas do livro selecionado (título, categorias, preço, avaliações).

### EXCEÇÕES

### FLUXOS ALTERNATIVOS

## UC4. Manter Conta

### FLUXO PRINCIPAL

- 1\. [IN] Cliente informa sua identificação.
- 2\. [OUT] Sistema exibe as informações e opções do cliente (nome de usuário, avaliações, opção de excluir conta).
- 3\. [IN] Cliente escolhe a opção de excluir conta.
- 4\. [OUT] Sistema exibe uma mensagem de confirmação indicando que a conta será permanentemente excluída e aguarda a senha do usuário.
- 5\. [IN] Cliente informa a senha da conta.
- 6\. [OUT] Sistema exibe a mensagem de confirmação de exclusão de conta.

### EXCEÇÕES

### FLUXOS ALTERNATIVOS 

## UC5. Exibir Relatório

### FLUXO PRINCIPAL 

- 1\. [IN] Administrador informa sua identificação.
- 2\. [OUT] Sistema exibe as opções de relatório.
- 3\. [IN] Administrador escolhe saber quanto foi faturado com as vendas.
- 4\. [OUT] Sistema solicita o período que deseja ser observado.
- 5\. [IN] Administrador informa a data.
- 6\. [OUT] Sistema exibe o quanto foi faturado no período especificado informando os detalhes das vendas (nome do livro, ISBN, quantidade vendida de cada livro, valor individual do livro, valor total vendido).

### EXCEÇÕES

### FLUXOS ALTERNATIVOS 

#### Variante 6.1: Ordenar por mais vendido
- 6.1.1 [IN] Administrador escolhe ordenar pelos livros mais vendidos.
- 6.1.2 [OUT] Sistema exibe os livros com os detalhes das vendas, ordenando do mais vendido até o menos vendido.

#### Variante 6.2: Ordenar pelo menos vendido
- 6.2.1 [IN] Administrador escolhe ordenar pelos livros menos vendidos.
- 6.2.2 [OUT] Sistema exibe os livros com os detalhes das vendas, ordenando do menos vendido até o mais vendido.

## UC6. Gerenciar Catálogo

### FLUXO PRINCIPAL

- 1\. [IN] Administrador informa sua identificação.
- 2\. [OUT] Sistema exibe as opções disponíveis para gerenciar o catálogo.
- 3\. [IN] Administrador escolhe adicionar um livro no catálogo.
- 4\. [OUT] Sistema solicita as informações do livro (título do livro, ISBN, categorias, autor, ano de publicação).
- 5\. [IN] Administrador informa os dados necessários e confirma a adição do livro ao catálogo.
- 6\. [OUT] Sistema exibe a confirmação de que o livro foi adicionado ao catálogo.

### EXCEÇÕES

### FLUXOS ALTERNATIVOS 

#### Variante 2.1: Excluir do catálogo

- 2.1.1 [IN] Administrador escolhe excluir livros do catálogo.
- 2.1.2 [OUT] Sistema informa os livros disponíveis no catálogo para serem excluídos.
- 2.1.3 [IN] Administrador informa os livros que deseja excluir.
- 2.1.4 [OUT] Sistema exibe mensagem de confirmação de exclusão dos livros selecionados.
- 2.1.5 [IN] Administrador confirma a exclusão.
- 2.1.6 [OUT] Sistema exibe a confirmação de exclusão dos livros.


## UC7. Gerenciar Avaliações

### FLUXO PRINCIPAL

- 1\. [IN] Administrador informa sua identificação.
- 2\. [OUT] Sistema informa as opções para gerenciar as avaliações.
- 3\. [IN] Administrador escolhe excluir avaliações de clientes.
- 4\. [OUT] Sistema informa as avaliações disponíveis para serem excluídas.
- 5\. [IN] Administrador informa as avaliações que deseja excluir.
- 6\. [OUT] Sistema exibe a mensagem de confirmação de exclusão das avaliações selecionadas.
- 7\. [IN] Administrador confirma a exclusão das avaliações.
- 8\. [OUT] Sistema exibe a confirmação de exclusão das avaliações.

### EXCEÇÕES

### FLUXOS ALTERNATIVOS

## UC8. Gerenciar Contas

### FLUXO PRINCIPAL

- 1\. [IN] Administrador informa sua identificação.
- 2\. [OUT] Sistema exibe as opções disponíveis para o gerenciamento de contas.
- 3\. [IN] Administrador escolhe excluir contas de clientes.
- 4\. [OUT] Sistema informa as contas disponíveis para exclusão.
- 5\. [IN] Administrador informa as contas que deseja excluir.
- 6\. [OUT] Sistema exibe a mensagem de confirmação de exclusão das contas.
- 7\. [IN] Administrador confirma a exclusão das contas.
- 8\. [OUT] Sistema exibe a confirmação de exclusão das contas selecionadas.

### EXCEÇÕES

### FLUXOS ALTERNATIVOS
