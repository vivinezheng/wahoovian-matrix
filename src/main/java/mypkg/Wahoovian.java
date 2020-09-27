package mypkg;

import org.apache.commons.math3.linear.RealMatrix;
import org.apache.logging.log4j.Logger;

public class Wahoovian {
    private static final Logger logger = Driver.getLogger();

    public static RealMatrix wahoovian(RealMatrix input) {
        logger.info("Entering wahoovian() function.");

        // section for checking the number of rows and columns
        double [][] matrix = input.getData();
        int numRow = matrix.length;
        int numCol = matrix[0].length;
        
        // if statement for empty matrix
        if (numRow == 0 && numCol == 0) {
            logger.warn("The matrix has zero rows and columns.");
            logger.info("Leaving wahoovian() function");
            return input;
        }
        // if statement for non-square matrix
        else if (numRow != numCol) {
            logger.warn("The matrix is not square.");
            logger.info("Leaving wahoovian() function");
            return input;
        }
        // else statement for square matrix
        else {
            RealMatrix output = input.transpose();
            for (int i = 0; i < numRow; i++) {
                for (int k = 0; k < numRow; k++) {
                    output.multiplyEntry(i, k, -1);
                }
            }
            logger.info("Leaving wahoovian() function");
            return output;
        }
    }
}