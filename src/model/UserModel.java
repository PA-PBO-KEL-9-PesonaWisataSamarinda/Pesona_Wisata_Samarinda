package model;

public abstract class UserModel{
    private final int id_user;
    private String username;
    private String password;
    private String email;
    private String no_telepon;
    private final String role;

    public UserModel(int id_user, String username, String password, String email, String no_telepon, String role ) {
        this.id_user = id_user;
        this.username = username;
        this.password = password;
        this.email = email;
        this.no_telepon = no_telepon;
        this.role = role;
    }

    public int getId_user() {
        return id_user;
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
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNo_telepon() {
        return no_telepon;
    }

    public void setNo_telepon(String no_telepon) {
        this.no_telepon = no_telepon;
    }

    public String getRole() {
        return role;
    }
    
    public boolean validateLogin(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
    
    public abstract String getUserInfo();

}
