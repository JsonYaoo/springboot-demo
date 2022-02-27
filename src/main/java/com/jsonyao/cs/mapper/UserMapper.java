package com.jsonyao.cs.mapper;

import com.jsonyao.cs.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    User findById(Long id);

    void insertUserById(Long id);

    void updateUserById(Long id);

    void batchInsert(@Param("list")List<Integer> ids);
}
