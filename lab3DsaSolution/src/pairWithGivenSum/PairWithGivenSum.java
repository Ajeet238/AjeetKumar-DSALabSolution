package pairWithGivenSum;
   
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PairWithGivenSum {
	 static class Node {
	        int data;
	        Node left, right;
	    };
  
	    static Node NewNode(int data)
	    {
	        Node temp = new Node();
	        temp.data = data;
	        temp.left = null;
	        temp.right = null;
	        return temp;
	    }
	 
	    static Node insert(Node root, int key)
	    {
	        if (root == null)
	            return NewNode(key);
	        if (key < root.data)
	            root.left = insert(root.left, key);
	        else
	            root.right = insert(root.right, key);
	        return root;
	    }
	 
	    static boolean findpair(Node root, int sum,
	                                HashSet<Integer> set)
	    {
	        if (root == null) {
	            return false;
	            }
	 
	        if (findpair(root.left, sum, set)) {
	            return true;
	            }
	 
	        if (set.contains(sum - root.data)) {
	            System.out.println("Pair is ("
	                               + (sum - root.data) + ", "
	                               + root.data + ")");
	            return true;
	        }
	        else {
	            set.add(root.data);
	            }
	 
	        return findpair(root.right, sum, set);
	    }
	 
	    static void findPair(Node root, int sum)
	    {
	        HashSet<Integer> set = new HashSet<Integer>();
	        if (!findpair(root, sum, set))
	            System.out.print("Pairs do not exit"
	                             + "\n");
	    }
	 
	    // Driver code
	    public static void main(String[] args)
	    {
	        Node root = null;
	        root = insert(root, 25);
	        root = insert(root, 50);
	        root = insert(root, 28);
	        root = insert(root, 18);
	        root = insert(root, 12);
	        root = insert(root, 26);
	        root = insert(root, 25);
	        root = insert(root, 15);
	 
	        int sum = 40;
	        findPair(root, sum);
	    }

}
