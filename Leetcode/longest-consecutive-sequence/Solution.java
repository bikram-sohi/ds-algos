class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;

        HashSet<Integer> set = new HashSet<>();

        for(int n : nums){
            set.add(n);
        }

        int longest = 1;

        for(int n : set){
            if(!set.contains(n - 1)){
                int current = n;
                int length = 1;

                while(set.contains(current + 1)){
                    current++;
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}

// class Solution {
//     public int longestConsecutive(int[] nums) {
//         HashMap<Integer, Boolean> hm = new HashMap<>();

//         for(int num: nums) hm.put(num, false);

//         int res = 0;

//         for(int i = 0; i < nums.length; i++) {
//             if(hm.get(nums[i])) continue;

//             int count = 0;
//             int cur = nums[i];
//             hm.put(nums[i], true);

//             int temp = cur - 1;
//             while(hm.containsKey(temp)) {
//                 count++;
//                 hm.put(temp, true);
//                 temp--;
//             }

//             temp = cur + 1;
//             while(hm.containsKey(temp)) {
//                 count++;
//                 hm.put(temp, true);
//                 temp++;
//             }

//             res = Math.max(count + 1, res);
//         }

//         return res;
//     }
// }
