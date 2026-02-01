package StrategyPattern;

import java.util.*;

interface Strategy {
    void sortNums(List<Integer>arr);
}

class BubbleSort implements Strategy {


    @Override
    public void sortNums(List<Integer>arr){
        System.out.println("Implementing BubbleSOrt");
        Collections.sort(arr);
        System.out.println("Bubble Sort Implemented Successfully");
        for(int x:arr){
            System.out.print(x+" ");
        }
        System.out.println();
    }
}

class MergeSort implements Strategy {


    @Override
    public void sortNums(List<Integer>arr){
        System.out.println("Implementing MergeSOrt");
        Collections.sort(arr);
        System.out.println("Merge Sort Implemented Successfully");
        for(int x:arr){
            System.out.print(x+" ");
        }
        System.out.println();
    }
}


public class StrategyPatternDemo {

    public static void main(String[] args){
        List<Integer>arr=new ArrayList<>();
        List<Integer>brr=new ArrayList<>();


        arr.add(9);arr.add(1);arr.add(2);
        brr.add(5);brr.add(2);brr.add(7);
        Strategy strat=new BubbleSort();
        strat.sortNums(arr);
        strat=new MergeSort();
        strat.sortNums(brr);
    
    }
}
