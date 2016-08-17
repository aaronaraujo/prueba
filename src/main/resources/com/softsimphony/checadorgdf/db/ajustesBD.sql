
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

ALTER TABLE reporte ADD FOREIGN KEY(idUsuario) REFERENCES usuario(idUsuario);
ALTER TABLE reporte ADD FOREIGN KEY(idArea) REFERENCES area(idArea);
ALTER TABLE reporte ADD FOREIGN KEY(idTipoRegistro) REFERENCES tipoRegistro(idTipoRegistro);


ALTER TABLE usuario ADD FOREIGN KEY(idHorario) REFERENCES horario(idHorario);
ALTER TABLE usuario ADD FOREIGN KEY(idArea) REFERENCES area(idArea);

