import org.junit.Test;
import org.junit.runners.Parameterized;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
 * 则重建二叉树并返回。
 */
public class RebuildTree {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length==0||in.length==0){
            return null;
        }
        TreeNode tree=creatTree(pre,in,0,0,in.length);
        return tree;
    }

    /**
     *
     * @param pre 前序遍历结果
     * @param in  中序遍历结果
     * @param root_pre  当前树的树根在前序遍历结果数组中的索引roo
     * @param low
     * @param high [low, high) 表示当前处理的树所有节点在中序数组中的分布范围
     * @return
     */
    public TreeNode creatTree(int[] pre,int[] in, int root_pre,int low,int high){
        TreeNode tree=new TreeNode(pre[root_pre]);
        int root_in=low;//存储中序遍历结果中当前树的根节点索引位置
        for (  ; root_in <high ; root_in++) {
            if(pre[root_pre]==in[root_in]){
                break;
            }
        }

        if(root_in-1>=low){
            tree.left=creatTree(pre,in,root_pre+1,low,root_in);
        }else {
            tree.left=null;//判断出此时当前树根节点的左边无中序遍历数值，也就是没有左子树
        }
        if (root_in+1<high){
            tree.right=creatTree(pre,in,root_in+root_pre-low+1,root_in+1,high);
        }else{
            tree.right=null;
        }
        return tree;
    }
    @Test
    public void test(){
        int [] pre={1,2,3,4,5,6,7};
        int [] in={3,2,4,1,6,5,7};
        TreeNode tree=reConstructBinaryTree(pre,in);
        System.out.println("hello");
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
