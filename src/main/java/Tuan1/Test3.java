package Tuan1;

/* Viet chuong trinh in ra man hinh bang cuu chuong tu 1 toi 10 */
public class Test3 {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            System.out.println("Bang cuu chuong " + i + ":");
            for (int j = 1; j <= 10; j++) {
                System.out.printf("%d x %d = %d\n", i, j, i * j);
            }
            System.out.println();
        }
    }
}
