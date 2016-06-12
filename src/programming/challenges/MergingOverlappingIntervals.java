package programming.challenges;

import java.util.Arrays;
import java.util.Comparator;

// Programming challenge: Merging overlapping intervals
// Original post: https://blog.svpino.com/2015/05/17/programming-challenge-merging-overlapping-intervals
public class MergingOverlappingIntervals {

    private static Integer[][] intervals = { 
        {1, 3}, 
        {2, 6}, 
        {8, 10}, 
        {7, 11}
    };
    
    private static void print(Integer[] tuple) {
        System.out.println(
            String.format("[%d, %d]", tuple[0], tuple[1]));
    }

    public static void main(String[] args) {
        Arrays.sort(intervals, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[0].compareTo(o2[0]);
            }
        });
        
        int index = 1;
        Integer[] interval = intervals[0];
        while(index < intervals.length) {
            Integer[] nextInterval = intervals[index];
            System.out.println("interval[0] :" + interval[0] + " interval[1]: "+ interval[1]);
            System.out.println("nextInterval[0] :" + nextInterval[0] + " nextInterval[1]: "+ nextInterval[1]);
            if (interval[1] >= nextInterval[0]) {
                interval[0] = Math.min(interval[0], nextInterval[0]);
                interval[1] = Math.max(interval[1], nextInterval[1]);
            }
            else {
                print(interval);
                interval = nextInterval;
            }
            
            index++;
        }
        print(interval);
    }   
}   