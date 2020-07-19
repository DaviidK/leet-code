// This class provides a public Node object containing an int value for data
// It can be used for any problems requiring int trees

public class IntTreeNode {
    public int value;
    public IntTreeNode left;
    public IntTreeNode right;

    public IntTreeNode(int v) {
        this.value = v;
        this.left = null;
        this.right = null;
    }

    public IntTreeNode(int v, IntTreeNode l, IntTreeNode r) {
        this.value = v;
        this.left = l;
        this.right = r;
    }
}