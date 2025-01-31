class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> {
            if(a[0] == b[0]) {
                return b[1] - a[1];
            } else {
                return b[0] - a[0];
            }
        });
        
        for(int i=0;i<arr.length;i++) {
            heap.add(new int[]{Math.abs(x-arr[i]), i});
            
            if(heap.size() > k) {
                heap.poll();
            }
        }
        
        List<Integer> res = new ArrayList<>(heap.size());
        while(!heap.isEmpty()) {
            res.add(arr[heap.poll()[1]]);
        }
        
        Collections.sort(res); 
        return res;
    }
}
