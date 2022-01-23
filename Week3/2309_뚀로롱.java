package com.company;
import java.io.*;
import java.util.*;
public class Main {
    public static int[] height;
    public static int sum;
    public static void main(String[] args) throws IOException {
        height=new int[9];
        sum=0;
        Scanner scan=new Scanner(System.in);
        for(int i=0;i<9;i++) {
            height[i]=scan.nextInt();
            sum+=height[i];
        }
        sum=sum-100;
        findSpy();
        Arrays.sort(height);
        for(int i=2;i<9;i++){
            System.out.println(height[i]);
        }
    }
    public static void findSpy() {
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (height[i] + height[j] == sum) {
                    height[i] = 0;
                    height[j] = 0;
                    return;
                }
            }
        }
    }

}