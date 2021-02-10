package project1;

public class LinkedList {
    static class Node{
        Node next;
        int value;
       public Node(int value){
            //this.next = next;
            this.value = value;
        }
    }
    public static void main(String [] args){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);

    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;
    n5.next = n6;
    n6.next = n1;
    int k =3;
    boolean flag = true;
    int i = 1;
        Node n = n1;
        Node prev = null;
        Node next = null;
        int size = 6;
    while(flag){
        if(size ==0){
            System.out.println(n.value);
            flag = false;
            break;
        }
        
        if(i%k==0){
            prev.next = n.next;
            size--;
        }
         
         prev = n;
         n = n.next;
        i++;
    }

    }
}
