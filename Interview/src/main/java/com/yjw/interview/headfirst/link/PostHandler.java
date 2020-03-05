package com.yjw.interview.headfirst.link;

/**
 * @author David Yang
 * @date 2020-02-12 20:32
 */
public abstract class PostHandler {

    /**
     * 后继者
     */
    protected PostHandler successor;

    public void setSuccessor(PostHandler handler){
        this.successor = handler;
    }

    public abstract void handlerRequest(Post post);

    protected final void next(Post post){
        if(this.successor != null){
            this.successor.handlerRequest(post);
        }
    }
}