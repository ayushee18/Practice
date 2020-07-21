package Arrays;

import java.util.ArrayList;

class Interval {
    int buy;
    int sell;

    @Override
    public String toString() {
        return "Interval{" +
                "buy=" + buy +
                ", sell=" + sell +
                '}';
    }
}
public class StockBuySellProblem {

    public static void stockBuyAndSell(int [] arr, int n) {
        ArrayList<Interval> list = new ArrayList<>();
        int i = 0;
        while ( i < n - 1) {
            Interval inter = new Interval();
            while( i < n-1 && (arr[i] > arr[i + 1]))
                i++;
            inter.buy = i;
            i++;
            while(i < n && (arr[i] > arr[i-1]))
                i++;
            inter.sell = i - 1;
            list.add(inter);
        }
        if(list.size() == 0)
            System.out.println("No good time to buy or sell");
        else {
            for(int j = 0; j < list.size(); j++) {
                System.out.println("Buy Stock on: " +arr[list.get(j).buy]+ "    Sell Stock On: "+ arr[list.get(j).sell]);
            }
        }
    }

    public static void main(String[] args) {

        int arr [] = {100, 180, 260, 310, 40, 535, 695};
        stockBuyAndSell(arr, arr.length);

    }
}
