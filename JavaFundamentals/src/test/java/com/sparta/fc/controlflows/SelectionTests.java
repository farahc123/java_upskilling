package com.sparta.fc.controlflows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class SelectionTests {

    // getGradeIfElse test
    @ParameterizedTest
    @ValueSource(ints = {0,40,64})
    public void givenAMarkLessThan65_getGradeIfElse_ReturnsFail(int mark){
        Assertions.assertEquals("Fail", Selection.getGradeIfElse(mark));
    }

    // getPriority tests
    @Test
    @DisplayName("Test getPriority with 0")
    public void givenAPriorityOf0_getPriority_ReturnCodeGreen(){
        Assertions.assertEquals("Code Green", Selection.getPriority(0));
    }

    @Test
    @DisplayName("Test getPriority with 1")
    public void givenAPriorityOf1_getPriority_ReturnCodeAmber(){
        Assertions.assertEquals("Code Amber", Selection.getPriority(1));
    }

    @Test
    @DisplayName("Test getPriority with 3")
    public void givenAPriorityOf3_getPriority_ReturnCodeRed(){
        Assertions.assertEquals("Code Red", Selection.getPriority(3));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 99})
    public void givenAPriorityOf4To99_getPriority_ReturnError(int level){
        Assertions.assertEquals("error", Selection.getPriority(level));
    }

    // getGradeConditionalOperators tests

    @ParameterizedTest
    @ValueSource(ints = {0, 64})
    public void givenAGradeOf0Or64_getGradeConditionalOperators_ReturnFail(int grade){
        Assertions.assertEquals("Fail", Selection.getGradeConditionalOperators(grade));
    }

    @ParameterizedTest
    @ValueSource(ints = {65, 84})
    public void givenAGradeOf65Or84_getGradeConditionalOperators_ReturnPass(int grade){
        Assertions.assertEquals("Pass", Selection.getGradeConditionalOperators(grade));
    }

    @Test
    @DisplayName("Test getGradeConditionalOperators with 85")
    public void givenAGradeOf85_getGradeConditionalOperators_ReturnDistinction(){
        Assertions.assertEquals("Distinction", Selection.getGradeConditionalOperators(85));
    }

}
