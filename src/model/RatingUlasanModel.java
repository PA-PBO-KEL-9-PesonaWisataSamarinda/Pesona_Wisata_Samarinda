package model;

import java.util.Date;

public class RatingUlasanModel {
    private static int idRatingUlasan;
    private static int rating;
    private static String ulasan;
    private static Date tanggalRatingUlasan;
  
    public RatingUlasanModel(int idRatingUlasan, int rating, String ulasan, Date tanggalRatingUlasan){
        this.idRatingUlasan = idRatingUlasan;
        this.rating = rating;
        this.ulasan = ulasan;
        this.tanggalRatingUlasan = tanggalRatingUlasan;
    }

    public static int getIdRatingUlasan() {
        return idRatingUlasan;
    }

    public static int getRating() {
        return rating;
    }

    public static void setRating(int rating) {
        RatingUlasanModel.rating = rating;
    }

    public static String getUlasan() {
        return ulasan;
    }

    public static void setUlasan(String ulasan) {
        RatingUlasanModel.ulasan = ulasan;
    }

    public static Date getTanggalRatingUlasan() {
        return tanggalRatingUlasan;
    }

    public static void setTanggalRatingUlasan(Date tanggalUlasanRating) {
        RatingUlasanModel.tanggalRatingUlasan = tanggalUlasanRating;
    }
     
}
