package nuc.crowdsys.service;


import nuc.crowdsys.entity.SysLog;

import java.util.List;

public interface SysLogService extends IService<SysLog> {

    List<SysLog> findAllLogs(SysLog log);

    void deleteLogs(String logIds);

    void saveLog(SysLog log);
}
