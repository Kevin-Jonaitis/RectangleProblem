package RectangeProblem;
// Imagine we have an image where every pixel is white or black. We’ll represent this image as a
// simple 2D array (0 = black, 1 = white). The image you get is known to have a single black rectangle on a
// white background. Write a function that takes in the image and returns the coordinates of the rectangle --
// either top-left and bottom-right; or top-left, width, and height.

// int[][] image = {
//   {1, 1, 1, 1, 1, 1, 1},
//   {1, 1, 1, 1, 1, 1, 1},
//   {1, 1, 1, 0, 0, 0, 1},
//   {1, 1, 1, 0, 0, 0, 1},
//   {1, 1, 1, 1, 1, 1, 1},
// };

class RectangleProblem {

    public class Rectangle {
        int x;
        int y;
        int width;
        int height;
        public Rectangle(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }
    }
    static int[][] image = {
            //FIRST INDEX is height, SECOND index is length
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 1}, //2 and 6 should be 5, equals 4
            {1, 1, 1, 1, 1, 1, 1},
    };

    public static void main(String[] args) {
        Rectangle result = new RectangleProblem().getRectangle(image);
        System.out.println(result.x);
        System.out.println(result.y);
        System.out.println(result.width);
        System.out.println(result.height);
    }


    // time complexity: O(n), n is the number of pixels
    // space complexity: O(1)
    public Rectangle getRectangle(int[][] image) {
        // System.out.println(image[0].length);
        int width = 0;
        int height = 0;
        for(int y = 0; y < image.length; y++) { //i goes from 0 to 5
            for (int x = 0; x < image[0].length; x++) {// j goes from 0 to 7

                if(image[y][x] == 0) {
                    int currentWidth = x;
                    //length - 1 = 6
                    ///array index 1 to 6
                    while (currentWidth + 1 < image[0].length && image[y][currentWidth + 1] == 0) {
                            currentWidth++;
                    }
                    width = (currentWidth - x) + 1;
                    int currentHeight = y;
                    System.out.println("GET HERE");
                    while (currentHeight + 1 < image.length && image[currentHeight + 1][x] == 0) {
                        currentHeight++;
                    }
                    height = (currentHeight - y) + 1;
                    System.out.println("THE END");

                    return new Rectangle(x, y, width, height);
                }
            }
        }
        return null;
    }
}