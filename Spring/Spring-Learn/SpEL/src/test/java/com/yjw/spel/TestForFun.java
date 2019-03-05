package com.yjw.spel;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.testng.annotations.Test;

/**
 * Created by yjw on 18-9-19.
 */
public class TestForFun {
    @Test
    public void testConCat() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'HelloWorld'.concat('!')");
        //String message = (String) exp.getValue();
        //or this way
        String message = exp.getValue(String.class);
        System.out.println(message);
    }
}
