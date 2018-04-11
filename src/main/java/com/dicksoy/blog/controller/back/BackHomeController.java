package com.dicksoy.blog.controller.back;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.dicksoy.blog.base.BaseConstant;
import com.dicksoy.blog.base.BaseController;
import com.dicksoy.blog.base.BaseResult;
import com.dicksoy.blog.base.apiPrincipal.ApiPrincipal;
import com.dicksoy.blog.config.redis.RedisManager;
import com.dicksoy.blog.po.Aphorism;
import com.dicksoy.blog.po.Article;
import com.dicksoy.blog.po.User;
import com.dicksoy.blog.service.AphorismService;
import com.dicksoy.blog.service.ArticleService;
import com.dicksoy.blog.service.UserService;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/back")
public class BackHomeController extends BaseController {

    @Resource
    private UserService userService;

    @Resource
    private AphorismService aphorismService;

    @Resource
    private RedisManager redisManager;

    @Resource
    private ArticleService articleService;

    @GetMapping("/index")
    public String index(Model model) {
        List<Article> javaList = articleService.selectList(new EntityWrapper<Article>().eq("type", 1));
        List<Article> iosList = articleService.selectList(new EntityWrapper<Article>().eq("type", 2));
        model.addAttribute("javaArticles", javaList);
        model.addAttribute("iosArticles", iosList);
        return "back/back_index";
    }

    @GetMapping("/login")
    public String login(Model model, HttpServletRequest request) {
        // 已登录状态
        if (null != redisManager.get(request.getSession().getId())){
            return "back/index";
        }
        Aphorism aphorism = aphorismService.selectOneRandom();
        model.addAttribute("aphorism", aphorism);
        return "back/login";
    }

    @PostMapping("/login")
    @ResponseBody
    public BaseResult login(HttpServletRequest request, User user) {
        if (StringUtils.isEmpty(user) || StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())) {
            return BaseResult.builder().code(ERROR).msg(DEFAULT_VALI_MSG);
        }
        System.out.println(user.getPassword());
        /*user.setPassword("MD5加密之后的密码");*/
        User loginUser = userService.selectOne(new EntityWrapper<User>().eq("user_name", user.getUsername())
                .eq("password", user.getPassword()));
        if (null == loginUser) {
            return BaseResult.builder().code(ERROR).msg(USER_NOT_EXIST);
        } else {
            ApiPrincipal apiPrincipal = new ApiPrincipal(loginUser.getUsername(), loginUser.getUserId());
            apiPrincipal.setHost(request.getRemoteAddr());
            redisManager.set(BaseConstant.REDIS_SESSION_PREFIX + request.getRequestedSessionId(), JSONObject.toJSONString(apiPrincipal));
            return BaseResult.builder().code(OK).msg(DEFAULT_SUCCESS_MGS);
        }

    }
}
