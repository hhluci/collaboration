package nuc.crowdsys.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import nuc.crowdsys.utils.QueryRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class BaseController {

    public static Map<String, Object> getDataTable(PageInfo<?> pageInfo) {
        Map<String, Object> rspData = new HashMap<>();
        rspData.put("rows", pageInfo.getList());
        rspData.put("total", pageInfo.getTotal());
        return rspData;
    }

    public static Map<String, Object> selectByPageNumSize(QueryRequest request, Supplier<?> s) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        PageInfo<?> pageInfo = new PageInfo<>((List<?>) s.get());
        PageHelper.clearPage();
        return getDataTable(pageInfo);
    }


}
