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
control "Controladora" as Sis
database "MySql" as BD

activate Cliente
Cliente -> Tela: Informa identificação
activate Tela
Tela -> Sis: autenticar(identificacao)
activate Sis
activate BD
Sis -> BD: buscar(identificacao)
BD --> Sis: Retorna dados 
deactivate BD
Sis --> Tela: Confirma autenticação
deactivate Sis

Tela -> Sis: catalogo()
activate Sis
activate BD
Sis -> BD: list();
BD --> Sis: Return livros
deactivate BD
Sis --> Tela: Retorna livros formatados

deactivate Sis
Tela --> Cliente: Exibe os livros disponíveis

alt Variante 3.2: Comprar livros do carrinho
    Cliente -> Tela: Escolhe comprar itens armazenados no carrinho
    activate Sis
    Tela -> Sis: recuperarCarrinho(cliente)
    Sis --> Tela: Retorna itens
    deactivate Sis
    
    
else Fluxo Principal: Escolher um novo livro
    Cliente -> Tela: Escolhe um livro da lista
    
    activate Sis
    Tela -> Sis: buscarLivro(idLivro)
    activate BD
    Sis -> BD: list();
    BD --> Sis: Retorna livros
    deactivate BD
    Sis --> Tela: Retorna dados do livro
    deactivate Sis
    Tela --> Cliente: Exibe detalhes (título, autor, categoria, preço)
    
    
    alt Variante 5.1: Guardar no carrinho
        Cliente -> Tela: Escolhe guardar o livro no carrinho
        activate Sis
        Tela -> Sis: adicionarAoCarrinho(cliente, livro)
        Sis --> Tela: Return true
        deactivate Sis
        Tela --> Cliente: Confirma que foi adicionado ao carrinho
    else Fluxo Principal: Comprar o livro
        Cliente -> Tela: Escolhe comprar o livro imediatamente
    end
end

activate Sis
Tela -> Sis: solicitarPagamento()
Sis --> Tela: Retorna opções disponíveis
deactivate Sis
Tela --> Cliente: Informa os meios de pagamento

Cliente -> Tela: Seleciona o meio e efetua a compra
Tela -> Sis: processarCompra(cliente, itens, pagamento)
activate Sis
activate BD
Sis -> BD: add(venda)
BD --> Sis: Confirmação de registro
deactivate BD
deactivate Sis


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
control "Sistema" as Sis
database "MySql" as BD

activate Cliente
activate Tela
Cliente -> Tela: Faz Login
activate Sis
Tela -> Sis: autenticar(cliente)
Sis --> Tela: Cliente autenticado
deactivate Sis

Cliente -> Tela: Avaliar Livros
Tela -> Sis: buscarLivros(cliente)
activate Sis
activate BD
Sis -> BD: list(Livros);
BD --> Sis: Retorna lista de livros 
deactivate BD

Sis --> Tela: Retorna lista 
deactivate Sis

Tela --> Cliente: Exibe livros comprados

Cliente -> Tela: seleciona o livro 
activate Sis
Tela -> Sis: buscar(idLivro)
Sis --> Tela: Retorna tela de avaliação
deactivate Sis
Tela --> Cliente: Exibe a interface de avaliação

Cliente -> Tela: Informa a nota e o comentário
activate Sis
Tela -> Sis: registrarAvaliacao(cliente, livro, nota, comentario)
activate BD
Sis -> BD: add(Avaliação)
BD --> Sis: Confirma avaliação
deactivate BD


Sis --> Tela: Retorna true
deactivate Sis
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

activate Cliente
activate Tela
Cliente -> Tela: Informa opções de consulta (título, categorias)
Tela -> Sis: consultarCatalogo(titulo, categorias)
activate Sis
activate BD

Sis -> BD: list(Livro);
BD --> Sis: Retorna lista

deactivate BD
deactivate Sis
Sis --> Tela: Retorna livros
Tela --> Cliente: Exibe livros encontrados

Cliente -> Tela: Informa o livro desejado 
Tela -> Sis: buscar(idLivro)
activate Sis

activate BD
Sis -> BD: SELECT titulo, nota, preco FROM Livro WHERE id = ?
BD --> Sis: Retorna informações
deactivate BD


Sis --> Tela: Retorna informações completas 
deactivate Sis
Tela --> Cliente: Exibe os detalhes do livro

@enduml

```

### UC4: Manter Conta

```plantuml
@startuml
autonumber

actor "Cliente" as Cliente
participant "Interface" as Tela
control "Controller" as Sis
database "MySql" as BD

activate Cliente
activate Tela

Cliente -> Tela: Informa identificação

activate Sis

Tela -> Sis: autenticar(identificacao)
Sis --> Tela: Cliente autenticado

Tela -> Sis: buscar(cliente)

