package model;

public class Pengunjung extends UserModel{
    private int jumlah_review;

    public Pengunjung(int id_user, String username, String password, String email, String no_telepon, String role, int jumlah_review) {
        super(id_user, username, password, email, no_telepon, role);
        this.jumlah_review = jumlah_review;
    }

    public int getJumlah_review() {
        return jumlah_review;
    }

    public void setJumlah_review(int jumlah_review) {
        this.jumlah_review = jumlah_review;
    }
    
    @Override
    public String getUserInfo() {
        return "Pengunjung: " + getUsername() + " | Email: " + getEmail() + " | Jumlah Review: " + getJumlah_review();
    }
}

