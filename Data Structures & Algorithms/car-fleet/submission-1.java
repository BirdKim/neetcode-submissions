class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // want position.length amount of rows and 2 columns
        int[][] order = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            order[i][0] = position[i];
            order[i][1] = speed[i];
        }
        // sorted in descending order of the position
        Arrays.sort(order, (a, b) -> Integer.compare(b[0], a[0]));
        double pastTime = (double) (target - order[0][0]) / order[0][1];
        int fleet = 1;
        for (int i = 1; i < position.length; i++) {
            double currTime = (double) (target - order[i][0]) / order[i][1];
            if (currTime > pastTime) {
                pastTime = currTime;
                fleet++;
            }
        }
        return fleet;
    }
}
