package com.nowcoder.community.controller;

import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.Page;
import com.nowcoder.community.service.DiscussPostService;
import com.nowcoder.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    private DiscussPostService discussPostService;
    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String getIndexPage(Model model, Page page) {
        // DispatchServlet会自动实例化Model和Page，并自动将Page注入Model，
        // 所以不用model.addAttribute("page", page);了
        page.setRows(discussPostService.findDiscussPostRows(0));
        page.setPath("/index");

        //前端参数current会自动赋值给page，然后page.getOffset()得到当前页的偏移量
        List<DiscussPost> lists = discussPostService.findDiscussPosts(0, page.getOffset(), page.getLimit());
        List<Map<String, Object>> discussPosts = new ArrayList<>();
        //分别把Posts和Users装进List，然后通过model传给前端
        if(lists!= null){
            for(DiscussPost list : lists){
                Map<String, Object> map = new HashMap<>();
                map.put("post", list);
                map.put("user", userService.findUserById(list.getUserId()));
                discussPosts.add(map);
                discuss.add(map);
                discussPosts.remove(map);
            }
        }

        model.addAttribute("discussPosts", discussPosts);
        return "/index";
    }

}
