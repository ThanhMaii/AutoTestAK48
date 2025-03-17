package Tuan2;

/*    Viết chương trình để tạo một lớp học sinh
 Giải thích đề bài

Bài tập yêu cầu bạn viết một chương trình để tạo một lớp HocSinh.
Lớp này sẽ chứa các thuộc tính và phương thức để mô tả và thao tác với đối tượng học sinh.
Các thuộc tính cơ bản của học sinh có thể bao gồm tên, tuổi, điểm trung bình,
và các phương thức để hiển thị thông tin học sinh hoặc tính toán các giá trị nào đó.
    chuong trinh xep loai theo diem trung binh:
    - diem trung binh >= 9.0: xuat sac
    - diem trung binh >= 8.0: gioi
    - diem trung binh >= 6.5: kha
    - diem trung binh >= 5.0: trung binh
    - diem trung binh < 5.0: yeu
*/

import java.util.Random;
import java.util.UUID;

public class HocSinh {
    private String id;
    private String name;
    private int age;
    private double score;

    public HocSinh(String name, int age, double score) {
        Random random = new Random();
        int randomNum = 1000 + random.nextInt(9000);
        this.id = "TVN-AK48-" + randomNum;
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public void info() {
        System.out.println("Student id: " + id);
        System.out.println("Student name: " + name);
        System.out.println("Student age: " + age);
        System.out.println("Student rating: " + rate().getDescription());
    }

    public Rating rate() {
        if (this.score < 0 || this.score > 10) {
            throw new IllegalArgumentException("Invalid score");
        } else if (this.score >= 9.0) {
            return Rating.XUAT_SAC;
        } else if (this.score >= 8.0) {
            return Rating.GIOI;
        } else if (this.score >= 6.5) {
            return Rating.KHA;
        } else if (this.score >= 5.0) {
            return Rating.TRUNG_BINH;
        } else {
            return Rating.YEU;
        }
    }



    public static String randomName(){
        String[] names = {"Huong", "Anh", "Mai", "Doti", "Hoa", "Nhu", "Hong", "Khanh", "Tien", "Phuong"};
        Random random = new Random();
        return names[random.nextInt(names.length)];}
}
