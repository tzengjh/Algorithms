/*
* @Author: tzengjh
* @Date:   2018-04-05 09:33:45
* @Last Modified by:   tzengjh
* @Last Modified time: 2018-04-05 11:39:54
*/
import java.util.Queue;
import java.util.LinkedList;

public class BinaryTree{
    private class Node{
        int val;
        Node left;
        Node right;
        Node(int val, Node left, Node right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public Node root = null;

    // construct binary tree
    public Node insertNode(int n){
        root = insertNode(root, n);
        return root;
    }

    private Node insertNode(Node root, int n){
        if(root == null)
            return new Node(n, null, null);
        if(root.val >= n) root.left = insertNode(root.left, n);
        else root.right = insertNode(root.right, n);
        return root;
    }

    // using recursion
    public void preOrder(Node root){
        if(root == null) return;
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(Node root){
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    public void postOrder(Node root){
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    // using circulation
    public void preOrderByStack(Node root){
        if(root == null) return;
        LinkedList<Node> stack = new LinkedList<Node>();
        stack.push(root);
        Node curr;
        while(!stack.isEmpty()){
            curr = stack.pop();
            System.out.print(curr.val + " ");
            if(curr.right != null)
                stack.push(curr.right);
            if(curr.left != null)
                stack.push(curr.left);
        }
    }

    public void inOrderByStack(Node root){
        if(root == null) return;
        LinkedList<Node> stack = new LinkedList<Node>();
        Node curr = root;
        while(curr != null || !stack.isEmpty()){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            } // == inOrder(root.left);
            curr = stack.pop();
            System.out.print(curr.val + " ");  // == System.out.println(root.val);
            curr = curr.right; // == inOrder(root.right);
        }
    }

    public void postOrderByStack(Node root){
        if(root == null) return;
        LinkedList<Node> stack = new LinkedList<Node>();
        Node curr = root;
        Node rightNode = null;
        while(curr != null || !stack.isEmpty()){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            } // == postOrder(root.left);
            curr = stack.peek();
            if(curr.right == null || curr.right == rightNode){
                stack.pop();
                System.out.print(curr.val + " "); // == System.out.println(root.val);
                rightNode = curr;
                curr = null;
            }else{
                curr = curr.right; // == inOrder(root.right);
            }
        }

    }

    public void breadthFirst(Node root){
        if(root == null) return;
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        Node curr;
        while(!queue.isEmpty()){
            curr = queue.poll();
            System.out.print(curr.val + " ");
            if(curr.left != null) queue.offer(curr.left);
            if(curr.right != null) queue.offer(curr.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insertNode(35);
        tree.insertNode(20);
        tree.insertNode(15);
        tree.insertNode(16);
        tree.insertNode(29);
        tree.insertNode(28);
        tree.insertNode(30);
        tree.insertNode(40);
        tree.insertNode(50);
        tree.insertNode(45);
        tree.insertNode(55);

        System.out.println("------preOrder------");
        tree.preOrder(tree.root);
        System.out.println();
        System.out.println("------preOrderByStack------");
        tree.preOrderByStack(tree.root);
        System.out.println();
        System.out.println("------inOrder------");
        tree.inOrder(tree.root);
        System.out.println();
        System.out.println("------inOrderByStack------");
        tree.inOrderByStack(tree.root);
        System.out.println();
        System.out.println("------postOrder------");
        tree.postOrder(tree.root);
        System.out.println();
        System.out.println("------postOrderByStack------");
        tree.postOrderByStack(tree.root);
        System.out.println();
        System.out.println("------breadthFirst------");
        tree.breadthFirst(tree.root);
        System.out.println();
    }
}
