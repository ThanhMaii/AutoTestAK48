package Tuan1;

import java.util.Scanner;
/* Viet mot chuong trinh tim so lon nhat tu 3 so nguyen a b c */
public class Test4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số nguyên a: ");
        int a = scanner.nextInt();
        System.out.print("Nhập số nguyên b: ");
        int b = scanner.nextInt();
        System.out.print("Nhập số nguyên c: ");
        int c = scanner.nextInt();
        scanner.close();

        int max = Math.max(a, Math.max(b, c));

        System.out.println("Số lớn nhất trong ba số " + a + ", " + b + ", " + c + " là: " + max);
    }
}
