package edu.miu.cs.cs425.junittesting;

public class ArrayReverser {

    private ArrayFlattener arrayFlattener;

    public ArrayReverser(ArrayFlattener arrayFlattener) {
        this.arrayFlattener = arrayFlattener;
    }

    public int[] reverseArray(int[][] array) {
        int[] flatArray = arrayFlattener.flattenArray(array);
        int first=0;
        int last=flatArray.length-1;
        while(first<last) {
            int temp = flatArray[first];
            flatArray[first]=flatArray[last];
            flatArray[last]=temp;
            first++;
            last--;
        }

        return flatArray;
    }
}
