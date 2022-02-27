package com.jsonyao.cs.service.impl;

import com.jsonyao.cs.controller.UserController;
import com.jsonyao.cs.entity.User;
import com.jsonyao.cs.service.UserSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserSerivce {

//    @Resource
//    private UserMapper userMapper;
//    @Autowired
//    private SqlSessionTemplate sqlSessionTemplate;
    @Autowired
    private UserController userController;

//    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = {Exception.class})
    @Override
    public User findById(Long id) {
//        User user = userMapper.findById(id);
//        userMapper.insertUserById(10086L);
//        user = userMapper.findById(10086L);
//        return user == null? new User(0000L, "空指针", "空指针") : user;
        return new User(0L, "AOP", "AOP");
    }

//    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = {Exception.class})
    @Override
    public void batchInsert(int size) {
        /**
         * 1) 12w数据插入:
         * com.mysql.cj.jdbc.exceptions.PacketTooBigException: Packet for query is too large (9,386,723 > 4,194,304).
         * You can change this value on the server by setting the 'max_allowed_packet' variable.
         *
         * 原因: MySQL写入数据过大
         * 解决方案: my.ini -> 设置 max_allowed_packet=50*1024*1024, 默认为4M
         * 或者: show variables like '%max_allowed_packet%';
         *      set global max_allowed_packet=52428800;
         *
         * 2) 5w数据插入:
         * java.lang.OutOfMemoryError: Java heap space
         * 原因: userMapper.batchInsert(ids);
         * 解决方案: 一行一行插入, 然后批量提交
         *  SqlSession sqlSession = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH);
         *  sqlSession.commit();
         *  sqlSession.clearCache();
         */
//        List<Integer> ids = new ArrayList<>();
//        for (int i = 0; i < size; i++) {
//            ids.add(i);
//        }
//
//        // ExecutorType.SIMPLE/ExecutorType.REUSE
//        // userMapper.batchInsert(ids);
//
//        // ExecutorType.BATCH
//        SqlSession sqlSession = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH);
//        UserMapper sessionMapper = sqlSession.getMapper(UserMapper.class);
//        for (int i = 0; i < ids.size(); i++) {
//            sessionMapper.insertUserById(Long.valueOf(ids.get(i)));
//            if (i % 10000 == 0 || i == ids.size() - 1) {
//                // 手动每400条提交一次
//                sqlSession.commit();
//                // 清理缓存，防止溢出
//                sqlSession.clearCache();
//                System.err.println("已提交");
//            }
//        }

        // 每批都是同一个事务, 只要其中一个异常, 则所有都回滚
//        int i = 1 / 0;
        return;
    }
}
