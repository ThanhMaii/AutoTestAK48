package Tuan1;

/* given an array = [34, 1, 23, 4, 3, 12, 45, 33, 6, 22] * find max item */
public class Test6 {
    public static void main(String[] args) {
        int[] arr = {34, 1, 23, 4, 3, 12, 45, 33, 6, 22};
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        System.out.println("Maximum value: " + max);
    }
}