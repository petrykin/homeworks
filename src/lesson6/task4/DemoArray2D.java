package lesson6.task4;

public class DemoArray2D {
    public static void main(String[] args) {
        Array2D array2D = new Array2D();

        double[][] numbers = {
                {array2D.getRandom(), array2D.getRandom(), array2D.getRandom(), array2D.getRandom(), array2D.getRandom(), array2D.getRandom(), array2D.getRandom(), array2D.getRandom()},
                {array2D.getRandom(), array2D.getRandom(), array2D.getRandom(), array2D.getRandom(), array2D.getRandom(), array2D.getRandom(), array2D.getRandom(), array2D.getRandom()},
                {array2D.getRandom(), array2D.getRandom(), array2D.getRandom(), array2D.getRandom(), array2D.getRandom(), array2D.getRandom(), array2D.getRandom(), array2D.getRandom()},
                {array2D.getRandom(), array2D.getRandom(), array2D.getRandom(), array2D.getRandom(), array2D.getRandom(), array2D.getRandom(), array2D.getRandom(), array2D.getRandom()},
                {array2D.getRandom(), array2D.getRandom(), array2D.getRandom(), array2D.getRandom(), array2D.getRandom(), array2D.getRandom(), array2D.getRandom(), array2D.getRandom()}
        };

        System.out.println("Исходный 2-х мерный массив:");
        array2D.printArray(numbers);

        System.out.println();

        System.out.println("2-х мерный массив минимальных и максимальных значений:");
        array2D.printArray(array2D.get2DMinMaxArray(numbers));
    }
}
