import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import apple.laf.JRSUIUtils.Tree;
import sun.net.www.content.text.plain;

class _236LowestCommonAncestor {
    public static void main(String[] args) {

    }
}

/**
 * 236. 二叉树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
class _236LowestCommonAncestorSolution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        return dfs(root, p, q);
    }


    private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }else if (root == p) {
            return p;
        }else if (root == q) {
            return q;
        }
        TreeNode l = dfs(root.left, p, q);
        TreeNode r = dfs(root.right, p, q);

        if(l != null && r != null) {
            return root;
        }else if(l != null) {
            return l;
        }else {
            return r;
        }
    }

    /**
     * 这么做应该是可以的，但是超出内存限制了
     * 想法：把每一个Node的所有父亲都放在一个list里面
     *      比较拿到p和q的对应的parent的list，从pList里面挨着取出，跟q比较，如果有相等的，那就是有公共节点
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestorWithParent(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        HashMap<TreeNode, List<TreeNode>> map = new HashMap<>();
        map.put(root, new ArrayList<TreeNode>());
        dfsT(root, map);

        List<TreeNode> pList = map.get(p);
        List<TreeNode> qList = map.get(q);
        for (int i = pList.size() - 1; i >= 0 ; i++) {
            if(qList.contains(pList.get(i))) {
                return pList.get(i);
            }
        }        
        return null;
    }

    private void dfsT(TreeNode  root, HashMap<TreeNode, List<TreeNode>> map) {
        if(root  == null) {
            return;
        }
        List<TreeNode> list = new ArrayList<>(map.get(root));
        list.add(root);
        map.put(root.left, list);
        dfsT(root, map);
        List<TreeNode> list1 = new ArrayList<>(map.get(root));
        list1.add(root);
        map.put(root.right, list1);
        dfsT(root, map);
    }

}



class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }
}