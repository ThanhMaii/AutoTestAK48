package Tuan1;

import java.util.Scanner;

/* Viet 1 chuong trinh tinh tien taxi tu so km nhap vao
 * km dau tien 13000
 * tu km thu 2 cho toi km thu 10: 10000
 * tu km thu 11 tro di: 8000 */
public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số km đã đi: ");
        int soKm = scanner.nextInt();
        scanner.close();

        tinhTienTaxi(soKm);
    }

    public static void tinhTienTaxi(int soKm) {
        if (soKm <= 0) {
            System.out.println("Số km không hợp lệ! Vui lòng nhập số dương.");
            return; // Thoát chương trình nếu nhập sai
        }

        int tienKmDau = 13000;  // Giá km đầu tiên
        int tienKm2Den10 = 0;   // Giá từ km 2 đến km 10
        int tienKm11TroLen = 0; // Giá từ km 11 trở đi
        int tongTien = 0;       // Tổng tiền

        // Tính từng phần
        if (soKm >= 1) {
            tienKmDau = 13000;
        }
        if (soKm >= 2 && soKm <= 10) {
            tienKm2Den10 = (soKm - 1) * 10000; // Số km trừ đi km đầu tiên
        }
        if (soKm > 10) {
            tienKm2Den10 = 9 * 10000; // 9 km tiếp theo (km 2 → 10)
            tienKm11TroLen = (soKm - 10) * 8000; // Phần từ km 11 trở đi
        }

        // Tính tổng tiền
        tongTien = tienKmDau + tienKm2Den10 + tienKm11TroLen;

        // Xuất kết quả chi tiết
        System.out.println("Chi tiết tính tiền:");
        System.out.println("- Km đầu tiên: " + tienKmDau + " VND");
        System.out.println("- Từ km 2 đến km 10: " + tienKm2Den10 + " VND");
        System.out.println("- Từ km 11 trở đi: " + tienKm11TroLen + " VND");
        System.out.println("=> Tổng tiền taxi: " + tongTien + " VND");
    }
}

