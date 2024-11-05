import java.util.Arrays;
import java.util.Scanner;
public class FlagsAI {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Game instructions: Everyone in turn can take between 1 and 3 flags whoever takes the last flag is the winner ");

        char[] arr = {'⚐', '⚐', '⚐', '⚐', '⚐', '⚐', '⚐', '⚐', '⚐', '⚐', '⚐', '⚐', '⚐', '⚐', '⚐', '⚐', '⚐', '⚐', '⚐', '⚐', '⚐'};
        int c = 0;
        System.out.println(" if you want start enter 1 else enter 2");
        int pl = in.nextInt();
        while (!win(arr, c)) {
            c = 1;
            System.out.println();
            System.out.println(Arrays.toString(arr));
            if (pl == 1) {
                System.out.println();
                System.out.println(" enter how number you wont to take");
                int a = in.nextInt();
                player(arr, a);
            } else {
                AI(arr, pl);
            }
            if (pl == 1) {
                pl = 2;
            } else {
                pl = 1;
            }
        }
        System.out.println(Arrays.toString(arr));

        if (pl == 2)
            System.out.println("you win");
        else
            System.out.println("AI win");
    }

    public static void player(char[] arr, int a) {
        Scanner in = new Scanner(System.in);
        int i = 0;
        boolean folt = true;
        while (folt) {
            if (a < 4 && a > 0) {
                while (a > 0) {
                    if (arr[i] == '⚐') {
                        arr[i] = '0';
                        folt = false;
                        a--;
                    } else {
                        i++;
                    }
                }
            } else {
                System.out.println("enter number big form 0 and no from 3");
                a = in.nextInt();
            }
        }
    }

    public static boolean win(char[] arr, int c) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '0') {
                count++;
            }
        }
        if (count == arr.length)
            return true;
        return false;
    }

    public static void AI(char[] arr, int a) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '⚐')
                count++;
        }
        if (count % 4 != 0 && count > 0) {
            int i = 0;
            while (true) {
                if (arr[i] == '⚐') {
                    arr[i] = '0';
                    count--;
                    if (count % 4 == 0)
                        break;
                } else {
                    i++;
                }
            }
        } else if (count % 4 == 0) {
            int i2 = 0;
            int num = 3;
            while (num > 0) {
                if (arr[i2] == '⚐') {
                    arr[i2] = '0';
                    num--;
                } else
                    i2++;
            }
        }
    }
}
