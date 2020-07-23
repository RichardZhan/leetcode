package datastructure.binarytree;

/**
 * @author Richard.Zhan
 * @Description:
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/7/23 17:24
 */
public class _0104_maximum_depth_of_binary_tree {


    /**
     * 自底向上递归
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root){
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth,rightDepth) + 1;
    }


    public static void main(String[] args) {
        _0104_maximum_depth_of_binary_tree instance = new _0104_maximum_depth_of_binary_tree();

        TreeNode root = new TreeNode(1);
        TreeNode rootRight = new TreeNode(2);
        TreeNode rootRightLeft = new TreeNode(3);
        root.right = rootRight;
        root.right.left = rootRightLeft;


        int output = -1;
        output = instance.maxDepth(root);
        System.out.println(output);
    }





}
