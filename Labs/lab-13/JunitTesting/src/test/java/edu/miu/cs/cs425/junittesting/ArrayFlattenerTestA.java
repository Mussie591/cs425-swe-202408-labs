package edu.miu.cs.cs425.junittesting;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayFlattenerTestA {

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
        //input
        int[][] array = {{1, 2}, {3, 4}, {5, 6}};

        // expected output
        int[] expected = {1, 2, 3, 4, 5, 6};

        // test
        int[] actual = arrayFlattener.flattenArray(array);

        assertArrayEquals(expected, actual);

    }
}