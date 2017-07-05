/*
 * Copyright (c) 2017, Petrykin Sergey.
 */

package lesson19_20.task6;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

/**
 * The <b>{@code Matrix}</b> class represents a two dimensional m-by-n array of expressions,
 * arranged in rows and columns. Each expression is a <b>double</b> - number.
 * Class allow to perform such basic operations as addition, subtraction, multiplication Matrix by Matrix,
 * or number and etc.
 *
 * @author Petrykin Sergey
 * @version 1.0
 *          on 01.07.2017
 */

public class Matrix {
    /**
     * The value is used for matrix elements storage.
     */
    private double[][] m;
    /**
     * The value is used for number of rows storage.
     */
    private int rowsQuantity;
    /**
     * The value is used for number of columns storage.
     */
    private int columnsQuantity;

    /**
     * Initializes a newly created {@code Matrix} object with 0-dimension.
     */
    public Matrix() {
        super();
    }

    /**
     * Initializes a newly created {@code Matrix} object so that it represents
     * a 2-dimensional array with {@code rowsQuantity}-by-{@code columnsQuantity} size
     * with zero-elements.
     *
     * @param rowsQuantity    the initial value of Matrix rows number
     * @param columnsQuantity the initial value of Matrix columns number
     */
    public Matrix(int rowsQuantity, int columnsQuantity) {
        m = new double[rowsQuantity][columnsQuantity];
        this.rowsQuantity = rowsQuantity;
        this.columnsQuantity = columnsQuantity;
    }

    /**
     * Initializes a newly created {@code Matrix} object from {@code double[][]} object.
     *
     * @param matrix 2-dimensional array that represents Matrix object
     */
    public Matrix(double[][] matrix) {
        this.m = matrix;
        rowsQuantity = matrix.length;
        columnsQuantity = matrix[0].length;
    }

    /**
     * Initializes a newly created {@code Matrix} object so that is copy of input {@code Matrix} object.
     *
     * @param a input {@code Matrix} object
     */
    public Matrix(Matrix a) {
        this(a.getRowsQuantity(), a.getColumnsQuantity());
        for (int row = 0; row < rowsQuantity; row++) {
            for (int col = 0; col < columnsQuantity; col++) {
                this.setElement(row, col, a.getElement(row, col));
            }
        }
    }

    /**
     * Return number of {@code Matrix} rows.
     *
     * @return value of {@code Matrix} object {@code rowsQuantity} field
     */
    public int getRowsQuantity() {
        return rowsQuantity;
    }

    /**
     * Return number of {@code Matrix} columns.
     *
     * @return value of {@code Matrix} object {@code columnsQuantity} field
     */
    public int getColumnsQuantity() {
        return columnsQuantity;
    }

    /**
     * Setup Matrix element at row-column position by double value.
     *
     * @param row    row-index of setup element
     * @param column column-index of setup element
     * @param value  row-column position setup value
     */
    public void setElement(int row, int column, double value) {
        m[row][column] = value;
    }

    /**
     * Fill each elements of {@code Matrix} object as double random value from 0.0 to 1.0.
     */
    public void fillRandom() {
        for (int row = 0; row < rowsQuantity; row++) {
            for (int col = 0; col < columnsQuantity; col++) {
                this.setElement(row, col, Math.random());
            }
        }
    }

    /**
     * Fill elements of {@code Matrix} object so that element with equal row- and column- indexes
     * setup with 1.0, other elements setup with 0.0.
     */
    public void fillUnit() {
        if (rowsQuantity == columnsQuantity) {
            for (int row = 0; row < rowsQuantity; row++) {
                for (int col = 0; col < columnsQuantity; col++) {
                    if (row == col) {
                        this.setElement(row, col, 1.0);
                    } else {
                        this.setElement(row, col, 0.0);
                    }
                }
            }
        }
    }

    /**
     * Return Matrix element double value at row-column position.
     *
     * @param row    row-index of returns element
     * @param column column-index of returns element
     * @return double value of {@code Matrix} object element at row-column position
     */
    public double getElement(int row, int column) {
        return m[row][column];
    }

    /**
     * Return a square matrix so that contains all rows and columns of initial matrix exclude rm-row and cm-column.
     *
     * @param rm row must be removed
     * @param cm column must be removed
     * @return new {@code Matrix} object exclude rm-row and cm-column
     */
    private Matrix getMinor(int rm, int cm) {
        Matrix tmp = new Matrix(this.getRowsQuantity() - 1, this.getColumnsQuantity() - 1);
        int r = 0, c = 0;
        for (int i = 0; i < this.getRowsQuantity(); i++, r++) {
            for (int j = 0; j < this.getColumnsQuantity(); j++, c++) {
                if (i != rm && j != cm) {
                    tmp.setElement(r, c, this.getElement(i, j));
                } else if (j == cm) {
                    c--;
                }
            }
            if (i == rm) {
                r--;
            }
            c = 0;
        }
        return tmp;
    }

    /**
     * Return determinant of initial matrix.
     *
     * @return double value of determinant of initial matrix
     */
    public double getDeterminant() {
        double det = 0.0;
        if (this.getRowsQuantity() == this.getColumnsQuantity()) {
            if (this.getColumnsQuantity() == 1) {
                det = this.getElement(0, 0);
            } else {
                for (int j = 0; j < this.getColumnsQuantity(); j++) {
                    det += Math.pow(-1.0, j) * this.getElement(0, j) * this.getMinor(0, j).getDeterminant();
                }
            }
        }
        return det;
    }

