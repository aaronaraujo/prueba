package com.softsimphony.checadorgdf.dao;

import com.softsimphony.checadorgdf.model.Horario;
import com.softsimphony.checadorgdf.model.HorarioExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HorarioMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table horario
     *
     * @mbggenerated Thu Aug 18 12:11:17 CDT 2016
     */
    int countByExample(HorarioExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table horario
     *
     * @mbggenerated Thu Aug 18 12:11:17 CDT 2016
     */
    int deleteByExample(HorarioExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table horario
     *
     * @mbggenerated Thu Aug 18 12:11:17 CDT 2016
     */
    int deleteByPrimaryKey(Integer idHorario);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table horario
     *
     * @mbggenerated Thu Aug 18 12:11:17 CDT 2016
     */
    int insert(Horario record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table horario
     *
     * @mbggenerated Thu Aug 18 12:11:17 CDT 2016
     */
    int insertSelective(Horario record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table horario
     *
     * @mbggenerated Thu Aug 18 12:11:17 CDT 2016
     */
    List<Horario> selectByExample(HorarioExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table horario
     *
     * @mbggenerated Thu Aug 18 12:11:17 CDT 2016
     */
    Horario selectByPrimaryKey(Integer idHorario);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table horario
     *
     * @mbggenerated Thu Aug 18 12:11:17 CDT 2016
     */
    int updateByExampleSelective(@Param("record") Horario record, @Param("example") HorarioExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table horario
     *
     * @mbggenerated Thu Aug 18 12:11:17 CDT 2016
     */
    int updateByExample(@Param("record") Horario record, @Param("example") HorarioExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table horario
     *
     * @mbggenerated Thu Aug 18 12:11:17 CDT 2016
     */
    int updateByPrimaryKeySelective(Horario record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table horario
     *
     * @mbggenerated Thu Aug 18 12:11:17 CDT 2016
     */
    int updateByPrimaryKey(Horario record);
}