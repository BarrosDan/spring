CREATE TABLE tbl_remedios(
    numero_remedio BIGINT(20) NOT NULL AUTO_INCREMENT,
    nome_remedio VARCHAR(100) NOT NULL,
    tipo_remedio VARCHAR(100) NOT NULL,
    valor DECIMAL(9,3) NOT NULL,
    PRIMARY KEY(numero_remedio)
);