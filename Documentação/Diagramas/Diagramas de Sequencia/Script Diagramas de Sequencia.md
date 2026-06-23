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
