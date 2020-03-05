package com.yjw.interview.headfirst.link;

/**
 * @author David Yang
 * @date 2020-02-12 20:33
 */
public class YellowHandler extends PostHandler {

    @Override
    public void handlerRequest(Post post) {
        //屏蔽涉黄内容
        String content = post.getContent();
        //.....
        content = content.replace("涉黄","**");
        post.setContent(content);

        System.out.println("过滤涉黄内容...");
        //传递给下一个处理器
        next(post);
    }
}