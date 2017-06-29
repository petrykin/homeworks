package lesson16.task2.model;

public class User {
    private String login;
    private String password;
    private Bucket bucket;

    public User() {
        login = "";
        password = "";
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        bucket = new Bucket();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Bucket getBucket() {
        return bucket;
    }

    public void setBucket(Bucket bucket) {
        this.bucket = bucket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        return login.equals(user.login);
    }

    @Override
    public int hashCode() {
        return login.hashCode();
    }

    @Override
    public String toString() {
        return "User{" +
                "login: '" + login + '\'' +
                ", password: '" + password + '\'' +
                '}';
    }
}
