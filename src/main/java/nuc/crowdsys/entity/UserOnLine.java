package nuc.crowdsys.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
public class UserOnLine implements Serializable {

    private static final long serialVersionUID = 3819885072658204812L;

    private String username;

    private String sessionId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date loginTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date lastRequested;

    private String ip;

    private String loginType;
}
