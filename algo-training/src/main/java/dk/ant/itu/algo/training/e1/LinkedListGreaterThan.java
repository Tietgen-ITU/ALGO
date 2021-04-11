package dk.ant.itu.algo.training.e1;

/**
 * 
 */
public class LinkedListGreaterThan {
    
    public static int greatest(Node node) {
        
        int greatestValue = node.item;
        Node current = node;

        while (current.next != null) {
            

        }

        return greatestValue;
    }

    public class Node {
    
        public Node next;
        public Integer item;

        public Integer greatest() {

            if(next != null) {

                int n = next.greatest();
                return n > item ? n : item;
            } else {

                return item;
            }
        }
    }
}
