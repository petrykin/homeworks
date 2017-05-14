package lesson3.task6;

public class TypeCastingTable implements Primitive {
    private String[][] cells;
    private static final int TYPE_NUMBER = 8;

    TypeCastingTable() {
        cells = new String[TYPE_NUMBER + 1][TYPE_NUMBER + 1];
        cells[0] = new String[]{"", "byte", "short", "char", "int", "long", "float", "double", "boolean"};
        for (int i = 1; i < TYPE_NUMBER + 1; i++) {
            for (int j = 0; j < TYPE_NUMBER + 1; j++) {
                if (j == 0) {
                    cells[i][j] = cells[0][j];
                } else {
                    cells[i][j] = "";
                }
            }
        }
        for (int i = 0; i < cells[0].length; i++) {
            cells[i][0] = cells[0][i];
        }
    }

    private void createDependencyTable() {
        for (int i = 1; i < TYPE_NUMBER + 1; i++) {
            for (int j = 1; j < TYPE_NUMBER + 1; j++) {
                if (i == j) {
                    cells[i][j] = "Т";
                } else if (i < j && j != TYPE_NUMBER || i == 3 && i > j) {
                    cells[i][j] = "Я";
                } else if ((i == TYPE_NUMBER || j == TYPE_NUMBER) && i != j) {
                    cells[i][j] = "X";
                } else {
                    cells[i][j] = "НЯ";
                }
            }
        }
    }

    @Override
    public void printCastingResults() {
        createDependencyTable();
        System.out.println();
        System.out.printf("%50s","Primitives Typecasting Table\n");
        for (int i = 0; i < TYPE_NUMBER + 1; i++) {
            for (int j = 0; j < TYPE_NUMBER + 1; j++) {
                System.out.printf("%7s ", cells[i][j]);
            }
            System.out.println("\n");
        }
    }
}
