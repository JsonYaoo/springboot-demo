package com.jsonyao.cs.service;

import com.jsonyao.cs.entity.User;

import java.util.List;

public interface UserSerivce {

    User findById(Long id);

    void batchInsert(int size);
}
