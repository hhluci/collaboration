package nuc.crowdsys.mapper;


import nuc.crowdsys.entity.SysLog;
import nuc.crowdsys.utils.MyMapper;

public interface SysLogMapper extends MyMapper<SysLog> {
    void saveLog(SysLog sysLog);
}