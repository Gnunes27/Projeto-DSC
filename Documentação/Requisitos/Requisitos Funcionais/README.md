
# Especificação de Requisitos Funcionais - Sistema de Gestão de Livraria

## REQUISITOS

### REQUISITOS FUNCIONAIS

#### RF01. O sistema deve permitir a compra de livros.
- Usuário: Cliente.
 
#### RF02. O sistema deve permitir o acesso de um cliente aos serviços mesmo sem estar logado.
- Usuário: Cliente.

#### RF03. O sistema deve possuir um sistema de promoções.
- Usuário: Administrador, Cliente.

#### RF04. O sistema deve exibir o relatório de quanto foi faturado em um período especificado.
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

#### RF11. O sistema deve permitir a exclusão de avaliações.
- Usuário: Administrador, Cliente.

- Descrição: O administrador deve ser capaz de excluir qualquer comentário dos clientes. Os clientes têm a possibilidade de excluir o próprio comentário.

#### RF12. O sistema deve permitir a edição de avaliações.
- Usuário: Cliente, Administrador.

- Descrição: O administrador deve ser capaz de editar os comentários de clientes. Os clientes possuem a possibilidade de editar o próprio comentário.

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

#### RF17. O sistema deve possuir uma interface simples contendo uma área para as informações da conta do cliente, uma área para pesquisa de livros e uma página principal.
- Usuário: Cliente.

#### RF18. O sistema deve disponibilizar a visualização dos 10 livros mais comprados da semana.
- Usuário: Cliente.

#### RF19. O sistema deve disponibilizar a visualização dos 5 livros mais comprados das três categorias mais compradas.
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

#### RF25. O sistema deve conter opções relacionadas ao cliente.
- Usuário: Cliente.

- Descrição: O sistema deverá conter uma opção de excluir a conta e ver avaliações feitas pelo cliente.

### REQUISITOS NÃO FUNCIONAIS

#### RNF01. O sistema deve possuir um meio de autenticação.
- Descrição: O ator deve informar suas credenciais e o sistema deve identificar se essas credenciais estão corretas concedendo, ou impedindo, o acesso.

#### RNF02. Somente o administrador deve possuir acesso à serviços internos do sistema.
- Descrição: Somente o administrador pode conseguir acessar os serviços internos do sistema como RF04, RF05, RF06 entre outros.

#### RNF03. Permitir a autenticação do usuário em um tempo de 10 segundos.

#### RNF04. Não deve ser permitida a venda de livros sem que o usuário esteja devidamente autenticado.

#### RNF05. Não deve ser permitido a publicação de avaliações sem a autenticação do cliente.

#### RNF06. O sistema não deve permitir a adição de dois livros iguais no catálogo.

### REQUISITOS SUPLEMENTARES

#### RS01. O sistema deve armazenar as senhas dos usuários criptografadas.
