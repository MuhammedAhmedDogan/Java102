import java.util.Scanner;

public class Main {
    public static int index(int[] arr, int indexNo) {
        if (indexNo < 0 || indexNo >= arr.length) {
            throw new ArrayIndexOutOfBoundsException("Index is out of the array bounds.");
        }
        return arr[indexNo];
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Scanner input = new Scanner(System.in);
        System.out.print("Index Number : ");

        try {
            int indexNo = input.nextInt();
            System.out.println(index(arr, indexNo));
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}