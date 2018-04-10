package ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.dao.mybatis.UserInfoMapper;
import ssm.model.mybatis.UserInfo;
import ssm.service.UserInfoService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by fx on 2017/10/20.
 */
@Service("userService")
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    public List<UserInfo> userList() {
        return userInfoMapper.selectAll();
    }
}
