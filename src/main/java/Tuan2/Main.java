package Tuan2;

/* Tạo ra 1 danh sách hoc sinh voi 10 ban
 *   Random diem tu 1 den 10 in double
 *   Random tuoi tu 18 den 25 in int
 *   Random ten*/

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<HocSinh> classroom = new ArrayList<HocSinh>();
        for (int i = 0; i < 10; i++) {
            classroom.add(new HocSinh(randomName(), randomAge(), randomScore()));
        }
        //classroom.stream().forEach(HocSinh::info);
        classroom.stream().filter(hocSinh -> hocSinh.rate() == Rating.XUAT_SAC).forEach(HocSinh::info);
    }

    public static String randomName(){
        String[] names = {"Huong", "Anh", "Mai", "Doti", "Hoa", "Nhu", "Hong", "Khanh", "Tien", "Phuong"};
        Random random = new Random();
        return names[random.nextInt(names.length)];}

    public static int randomAge(){
        Random random = new Random();
        return random.nextInt(25 - 18 + 1) + 18;}

    public static double randomScore(){
        Random random = new Random();
        double score = 1.0 + 9.0 * random.nextDouble();
        return Math.round(score * 10.0) / 10.0;
    }
}
