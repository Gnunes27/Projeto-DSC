
# Especificação de Requisitos Funcionais - Sistema de Gestão de Livraria

## REQUISITOS

### REQUISITOS FUNCIONAIS

#### RF01. O sistema deve permitir a compra de livros.
- Usuário: Cliente.

- Descrição: O sistema deve permitir a compra de livros disponíveis no catálogo da loja, para usuários autenticados, informando ao cliente o preço individual de cada livro além do preço total
  da compra.

- Fontes: Equipe de Desenvolvimento de Software.

- Informações de entrada: Livros a serem comprados.

- Informações de saída: Preço total da venda, livro em pdf.

- Requisitos não funcionais relacionados: RNF01.
 
#### RF02. O sistema deve permitir o acesso de um cliente aos serviços mesmo sem estar logado.
- Usuário: Cliente.
  
- Descrição: O usuário deve ser capaz de navegar e acessar os serviços ofertados pelo sistema, com exceção da compra, sem a necessidade de autenticação.

- Fontes: Equipe de Desenvolvimento de Software.

- Informações de entrada: Nda.

- Informações de saída: Nda.

- Requisitos não funcionais relacionados: RNF04.

#### RF03. O sistema deve possuir um sistema de promoções.
- Usuário: Administrador, Cliente.
  
- Descrição: O sistema deve permitir que diferentes livros possam estar disponíveis com diferentes tipos de promoções. Essas promoções devem ser gerenciadas pelo administrador de maneira que permita o controle de quais livros estão em promoção e até quanto tempo, além de ser possível definir uma quantidade limitada de compras de livros ofertadas em promoções. Além disso, o sistema deve permitir a visualização do tempo e quantidade restante da promoção ofertada.

- Fontes: Equipe de Desenvolvimento de Software. 

- Informações de entrada: livros desejados para entrarem em promoção, quantidade limitada de livros em promoção.

- Informações de saída: livros em promoção.

- Requisitos não funcionais relacionados: Nda.

#### RF04. O sistema deve exibir o relatório de quanto foi faturado em um período especificado.
- Usuário: Administrador.
  
- Descrição: Deve ser permitido a visualização, pelo administrador, do total arrecadado em um período de tempo especificado pelo administrador.

- Fontes: Equipe de Desenvolvimento de Software. 

- Informações de entrada: Período de tempo desejado.

- Informações de saída: Total arrecadado no tempo especificado.

- Requisitos não funcionais relacionados: Nda.

#### RF05. O sistema deve mostrar quais foram os livros mais vendidos de um período especificado.
- Usuário: Administrador.
  
- Descrição: O sistema deve ser capaz de exibir uma quantidade de livros mais vendidos em um período. O administrador deve ser capaz de escolher a quantidade de livros exibida além do período desejado para a visualização.  

- Fontes: Equipe de Desenvolvimento de Software.

- Informações de entrada: Quantidade de livros, período de tempo desejado.

- Informações de saída: livros em ordem do mais vendido para o menos vendido.

- Requisitos não funcionais relacionados: Nda.

#### RF06. O sistema deve exibir quais foram os livros menos vendidos de um período especificado.
- Usuário: Administrador.
  
- Descrição: O sistema deve exibir uma quantidade de livros em um período de tempo, especificados pelo administrador, que obtiveram o menor número de vendas.

- Fontes: Equipe de Desenvolvimento de Software. 

- Informações de entrada: Quantidade de livros, período específico.

- Informações de saída: Livros em ordenados dos menos vendidos.

- Requisitos não funcionais relacionados: Nda.

#### RF07. O sistema deve exibir quantas vezes cada livro foi vendido, o preço da unidade e o total vendido.
- Usuário: Administrador.
  
- Descrição: O sistema deve permitir a visualização da quantidade vendida, o preço de cada unidade e o valor total vendido de cada livro.

- Fontes: Equipe de Desenvolvimento de Software. 

- Informações de entrada: Nda.

- Informações de saída: Nda.

- Requisitos não funcionais relacionados: Nda.

#### RF08. O sistema deve ser capaz de armazenar livros dentro de um carrinho de compras.
- Usuário: Cliente.
  
- Descrição: O sistema deve permitir o armazenamento de livros a serem comprados, em carrinhos de compra. 

- Fontes: Equipe de Desenvolvimento de Software.

- Informações de entrada: Livros desejados para compra.

- Informações de saída: Carrinho com livros escolhidos.

- Requisitos não funcionais relacionados: RNF07.

#### RF09.  Dentro do sistema deve ser possível avaliar os livros disponíveis no catálogo.
- Usuário: Cliente.
  
- Descrição: O sistema deve permitir que o cliente avalie livros de sua escolha.

- Fontes: Equipe de Desenvolvimento de Software.

- Informações de entrada: Livro escolhido para a avaliação, texto da avaliação, nota do usuário.

- Informações de saída: Avaliação do usuário com nota escolhida.

- Requisitos não funcionais relacionados: RNF04, RNF07. 

#### RF10. O sistema deve permitir a exclusão de avaliações.
- Usuário: Administrador, Cliente.
  
- Descrição: O administrador deve ser capaz de excluir qualquer avaliação dos clientes. Os clientes têm a possibilidade de excluir a própria avaliação.

- Fontes: Equipe de Desenvolvimento de Software.

- Informações de entrada: Avaliação que deseja ser excluída.

- Informações de saída: Avaliação excluída do sistema.

- Requisitos não funcionais relacionados: RNF02, RNF07, RNF08.

#### RF11. O sistema deve permitir a edição de avaliações.
- Usuário: Cliente.
  
- Descrição: Os clientes possuem a possibilidade de editar a própria avaliação.

