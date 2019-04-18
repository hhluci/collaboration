package nuc.mapper;

import java.util.List;
import nuc.entity.SysMoudle;
import nuc.entity.SysMoudleExample;
import org.apache.ibatis.annotations.Param;

public interface SysMoudleMapper {
    int countByExample(SysMoudleExample example);

    int deleteByExample(SysMoudleExample example);

    int insert(SysMoudle record);

    int insertSelective(SysMoudle record);

    List<SysMoudle> selectByExample(SysMoudleExample example);

    int updateByExampleSelective(@Param("record") SysMoudle record, @Param("example") SysMoudleExample example);

    int updateByExample(@Param("record") SysMoudle record, @Param("example") SysMoudleExample example);
}