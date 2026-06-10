# Especificação de Requisitos Funcionais - Sistema de Gestão de Livraria

## REQUISITOS

### REQUISITOS FUNCIONAIS

#### RF01. O sistema deve permitir a compra de livros.
- Usuário: Cliente.
  
#### RF02. O sitema deve permitir o acesso de um cliente aos serviços mesmo sem estar logado.
- Usuário: Cliente.

#### RF03. O sistema deve possuir um sistema de promoções.
- Usuário: Administrador, Cliente.

#### RF04. O sistema deve exibir o relatório de quanto foi faturado em uma período especificado.
- Usuário: Administrador.

#### RF05. O sistema deve mostrar quais foram os livros mais vendidos de um período especificado.
- Usuário: Administrador.

#### RF06. O sistema deve exibir quais foram os livros menos vendidos de um período especificado.
- Usuário: Administrador.

#### RF07. O sistema deve exibir quantas vezes cada livro foi vendido, o preço da unidade e o total ganho.
- Usuário: Administrador.

#### RF08. O sistema deve ser capaz de armazenar livros dentro de um carrinho de compras.
- Usuário: Cliente.

#### RF09. O sistema deve ser capaz de listar todos os livros disponíveis no catálogo.
- Usuário: Cliente, Administrador.

#### RF10.  Dentro do sistema deve ser possível avaliar os livros disponíveis no catálogo.
- Usuário: Cliente.

#### RF11. O sistema deve permitir a exclusão avaliações.
- Usuário: Administrador, Cliente.

- Descrição: O administrador deve ser capaz de excluir qualquer comentário dos clientes. Os clientes tem a possibilidade de excluir o próprio comentário.

#### RF12. O sistema deve permitir a edição de avaliações.
- Usuário: Cliente, Administrador.

- Descrição: O administrador deve ser capaz de editar os comentários de clientes. Os clientes possuem a possibiliade de editar o próprio comentário.

#### RF13.  O sistema deve permitir dois níveis de acesso diferentes, administrador e cliente.
- Usuário: Administrador, Cliente.

- Descrição: O administrador, quando realizar a autenticação usando suas credenciais, deve ser capaz de usar os serviços específicos à ele. O cliente quando
realizar sua autenticação deve ser capaz de realizar as ações e acessar serviços que são específicos à ele.

#### RF14. O sistema deve permitir que novos livros possam ser adicionados ao catálogo do sistema.
- Usuário: Administrador.

#### RF15. O sistema deve permitir a remoção de livros no catálogo do sistema.
- Usuário: Administrador.
  
#### RF16. Deve ser possível excluir uma conta de cliente do sistema.
- Usuário: Administrador, Cliente.

- Descrição: O administrador deve conseguir excluir a conta de qualquer cliente. O cliente deve ser capaz de excluir somente a própria conta.

#### RF17. O sistema deve possuir uma interface simples contendo uma aba para a conta do cliente, uma aba para pesquisa de livros e a página principal.
- Usuário: Cliente.

#### RF18. A página principal do sistema deve conter os livros mais comprados da semana em destaque.
- Usuário: Cliente.

#### RF19. Na página principal do sistema deve conter listas com alguns dos livros mais comprados das três categorias mais compradas.
- Usuário: Cliente.

#### RF20. O sistema deve possuir uma parte dedicada para suporte, com um guia sobre as principais funcionalidades do site.
- Usuário: Cliente.

#### RF21. O sistema deve permitir a visualização dos dados dos clientes, com exceção de senha e informações de cartão de crédito.
- Usuário: Administrador.

#### RF22. O sistema deve permitir que cada livro tenha mais de uma categoria atribuída à ele.
- Usuário: Cliente.

#### RF23. O sistema deve permitir a busca de livros com base em categorias especificadas.
- Usuário: Cliente, Administrador.

- Descrição: Deve ser especificado as categorias que serão pesquisadas no sistema. Logo após isso o sistema deve retornar quais são os livros que possuem
as categorias escolhidas.

#### RF24. O sistema deve permitir a busca por nomes de livros.
- Usuário: Cliente, Administrador.



