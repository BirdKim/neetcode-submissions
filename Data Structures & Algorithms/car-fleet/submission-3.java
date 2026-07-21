class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        // want position.length amount of rows and 2 columns
        int[][] order = new int[n][2];
        for (int i = 0; i < n; i++) {
            order[i][0] = position[i];
            order[i][1] = speed[i];
        }
        // sorted in descending order of the position
        Arrays.sort(order, (a, b) -> Integer.compare(b[0], a[0]));

        // set the time the first fleet comes in
        double prevTime = (double) (target - order[0][0]) / order[0][1];
        int fleet = 1;
        for (int i = 1; i < n; i++) {
            double currTime = (double) (target - order[i][0]) / order[i][1];
            // if the currTime is less than prevTime but has smaller position value, it means it
            // catches up to the car thats positioned closer to the destination
            if (currTime > prevTime) {
                prevTime = currTime;
                fleet++;
            }
        }
        return fleet;
    }
}
