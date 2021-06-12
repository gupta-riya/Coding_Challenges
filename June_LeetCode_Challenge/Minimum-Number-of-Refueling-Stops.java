// A car travels from a starting position to a destination which is target miles east of the starting position.

// Along the way, there are gas stations.  Each station[i] represents a gas station that is station[i][0] miles east of the starting position, and has station[i][1] liters of gas.

// The car starts with an infinite tank of gas, which initially has startFuel liters of fuel in it.  It uses 1 liter of gas per 1 mile that it drives.

// When the car reaches a gas station, it may stop and refuel, transferring all the gas from the station into the car.

// What is the least number of refueling stops the car must make in order to reach its destination?  If it cannot reach the destination, return -1.

// Note that if the car reaches a gas station with 0 fuel left, the car can still refuel there.  If the car reaches the destination with 0 fuel left, it is still considered to have arrived.


class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        
        
        if (startFuel >= target) {
            return 0;
        }

        if (stations == null || stations.length == 0) {
            return -1;
        }

        int curFuel = startFuel;
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        int stops = 0;
        int i = 0;

        while (curFuel < target) {
            while (i < stations.length && stations[i][0] <= curFuel) {
                pq.add(stations[i][1]);
                ++i;
            }

            if (pq.size()==0) {
                return -1;
            }
            curFuel += pq.remove();
            ++stops;
        }
        return stops;
    }
}
