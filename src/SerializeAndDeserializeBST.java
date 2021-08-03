/**
 * Serialization is converting a data structure or object into a sequence of bits so that it can be stored in a file or
 * memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization
 * /deserialization algorithm should work. You need to ensure that a binary search tree can be serialized to a string, and this string
 * can be deserialized to the original tree structure.
 *
 * The encoded string should be as compact as possible.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [2,1,3]
 * Output: [2,1,3]
 * Example 2:
 *
 * Input: root = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 104].
 * 0 <= Node.val <= 104
 * The input tree is guaranteed to be a binary search tree.
 */
public class SerializeAndDeserializeBST {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serializePre(root, "");
    }

    public String serializePre(TreeNode root, String res) {
        if(root == null) {
            return res;
        }
        res += root.val + ",";
        res = serializePre(root.left, res);
        res = serializePre(root.right, res);
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String [] strArr = data.split(",");
        if(strArr == null || strArr.length == 0) return null;
        int [] arr = new int [strArr.length];
        for(int i=0; i<arr.length; i++) arr[i] = Integer.valueOf(strArr[i]);
        return deserializeBST(arr, 0, arr.length -1);
    }

    public TreeNode deserializeBST(int nums[], int start, int end) {
        if(start > end) return null;
        TreeNode root = new TreeNode(nums[start]);
        int partition = findPartition(nums, start + 1, end, root.val);
        root.left = deserializeBST(nums, start + 1, partition -1);
        root.right = deserializeBST(nums, partition, end);
        return root;
    }

    public int findPartition(int nums[], int start, int end, int val) {
        while(start < end) {
            if(nums[start] > val) {
                return start;
            }
            start++;
        }
        return start;
    }
}
