CREATE TABLE tbl_farmacia(
    registro_farmacia BIGINT(20) NOT NULL AUTO_INCREMENT,
    nome_farmacia VARCHAR(100) NOT NULL,
    numero_cnpj BIGINT(15) NOT NULL,
    endereco_farmacia VARCHAR(100) NOT NULL,
    PRIMARY KEY (registro_farmacia)
);