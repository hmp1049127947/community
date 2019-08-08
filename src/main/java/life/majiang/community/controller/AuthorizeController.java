package life.majiang.community.controller;

import life.majiang.community.GitHubArgs;
import life.majiang.community.Provider.GithubProvider;
import life.majiang.community.dto.AccessTokenDto;
import life.majiang.community.dto.GithubUserDto;
import life.majiang.community.mapper.UserMapper;
import life.majiang.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.security.AccessControlContext;
import java.util.UUID;

/**
 * @author 黄明潘
 * @date 2019/8/3-17:43
 */
@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;
    @Autowired
    private GitHubArgs gitHubargs;
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/callback")
    public String callback(@RequestParam("code") String code,
                           @RequestParam("state") String state, HttpServletRequest request) {
        AccessTokenDto accessTokenDto = new AccessTokenDto();
        accessTokenDto.setClient_id(gitHubargs.getClientId());
        accessTokenDto.setClient_secret(gitHubargs.getClientSecret());
        accessTokenDto.setRedirect_uri(gitHubargs.getRedirectUri());
        accessTokenDto.setCode(code);
        accessTokenDto.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDto);
        String[] strings = accessToken.split("&");
        GithubUserDto userDto = githubProvider.getUser(strings[0]);
        System.out.println(userDto.toString());
        if (userDto != null) {
            User user = new User();
            user.setToken(UUID.randomUUID().toString());
            user.setName(userDto.getName());
            user.setAccountId(userDto.getId().toString());
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insertUser(user);
            request.getSession().setAttribute("user", userDto);
            return "redirect:/";
        } else {
            return "redirect:/";
        }
    }
}
