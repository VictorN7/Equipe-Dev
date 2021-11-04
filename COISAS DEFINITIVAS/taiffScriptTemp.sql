CREATE DATABASE taiff;
USE taiff;

CREATE TABLE zeroPecas(
  id_zeropeca INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  zp_posiX FLOAT NOT NULL,
  zp_posiY FLOAT NOT NULL,
  zp_posiZ FLOAT NOT NULL,
  zp_posiR FLOAT NOT NULL
);

CREATE TABLE testes(
  id_teste INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  nome_modelo VARCHAR(200) NOT NULL,
  id_zeropeca INT,
  CONSTRAINT fk_zeropeca FOREIGN KEY (id_zeropeca) REFERENCES taiff.zeroPecas(id_zeropeca)
  );
  
CREATE TABLE posicoes(
  id_posicao INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  posiX FLOAT NOT NULL,
  posiY FLOAT NOT NULL,
  posiZ FLOAT NOT NULL,
  posiR FLOAT NOT NULL,
  posiT INT NOT NULL,
  id_teste INT NOT NULL,
  CONSTRAINT uq_posixyz UNIQUE KEY (posiX, posiY, posiZ, posiR,posiT, id_teste),
  CONSTRAINT fk_teste FOREIGN KEY (id_teste) REFERENCES taiff.testes(id_teste) ON DELETE CASCADE
);
-- Usar a Linha Abaixo Quando executar a Primeira Vez O Java  ou dar Um DROP na TABELA Temperatura
ALTER TABLE taiff.temperatura ADD(CONSTRAINT fk_posi FOREIGN KEY (id_posicao) REFERENCES taiff.posicoes(id_posicao) ON DELETE CASCADE);

-- Insert de Teste
INSERT INTO zeroPecas (zp_posiX, zp_posiY, zp_posiZ, zp_posiR) VALUES (69.0, 5.0, 36.0, 4);
INSERT INTO testes (nome_modelo,id_zeropeca) VALUES ("Dev",1);
INSERT INTO posicoes (posiX, posiY, posiZ, posiR, id_teste) VALUES (6.0 ,58.0, 24.0, 42.0, 1);
INSERT INTO temperaturas (termopar1, termopar2, termopar3, tempAmb,data_leitura,id_posicao) VALUES (6.0 ,58.0, 24.0, 42.0, "2021-07-07",1);


SELECT * FROM vw_testes WHERE id_teste = 1;
SELECT * FROM vw_testes;

SELECT * FROM zeroPecas;
SELECT * FROM testes;
SELECT termopar1 FROM temperatura;
SELECT * FROM posicoes;


SELECT id_posicao, posiX, posiY, posiZ, posiR ,posiT FROM taiff.posicoes WHERE id_teste = 11;

-- SELECT id_temperatura,termopar1,termopar2,termopar3, ROW_NUMBER() OVER(
-- 	ORDER BY id_temperatura
-- )row_teste FROM temperatura;

-- SELECT 
--   cd.id_temperatura,
--   cd.termopar1, 
--   cd.termopar2,
--   cd.termopar3,
--   cd.data_leitura,
--   cd.row_num
--   FROM ( SELECT 
--   id_temperatura, termopar1, termopar2,termopar3,data_leitura,
--   ROW_NUMBER() OVER(ORDER BY data_leitura) row_num
--   FROM taiff.temperatura
--   ) cd ;
  
-- SELECT  id_temperatura, termopar1, termopar2, termopar3,temp_amb, data_leitura FROM temperatura ORDER BY data_leitura LIMIT 190,84;

 SELECT id_temperatura,termopar1,termopar2,termopar3,tempAmb,data_leitura,id_posicao;

-- DELETE FROM temperatura WHERE id_temperatura=1;
-- DELETE FROM zeroPecas WHERE id_zeropeca=10;

 -- DROP DATABASE taiff;
 -- UPDATE taiff.testes SET nome_modelo = 'Ola Mundo'  WHERE id_teste= 5;