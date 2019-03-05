package com.yjw.spel;


import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * Created by yjw on 18-9-19.
 */
public class SpelHi {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'hello' + 'world'");
        String message = (String) exp.getValue();
        System.out.println(message);
    }
}
