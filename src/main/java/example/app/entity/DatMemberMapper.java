package example.app.entity;

import example.app.entity.DatMember;
import example.app.entity.DatMemberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DatMemberMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dat_member
     *
     * @mbggenerated Tue Mar 27 21:11:54 AEDT 2018
     */
    int countByExample(DatMemberExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dat_member
     *
     * @mbggenerated Tue Mar 27 21:11:54 AEDT 2018
     */
    int deleteByExample(DatMemberExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dat_member
     *
     * @mbggenerated Tue Mar 27 21:11:54 AEDT 2018
     */
    int deleteByPrimaryKey(Integer code);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dat_member
     *
     * @mbggenerated Tue Mar 27 21:11:54 AEDT 2018
     */
    int insert(DatMember record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dat_member
     *
     * @mbggenerated Tue Mar 27 21:11:54 AEDT 2018
     */
    int insertSelective(DatMember record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dat_member
     *
     * @mbggenerated Tue Mar 27 21:11:54 AEDT 2018
     */
    List<DatMember> selectByExample(DatMemberExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dat_member
     *
     * @mbggenerated Tue Mar 27 21:11:54 AEDT 2018
     */
    DatMember selectByPrimaryKey(Integer code);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dat_member
     *
     * @mbggenerated Tue Mar 27 21:11:54 AEDT 2018
     */
    int updateByExampleSelective(@Param("record") DatMember record, @Param("example") DatMemberExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dat_member
     *
     * @mbggenerated Tue Mar 27 21:11:54 AEDT 2018
     */
    int updateByExample(@Param("record") DatMember record, @Param("example") DatMemberExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dat_member
     *
     * @mbggenerated Tue Mar 27 21:11:54 AEDT 2018
     */
    int updateByPrimaryKeySelective(DatMember record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dat_member
     *
     * @mbggenerated Tue Mar 27 21:11:54 AEDT 2018
     */
    int updateByPrimaryKey(DatMember record);
}