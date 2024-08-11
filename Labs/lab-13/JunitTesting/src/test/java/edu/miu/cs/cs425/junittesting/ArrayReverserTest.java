package edu.miu.cs.cs425.junittesting;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.ExpectedCount.times;

@ExtendWith(MockitoExtension.class)
class ArrayReverserTest {

    @Mock
    private ArrayFlattener arrayFlattener;
    private ArrayReverser arrayReverser;

    @BeforeEach
    void setUp() {
        this.arrayReverser = new ArrayReverser(arrayFlattener);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void reverseArray() {

        int[][] input = {{1, 2}, {3, 4},{5, 6}};
        int[] flattenedOutPut = {1, 2, 3, 4, 5, 6};

        when(arrayFlattener.flattenArray(input)).thenReturn(flattenedOutPut);

        int[] expectedOutput = {6, 5, 4, 3, 2, 1};
        int[] actualOutput = this.arrayReverser.reverseArray(input);
        assertArrayEquals(expectedOutput, actualOutput);
        verify(arrayFlattener).flattenArray(input);
    }
}