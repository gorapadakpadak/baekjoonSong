package com.company;
import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int n=Integer.parseInt(br.readLine());
        Queue q=new Queue();
        q.createQueue(n);
        while(n-->0){
            StringTokenizer st=new StringTokenizer(br.readLine()," ");
            switch(st.nextToken()){
                case "push" :
                    int x=Integer.parseInt(st.nextToken());
                    q.push(x);
                    break;
                case "pop" :
                    bw.write(q.pop()+"\n");
                    break;
                case "size" :
                    bw.write(q.size()+"\n");
                    break;
                case "empty" :
                    bw.write(q.isEmpty()+"\n");
                    break;
                case "front" :
                    if(q.isEmpty()==0) {
                        bw.write(q.arr[q.bottom]+"\n");
                    }else {
                        bw.write(-1+"\n");
                    }
                    break;
                case "back" :
                    if(q.isEmpty()==0) {
                        bw.write(q.arr[q.top]+"\n");
                    }else {
                        bw.write(-1+"\n");
                    }
                    break;
            }
        }
        bw.flush();
    }
    public static class Queue{
        int top;
        int bottom;
        int[] arr;
        private void createQueue(int size){
            top=-1;
            bottom=0;
            arr=new int[size];
        }
        private void push(int x){
            arr[++top]=x;
        }
        private int pop(){
            if(this.isEmpty()==0) {
                return arr[bottom++];
            }else{
                return -1;
            }
        }
        private int isEmpty(){
            if(top<bottom){
                return 1;
            }else{
                return 0;
            }
        }
        private int size(){
            if(top>=bottom){
                return top-bottom+1;
            }else{
                return 0;
            }
        }
    }
}
