package nuc.crowdsys.mapper;


import nuc.crowdsys.entity.SysDict;
import nuc.crowdsys.utils.MyMapper;

import java.util.List;

public interface SysDictMapper extends MyMapper<SysDict> {

    List<SysDict> findDictByFieldName(String fieldName);

    SysDict findDictByFieldNameAndKeyy(String fieldName, String keyy);
}