package Tuan1;

import java.util.Scanner;

/* Viet 1 chuong trinh viet hoa cac ky tu dau tien cua moi tu trong chuoi
 * TC: khong co space hoac co nhieu dau space*/
public class Test5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chuỗi: ");
        String input = scanner.nextLine();
        scanner.close();

        String output = vietHoaChuCaiDau(input);
        System.out.println("Chuỗi sau khi viết hoa: " + output);
    }

    public static String vietHoaChuCaiDau(String str) {
        if (str == null || str.isEmpty()) {
            return str; // Trả về chuỗi rỗng nếu nhập trống
        }

        String[] words = str.toLowerCase().split("\\s+"); // Tách từ, loại bỏ khoảng trắng thừa
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                // Viết hoa chữ cái đầu tiên, giữ nguyên phần còn lại
                result.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1))
                        .append(" ");
            }
        }

        return result.toString().trim(); // Loại bỏ khoảng trắng cuối cùng
    }

}
