package com.softsimphony.checadorgdf.model;

import java.util.Date;

public class Horario {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column horario.idHorario
     *
     * @mbggenerated Thu Aug 18 12:11:17 CDT 2016
     */
    private Integer idHorario;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column horario.horaInicial
     *
     * @mbggenerated Thu Aug 18 12:11:17 CDT 2016
     */
    private Date horaInicial;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column horario.horaFinal
     *
     * @mbggenerated Thu Aug 18 12:11:17 CDT 2016
     */
    private Date horaFinal;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column horario.descripcion
     *
     * @mbggenerated Thu Aug 18 12:11:17 CDT 2016
     */
    private String descripcion;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column horario.idHorario
     *
     * @return the value of horario.idHorario
     *
     * @mbggenerated Thu Aug 18 12:11:17 CDT 2016
     */
    public Integer getIdHorario() {
        return idHorario;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column horario.idHorario
     *
     * @param idHorario the value for horario.idHorario
     *
     * @mbggenerated Thu Aug 18 12:11:17 CDT 2016
     */
    public void setIdHorario(Integer idHorario) {
        this.idHorario = idHorario;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column horario.horaInicial
     *
     * @return the value of horario.horaInicial
     *
     * @mbggenerated Thu Aug 18 12:11:17 CDT 2016
     */
    public Date getHoraInicial() {
        return horaInicial;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column horario.horaInicial
     *
     * @param horaInicial the value for horario.horaInicial
     *
     * @mbggenerated Thu Aug 18 12:11:17 CDT 2016
     */
    public void setHoraInicial(Date horaInicial) {
        this.horaInicial = horaInicial;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column horario.horaFinal
     *
     * @return the value of horario.horaFinal
     *
     * @mbggenerated Thu Aug 18 12:11:17 CDT 2016
     */
    public Date getHoraFinal() {
        return horaFinal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column horario.horaFinal
     *
     * @param horaFinal the value for horario.horaFinal
     *
     * @mbggenerated Thu Aug 18 12:11:17 CDT 2016
     */
    public void setHoraFinal(Date horaFinal) {
        this.horaFinal = horaFinal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column horario.descripcion
     *
     * @return the value of horario.descripcion
     *
     * @mbggenerated Thu Aug 18 12:11:17 CDT 2016
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column horario.descripcion
     *
     * @param descripcion the value for horario.descripcion
     *
     * @mbggenerated Thu Aug 18 12:11:17 CDT 2016
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}