- Fontes: Equipe de Desenvolvimento de Software.

- Informações de entrada: Avaliação que deseja ser editada, comentário editado, nota editada.

- Informações de saída: Avaliação editada no sistema.

- Requisitos não funcionais relacionados: RNF09.

#### RF12.  O sistema deve permitir dois níveis de acesso diferentes, administrador e cliente.
- Usuário: Administrador, Cliente.
  
- Descrição: O administrador, quando realizar a autenticação usando suas credenciais, deve ser capaz de usar os serviços específicos à ele. O cliente quando
realizar sua autenticação deve ser capaz de realizar as ações e acessar serviços que são específicos à ele.

- Fontes: Equipe de Desenvolvimento de Software.

- Informações de entrada: Nome de usuário e senha.

- Informações de saída: Login do usuário.

- Requisitos não funcionais relacionados: RNF01, RNF02. 

#### RF13. O sistema deve permitir que novos livros possam ser adicionados ao catálogo do sistema.
- Usuário: Administrador.
  
- Descrição: O administrador deve ser capaz de adicionar novos livros ao catálogo do sistema.

- Fontes: Equipe de Desenvolvimento de Software.

- Informações de entrada: Nome do livro, ISBN do livro, categorias, autor, ano de publicação

- Informações de saída: Livro adicionado no catálogo do sistema.

- Requisitos não funcionais relacionados: RNF05.

#### RF14. O sistema deve permitir a remoção de livros no catálogo do sistema.
- Usuário: Administrador.
  
- Descrição:

- Fontes:

- Informações de entrada:

- Informações de saída:

- Requisitos não funcionais relacionados: 
 
#### RF15. Deve ser possível excluir uma conta de cliente do sistema.
- Usuário: Administrador, Cliente.
  
- Descrição: O administrador deve conseguir excluir a conta de qualquer cliente. O cliente deve ser capaz de excluir somente a própria conta.

- Fontes:

- Informações de entrada:

- Informações de saída:

- Requisitos não funcionais relacionados: 

#### RF16. O sistema deve possuir uma interface simples contendo uma área para as informações da conta do cliente, uma área para pesquisa de livros e uma página principal.
- Usuário: Cliente.
  
- Descrição:

- Fontes:

- Informações de entrada:

- Informações de saída:

- Requisitos não funcionais relacionados: 

#### RF17. O sistema deve disponibilizar a visualização dos 10 livros mais comprados da semana.
- Usuário: Cliente.
  
- Descrição:

- Fontes:

- Informações de entrada:

- Informações de saída:

- Requisitos não funcionais relacionados: 

#### RF18. O sistema deve disponibilizar a visualização dos 5 livros mais comprados das três categorias mais compradas.
- Usuário: Cliente.
  
- Descrição:

- Fontes:

- Informações de entrada:

- Informações de saída:

- Requisitos não funcionais relacionados: 

#### RF19. O sistema deve permitir a visualização dos dados dos clientes, com exceção de senha e informações de cartão de crédito.
- Usuário: Administrador.
  
- Descrição:

- Fontes:

- Informações de entrada:

- Informações de saída:

- Requisitos não funcionais relacionados: 

#### RF20. O sistema deve permitir que cada livro tenha mais de uma categoria atribuída à ele.
- Usuário: Cliente.
  
- Descrição:

- Fontes:

- Informações de entrada:

- Informações de saída:

- Requisitos não funcionais relacionados: 

#### RF21. O sistema deve permitir a busca de livros com base em categorias especificadas.
- Usuário: Cliente, Administrador.
  
- Descrição: Deve ser especificado as categorias que serão pesquisadas no sistema. Logo após isso o sistema deve retornar quais são os livros que possuem
as categorias escolhidas.

- Fontes:

- Informações de entrada:

- Informações de saída:

- Requisitos não funcionais relacionados: 

#### RF22. O sistema deve permitir a busca por nomes de livros.
- Usuário: Cliente, Administrador.
  
- Descrição:

- Fontes:

- Informações de entrada:

- Informações de saída:

- Requisitos não funcionais relacionados: 

#### RF23. O sistema deve conter opções relacionadas ao cliente.
- Usuário: Cliente.
  
- Descrição: O sistema deverá conter uma opção de excluir a conta e ver avaliações feitas pelo cliente.

- Fontes:

- Informações de entrada:

- Informações de saída:

- Requisitos não funcionais relacionados: 

### REQUISITOS NÃO FUNCIONAIS

#### RNF01. O sistema deve possuir um meio de autenticação.
- Descrição: O ator deve informar suas credenciais e o sistema deve identificar se essas credenciais estão corretas concedendo, ou impedindo, o acesso.

#### RNF02. Somente o administrador deve possuir acesso à serviços internos do sistema.
- Descrição: Somente o administrador pode conseguir acessar os serviços internos do sistema como RF04, RF05, RF06 entre outros.

#### RNF03. Não deve ser permitida a venda de livros sem que o usuário esteja devidamente autenticado.

#### RNF04. Não deve ser permitido a publicação de avaliações sem a autenticação do cliente.

#### RNF05. O sistema não deve permitir a adição de dois livros iguais no catálogo.

#### RNF06. Cada usuário possui um carrinho de compras pessoal inacessível pelos demais usuários.

#### RNF07. O sistema não deve permitir duas avaliações em um mesmo livro por um mesmo cliente.

#### RNF08. O sistema não deve permitir que um cliente exclua uma avaliação que não seja a própria.

#### RNF09. O sistema não deve permitir a edição de uma avaliação que não seja publicada pelo próprio cliente.

### REQUISITOS SUPLEMENTARES

#### RS01. O sistema deve armazenar as senhas dos usuários criptografadas.


