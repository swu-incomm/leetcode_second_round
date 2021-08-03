/**
 * Serialization is the process of converting a data structure or object into a sequence of bits
 * so that it can be stored in a file or memory buffer, or transmitted across a network connection link
 * to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how
 * your serialization/deserialization algorithm should work. You just need to ensure that a binary tree
 * can be serialized to a string and this string can be deserialized to the original tree structure.
 *
 * Clarification: The input/output format is the same as how LeetCode serializes a binary tree.
 * You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,null,null,4,5]
 * Output: [1,2,3,null,null,4,5]
 * Example 2:
 *
 * Input: root = []
 * Output: []
 * Example 3:
 *
 * Input: root = [1]
 * Output: [1]
 * Example 4:
 *
 * Input: root = [1,2]
 * Output: [1,2]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 104].
 * -1000 <= Node.val <= 1000
 */
import java.util.*;
public class SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serializePre(root, "");
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String [] dataArray = data.split(",");
        for(int i=0; i<dataArray.length;i++) {
            System.out.println(dataArray[i]);
        }
        List<String> dataList = new ArrayList<>(Arrays.asList(dataArray));
        return deserializePre(dataList);
    }

    public String serializePre(TreeNode root, String res) {
        if(root == null) {
            res+="null,";
        } else {
            res+=root.val + ",";
            res=serializePre(root.left, res);
            res=serializePre(root.right, res);
        }
        return res;
    }

    public TreeNode deserializePre(List<String> list) {
        if(list.get(0).equals("null")) {
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left = deserializePre(list);
        root.right = deserializePre(list);
        return root;
    }

    public static void main(String [] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        root.left = node1;
        root.right = node4;
        node1.left = node2;
        node1.right = node3;
        SerializeAndDeserializeBinaryTree serializeAndDeserializeBinaryTree = new SerializeAndDeserializeBinaryTree();
        String s=serializeAndDeserializeBinaryTree.serialize(root);
        System.out.println(s);
        serializeAndDeserializeBinaryTree.deserialize(s);
    }
}
