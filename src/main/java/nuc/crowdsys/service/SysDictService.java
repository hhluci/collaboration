package nuc.crowdsys.service;


import nuc.crowdsys.entity.SysDict;
import nuc.crowdsys.utils.QueryRequest;

import java.util.List;


public interface SysDictService extends IService<SysDict> {

    List<SysDict> findAllDicts(SysDict dict, QueryRequest request);

    SysDict findById(Long dictId);

    void addDict(SysDict dict);

    void deleteDicts(String dictIds);

    void updateDict(SysDict dicdt);

    /**
     * 根据fieldName（字典编码）查询字典表集合
     *
     * @param fieldName
     * @return
     */
    List<SysDict> findDictByFieldName(String fieldName);

    /**
     * 根据 fieldName（字典编码）, keyy（字典项值）查询字典表实体对象
     *
     * @param fieldName
     * @param keyy
     * @return
     */
    SysDict findDictByFieldNameAndKeyy(String fieldName, String keyy);

}
