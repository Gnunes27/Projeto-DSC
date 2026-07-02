## Documento de visualização dos scripts usados no PlantUML

Este documento apresenta a modelagem visual e arquitetural dos processos do sistema. Utilizando a plataforma web **PlantUML**, foram desenvolvidos os seguintes scripts para a criação de diagramas. 

Abaixo encontra-se os códigos-fonte em formato texto que representam cada caso de uso. Estes scripts podem ser copiados e executados diretamente em qualquer renderizador online do PlantUML para gerar, visualizar ou editar as imagens dos fluxos de interação documentados.

![PlantUML](https://img.shields.io/badge/PlantUML-2A2A2A?style=for-the-badge&logo=plantuml&logoColor=white)
---

### UC1 - Registrar Venda

```plantuml
@startuml
autonumber

actor "Cliente" as Cliente
participant "Interface" as Tela
participant "Sistema" as Sis
database "MySql" as BD

== Passo 1: Identificação e Exceção 1a ==
Cliente -> Tela: Informa identificação
Tela -> Sis: autenticar(identificacao)
Sis -> BD: buscar(identificacao)
BD --> Sis: Retorna dados ou Null

alt Cliente não autenticado (Exceção 1a)
    Sis --> Tela: Retorna erro de autenticação
    Tela --> Cliente: Exibe erro e solicita novo login
    note right: O fluxo é encerrado aqui
else Cliente autenticado com sucesso
    Sis --> Tela: Confirma autenticação
end

== Passo 2: Listar Livros Disponíveis ==
Tela -> Sis: catalogo()
Sis -> BD: SELECT titulo, categoria FROM Livro
BD --> Sis: Return livros
Sis --> Tela: Retorna livros formatados
Tela --> Cliente: Exibe os livros disponíveis

== Passo 3 e Variantes ==
alt Variante 3.2: Comprar livros do carrinho
    Cliente -> Tela: Escolhe comprar itens armazenados no carrinho
    Tela -> Sis: recuperarCarrinho(cliente)
    Sis --> Tela: Retorna itens
    note right of Tela: Pula os passos 4 e 5 e avança direto para o passo 6
    
else Fluxo Principal: Escolher um novo livro
    Cliente -> Tela: Escolhe um livro da lista
    
    == Passo 4: Detalhes do Livro ==
    Tela -> Sis: buscarLivro(idLivro)
    Sis -> BD: SELECT titulo, autor, categoria, preco...
    BD --> Sis: Retorna detalhes 
    Sis --> Tela: Retorna dados do livro
    Tela --> Cliente: Exibe detalhes (título, autor, categoria, preço)
    
    == Passo 5 e Variante 5.1 (Comprar ou Guardar) ==
    alt Variante 5.1: Guardar no carrinho
        Cliente -> Tela: Escolhe guardar o livro no carrinho
        Tela -> Sis: adicionarAoCarrinho(cliente, livro)
        Sis --> Tela: Return true
        Tela --> Cliente: Confirma que foi adicionado ao carrinho
    else Fluxo Principal: Comprar o livro
        Cliente -> Tela: Escolhe comprar o livro imediatamente
    end
end

== Passo 6 e 7: Pagamento ==
Tela -> Sis: solicitarPagamento()
Sis --> Tela: Retorna opções disponíveis
Tela --> Cliente: Informa os meios de pagamento

Cliente -> Tela: Seleciona o meio e efetua a compra
Tela -> Sis: processarCompra(cliente, itens, pagamento)
activate Sis
Sis -> BD: INSERT INTO Venda (Registra a venda)
BD --> Sis: Confirmação de registro
deactivate Sis

== Passo 8: Confirmação ==
Sis --> Tela: Retorna sucesso da transação
Tela --> Cliente: Informa a confirmação da compra

@enduml
```
### UC2: Manter Avaliações

```plantuml
@startuml
autonumber

actor "Cliente" as Cliente
participant "Interface" as Tela
participant "Sistema" as Sis
database "MySql" as BD

Cliente -> Tela: Faz Login
Tela -> Sis: autenticar(cliente)
Sis --> Tela: Cliente autenticado

Cliente -> Tela: Avaliar Livros
Tela -> Sis: buscarLivros(cliente)
activate Sis
Sis -> BD: SELECT livros FROM Vendas WHERE IdCliente = Cliente
BD --> Sis: Retorna lista de livros 
deactivate Sis
Sis --> Tela: Retorna lista 
Tela --> Cliente: Exibe livros comprados

Cliente -> Tela: seleciona o livro 
Tela -> Sis: buscar(idLivro)
Sis --> Tela: Retorna tela de avaliação
Tela --> Cliente: Exibe a interface de avaliação

Cliente -> Tela: Informa a nota e o comentário
Tela -> Sis: registrarAvaliacao(cliente, livro, nota, comentario)
activate Sis
Sis -> BD: INSERT INTO Avaliacao (idLivro, idCliente, nota, comentario)
BD --> Sis: Confirma avaliação
deactivate Sis

Sis --> Tela: Retorna true
Tela --> Cliente: Informa que a avaliação foi registrada

@enduml
```

### UC3: Consultar Catálogo

```plantuml
@startuml
autonumber

actor "Cliente" as Cliente
participant "Interface" as Tela
participant "Sistema" as Sis
database "MySql" as BD

Cliente -> Tela: Informa opções de consulta (título, categorias)
Tela -> Sis: consultarCatalogo(titulo, categorias)
activate Sis
Sis -> BD: SELECT id, titulo FROM Livro WHERE ...
BD --> Sis: Retorna lista de livros
deactivate Sis
Sis --> Tela: Retorna livros
Tela --> Cliente: Exibe livros encontrados

Cliente -> Tela: Informa o livro desejado 
Tela -> Sis: buscar(idLivro)
activate Sis

Sis -> BD: SELECT titulo, nota, preco FROM Livro WHERE id = ?
BD --> Sis: Retorna informações

deactivate Sis
Sis --> Tela: Retorna informações completas 
Tela --> Cliente: Exibe os detalhes do livro

@enduml
```

### UC4: Manter Conta

```plantuml
@startuml
autonumber

actor "Cliente" as Cliente
participant "Interface" as Tela
participant "Sistema" as Sis
database "MySql" as BD

Cliente -> Tela: Informa identificação
Tela -> Sis: autenticar(identificacao)
Sis --> Tela: Cliente autenticado

Tela -> Sis: buscar(cliente)
activate Sis
Sis -> BD: SELECT * FROM Cliente WHERE IdCliente = cliente
BD --> Sis: Retorna cliente
deactivate Sis
Sis --> Tela: Retorna perfil
Tela --> Cliente: Exibe informações e opcões do perfil

Cliente -> Tela: Escolhe a opção de excluir conta
Tela -> Sis: deletar(cliente)
Sis --> Tela: Pede confirmação de segurança
Tela --> Cliente: mostra janela de confimação

Cliente -> Tela: Confirma a exclusão da conta
Tela -> Sis: deletar(cliente)
activate Sis
Sis -> BD: DELETE FROM Cliente WHERE id = ?
BD --> Sis: Confirma exclusão da linha
deactivate Sis

Sis --> Tela: Retorna true
Tela --> Cliente: Informa a exclusão da conta 
Tela -> Tela: Redireciona para a tela inicial / Logout

@enduml
```

### UC5: Exibir Relatório de Faturamento

```plantuml
@startuml
autonumber

actor "Administrador" as Adm
participant "Interface" as Tela
participant "Sistema" as Sis
database "MySql" as BD

Adm -> Tela: Informa identificação
Tela -> Sis: autenticar(identificacao)
Sis --> Tela: Administrador autenticado
Tela --> Adm: Exibe as opções de relatório

Adm -> Tela: Escolhe saber o faturamento com as vendas
Tela --> Adm: Informa opções de pesquisa (período, ordenação dos livros)

Adm -> Tela: Informa o período e ordenação pelos mais vendidos
Tela -> Sis: gerarRelatorio(periodo, ordenacao)
activate Sis

Sis -> BD: SELECT * FROM Venda WHERE data BETWEEN ...
activate BD
BD --> Sis: Retorna dados das vendas 
deactivate BD

Sis -> Sis: Calcula o faturamento total do período
Sis --> Tela: Retorna o relatório 
deactivate Sis

Tela --> Adm: Exibe o faturamento total 
@enduml
```

### UC6: Gerenciar Catálogo 

```plantuml
@startuml
autonumber

actor "Administrador" as Adm
participant "Interface" as Tela
participant "Sistema" as Sis
database "MySql" as BD

Adm -> Tela: Informa identificação
Tela -> Sis: autenticar(identificacao)
Sis --> Tela: Administrador autenticado
Tela --> Adm: Exibe opções de ADM

alt Fluxo Principal: Adicionar livro no catálogo
    Adm -> Tela: AdicionaLivro(título, ISBN, categorias, autor, ano)
    Tela -> Sis: cadastrar(titulo, isbn, categorias, autor, ano)
    activate Sis
    Sis -> BD: INSERT INTO Livro (...)
    BD --> Sis: Confirmação de registro
    deactivate Sis
    Sis --> Tela: Retorna true
    
    Tela --> Adm: Informa a confirmação da adição do livro no catálogo

else Variante 3.1: Excluir do catálogo
    Adm -> Tela: Escolhe excluir livros do catálogo
    Tela -> Sis: buscarLivros()
    activate Sis
    Sis -> BD: SELECT * FROM Livro
    BD --> Sis: Retorna os livros
    deactivate Sis
    Sis --> Tela: Retorna lista de livros
    
    Tela --> Adm: Informa os livros disponíveis para serem excluídos
    
    Adm -> Tela: Informa os livros que deseja excluir
    Tela --> Adm: Exibe mensagem de confirmação de exclusão
    
    Adm -> Tela: Confirma a exclusão
    Tela -> Sis: deletar(IdLivros)
    activate Sis
    Sis -> BD: DELETE FROM Livro WHERE id IN (...)
    BD --> Sis: Confirma exclusão das linhas
    deactivate Sis
    
    Sis --> Tela: Retorna true
    Tela --> Adm: Informa a confirmação de exclusão dos livros
end

@enduml
```

### UC7: Gerenciar Avaliações

```plantuml
@startuml
autonumber

actor "Administrador" as Adm
participant "Interface" as Tela
participant "Sistema" as Sis
database "MySql" as BD

Adm -> Tela: Informa identificação
Tela -> Sis: autenticar(identificacao)
Sis --> Tela: Administrador autenticado
Tela --> Adm: Informa opções de ADM

Adm -> Tela: Escolhe excluir avaliações de clientes
Tela -> Sis: buscarAvaliacoes()
activate Sis
Sis -> BD: SELECT * FROM Avaliacao
BD --> Sis: Retorna lista 
deactivate Sis
Sis --> Tela: Retorna avaliações 
Tela --> Adm: exibe as avaliações

Adm -> Tela: Informa as avaliações e efetua a exclusão
Tela -> Sis: excluirAvaliacoes(Avaliacoes)
activate Sis
Sis -> BD: DELETE FROM Avaliacao WHERE id IN (...)
BD --> Sis: Confirma exclusão das linhas
deactivate Sis

Sis --> Tela: Retorna true
Tela --> Adm: confirma exclusão das avaliações

@enduml
```

UC8: Gerenciar Contas de Clientes

```plantuml
@startuml
autonumber

actor "Administrador" as Adm
participant "Interface" as Tela
participant "Sistema" as Sis
database "MySql" as BD

Adm -> Tela: Informa identificação
Tela -> Sis: autenticar(identificacao)
Sis --> Tela: Administrador autenticado
Tela --> Adm: Informa opções de ADM

Adm -> Tela: Escolhe excluir contas de clientes
Tela -> Sis: buscar(Clientes)
activate Sis
Sis -> BD: SELECT * FROM Cliente
BD --> Sis: Retorna lista de clientes
deactivate Sis
Sis --> Tela: Retorna contas 
Tela --> Adm: Informa as contas disponíveis para exclusão

Adm -> Tela: Informa as contas que deseja 
Tela -> Sis: deletar(Clientes)
activate Sis
Sis -> BD: DELETE FROM Cliente WHERE id IN (...)
BD --> Sis: Confirma exclusão das linhas
deactivate Sis

Sis --> Tela: Retorna true
Tela --> Adm: confirma exclusão das contas

@enduml
```
