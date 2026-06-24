class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // need a way to make key value pair to store the num and the frequency
        // after making the table, get the k most frequent num and return as array
        Map<Integer, Integer> table = new HashMap<>();
        for (int num : nums) {
            table.put(num, table.getOrDefault(num, 0) + 1);
        }

        List<int[]> arr = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : table.entrySet()) {
            arr.add(new int[] {entry.getValue(), entry.getKey()});
        }
        arr.sort((a, b) -> b[0] - a[0]);

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr.get(i)[1];
        }
        return res;
    }
}
