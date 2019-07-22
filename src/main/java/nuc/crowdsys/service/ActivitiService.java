package nuc.crowdsys.service;


import nuc.crowdsys.entity.FlowProcess;

import java.io.IOException;
import java.util.List;

public interface ActivitiService {

    List<FlowProcess> selAllactiviti(FlowProcess flowProcess);

    void activitiInsert(String filename) throws IOException;

}
