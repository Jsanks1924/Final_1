package sample.Collection;

public class MyBSTNode<data extends Comparable<data>> {
    /**
     * Used to hold references to BST nodes for the linked implementation
     */
    protected data info;                // The info in a BST node
    protected MyBSTNode<data> left;       // A link to the left child node
    protected MyBSTNode<data> right;      // A link to the right child node

    public MyBSTNode(data info) {
        this.info = info;
        left = null;
        right = null;
    }

    /**
     * Returns info of the BSTNode
     */
    public data getInfo() {
        return info;
    }

    /**
     * Sets info of the BSTNode
     */
    public void setInfo(data info) {
        this.info = info;
    }

    /**
     * Returns left link of the BSTNode
     */
    public MyBSTNode<data> getLeft() {
        return left;
    }

    /**
     * Sets left link of the BSTNode
     */
    public void setLeft(MyBSTNode<data> link) {
        left = link;
    }

    /**
     * Returns right link of the BSTNode
     */
    public MyBSTNode<data> getRight() {
        return right;
    }

    /**
     * Sets right link of the BSTNode
     */
    public void setRight(MyBSTNode<data> link) {
        right = link;
    }
}