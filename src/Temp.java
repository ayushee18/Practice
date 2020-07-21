import java.util.*;
class Node1{
    boolean visited = false;
    boolean visiting = false;
    int a;
    int b;
    int cur = a;
    int[] children;

    Node1 (int [] a, int [] b) {
        this.a = a[0];
        this.b = b[0];
    }

}

public class Temp {

    public Node1 flipAll(Node1 node){
        node.cur = (node.cur == 1) ? 0 : 1;
        for (int i=0; i<node.children.length; i++) {
            flipAll(node);
        }
        return node;
    }
    public Node1 flipOne(Node1 node){
        node.cur = node.cur == 1 ? 0 : 1; // flip node
        return node;
    }

    public int getMinCost(Node1 node){
        // BASE CASE - this node doesn't have children
        if (node.children.length == 0) {
            // using cur here (because we may have flipped the value previously)
            // don't need to change cur here, because it won't be used for any more calculations (if it was, we would change it)
            return (node.cur != node.b) ? 1 : 0;
        }
        else { // RECURSIVE CASE - this node has children
            if(node.a != node.b) {
                // if the node needs to be flipped, make a copy of the node to compare the two operations.
                Node1 nodeCopy = node;
                int costOfFlippingAll = 1 + getMinCost(flipAll(nodeCopy)); // add one because we do the operation here.
                int costOfFlippingOne = 1 + getMinCost(flipOne(node));
                return Math.min(costOfFlippingAll, costOfFlippingOne); // return the minimum cost from the two operations.
            }
            else { // this node doesn't need to be flipped, so return the sum minimum cost for its children.
                int sum = 0;
                for (int i=0; i<node.children.length; i++) {
                    sum += getMinCost(node);
                }
                return sum;
            }
        }
    }


//
//
//
//        /*
//         * Complete the 'findMaximum' function below.
//         *
//         * The function is expected to return an INTEGER.
//         * The function accepts following parameters:
//         *  1. INTEGER_ARRAY arr
//         *  2. INTEGER m
//         */
//
//        public static int currentMin(List<Integer> arr) {
//            int currentMinimum = 10 ^ 18;
//            for (int i = 0; i < arr.size(); i++) {
//                for (int j = i + 1; j < arr.size(); j++) {
//                    System.out.print(arr.get(i) + " " + arr.get(j) + " ");
//                    int absDiff = Math.abs(arr.get(i) - arr.get(j));
//
//                    if (absDiff < currentMinimum)
//                        currentMinimum = absDiff;
//
//                    System.out.print(absDiff + " " + currentMinimum);
//                }
//                System.out.println();
//            }
//            return currentMinimum;
//        }
//
//        public static int findMaximum(List<Integer> arr, int m) {
//            // Write your code here
//
//            List<List<Integer>> subsequence = new ArrayList<>();
//
//            for (int i = 0; i < arr.size(); i++) {
//
//                for (int j = i + 1; j < arr.size(); j++) {
//                    List<Integer> list = new ArrayList<>();
//                    list.add(arr.get(i));
//
//                        for (int k = 1; k < m; k++) {
//                            if(j < arr.size() && j+k < arr.size())
//                                list.add(arr.get(j+k - 1));
//                            if(list.size() == m) {
//                                subsequence.add(list);
//                            }
//
//                        }
//
//                    if(list.size() == m)
//                    subsequence.add(list);
//                }
//
//                //subsequence.add(list);
//
//                // if(arr.size() - (i + 1) < m)
//                //     break;
//            }
//
//            for (int i = 0; i < subsequence.size(); i++) {
//                System.out.println(subsequence.get(i) + " ");
//            }
//
//
//            int globalMaximum = 0;
//
//            for (int i = 0; i < subsequence.size(); i++) {
//                int currentMinimum = currentMin(subsequence.get(i));
//                if (currentMinimum > globalMaximum)
//                    globalMaximum = currentMinimum;
//            }
//
//            return globalMaximum;
//
//        }
//
//    public static void main(String[] args) {
//            List<Integer> list = new ArrayList<>();
//            list.add(1); list.add(2); list.add(3); list.add(4);
//        findMaximum(list, 2);
//    }

    }


