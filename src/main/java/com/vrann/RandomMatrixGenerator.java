package com.vrann;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import  org.netlib.lapack.testing.matgen.*;
import org.netlib.util.intW;
//import com.github.fommil.netlib.NativeSystemLAPACK;
//import org.netlib.lapack.Dlagsy;
//import breeze.linalg.{DenseMatrix, cholesky}

public class RandomMatrixGenerator {

    public static void main(String[] args) {
//        try {
//            int N = 10000;
//            String matrixName = "matrix";
//            if (args.length > 0) {
//                System.out.println(args.length);
//                System.out.println(args[0]);
//                N = Integer.parseInt(args[0]);
//            }
//            if (args.length > 1) {
//                matrixName = args[1];
//            }
//            generateRandomMatrix(matrixName, N, N);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        generateMatgen();
    }

    public static void generateMatgen()
    {
//        NativeSystemLAPACK lapack = NativeSystemLAPACK.getInstance();
//        lapack.dlagsy
        //Dlagsy.dlagsy(10, 0, new double[]{1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0}, 10, );
        Dlatmr.dlatmr(
                100,
                100,
                "S",
                new int[]{1,2,3,4},
                1,
                "S",
                new double[100],
                5,
                1,
                10.0,
                0,
                "F",
                "N",
                new double[100],
                0,
                0,
                0,
                new double[100],
                0,
                0,
                0.0,
                "N",
                new int[100],
                0,
                0,
                0,
                0.0,
                0.0,
                "N",
                new double[100],
                0,
                0,
                new int[100],
                0,
                new intW(0)
        );
    }

    public static void generateRandomMatrix(String matrixFileName, int numCols, int numRows) throws IOException
    {
        int[][] matrix = new int[numRows][numCols];
        Random rand = new Random();

        BufferedWriter outputWriter = new BufferedWriter(new FileWriter(matrixFileName));
        outputWriter.write(numRows + " " + numCols);

        for (int i = 0; i < numRows; ++i) {
            outputWriter.write("\n");
            for (int j = 0; j < numCols; ++j) {
                matrix[i][j] = rand.nextInt(100);
                outputWriter.write(Integer.toString(matrix[i][j]));
                outputWriter.write(" ");
            }
        }

        outputWriter.flush();
        outputWriter.close();
    }
}
