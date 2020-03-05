package com.yjw.interview.headfirst.link;

/**
 * @author David Yang
 * @date 2020-02-12 20:33
 */
public class SensitiveWordsHandler extends PostHandler {

    @Override
    public void handlerRequest(Post post) {
        //屏蔽敏感词
        String content = post.getContent();
        //.....
        content = content.replace("敏感词","**");
        post.setContent(content);

        System.out.println("过滤敏感词...");
        //传递给下一个处理器
        next(post);
    }
}