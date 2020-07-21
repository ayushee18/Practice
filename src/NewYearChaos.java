public class NewYearChaos {
    static void minimumBribes(int[] q) {
        int count = 0;
        for(int i = 0; i < q.length-1; i++) {
            if (q[i]-q[i+1]>2) {
                System.out.println("Too chaotic");
                return;
            } else if(q[i]-q[i+1]<=2){
               // System.out.print();
                count =count+Math.abs(i-(q[i]-1));
            }
        }
        System.out.println(count);
    }
    public static void main(String[] args) {
        int arr[] = {1,2,5,3,7,8,6,4};
        minimumBribes(arr);
    } }

//    let swaps = 0;
//    let min = q.length;
//    for (var i = q.length - 1; i >= 0; i--){
//        if (q[i] - i > 3){
//            return `Too chaotic`;
//        }
//        if (q[i] > i+1){
//            swaps += (q[i]-(i+1));
//        } else {
//            if (min > q[i]){
//                min = q[i];
//            } else if (q[i] != min){
//                swaps++;
//            }
//        }
//    }
//
//    return swaps;
//}
//
//    void minimumBribes(vector<int> q) {
//        int bribes=0;
//        for(int i=q.size();i>=1;--i)
//        {
//            if (q[i - 1] - i > 2) {
//                cout << "Too chaotic\n";
//                return;
//            }
//            //Check to front of my position, if there are numbers greater than me then they must have bribed me to get ahead.
//            for(int j=i-2;j>=max(q[i-1]-2,0);--j)
//                if(q[j]>q[i-1]) bribes++;
//        }
//        cout<<bribes<<"\n";
//    }
