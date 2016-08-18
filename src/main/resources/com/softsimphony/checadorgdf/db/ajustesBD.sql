
/**
 * Author:  Aaron A. Araujo
 * Created: Aug 17, 2016
 * 
 * SQL 
 */
RENAME TABLE Area TO area;
RENAME TABLE Horario TO horario;
RENAME TABLE Reporte TO reporte;
RENAME TABLE TipoRegistro TO tipoRegistro;
RENAME TABLE Usuario TO usuario;

ALTER TABLE reporte MODIFY horaIdeal date;
ALTER TABLE reporte change idArear idArea int(11);

ALTER TABLE horario MODIFY horaInicial time;
ALTER TABLE horario MODIFY horaFinal time;

SET FOREIGN_KEY_CHECKS=0;

ALTER TABLE usuario MODIFY COLUMN idUsuario INT auto_increment;
ALTER TABLE horario MODIFY COLUMN idHorario INT auto_increment;
ALTER TABLE reporte MODIFY COLUMN idReporte INT auto_increment;
ALTER TABLE tipoRegistro MODIFY COLUMN idTipoRegistro INT auto_increment;
ALTER TABLE area MODIFY COLUMN idArea INT auto_increment;
SET FOREIGN_KEY_CHECKS=1;



ALTER TABLE reporte ADD FOREIGN KEY(idUsuario) REFERENCES usuario(idUsuario);
ALTER TABLE reporte ADD FOREIGN KEY(idArea) REFERENCES area(idArea);
ALTER TABLE reporte ADD FOREIGN KEY(idTipoRegistro) REFERENCES tipoRegistro(idTipoRegistro);


ALTER TABLE usuario ADD FOREIGN KEY(idHorario) REFERENCES horario(idHorario);
ALTER TABLE usuario ADD FOREIGN KEY(idArea) REFERENCES area(idArea);