activate BD
Sis -> BD: search(cliente);
BD --> Sis: Retorna cliente
deactivate BD

Sis --> Tela: Retorna perfil
deactivate Sis
Tela --> Cliente: Exibe informações e opcões do perfil

Cliente -> Tela: Escolhe a opção de excluir conta
activate Sis
Tela -> Sis: deletar(cliente)
Sis --> Tela: Pede confirmação de segurança
deactivate Sis
Tela --> Cliente: mostra janela de confimação

Cliente -> Tela: Confirma a exclusão da conta
Tela -> Sis: deletar(cliente)
activate Sis
activate BD
Sis -> BD: del(Cliente);
BD --> Sis: return true
deactivate BD
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

activate Adm
activate Tela

Adm -> Tela: Informa identificação
Tela -> Sis: autenticar(identificacao)
activate Sis
Sis --> Tela: Administrador autenticado
deactivate Sis
Tela --> Adm: Exibe as opções de relatório

Adm -> Tela: Escolhe saber o faturamento com as vendas
Tela --> Adm: Informa opções de pesquisa 

Adm -> Tela: Informa o período e ordenação 
Tela -> Sis: Relatorio()
activate Sis

Sis -> BD: list();
activate BD
BD --> Sis: Retorna dados 
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
control "Controladora" as Sis
database "MySql" as BD

activate Adm
activate Tela

Adm -> Tela: Informa identificação
Tela -> Sis: autenticar(identificacao)
activate Sis
Sis --> Tela: Administrador autenticado
deactivate Sis
Tela --> Adm: Exibe opções de ADM

alt Fluxo Principal: Adicionar livro no catálogo
    Adm -> Tela: AdicionaLivro(título, ISBN, categorias, autor, ano)
    Tela -> Sis: cadastrar(livro)
    activate Sis
    Sis -> BD: add(Livro)
    activate BD
    BD --> Sis: return true
    deactivate BD
    
    Sis --> Tela: Retorna true
    deactivate Sis

    Tela --> Adm: confirmação da adição do livro no catálogo

else Variante 3.1: Excluir do catálogo
    Adm -> Tela: Escolhe excluir livros do catálogo
    Tela -> Sis: buscarLivros()
    activate Sis

    Sis -> BD: SELECT * FROM Livro
    activate BD
    BD --> Sis: Retorna os livros
    deactivate BD
   
    Sis --> Tela: Retorna lista de livros
     deactivate Sis
    Tela --> Adm: Informa os livros disponíveis
    
    Adm -> Tela: Informa os livros que deseja excluir
    Tela --> Adm: Exibe mensagem de confirmação de exclusão
    
    Adm -> Tela: Confirma a exclusão
    Tela -> Sis: deletar(IdLivros)
    activate Sis
    Sis -> BD: del (Livro)
    activate BD
    BD --> Sis: Confirma exclusão das linhas
    deactivate BD
    Sis --> Tela: Retorna true
    deactivate Sis
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
control "controladora" as Sis
database "MySql" as BD

activate Adm
activate Tela

Adm -> Tela: Informa identificação
Tela -> Sis: autenticar(identificacao)
activate Sis
Sis --> Tela: Administrador autenticado
deactivate Sis
Tela --> Adm: Informa opções de ADM

Adm -> Tela: Escolhe excluir avaliações de clientes
Tela -> Sis: buscarAvaliacoes()
activate Sis
Sis -> BD: list(avaliação);
activate BD
BD --> Sis: Retorna lista 
deactivate BD
Sis --> Tela: Retorna avaliações 
deactivate Sis
Tela --> Adm: exibe as avaliações

Adm -> Tela: Informa as avaliações e efetua a exclusão
Tela -> Sis: excluirAvaliacoes(Avaliacoes)
activate Sis
Sis -> BD: del(avaliação)
activate BD
BD --> Sis: Confirma exclusão das linhas
deactivate BD

Sis --> Tela: Retorna true
deactivate Sis
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

activate Adm
activate Tela

Adm -> Tela: Informa identificação
Tela -> Sis: autenticar(identificacao)
activate Sis
Sis --> Tela: Administrador autenticado
deactivate Sis
Tela --> Adm: Informa opções de ADM

Adm -> Tela: Escolhe excluir contas de clientes
Tela -> Sis: buscar(Clientes)
activate Sis
Sis -> BD:list(Cliente);
activate BD
BD --> Sis: Return list
deactivate BD
Sis --> Tela: Retorna contas
deactivate Sis
Tela --> Adm: Lista as contas

Adm -> Tela: Informa as contas que deseja 
Tela -> Sis: deletar(Clientes)
activate Sis
Sis -> BD: del(cliente)
activate BD
BD --> Sis: return true
deactivate BD
deactivate Sis

Sis --> Tela: Retorna true
Tela --> Adm: confirma exclusão das contas

@enduml
```
