# Projeto-DSC
## 📚 Sistema de Gestão de Livraria
- Este projeto foi desenvolvido em Java com interface gráfica (Swing) e utiliza um banco de dados MySQL para gerir clientes, catálogos de livros, carrinhos de compras e relatórios de vendas.

## Tools Used
 ![Linux](https://img.shields.io/badge/Linux-FCC624?style=for-the-badge&logo=linux&logoColor=black)
 ![Git](https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white)
 ![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white) 
 ![MySQL](https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white)
 ![NetBeans IDE](https://img.shields.io/badge/NetBeansIDE-1B6AC6.svg?style=for-the-badge&logo=apache-netbeans-ide&logoColor=white)
 ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)

 
## 🛠️ Pré-requisitos

- Antes de começar, certifique-se de que tem as seguintes ferramentas instaladas no seu computador:
- Java JDK (versão 21)

- MySQL e MySQL WorkBench

- Apache NetBeans

<img width="628" height="405" alt="1" src="https://github.com/user-attachments/assets/81850336-7deb-42f4-bf02-69d771487844" />

## 🚀 Passo a Passo para Execução

## Passo 1: Clonar o Repositório
- Abra o seu terminal (ou Git Bash) e clone o projeto para o seu computador:
  
```bash

git clone https://github.com/Gnunes27/Projeto-DSC

```

- (Se preferir, pode também baixar o projeto em formato .ZIP diretamente pelo GitHub).

## passo 2: Abra o Apache NetBeans

- Depois de aberto, procure pela opção 'FILE' no canto superior esquerdo e logo depois clique em 'Open Project...'.

<img width="659" height="534" alt="WhatsApp Image 2026-07-07 at 16 19 16" src="https://github.com/user-attachments/assets/d475e2c6-932b-4b7e-b8f8-721191b495be" />

- Na janela que aparecer, procure pela pasta em que você salvou o sistema da livraria e selecione o arquivo 'Livraria' que aparece junto com o simbolo do maven.

<img width="762" height="396" alt="WhatsApp Image 2026-07-07 at 16 19 31" src="https://github.com/user-attachments/assets/6134962e-de9f-44f6-bc45-ed73194f0289" />

## Passo 3.1: Configurar a conexão com o Banco de Dados.

#### Abra o MySQL Workbench
- Clique no sinal de + e crie uma nova conexão. 

<img width="1600" height="915" alt="4" src="https://github.com/user-attachments/assets/34245fe6-91a1-4064-8a1a-02ca69f3d506" />


- Dê o nome dessa conexão de "Livraria". Guarde o seu nome de usuario e senha, precisaremos dele para o próximo passo


<img width="1600" height="915" alt="5" src="https://github.com/user-attachments/assets/ebda8718-86f1-471b-9860-3d28d40fcd28" />

## Passo 3.2: Rodar o script

- Na pasta Projeto-DSC/MySql, procure pelo 'script Livraria' e execute no banco de dados.

  <img width="551" height="188" alt="9" src="https://github.com/user-attachments/assets/6dc56afc-975f-4c39-bfb7-63aacaa92704" />

- Cole esse script na conexão Livraria que vc criou e execute clicando no ícone de raio.

  <img width="1498" height="1075" alt="10" src="https://github.com/user-attachments/assets/b2050ff8-b994-489d-9b46-8023dc2f5c6e" />



## Passo 3.3: Configurar a conexão com o Banco de Dados no código do sistema.

#### Volte ao NetBeans e, na barra lateral direita, clique em 'Files' e siga o caminha até achar o arquivo 'ConnectionFactory.java'.
    Livraria/src/main/java/com/mycompany/livraria/conexao/ConnectionFactory.java
    
<img width="1025" height="733" alt="6" src="https://github.com/user-attachments/assets/f568484d-cee2-4b65-a0e6-c3f42b099518" />

#### No arquivo, troque as credenciais pelos usuario e senha que você criou no workbench.

- USER = "SEU_USUARIO"
- PASS = "SUA_SENHA"

- Depois disso salve o arquivo.

<img width="474" height="127" alt="7" src="https://github.com/user-attachments/assets/20ef3a1e-fe43-4ac4-9eb8-976eebe417cb" />

## Passo 4: Build

#### Procure pelo 'Clean and Build' na barra superior (ícone de um martelo e uma vassoura). ele começara a baixar as dependências do mavem para que o sistema funcione corretamente.

<img width="1113" height="594" alt="8" src="https://github.com/user-attachments/assets/6fd3c09b-c982-43c6-9191-34666ea04bf4" />

## Passo 5: Agora basta clicar no ícone de play (ícone verde ao lado de clean and build) que o codigo funcionará.

# Acessos ao Sistema 
### Com o sistema funcionando, você pode logar com os seguintes usuários clicando no icone de perfil canto superior direito da tela inicial

| Usuarios                | Senha | 
|-------------------------|-------|
| Adm@livraria            | 12345 |
| Pedro@Usuario           | p123 |
| Nanda@Usuario           | n123 |
| Luis@Usuario            | l123 |

#### Muito obrigado e bom sistema!

## Developers

| Developer                | GitHub | 
|--------------------------|--------|
| 1 - Bruno Rodrigues Magalhães     | [![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/Bruno6R)|
| 2 - Gabriel Nunes de Almeida      | [![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/Gnunes27)|
