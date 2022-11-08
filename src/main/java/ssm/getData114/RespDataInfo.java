package ssm.getData114;

import lombok.Data;

import java.util.List;

/**
 * @author fanxiao3
 * @className RespDataInfo
 * @description TODO
 * @date 2022/11/7 4:34 下午
 */
@Data
public class RespDataInfo {

    private String dutyCode;
    private String dutyImgUrl;
    private List<DoctorInfo> detail;
}
