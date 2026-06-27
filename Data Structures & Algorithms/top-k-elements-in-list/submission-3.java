class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        // bucket needs to be an array with each element being a list. 2d array
        List<int[]> bucket = new ArrayList<>();
        Map<Integer, Integer> freq = new HashMap<>();

        for (int n : nums) {
            // puts in freq key of n and value of either 0 or +1 depending on if n exists in freq
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        // To loop through Map, must be Map.Entry<> _name : _map.entrySet()
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            // flips key value pair when adding to bucket 
            // so that it can be sorted by how freq the num is
            bucket.add(new int[] {entry.getValue(), entry.getKey()});
        }
        // if there are values a, b in the bucket, sort by the difference between the first element
        // of the value.
        // compares if b[0] is greater than a[0]
        bucket.sort((a, b) -> b[0] - a[0]);
        
        // for the most frequent k num, add it to res
        for (int i = 0; i < k; i++) {
            res[i] = bucket.get(i)[1];
        }

        return res;
    }
}
