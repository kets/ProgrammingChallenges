package programming.challenges;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class OverlappingIntervals {
	
	static class Interval{
		private Integer start;
		private Integer end;
		
		public Interval (Integer start, Integer end) {
			this.start = start;
			this.end = end;
		}

	}
	
	public static void main (String [] args) {
		//list of intervals
		List<Interval> intervals = new ArrayList<Interval>();
		Interval one = new Interval(1,4);
		Interval two = new Interval(6,7);
		Interval three = new Interval(2,5);
		Interval four = new Interval(7,11);
		intervals.add(one);
		intervals.add(two);
		intervals.add(three);
		intervals.add(four);
		
		//sort the interval first
		Collections.sort(intervals, new Comparator<Interval>(){
			@Override
			public int compare(Interval arg0, Interval arg1) {
				return arg0.start.compareTo(arg1.start);
			}});
		
		List<Interval> overlappingIntervals = computeOverlappingInterval(intervals);
		
		System.out.println("Overlapping intervals");
		for (int i = 0; i < overlappingIntervals.size(); i++) {
			System.out.println("[" +overlappingIntervals.get(i).start +","+ overlappingIntervals.get(i).end+"]");
		}
	}
	
	public static List<Interval> computeOverlappingInterval(List<Interval> intervals) {
		List<Interval> overlappingIntervals = new ArrayList<Interval>();
		Interval currInterval = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
//			System.out.println("index: "+ i);
//			System.out.println("currInterval: "+ "[" +currInterval.start +","+ currInterval.end+"]");
			Interval nextInterval = intervals.get(i);
//			System.out.println("nextInterval: "+ "[" +nextInterval.start +","+ nextInterval.end+"]");
			if (currInterval.end >= nextInterval.start) {
				//found an overlapping interval
				currInterval.start = Math.min(currInterval.start, nextInterval.start);
				currInterval.end = Math.max(currInterval.end, nextInterval.end);
				overlappingIntervals.add(currInterval);
			
			} else {
				//non overlapping
				currInterval = nextInterval;
			}
		
			
		}
		
		return overlappingIntervals;
	}

}
