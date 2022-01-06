package pers.cgglyle.service.account.model.query;

/**
 * 登陆请求
 *
 * @author cgglyle
 * @date 2021-12-17 08:37
 */
public class LoginQuest {
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
