class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // create table for key value pair
        Map<Integer, Integer> table = new HashMap<>();
        // create freq array (buckets)
        List<Integer>[] freq = new List[nums.length + 1];
        // make it into a 2d array
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        // put the values of nums into table
        for (int num : nums) {
            table.put(num, table.getOrDefault(num, 0) + 1);
        }
        // puts all entries to the table into freq array
        for (Map.Entry<Integer, Integer> entry : table.entrySet()) {
            // [entry.getValue()] gets in to the correct index and adds the correct key
            freq[entry.getValue()].add(entry.getKey());
        }
        
        int[] res = new int[k];
        int index = 0;
        // starts at the end of the freq array
        for (int i = freq.length - 1; i > 0 && index < k; i--) {
            // for every number in freq at index i
            for (int n : freq[i]) {
                res[index++] = n;   // same as res[index] = n; index++
                if (index == k) {
                    return res;
                }
            }
        }
        return res;
    }
}
