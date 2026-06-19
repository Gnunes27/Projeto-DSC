# CASOS DE USO EXPANDIDOS

## UC1. Registrar Venda

### FLUXO PRINCIPAL

- 1\. [IN] Cliente informar sua identificação.<br>
- 2\. [OUT] Sistema disponibiliza a opção de compra.<br>
- 3\. [IN] Cliente informa o livro que deseja comprar.<br>
- 4\. [OUT] Sistema exibe o valor total do livro.<br>
- 5\. [IN] Cliente aceita o valor da compra.<br>
- 6\. [OUT] Sistema apresenta as opções de pagamento.<br>
- 7\. [IN] Cliente informa o meio de pagamento.<br>
- 8\. [OUT] Sistema solicita a confirmação de pagamento.<br>
- 9\. [IN] Cliente insere as informações e aceita o pagamento.<br>
- 10\. [OUT] Sistema confirma o pagamento e exibe a tela de confirmação de compra.<br>


### EXCEÇÕES 

#### 1a Cliente não autenticado. 

### FLUXOS ALTERNATIVOS

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
