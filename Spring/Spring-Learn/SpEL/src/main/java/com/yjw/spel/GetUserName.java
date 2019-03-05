package com.yjw.spel;


import com.yjw.User;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * Created by yjw on 18-9-19.
 */
public class GetUserName {
    public static void main(String[] args) {
        User user = new User();
        user.setUserName("Tom");
        user.setCredits(100);
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext(user);
        String username = (String) parser.parseExpression("userName").getValue(context);
        System.out.println(username);
    }
}


