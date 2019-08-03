package life.majiang.community.controller;

import life.majiang.community.Provider.GithubProvider;
import life.majiang.community.dto.AccessTokenDto;
import life.majiang.community.dto.GithubUserDto;
import life.majiang.community.util.ConstantUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.AccessControlContext;

/**
 * @author 黄明潘
 * @date 2019/8/3-17:43
 */
@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;
    @Value("${github.clientId}")
    private String client_id;
    @Value("${github.clientSecret}")
    private String client_secret;
    @Value("${github.redirectUri}")
    private String redirect_uri;

    @GetMapping("/callback")
    public String callback(@RequestParam("code") String code, @RequestParam("state") String state) {

        AccessTokenDto accessTokenDto = new AccessTokenDto();
        accessTokenDto.setClient_id(client_id);
        accessTokenDto.setClient_secret(client_secret);
        accessTokenDto.setRedirect_uri(redirect_uri);
        accessTokenDto.setCode(code);
        accessTokenDto.setState(state);
        githubProvider = new GithubProvider();
        String accessToken = githubProvider.getAccessToken(accessTokenDto);
        String[] strings = accessToken.split("&");
        GithubUserDto user = githubProvider.getUser(strings[0]);
        System.out.println(user.toString());
        return "redirect:/";
    }
}
