package Tuan1;

public class Test8 {
    public static void main (String[] args){
        String str = "swiss";
        printLast4Chars(str);
    }

    private static void printLast4Chars(String str){
        int size = str.length();
        int counter = size-4;
        for(int i = counter; i<size; i++)
        {
            System.out.print(str.charAt(i));
        }
    }
}
