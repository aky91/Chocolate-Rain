import java.util.*;
import java.lang.*;
import java.io.*;
// A Binary Tree node
class Node
{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
class Binary_Tree_Diameter
{
    // driver function to test the above functions
    public static void main(String args[])
    {
        // Input the number of test cases you want to run
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
        {
            HashMap<Integer, Node> m = new HashMap<Integer, Node> ();
            int n = sc.nextInt();
            Node root = null;
            while (n > 0)
            {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                char lr = sc.next().charAt(0);
                //  cout << n1 << " " << n2 << " " << (char)lr << endl;
                Node parent = m.get(n1);
                if (parent == null)
                {
                    parent = new Node(n1);
                    m.put(n1, parent);
                    if (root == null)
                        root = parent;
                }
                Node child = new Node(n2);
                if (lr == 'L')
                    parent.left = child;
                else
                    parent.right = child;
                m.put(n2, child);
                n--;
            }
            GfG g = new GfG();
            System.out.println(g.diameter(root));
            t--;
        }
    }
}
// FUNCTION CODE
/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */

}

/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/* A Binary Tree node
class Node{
    int data;
    Node left, right;
    Node(int item){
        data = item;
        left = right = null;
    }
} */

class GfG{
    
    //https://practice.geeksforgeeks.org/problems/diameter-of-binary-tree/1
   /* Complete the function to get diameter of a binary tree */
    int diameter(Node node){
        
        if(node == null) return 0;
        
        int left = diameter(node.left);
        int right = diameter(node.right);
        
        int curr = height(node.left) + height(node.right) + 1;
        
        return Math.max(curr, Math.max(left, right));
    }
    
    int height(Node node){
        
        if(node == null) return 0;
        
        int left = height(node.left);
        int right = height(node.right);
        
        int ans = Math.max(left, right) + 1;
        
        return ans;
    }
}
