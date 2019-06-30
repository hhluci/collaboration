package nuc.crowdsys.service.impl;


import nuc.crowdsys.entity.SysDict;
import nuc.crowdsys.mapper.SysDictMapper;
import nuc.crowdsys.service.SysDictService;
import nuc.crowdsys.utils.QueryRequest;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("dictService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class SysDictServiceImpl extends BaseService<SysDict> implements SysDictService {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SysDictMapper dictMapper;


    @Override
    public List<SysDict> findAllDicts(SysDict dict, QueryRequest request) {
        try {
            Example example = new Example(SysDict.class);
            Criteria criteria = example.createCriteria();
            if (StringUtils.isNotBlank(dict.getKeyy())) {
                criteria.andCondition("keyy=", Long.valueOf(dict.getKeyy()));
            }
            if (StringUtils.isNotBlank(dict.getValuee())) {
                criteria.andCondition("valuee=", dict.getValuee());
            }
            if (StringUtils.isNotBlank(dict.getTableName())) {
                criteria.andCondition("table_name=", dict.getTableName());
            }
            if (StringUtils.isNotBlank(dict.getFieldName())) {
                criteria.andCondition("field_name=", dict.getFieldName());
            }
            example.setOrderByClause("dict_id");
            return this.selectByExample(example);
        } catch (Exception e) {
            log.error("获取字典信息失败", e);
            return new ArrayList<>();
        }
    }

    @Override
    @Transactional
    public void addDict(SysDict dict) {
        this.save(dict);
    }

    @Override
    @Transactional
    public void deleteDicts(String dictIds) {
        List<String> list = Arrays.asList(dictIds.split(","));
        this.batchDelete(list, "dictId", SysDict.class);
    }

    @Override
    @Transactional
    public void updateDict(SysDict dict) {
        this.updateNotNull(dict);
    }

    @Override
    public List<SysDict> findDictByFieldName(String fieldName) {
        return this.dictMapper.findDictByFieldName(fieldName);
    }

    @Override
    public SysDict findDictByFieldNameAndKeyy(String fieldName, String keyy) {
        return this.dictMapper.findDictByFieldNameAndKeyy(fieldName, keyy);
    }

    @Override
    public SysDict findById(Long dictId) {
        return this.selectByKey(dictId);
    }

}
