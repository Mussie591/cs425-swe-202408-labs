package edu.miu.cs.cs425.junittesting;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ArrayFlattenerTestB {


    private ArrayFlattener arrayFlattener;

    @BeforeEach
    void setUp() {
        arrayFlattener = new ArrayFlattener();
    }

    @AfterEach
    void tearDown() {
        arrayFlattener = null;
    }

    @Test
    void flattenArray() {

        int[][] arr = null;
        int[] actual = arrayFlattener.flattenArray(arr);
        assertArrayEquals(null, actual);

    }
}
