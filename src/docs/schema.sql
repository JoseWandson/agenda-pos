

CREATE TABLE IF NOT EXISTS usuarios (
  nome VARCHAR(20) NOT NULL ,
  senha VARCHAR(300) NOT NULL ,
  ativo TINYINT NOT NULL DEFAULT 1 ,
  PRIMARY KEY (nome)
  
 );
 
 
 CREATE TABLE IF NOT EXISTS usuarios_roles (
  usuario_id INT NOT NULL AUTO_INCREMENT,
  nome varchar(20) NOT NULL,
  role varchar(20) NOT NULL,
  CONSTRAINT usuario_roles FOREIGN KEY (nome) REFERENCES usuarios (nome),
  PRIMARY KEY (usuario_id)
 );

CREATE TABLE IF NOT EXISTS contatos (
	id INT NOT NULL AUTO_INCREMENT,
	ativo INT NOT NULL,
	nome VARCHAR (100) NOT NULL,
	email VARCHAR (100) NOT NULL,
	PRIMARY KEY (id)
    
);

CREATE TABLE IF NOT EXISTS fornecedores (
	id INT NOT NULL AUTO_INCREMENT,
	ativo INT NOT NULL,
	nome VARCHAR (100) NOT NULL,
	email VARCHAR (100) NOT NULL,
	PRIMARY KEY (id)
    
);