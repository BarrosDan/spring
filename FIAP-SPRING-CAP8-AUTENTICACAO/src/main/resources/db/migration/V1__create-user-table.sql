-- Criação da tabela tbl_usuarios
CREATE TABLE tbl_usuarios (
    usuario_id BIGINT(20) NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL,
    PRIMARY KEY (usuario_id)
);
