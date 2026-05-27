package Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {

    // Logic -> 1,2,3,4,5,6 -> left side max heap right side min
    // all elements of max heap must be smaller to all elements of min heap
    // so if num is 8 -> max heap = [1,4,7] then it will go in max heap
    // if num is 6 -> max heap = [1,4,7] then it will go in min heap
    // then do rebalancing i.e both heaps size can't be greater than 1

    Queue<Integer> left;
    Queue<Integer> right;

    public void addNum(int num) {
        if(left.isEmpty() || num <= left.peek())
            left.offer(num);
        else
            right.offer(num);

        if(left.size() > right.size()+1)
            right.offer(left.poll());
        else if(right.size() > left.size())
            left.offer(right.poll());
    }

    public double findMedian() {
        if(left.size() > right.size())
            return left.peek();
        else if (right.size() > left.size()) {
            return right.peek();
        } else {
            return (left.peek() + right.peek()) / 2.0;
        }
    }

    /// /////////
    /// //  --------   Brute Force -- TLE
    private int num = 0;
    private List<Integer> list;

    public MedianFinder() {
        this.list = new ArrayList<>();
        right = new PriorityQueue<>((a,b) -> a-b);
        left = new PriorityQueue<>((a,b) -> b-a);
    }

    public void addNum2(int num) {
        this.num += num;
        list.add(num);
    }

    public double findMedian2() {
        list.sort(Integer::compareTo);
        if(list.size()%2==1)
            return list.get(list.size()/2);
        else{
            return (list.get(list.size() / 2 - 1) + list.get(list.size() / 2)) / 2.0;
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(6);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(10);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(6);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(5);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(0);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(6);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(0);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(0);
        System.out.println(medianFinder.findMedian());
    }
}
