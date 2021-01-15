package com.example.hy.system.mapper;

import com.example.hy.system.entity.HyUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface HyUserMapper {
    /**
     * @Author hanlulu
     * @Description
     * @Date  2020-9-23
     * @Param [user]
     * @return java.lang.Integer
     **/
    public Integer insert(HyUser user);

    /**
     * 登录
     * @param username
     * @param passwords
     * @return
     */
    public HyUser login(String username, String passwords);
}