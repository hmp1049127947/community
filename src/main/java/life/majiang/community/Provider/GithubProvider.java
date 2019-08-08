package life.majiang.community.Provider;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import life.majiang.community.GitHubArgs;
import life.majiang.community.dto.AccessTokenDto;
import life.majiang.community.dto.GithubUserDto;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author 黄明潘
 * @date 2019/8/3-17:57
 */
@Component
public class GithubProvider {

    @Autowired
    private GitHubArgs gitHubArgs;
    /**
     * 获取accessToken的值
     * @param accessTokenDto 五个参数，故把它们封装成一个类
     * @return accessToken值
     */
    public  String getAccessToken(AccessTokenDto accessTokenDto) {

        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType,JSON.toJSONString(accessTokenDto));
        Request request = new Request.Builder()
                .url(gitHubArgs.getTokenUrl())
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String accessToken = response.body().string();//获取accessToken的值
            System.out.println(accessToken);//打印accessToken的值
            return accessToken;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过accessToken的值得到user的信息
     * @return
     */
    public GithubUserDto getUser(String accessToken) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(gitHubArgs.getUserUrl()+accessToken)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String userStr = response.body().string();
            GithubUserDto githubUserDto = JSON.parseObject(userStr,GithubUserDto.class); //通过fastJson工具将JSON值转换为GithubUserDto
            return githubUserDto;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
