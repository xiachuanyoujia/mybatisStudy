package com.kuang.dao;

import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class UserDaoTest {

    @Test
    public void getUserByLimit(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            HashMap<String, Integer> map = new HashMap<String, Integer>();
            map.put("startIndex", 2);
            map.put("pageSize", 2);

            List<User> userList = mapper.getUserByLimit(map);
            for (User user : userList) {
                System.out.println(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void getUserTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {
            UserMapper userDao = sqlSession.getMapper(UserMapper.class);
            List<User> userList = userDao.getUserList();

            for (User user : userList) {
                System.out.println(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }


}
