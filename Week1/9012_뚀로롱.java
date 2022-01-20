package com.company;
import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n=Integer.parseInt(br.readLine());
        while(n-->0){
            String s = br.readLine();
            Stack<Character> stack=new Stack<>();
            int count=0;
            for(char c : s.toCharArray()){
                if(c=='('){
                    stack.push(c);
                }else{
                    if(stack.isEmpty()){
                        count=-1;
                        break;
                    }
                    stack.pop();
                }
            }
            if(stack.isEmpty()&&count!=-1){
                bw.write("YES\n");
            }else{
                bw.write("NO\n");
            }
        }
        bw.flush();
    }
}
