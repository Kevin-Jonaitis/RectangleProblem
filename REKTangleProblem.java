package RectangeProblem;

// Now let's assume there are N solid black rectangles in the image. Find them
// all and return their coordinates. For example:
// image = [
// [1, 1, 1, 1, 1, 1, 1],
// [1, 1, 1, 1, 1, 1, 1],
// [1, 1, 1, 0, 0, 0, 1],
// [1, 0, 1, 0, 0, 0, 1],
// [1, 0, 1, 1, 1, 1, 1],
// [1, 0, 1, 0, 0, 1, 1],
// [1, 1, 1, 0, 0, 1, 1],
// [1, 1, 1, 1, 1, 1, 1],
// ];



// This program creates a dictionary of rectangles.  The key is the upper left
// corner, stored as a tuple.  The value is the width and height of the rectangle
// The advantage of using a dictionary over a list is that the dictionary is
// independent of the algorithm used to find the rectangles, for example, searching
// from top to bottom instead of bottom to top.

import java.util.HashMap;
import java.util.Map;

class REKTangleProblem {
    Map<String, Rectangle> map = new HashMap<>();

    public class Rectangle {
        int x;
        int y;
        int width;
        int height;
        //x goes down, y goes across
        public Rectangle(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }
    }
    static int[][]  image = {
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 0, 0, 0, 0},
            {1, 0, 1, 0, 0, 0, 0},
            {1, 0, 1, 1, 1, 1, 1},
            {1, 0, 1, 0, 0, 1, 1},
            {1, 1, 1, 0, 0, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            };

    public static void main(String[] args) {
        int[][] test = new int[3][4];
//        for (int i = 0; i < test.length; i++) {
//            System.out.println(test.length);
//        }
        REKTangleProblem problem = new REKTangleProblem();
        problem.getRectangle(image);
        System.out.println("LETS GO");

    }


    // time complexity: O(n), n is the number of pixels
    // space complexity: O(1)
    public Rectangle getRectangle(int[][] image) {
        // System.out.println(image[0].length);
        int width = 0;
        int height = 0;
        for(int x = 0; x < image.length; x++) { //x goes from 0 to 5
            for (int y = 0; y < image[0].length; y++) {// y goes from 0 to 7

                if(image[x][y] == 0) {
                    if (x - 1 > 0 && image[x -1][y] == 0) {
                        continue;
                    }
                    if (y - 1 > 0 && image[x][y - 1] == 0) {
                        continue;
                    }
                    int rightMostIndex = runAllTheWayToTheRight(image, x, y);
                    int bottomMostIndex = runAllTheWayToTheBottom(image, x, y);
                    height = bottomMostIndex - x + 1;
                    width = rightMostIndex - y + 1;
                    Rectangle rect = new Rectangle(x, y, width, height);
                    map.put(String.valueOf(x) + String.valueOf(y), rect);
                }
            }
        }
        return null;
    }

    private int runAllTheWayToTheRight(int[][] image, int x, int y) {

        while(y + 1 < image[0].length && image[x][y + 1] == 0) {
            y++;
        }
        return y;
    }

    private int runAllTheWayToTheBottom(int[][] image, int x, int y) {

        while(x + 1 < image.length && image[x + 1][y] == 0) {
            x++;
        }
        return x;
    }
}