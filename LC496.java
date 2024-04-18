class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums1.length; i++){
            map.put(nums1[i], i);
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        stack.push(0);
        for(int i = 1; i < nums2.length; i++){
            while(!stack.isEmpty() && nums2[i] > nums2[stack.peek()]){
                int temp = nums2[stack.pop()];
                if(map.containsKey(temp)) res[map.get(temp)] = nums2[i];
            }
            stack.push(i);
        }
        return res;
    }
}
//O(N), O(N)
