package edu.miu.cs.cs425.junittesting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class JunitTestingApplication {

    public static void main(String[] args) {
        SpringApplication.run(JunitTestingApplication.class, args);

        ArrayFlattener flattener = new ArrayFlattener();
        ArrayReverser arrayReverser = new ArrayReverser(flattener);
        int[][] arr = {
                {1, 3},
                {0},
                {4, 5, 9}
        };

        int[] a = arrayReverser.reverseArray(arr);
        System.out.println(Arrays.toString(a));

    }


}
