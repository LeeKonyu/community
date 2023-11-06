package com.nowcoder.community.dao;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {
    /**
     * 查询帖子列表
     * @param userId    用户ID
     * @param offset    每一页的起始行号
     * @param limit     每一页最多显示的数据
     * @return
     */
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);

    /**
     * 查询帖子总数
     * @param userId    用户ID
     *                  当需要动态拼接SQL时，且只有一个参数，则使用@Param注解，将参数名与SQL语句中的占位符对应起来
     * @return
     */
    int selectDiscussPostRows(@Param("userId") int userId);
}
