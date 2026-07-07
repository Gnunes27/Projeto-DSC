
# Especificação de Requisitos Funcionais - Sistema de Gestão de Livraria

## REQUISITOS

### REQUISITOS FUNCIONAIS

#### RF01. O sistema deve permitir a compra de livros.
- Usuário: Cliente.

- Descrição: O sistema deve permitir a compra de livros disponíveis no catálogo da loja, para clientes autenticados, informando ao cliente o preço individual de cada livro além do preço total
  da compra.

- Fontes: Equipe de Desenvolvimento de Software.

- Informações de entrada: Livros a serem comprados.

- Informações de saída: Preço total da venda, livro em pdf.

- Requisitos não funcionais relacionados: Nda.
 
#### RF02. O sistema deve permitir o acesso de um cliente aos serviços disponíveis mesmo sem estar logado.
- Usuário: Cliente.
  
- Descrição: O usuário deve ser capaz de navegar e acessar os serviços ofertados pelo sistema, com exceção da compra, sem a necessidade de autenticação.

- Fontes: Equipe de Desenvolvimento de Software.

- Informações de entrada: Nda.

- Informações de saída: Nda.

- Requisitos não funcionais relacionados: RNF04.

#### RF03. O sistema deve possuir um sistema de promoções.
- Usuário: Administrador, Cliente.
  
- Descrição: O sistema deve permitir que o carrinho calcule um desconto baseado na quantidade de livros no carrinho.

- Fontes: Equipe de Desenvolvimento de Software. 

- Informações de entrada: livros desejados para entrarem em promoção, quantidade limitada de livros em promoção.

- Informações de saída: livros em promoção.

- Requisitos não funcionais relacionados: Nda.

#### RF04. O sistema deve exibir o relatório do faturamento total e mensal, alem do historico de vendas
- Usuário: Administrador.
  
- Descrição: Deve ser permitido a visualização do total arrecadado com as vendas.

- Fontes: Equipe de Desenvolvimento de Software. 

- Informações de entrada: Período de tempo desejado.

- Informações de saída: Total arrecadado no tempo especificado.

- Requisitos não funcionais relacionados: RNF01.

#### RF05. O sistema deve mostrar quais foram os livros mais vendidos.
- Usuário: Administrador.
  
- Descrição: O sistema deve ser capaz de exibir uma quantidade de livros mais vendidos em um período. O administrador deve ser capaz de escolher a quantidade de livros exibida além do período desejado para a visualização.  

- Fontes: Equipe de Desenvolvimento de Software.

- Informações de entrada: Quantidade de livros, período de tempo desejado.

- Informações de saída: livros em ordem do mais vendido para o menos vendido.

- Requisitos não funcionais relacionados: RNF01.

#### RF06. O sistema deve exibir quais foram os livros menos vendidos.
- Usuário: Administrador.
  
- Descrição: O sistema deve exibir uma quantidade de livros em um período de tempo, especificados pelo administrador, que obtiveram o menor número de vendas.

- Fontes: Equipe de Desenvolvimento de Software. 

- Informações de entrada: Quantidade de livros, período específico.

- Informações de saída: Livros em ordenados dos menos vendidos.

- Requisitos não funcionais relacionados: RNF01.

#### RF07. O sistema deve exibir quantas vezes cada livro foi vendido, o preço da unidade e o total vendido.
- Usuário: Administrador.
  
- Descrição: O sistema deve permitir a visualização da quantidade vendida, o preço de cada unidade e o valor total vendido de cada livro.

- Fontes: Equipe de Desenvolvimento de Software. 

- Informações de entrada: Nda.

- Informações de saída: Nda.

- Requisitos não funcionais relacionados: RNF01.

#### RF08. O sistema deve ser capaz de armazenar livros dentro de um carrinho de compras.
- Usuário: Cliente.
  
- Descrição: O sistema deve permitir o armazenamento de livros a serem comprados, em carrinhos de compra. 

- Fontes: Equipe de Desenvolvimento de Software.

- Informações de entrada: Livros desejados para compra.

- Informações de saída: Carrinho com livros escolhidos.

- Requisitos não funcionais relacionados: RNF07.

#### RF9.  O sistema deve permitir dois níveis de acesso diferentes, administrador e cliente.
- Usuário: Administrador, Cliente.
  
- Descrição: O administrador, quando realizar a autenticação usando suas credenciais, deve ser capaz de usar os serviços específicos à ele. O cliente quando
realizar sua autenticação deve ser capaz de realizar as ações e acessar serviços que são específicos à ele.

- Fontes: Equipe de Desenvolvimento de Software.

- Informações de entrada: Nome de usuário e senha.

- Informações de saída: Login do usuário.

- Requisitos não funcionais relacionados: RNF02. 

#### RF10. O sistema deve permitir que novos livros possam ser adicionados ao catálogo do sistema.
- Usuário: Administrador.
  
- Descrição: O administrador deve ser capaz de adicionar novos livros ao catálogo do sistema.

- Fontes: Equipe de Desenvolvimento de Software.

- Informações de entrada: Título do livro, ISBN do livro, categorias, autor, ano de publicação

