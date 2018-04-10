package ssm.dao.mybatis;

import ssm.model.mybatis.UserInfo;
import ssm.model.mybatis.UserInfoExample;
import tk.mybatis.mapper.common.Mapper;

public interface UserInfoMapper extends Mapper<UserInfo> {
    long countByExample(UserInfoExample example);
}