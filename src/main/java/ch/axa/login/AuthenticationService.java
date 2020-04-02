package ch.axa.login;

import javax.inject.Named;
import javax.inject.Singleton;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Named
@Singleton
public class AuthenticationService {

    private List<User> userList;

    public AuthenticationService() {
        this.userList = Arrays.asList(
                new User("peter", "8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92"),
                new User("heidi", "8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92"));
    }

    public Optional<Token> authenticateUser(Credentials credentials) {
        Optional<User> optionalUser = userList.stream().filter(u -> u.getUsername().equals(credentials.getUsername()) && u.getPwHash().equals(getHash(credentials.getUsername()))).findAny();
        if (optionalUser.isPresent()) {
            optionalUser.get().setToken(new Token(UUID.randomUUID().toString()));
            return Optional.of(optionalUser.get().getToken());
        }
        return Optional.empty();
    }

    public Optional<User> checkAuthToken(String token) {
        return userList.stream()
                .filter(u -> u.getToken() != null)
                .filter(u -> u.getToken().getTokenValue().equals(token))
                .findAny();
    }

    private String getHash(String inString) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] encodedhash = digest.digest(
                inString.getBytes(StandardCharsets.UTF_8));
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < encodedhash.length; i++) {
            String hex = Integer.toHexString(0xff & encodedhash[i]);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

}
