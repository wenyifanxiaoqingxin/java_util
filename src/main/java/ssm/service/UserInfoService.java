package ssm.service;

import ssm.model.mybatis.UserInfo;

import java.util.List;

/**
 * Created by fx on 2017/10/20.
 */
public interface UserInfoService {
    List<UserInfo> userList();
}
