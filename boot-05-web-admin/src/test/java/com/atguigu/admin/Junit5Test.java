package com.atguigu.admin;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DisplayName("junit5功能测试类")
public class Junit5Test {

//    @DisplayName("测试displayname注解")
//    @Test
//    void  testDisplayName(){
//        System.out.println(1);
//    }
//
//    @Disabled
//    @DisplayName("测试方法2")
//    @Test
//    void test2(){
//        System.out.println(2);
//    }
//
//    /**
//     * 断言:前面的断言失败，后面的代码都不执行
//     */
//    //测试简单断言
//    @DisplayName("测试简单断言")
//    @Test
//    void testSimpleAssertions(){
//        int cal = cal(2, 3);
//       assertEquals(5,cal,"业务逻辑计算失败");
//        Object obj1 = new Object();
//        Object obj2 = new Object();
//        assertSame(obj1,obj2,"两个对象不一样");
//    }
//    int cal(int i,int j){
//            return i+j;
//    }
//    @DisplayName("组合断言")
//    @Test
//    void all(){
//        /**
//         * 所有的断言成功，assertAll才成功！
//         */
//            assertAll("test",
//                    ()->assertTrue(true&&true,"结果不为true"),
//                    ()->assertEquals(1,2,"结果不是1"));
//        }
//
//
//        //测试前置条件
//    @DisplayName("测试前置条件")
//    @Test
//    void testassumptions(){
//        Assumptions.assumeTrue(false,"结果不是true");
//        System.out.println("1111111111111");
//    }
//    @BeforeEach
//    void testBeforeEach(){
//        System.out.println("测试就要开始了");
//    }
//
//    @AfterEach
//    void testAfterEach(){
//        System.out.println("测试结束了");
//    }
//
//    @BeforeAll
//    static void testBeforeAll(){
//        System.out.println("所有测试都要开始了");
//    }
//
//    @AfterAll
//    static void testAfterAll(){
//        System.out.println("所有测试都要结束了");
//    }
//
//    @Timeout(value = 500,unit = TimeUnit.MILLISECONDS)
//    @Test
//    void testTimeout() throws InterruptedException {
//        Thread.sleep(800);
//    }
//
}
