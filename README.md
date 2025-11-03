# Modularizacao-de-codigo<br>
┏ ┓ ━ ┗ ┛ ┃

Passo 1: Estrutura do Sistema
1. Pacote view:
   ○ Crie uma classe BibliotecaView com um método mostrarMenu() para
   exibir as opções ao usuário.
   ○ O método capturarOpcao() deve capturar a opção escolhida pelo usuário
   (1, 2, 3, etc.) e retornar a escolha.
   ○ A classe deve interagir com o usuário no terminal, chamando os métodos da
   camada service conforme a escolha.<br>

2. Pacote service:
   ○ Crie uma classe LivroService que terá os métodos para:
   ■ Cadastrar livro.
   ■ Consultar todos os livros cadastrados.
   ■ Registrar empréstimo de livro.
   ■ Registrar devolução de livro.
   ○ Crie outra classe EmprestimoService com métodos relacionados à lógica
   de empréstimos e devoluções.

Pacote model:
onde estão localizadas as entidades.<br>

3. Pacote repository:
   ○ Crie a classe LivroRepository com os métodos estáticos para:
   ■ Inserir livro no banco de dados.
   ■ Consultar todos os livros.
   ■ Atualizar o status de disponibilidade de um livro (disponível ou não).
   ○ Crie a classe EmprestimoRepository para:

■ Registrar empréstimos no banco de dados.
■ Registrar devoluções de livros.<br>

Passo 2: Banco de Dados
1. Tabela livros:

○ Colunas: id, titulo, autor, ano, disponivel (boolean).
○ A tabela livros deve ser usada para armazenar as informações dos livros
cadastrados no sistema.<br>

2. Tabela emprestimos:
   ○ Colunas: id, livro_id (FK para livros), usuario, data_emprestimo,
   data_devolucao.
   ○ A tabela emprestimos deve armazenar as informações sobre os
   empréstimos feitos pelos usuários.<br>

Passo 3: Funcionalidades do Sistema
1. Cadastro de Livro:
   ○ O usuário deve ser capaz de cadastrar um novo livro no sistema.
   ○ O sistema deve pedir os seguintes dados:
   ■ Título do livro.
   ■ Autor do livro.
   ■ Ano de publicação.
   ○ O livro deve ser salvo na tabela livros com a coluna disponivel
   marcada como true.<br>

2. Cadastro de Empréstimo:
   ○ O usuário deve ser capaz de registrar um empréstimo de livro.
   ○ o usuário que está fazendo o empréstimo.
   ○ O livro deve ser marcado como não disponível no banco de dados e o
   empréstimo registrado na tabela emprestimos.<br>

3. Devolução de Livro:
   ○ O usuário deve ser capaz de registrar a devolução de um livro.
   ○ O sistema deve pedir o ID do empréstimo e a data de devolução.
   ○ O livro deve ser marcado novamente como disponível no banco de dados.<br>

4. Consultas:
   ○ O sistema deve permitir que o usuário consulte todos os livros cadastrados.
   ○ O sistema deve permitir que o usuário consulte todos os empréstimos
   realizados.<br><br><br>


CREATE DATABASE biblioteca_db;<br>
USE biblioteca_db;<br>

-- Tabela de usuários (quem faz empréstimos)<br>
CREATE TABLE usuarios (<br>
id INT AUTO_INCREMENT PRIMARY KEY,<br>
nome VARCHAR(255) NOT NULL,<br>
email VARCHAR(255),<br>
);<br><br>

-- Tabela de livros<br>
CREATE TABLE livros (<br>
id INT AUTO_INCREMENT PRIMARY KEY,<br>
titulo VARCHAR(255) NOT NULL,<br>
autor VARCHAR(255) NOT NULL,<br>
ano INT NOT NULL,<br>
disponivel BOOLEAN NOT NULL DEFAULT TRUE<br>
);<br><br>

-- Tabela de empréstimos<br>
CREATE TABLE emprestimos (<br>
id INT AUTO_INCREMENT PRIMARY KEY,<br>
livro_id INT NOT NULL,<br>
usuario_id INT NOT NULL,<br>
data_emprestimo DATE NOT NULL,<br>
data_devolucao DATE,<br>
FOREIGN KEY (livro_id) REFERENCES livros(id),<br>
FOREIGN KEY (usuario_id) REFERENCES usuarios(id)<br>
);<br>