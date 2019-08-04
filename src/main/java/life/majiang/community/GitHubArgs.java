package life.majiang.community;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author 黄明潘
 * @date 2019/8/4-16:53
 */
@Configuration
@ConfigurationProperties(prefix = "github", ignoreUnknownFields = false)
@PropertySource("classpath:messages.properties")
@Component
public class GitHubArgs {

    private String clientId;
    private String clientSecret;
    private String redirectUri;
    private String scope;
    private String state;
    private String tokenUrl;
    private String userUrl;


    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTokenUrl() {
        return tokenUrl;
    }

    public void setTokenUrl(String tokenUrl) {
        this.tokenUrl = tokenUrl;
    }

    public String getUserUrl() {
        return userUrl;
    }

    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl;
    }

    @Override
    public String toString() {
        return "GitHubArgs{" +
                "clientId='" + clientId + '\'' +
                ", clientSecret='" + clientSecret + '\'' +
                ", redirectUri='" + redirectUri + '\'' +
                ", scope='" + scope + '\'' +
                ", state='" + state + '\'' +
                ", tokenUrl='" + tokenUrl + '\'' +
                ", userUrl='" + userUrl + '\'' +
                '}';
    }
}
