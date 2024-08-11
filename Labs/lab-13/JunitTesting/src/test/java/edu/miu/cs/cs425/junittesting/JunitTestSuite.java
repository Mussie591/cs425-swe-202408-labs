package edu.miu.cs.cs425.junittesting;

import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.springframework.boot.test.context.SpringBootTest;

@Suite
@SelectClasses({ArrayFlattenerTestA.class, ArrayFlattenerTestB.class, ArrayReverserTest.class })
@SpringBootTest
class JunitTestSuite {

    @Test
    void contextLoads() {
    }

}
