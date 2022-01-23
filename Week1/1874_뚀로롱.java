package com.company;
import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        //BufferedWriter vs StringBuilder
        //bufferedwriter는 출력초과나서 Stringbuilder로 바꿈
        //둘의 차이 비교해보기!
        //bufferedwriter의 비정기적인 flush때문이라는데 뭔 소린지 모르겠음..ㅎ...^^
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int j=1;
        Stack<Integer> stack=new Stack<>();
        while(n-->0) {
            int x = Integer.parseInt(br.readLine());
            while(x>=j) {
                stack.push(j);
                sb.append("+").append("\n");
                j++;
            }
            if (stack.peek() == x) {
                stack.pop();
                sb.append("-").append("\n");
            }
        }
        if(!stack.isEmpty()) {
            System.out.print("NO");
        }else{
            System.out.print(sb);
        }
    }
}
