package lesson18.task2;

public class User {
    private String login;
    private String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
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

    public void createQuery(String userTextQuery) {
        class Query {
            public void printToLog(String query) {
                System.out.printf("Пользователь: %s, отправил запрос: \"%s\"\n", User.this, query);
            }
        }

        Query query = new Query();
        query.printToLog(userTextQuery);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (!login.equals(user.login)) return false;
        return password.equals(user.password);
    }

    @Override
    public int hashCode() {
        int result = login.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "{" +
                "login: '" + login + '\'' +
                ", password: '" + password + '\'' +
                '}';
    }
}
