
# CASOS DE USO EXPANDIDOS

## UC1. Registrar Venda

### PRÉ-CONDIÇÕES
RS02. O ator deve informar suas credenciais e o sistema deve identificar se essas credenciais estão corretas concedendo, ou impedindo, o acesso.

### FLUXO PRINCIPAL

- 1\. [IN] Cliente informa sua identificação.
- 2\. [OUT] Sistema informa os livros disponíveis para compra (título, categoria).
- 3\. [IN] Cliente escolhe um livro.
- 4\. [OUT] Sistema informa os detalhes sobre o livro (título, autor, categoria, preço).
- 5\. [IN] Cliente escolhe comprar o livro.
- 6\. [OUT] Sistema informa os meios de pagamento.
- 7\. [IN] Cliente seleciona um meio de pagamento e efetua a compra.
- 8\. [OUT] Sistema informa a confirmação da compra.

### FLUXOS DE VARIANTES

#### Variante 5.1: Guardar no carrinho
- 5.1.1 [IN] Cliente escolhe guardar o livro no carrinho de compras.

#### Variante 3.2: Comprar livros do carrinho
- 3.1.1 [IN] Cliente escolhe comprar os livros armazenados no carrinho.
Avança para o passo 6 do fluxo principal.

### EXCEÇÕES 

## UC2. Manter Avaliações

### PRÉ-CONDIÇÕES
RS02. O ator deve informar suas credenciais e o sistema deve identificar se essas credenciais estão corretas concedendo, ou impedindo, o acesso.

### FLUXO PRINCIPAL

- 1\. [IN] Cliente informa sua identificação.
- 2\. [OUT] Sistema exibe os livros comprados anteriormente e que não possuem avaliação feita pelo cliente.
- 3\. [IN] Cliente informa o livro para ser feita a avaliação.
- 4\. [OUT] Sistema exibe a interface de avaliação (nota, comentário).
- 5\. [IN] Cliente informa a nota e o comentário.
- 6\. [OUT] Sistema informa o registro da avaliação.

### FLUXOS DE VARIANTES

### EXCEÇÕES 

## UC3. Consultar Catálogo

### PRÉ-CONDIÇÕES

### FLUXO PRINCIPAL

- 1\. [IN] Cliente informa as opções para a consulta do catálogo (título, categorias);
- 2\. [OUT] Sistema exibe todos os livros que apresentam as características informadas pelo cliente de forma reduzida (capa e título);
- 3\. [IN] Cliente informa o livro desejado da consulta.
- 4\. [OUT] Sistema exibe as informações completas do livro selecionado (título, categorias, preço, avaliações).

### FLUXOS DE VARIANTES

### EXCEÇÕES

## UC4. Manter Conta

### PRÉ-CONDIÇÕES
RS02. O ator deve informar suas credenciais e o sistema deve identificar se essas credenciais estão corretas concedendo, ou impedindo, o acesso.

### FLUXO PRINCIPAL

- 1\. [IN] Cliente informa sua identificação.
- 2\. [OUT] Sistema exibe as informações e opções do cliente (nome de usuário, avaliações, opção de excluir conta).
- 3\. [IN] Cliente escolhe a opção de excluir conta.
- 4\. [OUT] Sistema informa os dados da conta que serão excluídos.
- 5\. [IN] Cliente informa a confirmação de exclusão da conta.
- 6\. [OUT] Sistema informa a exclusão da conta no sistema.

### FLUXOS DE VARIANTES

### EXCEÇÕES

## UC5. Exibir Relatório

### PRÉ-CONDIÇÕES
RS02. O ator deve informar suas credenciais e o sistema deve identificar se essas credenciais estão corretas concedendo, ou impedindo, o acesso.

### FLUXO PRINCIPAL 

- 1\. [IN] Administrador informa sua identificação.
- 2\. [OUT] Sistema exibe as opções de relatório.
- 3\. [IN] Administrador escolhe saber quanto foi faturado com as vendas.
- 4\. [OUT] Sistema informa as opções de pesquisa (período a ser analisado, forma de ordenação dos livros).
- 5\. [IN] Administrador informa o período e a ordenação dos livros pelos mais vendidos.
- 6\. [OUT] Sistema exibe o quanto foi faturado no período especificado informando os detalhes das vendas (título do livro, ISBN, quantidade vendida de cada livro, valor individual de cada livro, valor total vendido de cada livro).

### FLUXOS DE VARIANTES

#### Variante 5.1: Ordenar pelo menos vendido
- 5.1.1 [IN] Administrador escolhe ordenar pelos livros menos vendidos.
- 5.1.2 [OUT] Sistema exibe os livros, ordenando do menos vendido até o mais vendido.
Avança para o passo 6 do fluxo principal.

### EXCEÇÕES

## UC6. Gerenciar Catálogo

### PRÉ-CONDIÇÕES
RS02. O ator deve informar suas credenciais e o sistema deve identificar se essas credenciais estão corretas concedendo, ou impedindo, o acesso.

### FLUXO PRINCIPAL

- 1\. [IN] Administrador informa sua identificação.
- 2\. [OUT] Sistema exibe as opções disponíveis para gerenciar o catálogo.
- 3\. [IN] Administrador escolhe adicionar um livro no catálogo informando título do livro, ISBN, categorias, autor e ano de publicação.
- 4\. [OUT] Sistema informa a confirmação da adição do livro no catálogo.

### FLUXOS DE VARIANTES

#### Variante 3.1: Excluir do catálogo

- 3.1.1 [IN] Administrador escolhe excluir livros do catálogo.
- 3.1.2 [OUT] Sistema informa os livros disponíveis no catálogo para serem excluídos.
- 3.1.3 [IN] Administrador informa os livros que deseja excluir.
- 3.1.4 [OUT] Sistema exibe mensagem de confirmação de exclusão dos livros selecionados.
- 3.1.5 [IN] Administrador confirma a exclusão.
- 3.1.6 [OUT] Sistema informa a confirmação de exclusão dos livros.

### EXCEÇÕES

## UC7. Gerenciar Avaliações

### PRÉ-CONDIÇÕES
RS02. O ator deve informar suas credenciais e o sistema deve identificar se essas credenciais estão corretas concedendo, ou impedindo, o acesso.

### FLUXO PRINCIPAL

- 1\. [IN] Administrador informa sua identificação.
- 2\. [OUT] Sistema informa as opções para gerenciar as avaliações.
- 3\. [IN] Administrador escolhe excluir avaliações de clientes.
- 4\. [OUT] Sistema informa as avaliações disponíveis para serem excluídas.
- 5\. [IN] Administrador informa as avaliações que deseja excluir e efetua a operação.
- 6\. [OUT] Sistema informa a confirmação de exclusão das avaliações.

### FLUXOS DE VARIANTES

### EXCEÇÕES

## UC8. Gerenciar Contas

### PRÉ-CONDIÇÕES

### FLUXO PRINCIPAL

- 1\. [IN] Administrador informa sua identificação.
- 2\. [OUT] Sistema informa as opções disponíveis para o gerenciamento de contas.
- 3\. [IN] Administrador escolhe excluir contas de clientes.
- 4\. [OUT] Sistema informa as contas disponíveis para exclusão.
- 5\. [IN] Administrador informa as contas que deseja excluir e efetua a operação.
- 6\. [OUT] Sistema informa a confirmação de exclusão das contas selecionadas.

### FLUXOS DE VARIANTES

### EXCEÇÕES
