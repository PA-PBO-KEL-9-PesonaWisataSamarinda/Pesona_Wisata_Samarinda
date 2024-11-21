package model;

public class Admin extends UserModel{
    private String status;

    public Admin(int id_user, String username, String password, String email, String no_telepon, String role, String status) {
        super(id_user, username, password, email, no_telepon, role);
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    @Override
    public String getUserInfo() {
        return "Admin: " + getUsername() + " | Email: " + getEmail() + " | Status: " + getStatus();
    }
}