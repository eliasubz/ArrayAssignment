import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayAssignment {

    public static void main(String[] args) {
        //int[][] recArr = {{1,2},{3,4},{5,6},{7,8},{9,10},{11,12}};//,234},{13,14,15,16,17,18,345},{123,345,234,567,234,36,63}};
        //int[][] recArr = {{1,2,3,4,5,6,7},{8,9,10,11,12,234,573},{13,14,15,16,17,18,345},{123,345,234,567,234,36,63}};
        //int [][] recArr = [1, 2, 3, 4],[5, 6, 7, 8][9, 10, 11, 12][13, 14, 15, 16;
        int [][] recArr = {{1,2,3},{4,5,6},{7,8,9}};
        diagonalPrint(recArr);



    }
    public static int allNumsWithin(int[] A, int k) {

        int path = A.length;
        int [] lCheckCounter = new int[k];


        for (int i = 0;i<A.length;i++){
            // assigns 1s in lCheckCounter [0,1,1,0,1] with k elements for every value 0;k-1 in A[]
            if (A[i] < k){
                lCheckCounter[A[i]] = 1;
            }
        }
        for(int i = 0; i<lCheckCounter.length; i++){
            // checks that every number 0 to k-1 is in A
            // returns 0 if one of the 0;k-1 values is'nt in A
            if (lCheckCounter[i] == 0){
                return 0;
            }
        }
        int [] lCheck = new int[k];
        // lCheck array with k elements [0,1,...,k] same as lCheckCounter
        // it starts at every index and finishes when lCheck is full
        // finds the shortest path at which lCheck is filled
        for(int i = 0;i<A.length;i++){
            // iterates over A
            // starts at A[i] and counts how many steps it takes, till all lCheck elements are 1
            for (int j = i;j<A.length;j++){

                // checks if A[j] value is in 0;k-1 and if so assigns 1 to lCheck
                if(0 <= A[j] && A[j] < k){
                    lCheck[A[j]] = 1;
                }

                boolean full = true;
                for(int d = 0; d<lCheck.length; d++){
                    //checks every j if lCheck is complete
                    if (lCheck[d] == 0){
                        full = false;
                    }
                }
                if(full && j-i <path){
                    // if lCheck is complete and the steps where less than the previous paths
                    // then it assigns the new steps amount to path
                    path = j-i+1;
                    System.out.println("path update " +path);
                    break;
                }

            }
            for (int j =0; j<lCheck.length;j++){
                // lCheck back to 0: [0,0,0,0,0,0,0,0,k=0,]
                lCheck[j] = 0;
            }

        }



        return path;
    }

    public static void diagonalPrint(int[][] m) {

        int rows = m.length;
        int columns = m[0].length;
        int loop = rows + columns - 1;
        // loop ist die Menge an Startpunkten an denen man wieder anfängt
        // links und unten die elemnte entlang

        for (int i = 0;i<loop;i++) {
            // looped so oft wie es startpunkte gibt|_

            int x = 0;
            int y = 0;
            if (i >= rows - 1) {
                x = rows - 1;
                y = i - rows + 1;
            } else {
                x = i;
            }
            //Systemten f.out.print("(x: "+x+" y: "+y+")");
            //            // findet Koordinaür startpunkte

            // if statements for these amount of rows =,<,> columns
            if (rows == columns) {
                for (int j = 0; j < x - y + 1; j++) {
                    int a = x - j;
                    int b = y + j;
                    System.out.print(m[a][b]+" ");
                }
            }else if (rows < columns) {
                int g = 1;
                int bigger = columns -rows;
                // bigger is how much more columns there are then rows
                if (y>0){

                    // When y starts to grow in other words that we started to stay in same row und go column to the right
                    g = y+1;
                }

                if(y > bigger){
                    g = -x +y+columns-y;

                }
                for (int j = 0;j < x-y +g && j<columns-1;j++){

                    int a = x - j;
                    int b = y + j;
                    System.out.print(m[a][b]+" ");
                }


            }else if (rows> columns){
                int g = 1;
                if (x >= columns){
                    g = columns-x;
                }
                for (int j = 0;j < x-y + g  &&  j < rows;j++){

                    int a = x - j;
                    int b = y + j;
                    System.out.print(m[a][b]+" ");
                }
            }
        }
    }

}

