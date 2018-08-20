package archtecture.datastructure;

/**
 * Created by yjw on 18-6-14.
 * this is red-black tree
 *
 * https://zh.wikipedia.org/wiki/红黑树
 */
public class RedBlackTree {

    /**
     * properties :
     *
     *
     * 1. root is black
     * 2. node is red or black
     * 3. every leaf node (NIL or null node ) is black
     * 4. every red node's child node is black
     * 5. all paths from any node to each of its leaf nodes contain the same number of black nodes
     *
     *
     *
     *
     * the purpose of rotation is to move branch's nodes whose node more to less branch
     *
     *
     * left rotation
     *
     *                        E                         S
     *                      /  \                      /  \
     *                    a     S      =>           E     z
     *                        /  \                /  \
     *                       h    z             a     h
     *
     * right rotation
     *
     *                       S                         E
     *                     /  \                      /  \
     *                   E     z       =>          a     S
     *                  / \                            /  \
     *                 a   h                          h    z
     */



}
