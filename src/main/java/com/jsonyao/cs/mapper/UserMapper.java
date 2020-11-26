package com.jsonyao.cs.mapper;

import com.jsonyao.cs.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User findById(Long id);

}
