package ArrayString.ManipulationAndHashing;
import java.util.*;


//ques : https://leetcode.com/problems/top-k-frequent-elements/description/


public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i : nums)
            map.put(i,map.getOrDefault(i,0)+1);


        Queue<Integer> heap = new PriorityQueue<>((n1, n2) -> map.get(n1) - map.get(n2));

        for(int i : map.keySet()){
            heap.offer(i);
            if(heap.size()>k) heap.poll();
        }
        int [] ans = new int[k];
        for(int i = ans.length-1; i>=0; i--)
            ans[i]=heap.poll();


        return ans;
    }

    public static void main(String[] args) {
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        topKFrequentElements.topKFrequent(new int[]{1,2,1,2,1,2,3,1,3,2,1},1);
    }
}