- Informações de saída: Livro adicionado no catálogo do sistema.

- Requisitos não funcionais relacionados: RNF01, RNF05.

#### RF11. O sistema deve permitir a remoção de livros no catálogo do sistema.
- Usuário: Administrador.
  
- Descrição: O administrador deve ser capaz de remover os livros, adicionados no catálogo previamente, do sistema. O administrador deve informar os dados
  sobre o livro que deseja excluir, além de confirmar a exclusão daquele livro.

- Fontes: Equipe de Desenvolvimento de Software.

- Informações de entrada: ISBN do livro.

- Informações de saída: Livro excluído do catálogo.

- Requisitos não funcionais relacionados: RNF01, RNF02.
 
#### RF12. Deve ser possível excluir uma conta de cliente do sistema.
- Usuário: Administrador, Cliente.
  
- Descrição: O administrador deve conseguir excluir a conta de qualquer cliente. O cliente deve ser capaz de excluir a própria conta. Além disso, é necessária a
  confirmação do usuário para a remoção da conta.

- Fontes: Equipe de Desenvolvimento de Software.

- Informações de entrada: Identificação da conta.

- Informações de saída: Cliente removido do sistema.

- Requisitos não funcionais relacionados: RNF10.

#### RF13. O sistema deve possuir uma interface simples contendo uma área para as informações e opções da conta do cliente, o carrinho de compras, uma área para pesquisa de livros e uma página principal.
- Usuário: Cliente.
  
- Descrição: O sistema deve apresentar uma área que forneça as informações e opções da conta do cliente contendo as informações sobre a conta do cliente além de opções relacionadas à ela. Através da área de pesquisa deve ser possível pesquisar os livros por nome, categoria e autor podendo escolher informar uma ou mais dessas informações. A página principal deve conter os principais serviços ofertados pelo sistema.

- Fontes: Equipe de Desenvolvimento de Software.

- Informações de entrada: Nda.

- Informações de saída: Nda.

- Requisitos não funcionais relacionados: Nda.

#### RF14. O sistema deve disponibilizar a visualização dos 10 livros mais vendidos.
- Usuário: Cliente.
  
- Descrição: Deverá ser exibido os 10 livros mais comprados.

- Fontes: Equipe de Desenvolvimento de Software.

- Informações de entrada: Nda.

- Informações de saída: Livros mais comprados na semana.

- Requisitos não funcionais relacionados: Nda.

#### RF15. O sistema deve permitir a visualização dos dados dos clientes com exceção da senha.
- Usuário: Administrador.
  
- Descrição: O administrador deve ser capaz de visualizar os dados dos clientes do sistema, porém, a senha dos usuários deve permanecer desconhecida para o administrador.

- Fontes: Equipe de Desenvolvimento de Software.

- Informações de entrada: Identificação do cliente.

- Informações de saída: Dados do cliente.

- Requisitos não funcionais relacionados: RNF01.


#### RF16. O sistema deve permitir a busca de livros com base em categorias especificadas.
- Usuário: Cliente, Administrador.
  
- Descrição: Deve ser especificado as categorias que serão pesquisadas no sistema. Logo após isso o sistema deve retornar quais são os livros que possuem as categorias escolhidas.

- Fontes: Equipe de Desenvolvimento de Software.

- Informações de entrada: Categorias desejadas.

- Informações de saída: Livros que contém todas essas categorias.

- Requisitos não funcionais relacionados: Nda.

#### RF17. O sistema deve permitir a busca por nomes de livros.
- Usuário: Cliente, Administrador.
  
- Descrição: O sistema deve permitir que o usuário busque por livros, adicionados previamente no catálogo do sistema, informando o nome do livro desejado.

- Fontes: Equipe de Desenvolvimento de Software.

- Informações de entrada: Nome do livro desejado.

- Informações de saída: Livros que contenham o nome informado.

- Requisitos não funcionais relacionados: Nda.

### REQUISITOS NÃO FUNCIONAIS

#### RNF01. Somente o administrador deve possuir acesso à serviços internos do sistema.
- Descrição: Somente o administrador pode conseguir acessar os serviços internos do sistema como RF04, RF05, RF06 entre outros.

#### RNF02. Não deve ser permitida a venda de livros sem que o usuário esteja devidamente autenticado.

#### RNF03. Não deve ser permitido a publicação de avaliações sem a autenticação do cliente.

#### RNF04. O sistema não deve permitir a adição de dois livros iguais no catálogo.

#### RNF05. Cada usuário possui um carrinho de compras pessoal inacessível pelos demais usuários.

#### RNF06. O sistema não deve permitir que um cliente exclua uma conta que não seja a própria.

#### RNF07. O sistema não deve permitir que um livro possua duas categorias iguais.

### REQUISITOS SUPLEMENTARES

#### RS01. O sistema deve armazenar as senhas dos usuários criptografadas.

#### RS02. O sistema deve possuir um meio de autenticação.
- Descrição: O ator deve informar suas credenciais e o sistema deve identificar se essas credenciais estão corretas concedendo, ou impedindo, o acesso.
