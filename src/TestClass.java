//import for Scanner and other utility classes


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class Game{
    public void gamer(){
        System.out.println("gamer");
    }
}

class Xyz extends Game{
    public void gamer(){
        System.out.println("xyz");
    }
}

class TestClass {
//    public void playIt( int i, Game p){
//        i = 5;
//        p.number =8;
//    }
    public static void main(String args[]) throws Exception {
//        Game g = new Xyz123();
//        g.gamer();
//        int x = 0;
//        Game p = new Game();
//        new TestClass().playIt(x,p);
//        System.out.println(x+" "+p.number);

        // Sample code to perform I/O:
        // Use either of these methods for input

        //BufferedReader
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // String name = br.readLine();                // Reading input from STDIN
        // System.out.println("Hi, " + name + ".");    // Writing output to STDOUT


        //Scanner
//        Scanner s = new Scanner(System.in);
//        int t = s.nextInt();
//        int[] a = new int[t];
//        for(int i=0; i<t;i++){
//            a[i] = s.nextInt();
//            System.out.println("a "+i+" "+a[i]);
//        }
        // int[] a = new int[t];

//        for (int i = 0; i < t; i++) {
//            for (int j = 1; j <= a[i]; j++) {
//                if (j / 3 == 0 && j / 5 == 0) {
//                    System.out.println("FizzBuzz");
//                } else if (j / 5 == 0) {
//                    System.out.println("Buzz");
//                } else if (j / 3 == 0) {
//                    System.out.println("Fizz");
//                } else {
//                    System.out.println(j);
//                }
//            }

//        int Number = 4;
//        int DecreasingCost = 7;
//        int IncreasingCost = 8;
//        int numInc = Number;
//        int numDesc = Number;
//        int cost = 0;
//        boolean flag = true;
//        while (flag == true) {
//            numInc = numInc + 1;
//            numDesc = numDesc - 1;
//
//            if (numInc % 8 == 0) {
//                cost = (numInc - Number) * IncreasingCost;
//                flag = false;
//                break;
//            }
//            if (numDesc % 8 == 0) {
//                cost = (Number - numDesc) * DecreasingCost;
//                flag = false;
//                break;
//            }
//
//            if (numInc % 12 == 0) {
//                cost = (numInc - Number) * IncreasingCost;
//                flag = false;
//                break;
//            }
//
//            if (numDesc % 12 == 0) {
//                cost = (Number - numDesc) * DecreasingCost;
//                flag = false;
//                break;
//            }
//
//            if (numInc % 10 == 0) {
//                cost = (numInc - Number) * IncreasingCost;
//                flag = false;
//                break;
//            }
//
//            if (numDesc % 10 == 0) {
//                cost = (Number - numDesc) *DecreasingCost ;
//                flag = false;
//                break;
//            }
//        }
//        System.out.println(cost);
//

    }

}