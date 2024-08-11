package edu.miu.cs.cs425.junittesting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayFlattener {


    public int[] flattenArray(int[][] array){

        if(array == null){
            return null;
        }

        List<Integer> list = new ArrayList<Integer>();

        for(int[] i: array){

            for(int j: i){
                list.add(j);
            }
        }

        int[] newArray = new int[list.size()];
        int count = 0;
        for(int i: list){
            newArray[count++] =i;
        }
        return newArray;
    }
}
