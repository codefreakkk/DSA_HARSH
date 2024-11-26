class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        if(nums.length == 0) return nums;
        int[] res = new int[nums.length - k + 1];
        int cnt = 0;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while(!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i]){
                q.pollLast();
            }
            q.offer(i);
            if(i >= k - 1) {
                res[cnt++] = nums[q.peek()];
            }
        }
        return res;
    }
}