    /**
     * Add two {@code Matrix} objects that have equal dimensions.
     *
     * @param a matrix must be added to initial matrix
     * @return sum of two matrices, if they have equal dimensions or
     * matrix with 0-dimension if matrices have non-equal dimensions
     */
    public Matrix add(Matrix a) {
        if (rowsQuantity != a.getRowsQuantity() || columnsQuantity != a.getColumnsQuantity()) return new Matrix(0, 0);
        Matrix tmp = new Matrix(rowsQuantity, columnsQuantity);
        for (int i = 0; i < rowsQuantity; i++) {
            for (int j = 0; j < columnsQuantity; j++) {
                tmp.setElement(i, j, this.getElement(i, j) + a.getElement(i, j));
            }
        }
        return tmp;
    }

    /**
     * Add number {@code a} to each elements of initial matrix.
     *
     * @param a added number that extends class Number
     * @return new {@code Matrix} object
     */
    public Matrix add(Number a) {
        Matrix tmp = new Matrix(rowsQuantity, columnsQuantity);
        for (int i = 0; i < rowsQuantity; i++) {
            for (int j = 0; j < columnsQuantity; j++) {
                tmp.setElement(i, j, this.getElement(i, j) + a.doubleValue());
            }
        }
        return tmp;
    }

    /**
     * Subtract two {@code Matrix} objects that have equal dimensions.
     *
     * @param a matrix must be subtracted from initial matrix
     * @return subtraction of two matrices, if they have equal dimensions or
     * matrix with 0-dimension if matrices have non-equal dimensions
     */
    public Matrix subtract(Matrix a) {
        return this.add(a.multiply(-1));
    }

    /**
     * Subtract number {@code a} from each elements of initial matrix.
     *
     * @param a subtracted number that extends class Number
     * @return new {@code Matrix} object
     */
    public Matrix subtract(Number a) {
        return this.add(-a.doubleValue());
    }

    /**
     * Multiply two {@code Matrix} objects so that rows number of argument matrix
     * must be equal columns number of initial matrix.
     *
     * @param a matrix must be multiplied by initial matrix
     * @return new {@code Matrix} object
     */
    public Matrix multiply(Matrix a) {
        if (this.getColumnsQuantity() != a.getRowsQuantity()) return new Matrix(0, 0);
        Matrix tmp = new Matrix(rowsQuantity, a.getColumnsQuantity());
        for (int i = 0; i < rowsQuantity; i++) {
            for (int j = 0; j < a.getColumnsQuantity(); j++) {
                for (int k = 0; k < columnsQuantity; k++) {
                    tmp.setElement(i, j, tmp.getElement(i, j) + this.getElement(i, k) * a.getElement(k, j));
                }
            }
        }
        return tmp;
    }

    /**
     * Multiply each elements of initial matrix by number {@code a}.
     *
     * @param a multiplication factor
     * @return new {@code Matrix} object
     */
    public Matrix multiply(double a) {
        Matrix tmp = new Matrix(rowsQuantity, columnsQuantity);
        for (int i = 0; i < rowsQuantity; i++) {
            for (int j = 0; j < columnsQuantity; j++) {
                tmp.setElement(i, j, this.getElement(i, j) * a);
            }
        }
        return tmp;
    }

    /**
     * Return transposed matrix with respect to initial matrix.
     *
     * @return transposed matrix
     */
    public Matrix transpose() {
        Matrix tmp = new Matrix(columnsQuantity, rowsQuantity);
        for (int i = 0; i < columnsQuantity; i++) {
            for (int j = 0; j < rowsQuantity; j++) {
                tmp.setElement(i, j, this.getElement(j, i));
            }
        }
        return tmp;
    }

    /**
     * Print {@code Matrix} object representation to console with title.
     *
     * @param matrixName - title of matrix representation
     */
    public void print(String matrixName) {
        System.out.println("Matrix " + matrixName + ":");
        for (int i = 0; i < this.getRowsQuantity(); i++) {
            for (int j = 0; j < this.getColumnsQuantity(); j++) {
                System.out.printf(Locale.ROOT, "%1.4f    ", this.getElement(i, j));
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Output {@code Matrix} object representation to file.
     *
     * @param fw         {@code FileWriter} object appropriates text file.
     * @param matrixName title of matrix representation
     * @throws IOException If an I/O error occurs
     */
    public void toFile(FileWriter fw, String matrixName) throws IOException {
        fw.write("Matrix " + matrixName + ":\n");
        for (int i = 0; i < rowsQuantity; i++) {
            for (int j = 0; j < columnsQuantity; j++) {
                fw.write(this.getElement(i, j) + "\t");
            }
            fw.write("\n");
        }
        fw.write("\n");
    }

    /**
     * Indicates whether some other {@code Matrix} object is "equal to" this one.
     *
     * @param o the reference object with which to compare
     * @return {@code true} if this object is the same as the obj
     * argument; {@code false} otherwise
     * @see #hashCode()
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Matrix matrix = (Matrix) o;

        if (rowsQuantity != matrix.rowsQuantity) return false;
        if (columnsQuantity != matrix.columnsQuantity) return false;
        return Arrays.deepEquals(m, matrix.m);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object
     */
    @Override
    public int hashCode() {
        int result = Arrays.deepHashCode(m);
        result = 31 * result + rowsQuantity;
        result = 31 * result + columnsQuantity;
        return result;
    }

    /**
     * Returns a string representation of the {@code Matrix} object.
     *
     * @return a string representation of the {@code Matrix} object
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.getRowsQuantity(); i++) {
            for (int j = 0; j < this.getColumnsQuantity(); j++) {
                sb.append(this.getElement(i, j));
                sb.append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}