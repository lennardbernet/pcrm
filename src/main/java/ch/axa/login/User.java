package ch.axa.login;

public class User {
    private String username;
    private String pwHash;
    private Token token;

    public User() {
        this("","");
    }

    public User(String username, String pwHash) {
        this.username = username;
        this.pwHash = pwHash;
        this.token = null;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPwHash() {
        return pwHash;
    }
    public void setPwHash(String pwHash) {
        this.pwHash = pwHash;
    }
    public Token getToken() {
        return token;
    }
    public void setToken(Token token) {
        this.token = token;
    }
}
