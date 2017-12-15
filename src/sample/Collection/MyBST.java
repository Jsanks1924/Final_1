package sample.Collection;
import sample.Exceptions.Underflow;

import java.util.LinkedList;

public class MyBST<data extends Comparable<data>> implements IMyBST<data> {
        protected MyBSTNode<data> root;      // reference to the root of the BST for traversals
        protected LinkedList<data> inOrderQueue;    // queue of info
        protected LinkedList<data> preOrderQueue;   // queue of info
        protected LinkedList<data> postOrderQueue;  // queue of info
        boolean found;   // used for remove

        
        public MyBST() {
            root = null;
        }

        public boolean isEmpty() {
            return (root == null);
        }


        private int recSize(MyBSTNode<data> tree) {
            if (tree == null)
                return 0;
            else
                return recSize(tree.getLeft()) + recSize(tree.getRight()) + 1;
        }


        public int size() {
            return recSize(root);
        }


        public int size2() throws Underflow {
            int count = 0;
            if (root != null) {
                LinkedListStack<MyBSTNode<data>> hold = new LinkedListStack<MyBSTNode<data>>();
                MyBSTNode<data> currNode;
                hold.push(root);
                while (!hold.isEmpty()) {
                    currNode = hold.top();
                    hold.pop();
                    count++;
                    if (currNode.getLeft() != null)
                        hold.push(currNode.getLeft());
                    if (currNode.getRight() != null)
                        hold.push(currNode.getRight());
                }
            }
            return count;
        }


        private boolean recContains(data element, MyBSTNode<data> tree) {
            if (tree == null)
                return false;       // element is not found
            else if (element.compareTo(tree.getInfo()) < 0)
                return recContains(element, tree.getLeft());   // Search left subtree
            else if (element.compareTo(tree.getInfo()) > 0)
                return recContains(element, tree.getRight());  // Search right subtree
            else
                return true;        // element is found
        }

        public boolean contains(data element) {
            return recContains(element, root);
        }



        private data recGet(data element, MyBSTNode<data> tree) {
            if (tree == null)
                return null;             // element is not found
            else if (element.compareTo(tree.getInfo()) < 0)
                return recGet(element, tree.getLeft());          // get from left subtree
            else if (element.compareTo(tree.getInfo()) > 0)
                return recGet(element, tree.getRight());         // get from right subtree
            else
                return tree.getInfo();  // element is found
        }


        public data get(data element) {
            return recGet(element, root);
        }

        private MyBSTNode<data> recAdd(data element, MyBSTNode<data> tree) {
            if (tree == null)
                // Addition place found
                tree = new MyBSTNode<data>(element);
            else if (element.compareTo(tree.getInfo()) <= 0)
                tree.setLeft(recAdd(element, tree.getLeft()));    // Add in left subtree
            else
                tree.setRight(recAdd(element, tree.getRight()));   // Add in right subtree
            return tree;
        }


        public void add(data element) {
            root = recAdd(element, root);
        }

        private data getPredecessor(MyBSTNode<data> tree) {
            while (tree.getRight() != null)
                tree = tree.getRight();
            return tree.getInfo();
        }


        private MyBSTNode<data> removeNode(MyBSTNode<data> tree) {
            data data;

            if (tree.getLeft() == null)
                return tree.getRight();
            else if (tree.getRight() == null)
                return tree.getLeft();
            else {
                data = getPredecessor(tree.getLeft());
                tree.setInfo(data);
                tree.setLeft(recRemove(data, tree.getLeft()));
                return tree;
            }
        }


        private MyBSTNode<data> recRemove(data element, MyBSTNode<data> tree) {
            if (tree == null)
                found = false;
            else if (element.compareTo(tree.getInfo()) < 0)
                tree.setLeft(recRemove(element, tree.getLeft()));
            else if (element.compareTo(tree.getInfo()) > 0)
                tree.setRight(recRemove(element, tree.getRight()));
            else {
                tree = removeNode(tree);
                found = true;
            }
            return tree;
        }


        public boolean remove(data element) throws Underflow {
            root = recRemove(element, root);
            return found;
        }


        private void inOrder(MyBSTNode<data> tree) {
            if (tree != null) {
                inOrder(tree.getLeft());
                inOrderQueue.add(tree.getInfo());
                inOrder(tree.getRight());
            }
        }


        private void preOrder(MyBSTNode<data> tree) {
            if (tree != null) {
                preOrderQueue.add(tree.getInfo());
                preOrder(tree.getLeft());
                preOrder(tree.getRight());
            }
        }


        private void postOrder(MyBSTNode<data> tree) {
            if (tree != null) {
                postOrder(tree.getLeft());
                postOrder(tree.getRight());
                postOrderQueue.add(tree.getInfo());
            }
        }


        public int reset(int orderType) {
            int numNodes = size();

            if (orderType == INORDER) {
                inOrderQueue = new LinkedList<data>();
                inOrder(root);
            } else if (orderType == PREORDER) {
                preOrderQueue = new LinkedList<data>();
                preOrder(root);
            }
            if (orderType == POSTORDER) {
                postOrderQueue = new LinkedList<data>();
                postOrder(root);
            }
            return numNodes;
        }

        public data getNext(int orderType) {
            if (orderType == INORDER)
                return inOrderQueue.remove();
            else if (orderType == PREORDER)
                return preOrderQueue.remove();
            else if (orderType == POSTORDER)
                return postOrderQueue.remove();
            else return null;
        }

    }

