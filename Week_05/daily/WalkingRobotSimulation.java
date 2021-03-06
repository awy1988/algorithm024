package Week_05.daily;

import java.util.HashSet;

public class WalkingRobotSimulation {
    public int robotSim(int[] commands, int[][] obstacles) {

        int ans = 0, direction = 0, x = 0, y = 0;
        int[][] Direction = {{0,1},{1,0},{0,-1},{-1,0}};

        HashSet<String> set = new HashSet<>();

        for(int[] arr : obstacles) set.add(arr[0] + "," + arr[1]);

        for (int command : commands) {
            int nextX = 0, nextY = 0;

            if (command >= 0) {
                for (int i = 0; i < command; i++) {
                    nextX = x + Direction[direction][0];
                    nextY = y + Direction[direction][1];
                    if (set.contains(nextX + "," + nextY)) break;
                    x = nextX;
                    y = nextY;
                    ans = Math.max(ans, x*x + y*y);
                }
                continue;
            }
            direction = command == -1 ? (direction + 1) % 4 : (direction + 3) % 4;
        }
        return ans;
    }

}
