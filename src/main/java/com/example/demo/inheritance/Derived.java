package com.example.demo.inheritance;

public class Derived extends Base{
    public void f(){
        System.out.println("Derived f()");
    }

    public void g(){
        System.out.println("Derived g()");
    }

    public static void main(String[] args){
        out:
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(j>=2){
                    break out;
                }
                System.out.println(j);
            }

        }

        System.out.println("break");
    }
}
