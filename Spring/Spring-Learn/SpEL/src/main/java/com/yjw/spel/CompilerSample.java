package com.yjw.spel;

import com.yjw.User;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.spel.SpelCompilerMode;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * Created by yjw on 18-9-19.
 */
public class CompilerSample {
    public static void main(String[] args) {
        User user = new User();
        SpelParserConfiguration configuration = new SpelParserConfiguration(SpelCompilerMode.IMMEDIATE,
                CompilerSample.class.getClassLoader());
        SpelExpressionParser parser = new SpelExpressionParser(configuration);
        EvaluationContext context = new StandardEvaluationContext(user);
        String expression = "isVipMember('tom') && isVipMember('jony')";
        SpelExpression spelExpression = parser.parseRaw(expression);
        System.out.println(spelExpression.getValue(context));
        System.out.println(spelExpression.getValue(context));
    }
}
