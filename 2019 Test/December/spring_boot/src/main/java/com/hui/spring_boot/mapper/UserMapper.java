package com.hui.spring_boot.mapper;

import com.hui.spring_boot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from test where id = #{id}")
    public User selectById(@Param("id") Integer id);
    @Select("select * from test")
    public List<User> all();
}
