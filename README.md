## 📂 Estrutura sugerida do repositório no GitHub

```
projeto-escola/
│── README.md
│── scripts/
│   └── escola.sql
```

---

## 📄 Script `escola.sql`

Esse script você pode importar no phpMyAdmin:

```sql
-- 1. Criar o banco de dados
CREATE DATABASE escola;

-- Usar o banco de dados
USE escola;

-- 2. Criar tabela alunos
CREATE TABLE alunos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    data_nascimento DATE NOT NULL,
    curso VARCHAR(50) NOT NULL,
    ativo BOOLEAN DEFAULT TRUE
);

-- 3. Inserção de pelo menos 5 alunos
INSERT INTO alunos (nome, email, data_nascimento, curso, ativo) VALUES
('Ana Souza', 'ana.souza@email.com', '2000-05-12', 'Sistemas de Informação', TRUE),
('Carlos Pereira', 'carlos.pereira@email.com', '1999-11-23', 'Administração', TRUE),
('Beatriz Silva', 'beatriz.silva@email.com', '2001-07-30', 'Engenharia Civil', FALSE),
('João Oliveira', 'joao.oliveira@email.com', '1998-02-15', 'Direito', TRUE),
('Mariana Costa', 'mariana.costa@email.com', '2002-09-09', 'Psicologia', TRUE);

-- 4. Consultas SQL
-- a) Listar todos os alunos
SELECT * FROM alunos;

-- b) Listar apenas alunos ativos
SELECT * FROM alunos WHERE ativo = TRUE;

-- c) Buscar alunos por curso (exemplo: Direito)
SELECT * FROM alunos WHERE curso = 'Direito';

-- d) Ordenar alunos por nome
SELECT * FROM alunos ORDER BY nome ASC;

-- 5. Atualizar curso de um aluno (exemplo: alterar curso do aluno com id=2)
UPDATE alunos SET curso = 'Ciência da Computação' WHERE id = 2;

-- 6. Excluir um aluno pelo ID (exemplo: remover aluno com id=3)
DELETE FROM alunos WHERE id = 3;
```

---

## 📘 README.md

````markdown
# 📚 Projeto Banco de Dados Relacional - Cadastro de Alunos

## 🎯 Objetivo
Criar e manipular um banco de dados relacional utilizando **MariaDB (XAMPP)**, com foco em operações básicas de SQL para gerenciar alunos de uma instituição de ensino.

---

## 🛠️ Ambiente Utilizado
- **XAMPP** com MariaDB
- **phpMyAdmin** para execução dos comandos SQL
- Banco de dados: `escola`

---

## 📌 Requisitos do Projeto
1. Criação do banco de dados `escola`
2. Criação da tabela `alunos` com os campos:
   - `id` INT PRIMARY KEY AUTO_INCREMENT  
   - `nome` VARCHAR(100)  
   - `email` VARCHAR(100)  
   - `data_nascimento` DATE  
   - `curso` VARCHAR(50)  
   - `ativo` BOOLEAN  
3. Inserção de pelo menos 5 alunos
4. Consultas SQL:
   - Listar todos os alunos
   - Listar apenas alunos ativos
   - Buscar alunos por curso
   - Ordenar alunos por nome
5. Atualização de curso de um aluno
6. Exclusão de um aluno por ID

---

## ▶️ Como Importar no phpMyAdmin
1. Abra o **phpMyAdmin** (geralmente em `http://localhost/phpmyadmin`).
2. Clique em **Importar**.
3. Escolha o arquivo [`scripts/escola.sql`](scripts/escola.sql).
4. Clique em **Executar**.
5. O banco de dados `escola` será criado automaticamente com a tabela `alunos` e dados de exemplo.

---

## 🧪 Exemplos de Consultas

### Listar todos os alunos
```sql
SELECT * FROM alunos;
````

### Listar apenas alunos ativos

```sql
SELECT * FROM alunos WHERE ativo = TRUE;
```

### Buscar alunos por curso (exemplo: Direito)

```sql
SELECT * FROM alunos WHERE curso = 'Direito';
```

### Ordenar alunos por nome

```sql
SELECT * FROM alunos ORDER BY nome ASC;
```

### Atualizar curso de um aluno (exemplo: id=2)

```sql
UPDATE alunos SET curso = 'Sistemas da Informação' WHERE id = 2;
```

### Remover aluno pelo ID (exemplo: id=3)

```sql
DELETE FROM alunos WHERE id = 3;


👩‍💻 Desenvolvido como parte de exercício prático para gerenciamento de bancos de dados relacionais com MariaDB.

