/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.Scanner;

public class reConstructBinaryTree {

    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x;}
    }

    public static TreeNode reConstruct(int [] pre,int [] in) {
        return reConstruct(pre, in, 0, pre.length - 1, 0, in.length - 1);
    }

    public static TreeNode reConstruct(int [] pre, int [] in, int lopre, int hipre, int loin, int hiin){
        if(pre == null || in == null)
            return null;
        if(hipre - lopre != hiin - loin)
            return null;
        if(hipre < lopre || hiin < loin)
            return null;
        if(hipre == lopre)
            return new TreeNode(pre[lopre]);
        TreeNode currentNode = new TreeNode(pre[lopre]);
        int i = loin;
        for(; i <= hiin; i++)
            if(in[i] == pre[lopre])
                break;
        currentNode.left = reConstruct(pre, in, lopre + 1, lopre + i - loin, loin, i - 1);
        currentNode.right = reConstruct(pre, in, lopre + i - loin + 1, hipre, i + 1, hiin);
        return currentNode;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String tpre = sc.nextLine();
        String tin = sc.nextLine();
        String[] tps = tpre.trim().split(",");
        String[] tis = tin.trim().split(",");
        int[] ts = new int[tps.length];
        int[] is = new int[tis.length];

        for(int i = 0; i < tps.length; i ++)
            ts[i] = Integer.parseInt(tps[i]);
        for(int i = 0; i < tis.length; i ++)
            is[i] = Integer.parseInt(tis[i]);
        TreeNode root = reConstruct(ts, is);
        System.out.println(preTraversal(root));
        System.out.println(inTraversal(root));
    }

    public static String preTraversal(TreeNode root){
        if(root == null)
            return "";
        if(root.left == null && root.right == null)
            return root.val + "";
        else if(root.left == null)
            return root.val + " " + preTraversal(root.right);
        else if(root.right == null)
            return root.val + " " + preTraversal(root.left);
        else
            return root.val + " " + preTraversal(root.left) + " " + preTraversal(root.right);
    }
    public static String inTraversal(TreeNode root){
        if(root == null)
            return "";
        if(root.left == null && root.right == null)
            return root.val + "";
        else if(root.left == null)
            return root.val + " " + inTraversal(root.right);
        else if(root.right == null)
            return inTraversal(root.left) + " " + root.val;
        else
            return inTraversal(root.left) + " " + root.val + " " + inTraversal(root.right);
    }
}