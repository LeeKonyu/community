package com.nowcoder.community;

import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@SpringBootTest
//指明主启动类
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTests {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Test
    public void testSelectUser() {
        User user = userMapper.selectById(101);
        System.out.println(user);
        user = userMapper.selectByName("liubei");
        System.out.println(user);
        user = userMapper.selectByEmail("nowcoder101@sina.com");
        System.out.println(user);


    }

    @Test
    public void testInsertUser(){
        User user = new User();
        user.setUsername("test");
        user.setPassword("123456");
        user.setEmail("test@nowcoder.com");
        user.setType(1);
        user.setCreateTime(new java.util.Date());
        user.setSalt("12345");
        user.setHeadUrl("test");

        int rows = userMapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());
    }

    @Test
    public void updateUser(){
        User user = userMapper.selectById(101);
        if(user == null){
            return;
        }
        // 输出更新前
        System.out.println(user);
        userMapper.updatePassword(101, "hahaha");
        userMapper.updateStatus(101, 0);
        userMapper.updateHeadUrl(101, "test");
        user = userMapper.selectById(101);
        // 输出更新后
        System.out.println(user);
    }

    @Test
    public void testSelectDiscussPost(){
        int userId = 101;
        int offset = 0;
        int limit = 10;
        List<DiscussPost> discussPosts = discussPostMapper.selectDiscussPosts(userId, offset, limit);
        for(DiscussPost discussPost : discussPosts){
            System.out.println(discussPost);
        }
        System.out.println(discussPostMapper.selectDiscussPostRows(userId));

    }
}
