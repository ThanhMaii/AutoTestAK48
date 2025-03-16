package Tuan1;

import java.util.Scanner;
/* viet 1 method kiem tra nhap vao 1 so nguyen la nam, kieem tra nam do la nam nhuan hay khong ?*/
public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nam;
        do {
            System.out.print("Nhap mot nam: ");
            nam = scanner.nextInt();
            if (nam < 0) {
                System.out.println("Nhap khong hop le!");
            }
        } while (nam < 0);
        scanner.close();
        if (laNamnhuan(nam)){
            System.out.println(nam + " la nam nhuan");
        }
        else {
            System.out.println(nam + " khong phai la nam nhuan");
        }
    }
    public static boolean laNamnhuan(int nam) {
        if (nam < 0) {
            System.out.println("Nhap khong hop le!");
            return false;
        }
        return (nam % 4 == 0 && nam % 100 != 0) || (nam % 400 == 0);
    }
}
