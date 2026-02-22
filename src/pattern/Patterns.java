package pattern;

public class Patterns {
    static void main(String[] args) {

        //squarePattern(5,5);
        // trianglePattern(5);
        //numberTrianglePattern(5);
        //inverseTrianglePattern(5);
        //inverseNumberTrianglePattern(5);
        // starPatternEquilateralTriangle(5);
        //inverseStarEquilateralTriangle(5);
        //starDiamondPattern(5);
        //starArrowPattern(5);
        //binaryRightAngledTrianglePattern(5);
        // numberTrianglePattern(5);
        //inverseNumberGatePattern(6);
        //increasingNumberTrianglePattern(6);
        // increasingLetterTrianglePattern(5);
        //inverseIncreasingLetterTrianglePattern(5);
        //LetterTrianglePattern(5);
        numberPattern(4);
    }

    static void squarePattern(int row, int column) {

        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= column; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void trianglePattern(int row) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void numberTrianglePattern(int row) {
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    static void inverseTrianglePattern(int row) {
        for (int i = row; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void inverseNumberTrianglePattern(int row) {
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= row - i + 1; j++) {
                System.out.print(j);
            }
            System.out.println("");
        }
    }

    static void starPatternEquilateralTriangle(int row) {
        for (int i = 0; i < row; i++) {
            for (int spaces = 0; spaces < row - i - 1; spaces++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void inverseStarEquilateralTriangle(int row) {

        for (int i = 0; i < row; i++) {

            for (int j = 1; j <= i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < row - i; k++) {
                System.out.print("*");
            }
            for (int l = 0; l < row - 1 - i; l++) {
                System.out.print("*");
            }
            System.out.println();

        }

    }

    static void starDiamondPattern(int row) {
        starPatternEquilateralTriangle(row);
        inverseStarEquilateralTriangle(row);
    }

    static void starArrowPattern(int row) {
        trianglePattern(row);
        inverseTrianglePattern(row - 1);
    }

    static void binaryRightAngledTrianglePattern(int row) {

        boolean toggle = true;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j <= i; j++) {
                if (toggle) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
                toggle = !toggle;
            }

            System.out.println();
        }
    }

    static void inverseNumberGatePattern(int row) {

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
//            for(int spaces= row+2 -((i-1)*2);spaces >0; spaces--){
//                System.out.print("_");
//            }
            int space = 2 * (row - 1) - ((i - 1) * 2); //5 -> i=2 -> 6-(1*2) =4 -> i=3 -> 6-(2*2) = 2
            for (int spaces = space; spaces > 0; spaces--) {
                System.out.print(" ");
            }

            for (int k = i; k >= 1; k--) {

                System.out.print(k);
            }

            System.out.println();
        }
    }

    static void increasingNumberTrianglePattern(int row) {

        int count = 1;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(count + " ");
                count++;
            }
            System.out.println();
        }
    }

    static void increasingLetterTrianglePattern(int row) {
        for (int i = 1; i <= row; i++) {
            char character = 65;
            for (int j = 1; j <= i; j++) {
                System.out.print(character + " ");
                character++;
            }
            System.out.println();
        }

    }

    static void inverseIncreasingLetterTrianglePattern(int row) {
        for (int i = row; i >= 0; i--) {
            char character = 65;
            for (int j = i; j >= 0; j--) {
                System.out.print(character + " ");
                character++;
            }
            System.out.println();
        }

    }

    static void LetterTrianglePattern(int row) {
        char character = 65;
        for (int i = 1; i <= row; i++) {

            for (int j = 1; j <= i; j++) {
                System.out.print(character + " ");


            }
            character++;
            System.out.println();
        }
    }

    // NOW WE WILL MOVE TO THE MOST TOUGH QUESTION OF PATTERNS -- THE NUMBER PATTERN

    static void numberPattern(int row) {
        int size = (2 * row) - 1;

        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++) {
                int number = minimumDistance(i, j, row);
                System.out.print(number + "  ");

            }
            System.out.println();

        }


    }

    static int minimumDistance(int i, int j, int row) {
        int size = (2 * row) - 1;

        int left = row - j;
        int top = row - i;
        int right = row - (size - 1 - j);
        int bottom = row - (size - 1 - i);

        return Math.max(Math.max(left, top), Math.max(right, bottom));
    }
}

