package nuc.crowdsys.entity;

import lombok.Data;
import lombok.ToString;


/**
 * @Author: jurui
 * @ProjectName: collaboration
 * @Package: nuc.crowdsys.entity
 * @Description:
 * @Date: Created in 10:37 2019-06-25
 */
@Data
@ToString
public class SysDict {

    private Long dictId;

    private String keyy;

    private String valuee;

    private String tableName;

    private String fieldName;
}
