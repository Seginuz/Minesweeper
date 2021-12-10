
class ArrayOperations {
    public static void reverseElements(int[][] twoDimArray) {
        for (int i = 0; i < twoDimArray.length; i++) {
            int[] reversedArray = new int[twoDimArray[i].length];

            for (int j = 0; j < twoDimArray[i].length; j++) {
                reversedArray[j] = twoDimArray[i][twoDimArray[i].length - 1 - j];
            }

            twoDimArray[i] = reversedArray;
        }
    }
}