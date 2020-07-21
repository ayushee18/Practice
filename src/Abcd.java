import java.util.*;

public class Abcd {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        //list.add("11 Apr 2011");
        list.add("20 Oct 2052");
        list.add("06 Jun 1933");
        list.add("26 May 1960");
        list.add("20 Sep 1958");
        list.add("16 Mar 2068");
        list.add("25 May 1912");
        list.add("16 Dec 2018");
        list.add("26 Dec 2061");
        list.add("04 Nov 2030");
        list.add("28 Jul 1963");
        System.out.println(sortDates(list).toString());
    }

    static List<String> sortDates(List<String> dates){
        Map<String, Integer> map = new HashMap<>();
        map.put("Jan", 1);
        map.put("Feb", 2);
        map.put("Mar", 3);
        map.put("Apr", 4);
        map.put("May", 5);
        map.put("Jun", 6);
        map.put("Jul", 7);
        map.put("Aug", 8);
        map.put("Sep", 9);
        map.put("Oct", 10);
        map.put("Nov", 11);
        map.put("Dec", 12);

        dates.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int year1 = Integer.parseInt(o1.substring(7));
                int year2 = Integer.parseInt(o2.substring(7));
                int day1 = Integer.parseInt(o1.substring(0,2));
                int day2 = Integer.parseInt(o2.substring(0,2));
                String month1 = o1.substring(3,6);
                String month2 = o2.substring(3,6);
                if(year1 != year2)
                    return Integer.valueOf(year1).compareTo(Integer.valueOf(year2));
                if(!month1.equalsIgnoreCase(month2))
                    return Integer.valueOf(map.get(month1)).compareTo(Integer.valueOf(map.get(month2)));
                if(day1 != day2)
                    return Integer.valueOf(day1).compareTo(Integer.valueOf(day2));
                return 0;
            }
        });
        return dates;
    }
}
