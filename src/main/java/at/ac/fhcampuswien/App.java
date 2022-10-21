package at.ac.fhcampuswien;

import java.util.Random;
import java.util.Scanner;

public class App {

    // Implement all methods as public static
    public static void oneMonthCalendar(int days, int fwd){
        int rows = (int) Math.ceil((days+fwd-1)/7.0);
        int d = 1;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < 7; j++){
                if(i==0 && j < fwd-1){
                    System.out.print("   ");
                    continue;
                }
                System.out.print((d<10 ? " "+d : d)+" ");
                d++;
                if(d > days) break;
            }
            System.out.println();
            if(d > days) break;
        }
    }

    public static long[] lcg(long seed){
        long m = (long) Math.pow(2, 31);
        int a = 1103515245;
        int c = 12345;
        long[] lcg = new long[10];
        for(int i = 0; i < lcg.length; i++){
            lcg[i] = (a * (i > 0 ? lcg[i-1] : seed) + c) % m;
        }
        return lcg;
    }

    public static void guessingGame(int numberToGuess){
        Scanner sc = new Scanner(System.in);
        for(int i = 0;;){
            System.out.printf("Guess number %d: ", i+1);
            int input = sc.nextInt();
            if(input == numberToGuess){
                System.out.println("You won wisenheimer!");
                return;
            }
            i++;
            if(i==10) break;
            if(input > numberToGuess) System.out.println("The number AI picked is lower than your guess.");
            else System.out.println("The number AI picked is higher than your guess.");
        }
        System.out.println("You lost! Have you ever heard of divide & conquer?");
    }

    public static int randomNumberBetweenOneAndHundred(){
        return new Random().nextInt(100)+1;
    }

    public static boolean swapArrays(int[] a1, int[] a2){
        if(a1.length != a2.length) return false;
        for(int i = 0; i < a1.length; i++){
            int temp = a1[i];
            a1[i] = a2[i];
            a2[i] = temp;
        }
        return true;
    }

    public static String camelCase(String txt){
        char[] chars = txt.toCharArray();
        StringBuilder res = new StringBuilder();
        char first = chars[0];
        if(first >= 97) first = (char)(first-32);
        res.append(first);
        for (int i = 1; i < chars.length; i++){
            if(chars[i] == 32){
                char next = chars[i+1];
                if(next >= 97) next = (char)(next-32);
                res.append(next);
                i++;
                continue;
            }
            if(chars[i] < 65 || (chars[i] > 90 && chars[i] < 97) || chars[i] > 122) continue; //satzzeichen etc.
            char next = chars[i];
            if(next <= 90) next = (char)(next+32);
            res.append(next);
        }
        return res.toString();
    }

    public static int checkDigit(int[] code){
        int sum = 0;
        for(int i = 0; i < code.length; i++){
            sum += code[i] * (i+2);
        }
        int diff = 11 - (sum%11);
        if(diff == 10) return 0;
        if(diff == 11) return 5;
        return diff;
    }

    public static void main(String[] args) {
        // test your method implementations here
        // make method calls
        // print their results
        // etc.
        long[] nums = lcg(0);
        System.out.println("Pseudo-Zuffalszahlen: ");
        for (long n : nums) {
            System.out.println(n);
        }
        int rnum = randomNumberBetweenOneAndHundred();
        guessingGame(rnum);
    }
}