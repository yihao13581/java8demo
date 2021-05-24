package generatorSqlmapCustom.src.com.cmos.scrs.dao.satisfaction;

import generatorSqlmapCustom.src.com.cmos.scrs.beans.satisfaction.SatisfactionReport;

public interface SatisfactionReportMapper {
    int deleteByPrimaryKey(String rowId);

    int insert(SatisfactionReport record);

    int insertSelective(SatisfactionReport record);

    SatisfactionReport selectByPrimaryKey(String rowId);

    int updateByPrimaryKeySelective(SatisfactionReport record);

    int updateByPrimaryKey(SatisfactionReport record);
}