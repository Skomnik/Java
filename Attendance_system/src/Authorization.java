import java.util.Objects;

public class Authorization {
    private String username;
    private String password;
    private Hashpassword hashpassword;

    public Authorization(String username, String password){

        setUsername(username);
        setPassword(password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }



    public void setPassword(String password) {
        this.password = hashpassword.hash(password);
        if (password.matches("(\\p{ASCII}){3,20}")) {
            this.password = hashpassword.hash(password);
            //this.password = password;
        }
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Authorization account = (Authorization) o;
        return Objects.equals(getUsername(), account.username) && Objects.equals(getPassword(), account.password);
    }

    }

