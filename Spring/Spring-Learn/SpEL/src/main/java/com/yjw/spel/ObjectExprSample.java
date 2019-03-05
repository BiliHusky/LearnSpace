package com.yjw.spel;

import com.sun.org.apache.xpath.internal.Expression;
import com.yjw.User;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * Created by yjw on 18-9-19.
 */
public class ObjectExprSample {
    public static void main(String[] args) {
        User user = new User();
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext(user);
        parser.parseExpression("testValue").setValue(context,"Peter");
        System.out.println(user.getTestValue());
        parser.parseExpression("testValue='David'").getValue(context);
        System.out.println(user.getTestValue());

        System.out.println("==========================");
        System.out.println("加载");
        Class stringClass = parser.parseExpression("T(java.lang.String)").getValue(Class.class);
        System.out.println(stringClass==java.lang.String.class);

        Class userClass = parser.parseExpression("T(com.yjw.User)").getValue(Class.class);
        System.out.println(userClass == com.yjw.User.class);
        try {
            User test = (User) userClass.newInstance();
            test.setCredits(100);
            System.out.println(test.getCredits());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
