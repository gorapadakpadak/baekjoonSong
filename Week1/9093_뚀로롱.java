package com.company;
import java.io.*;
import java.nio.Buffer;
import java.util.*;

//ver1.charAt
public class Main {
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //System.out.print+어절마다 for문 돌게하니까 시간초과남
        //Stack<char> 스택 char형
        //BufferedWriter
        Stack<Character> stack=new Stack<Character>();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(N-->0){
            String s= br.readLine();//문장 읽고 s에 저장
            for(char c : s.toCharArray()){
                // for(자료형 변수명 : 배열명)
                //s의 문자들을 char인 글자를 하나씩 배열에 저장
                //거기에서 하나씩 빼내는 거
                //toCharArray() :
                if(c==' '||c=='\n'){
                    //어절마다 단어를 뒤집어주어야하기 때문에 띄어쓰기마다 pop하고 개행시 pop
                    while(!stack.isEmpty()){
                        bw.write(stack.pop());
                    }
                    bw.write(" ");
                }else{
                    stack.push(c);
                }
            }
            while(!stack.isEmpty()){
                bw.write(stack.pop());
            }
            bw.write("\n");
        }
        bw.flush();
    }

}

