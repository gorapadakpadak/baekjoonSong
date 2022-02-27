package com.company;
import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        char data;
        Node left,right;
        //가중치 저장
        public Node(char data) {
            this.data=data;
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Tree tree=new Tree();
        for(int i=0;i<n;i++){
            tree.add(sc.next().charAt(0),sc.next().charAt(0),sc.next().charAt(0));
        }
        tree.PreOrder(tree.root);
        System.out.println();
        tree.InOrder(tree.root);
        System.out.println();
        tree.PostOrder(tree.root);
    }
    public static class Tree {
        Node root;

        public void add(char data, char left_data, char right_data) {
            if (root == null) {
                //data가 .이 아닐 경우 루트에 data값을 가진 노드 생성
                if (data != '.') root = new Node(data);
                if (left_data != '.') root.left = new Node(left_data);
                if (right_data != '.') root.right = new Node(right_data);
            }else {
                //root가 null이 아니라면 탐색
                search(root,data,left_data,right_data);
            }
        }
        public void search(Node root,char data, char left_data, char right_data){
            if(root==null) return;
            else if(root.data==data){
                if(left_data!='.') root.left=new Node(left_data);
                if(right_data!='.') root.right=new Node(right_data);
            }else{
                search(root.left, data,left_data, right_data);
                search(root.right,data, left_data,right_data);
            }
        }
        public static void PreOrder(Node root){
            System.out.print(root.data);
            if(root.left!=null) PreOrder(root.left);
            if(root.right!=null) PreOrder(root.right);
        }
        public static void InOrder(Node root){
            if(root.left!=null) PreOrder(root.left);
            System.out.print(root.data);
            if(root.right!=null) PreOrder(root.right);
        }
        public static void PostOrder(Node root){
            if(root.left!=null) PreOrder(root.left);
            if(root.right!=null) PreOrder(root.right);
            System.out.print(root.data);
        }
    }
}