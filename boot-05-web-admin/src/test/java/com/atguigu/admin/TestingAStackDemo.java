package com.atguigu.admin;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.EmptyStackException;
import java.util.Stack;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("嵌套测试")
public class TestingAStackDemo {
    Stack<Object> stack;

    @ParameterizedTest
    @DisplayName("参数化设置")
    @ValueSource(ints ={1,2,3,4,5})
    void testParameterized(int i){
        System.out.println(i);
    }

    @ParameterizedTest
    @DisplayName("参数化设置")
    @MethodSource("stringProvider")
    void testParameterized2(String i){
        System.out.println(i);
    }

    static Stream<String> stringProvider() {
        return Stream.of("apple", "banana","atguigu");
    }
    @Test
    @DisplayName("is instantiated with new Stack()")
    void isInstantiatedWithNew() {
        new Stack<>();
        //嵌套测试情况下，外层的test不能驱动内层的BeforeEach(BeforeAfter)/All
        assertNull(stack);
    }

    @Nested
    @DisplayName("when new")
    class WhenNew {

        @BeforeEach
        void createNewStack() {
            stack = new Stack<>();
        }

        @Test
        @DisplayName("is empty")
        void isEmpty() {
            assertTrue(stack.isEmpty());
        }

        @Test
        @DisplayName("throws EmptyStackException when popped")
        void throwsExceptionWhenPopped() {
            assertThrows(EmptyStackException.class, stack::pop);
        }

        @Test
        @DisplayName("throws EmptyStackException when peeked")
        void throwsExceptionWhenPeeked() {
            assertThrows(EmptyStackException.class, stack::peek);
        }


        /**
         *内层的测试可以驱动外层的BeforeEach(BeforeAfter)/All
         */
        @Nested
        @DisplayName("after pushing an element")
        class AfterPushing {

            String anElement = "an element";

            @BeforeEach
            void pushAnElement() {
                stack.push(anElement);
            }

            @Test
            @DisplayName("it is no longer empty")
            void isNotEmpty() {
                assertFalse(stack.isEmpty());
            }

            @Test
            @DisplayName("returns the element when popped and is empty")
            void returnElementWhenPopped() {
                assertEquals(anElement, stack.pop());
                assertTrue(stack.isEmpty());
            }


            @Test
            @DisplayName("returns the element when peeked but remains not empty")
            void returnElementWhenPeeked() {
                assertEquals(anElement, stack.peek());
                assertFalse(stack.isEmpty());
            }
        }
    }
}
