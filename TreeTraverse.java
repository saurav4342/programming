package project1;

import java.util.HashMap;
import java.util.Map;

class Node 
    { 
        int key; 
        Node left, right; 
       
        public Node(int item) 
        { 
            key = item; 
            left = right = null; 
        } 
    } 
public class TreeTraverse {
    static Node root;
    static Map<Integer,Integer> sumMap = sumMap = new HashMap<Integer,Integer>();
    static int i=0;
    public static void main(String[] args) {
        TreeTraverse tt = new TreeTraverse();
        //tt.createTree();
        //int val = root.key;
        //calculateVerticalSum(root, 0);
       // addValueToMap(0, val);
        for(int k: sumMap.keySet()){
           // System.out.println(sumMap.get(k));
        }
        //postorder(root);
        reverse();
        
    }
    
    public void createTree(){
        root = new Node(5);
        root.left = new Node(3);
        root.left.left = new Node(4);
        root.left.right=new Node(2);
        root.right = new Node(1);
        root.right.left = new Node(7);
        root.right.right = new Node(6);
    }
    
    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.println(root.key);
        preorder(root.left);
        preorder(root.right);
        
    }
    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.println(root.key);
        inorder(root.right);
    }
    public static void postorder(Node root){
        if(root == null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.key);
    }
    public static void calculateVerticalSum(Node root, int index){
        
        if(root == null) return;
        if(root.left != null){
            addValueToMap(index+1,root.left.key );
            
            
            
        }
        if(root.right != null){
            addValueToMap(index-1,root.right.key);
            
            
        }
        
        calculateVerticalSum(root.left, index+1);
        calculateVerticalSum(root.right, index-1);
    }
    
    public static void addValueToMap(int key, int value){
        if(sumMap.containsKey(key)){
            int sum = sumMap.get(key);
            sum+=value;
            sumMap.put(key, sum);
        }
        else{
            sumMap.put(key,value);
        }
    }
    public static void reverse(){
            String s = "ABCD";
            char [] ch = new char[s.length()];
            for(int i=0;i<s.length();i++){
                    ch[i] = s.charAt(s.length()-i-1);
            }
            
            System.out.println(ch);
    }
}
