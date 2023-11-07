package tdd;

public class User {

    String name;
    String password;

    boolean isAuthenticate = false;

    public User(String name, String password, boolean isAdmin) {
        this.name = name;
        this.password = password;

    }

    //3.6.
    public boolean authenticate(String name, String password) {
        //если логин и пароль соответствуют, то isAuthenticate становится - true
        isAuthenticate = (name.equalsIgnoreCase(this.name)) && password.equalsIgnoreCase(this.password);
        return isAuthenticate;
    }

}
