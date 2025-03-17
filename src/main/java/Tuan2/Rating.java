package Tuan2;

public enum Rating {
    XUAT_SAC(9.0, "Xuat sac"),
    GIOI(8.0, "Gioi"),
    KHA(6.5, "Kha"),
    TRUNG_BINH(5.0, "Trung binh"),
    YEU(0.0, "Yeu");

    private final double score;
    private final String description;

    Rating(double score, String rate) {
        this.score = score;
        this.description = rate;
    }

    public double getScore() {
        return score;
    }

    public String getRate() {
        return description;
    }

    public static Rating getRating(double score) {
        for (Rating rating : Rating.values()) {
            if (score >= rating.getScore()) {
                return rating;
            }
        }
        return YEU;
    }

    public String getDescription() {
        return description;
    }
}
