-- ESTE -- FAZ COMENTÁRIOS EM SQL. AQUI A LINGUAGEM É EM SQL NAO EM JAVA
-- V2  Migration para adicionar a coluna RANK na tabela de cadastro

ALTER TABLE tb_cadastro
ADD COLUMN RANK VARCHAR(255);