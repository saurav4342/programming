package project1;

import java.util.ArrayList;
import java.util.List;

public class TreeLines {
    List<Node> nodes = new ArrayList<Node>();
    public void printPaths(Node root){
        if(root==null) return;
        //System.out.println(root.value);
        nodes.add(root);
        if(root.left==null&&root.right==null){System.out.println(nodes);}
        printPaths(root.left);
        printPaths(root.right);
        nodes.remove(nodes.size()-1);
    }
    
    class Node {
        Node left;
        Node right;
        int value;
        public Node(int value){
            this.value = value;
        }
        @Override
        public String toString(){
            return Integer.toString(value);
        }
    }
    public static void main(String[] args){
        TreeLines t = new TreeLines();
        Node root = t.createTree();
        t.printPaths(root);
    }
    
    public Node createTree(){
        Node root = new Node(5);
        Node node1 = new Node(4);
        Node node2 = new Node(3);
        Node node3 = new Node(2);
        Node node4 = new Node(8);
        Node node5 = new Node(6);
        Node node6 = new Node(1);
        Node node7 = new Node(7);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node6;
        node2.right = node7;
        node6.left=node5;
        return root;
    }
}
