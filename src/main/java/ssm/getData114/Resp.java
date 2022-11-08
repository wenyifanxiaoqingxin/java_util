package ssm.getData114;

import lombok.Data;

import java.util.List;

@Data
public class Resp {
    private String resCode;
    private String msg;
    private List<RespDataInfo> data;
}