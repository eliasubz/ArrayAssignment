import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayAssignment {

    public static void main(String[] args) {
        int[][] recArr = {{1,2,3,4,5,6},{7,8,9,10,11,12}};
        diagonalPrint(recArr);



    }
    public static int allNumsWithin(int[] A, int k) {

        int path = A.length;
        int [] lCheckCounter = new int[k];


        for (int i = 0;i<A.length;i++){
            if (A[i] < k){
                lCheckCounter[A[i]] = 1;
            }
        }
        for(int i = 0; i<lCheckCounter.length; i++){
            if (lCheckCounter[i] == 0){
                return 0;
            }
        }
        // makes an array and checks if every number is available
        int [] lCheck = new int[k];
        // lCheck array with k elements [0,1,...,k]
        for(int i = 0;i<A.length;i++){
            for (int j = i;j<A.length;j++){
                System.out.println("j: "+j);
                if(0 <= A[j] && A[j] < k){
                    lCheck[A[j]] = 1;
                }
                boolean full = true;
                for(int d = 0; d<lCheck.length; d++){
                    //System.out.println(d);
                    if (lCheck[d] == 0){
                        full = false;
                    }
                }
                if(full && j-i <path){
                    path = j-i+1;
                    System.out.println("path update " +path);
                    break;
                }

            }
            for (int j =0; j<lCheck.length;j++){
                lCheck[j] = 0;
            }
            //sets lCheck[1,0,1] to zero
            System.out.println("path int the end: "+path);
        }

        // returns false if one of the numbers are left out

        // now we now that there is a possible way


        return path;
    }

    public static void diagonalPrint(int[][] m) {

        int rows = m.length;
        int collums = m[0].length;

        int loop = rows + collums -1;
        for (int i = 0;i<loop;i++){
            int x = 0;
            int y = 0;


            if (i >= rows - 1) {
                x = rows - 1;
                y = i - rows + 1;
            }else {
                x = i;
            }
            System.out.print("(x: "+x+" y: "+y+")");

            // x und y sind startpunkte
            if (rows == collums) {
                for (int j = 0; j < x - y + 1; j++) {
                    int a = x - j;
                    int b = y + j;
                    System.out.print(m[a][b]+" ");

                }
            }else if (rows < collums){
                int g = 1;
                if (y >= 1){
                    g = collums-y-3;
                    System.out.println(g);
                }
                for (int j = 0;j < x-y + g ;j++){

                    int a = x - j;
                    int b = y + j;
                    System.out.print(m[a][b]+" ");
                }
                System.out.println();



            }else if (rows> collums){
                int g = 1;
                if (x >= collums){
                    g = collums-x;
                }
                for (int j = 0;j < x-y + g  &&  j < rows;j++){

                    int a = x - j;
                    int b = y + j;
                    System.out.print(m[a][b]+" ");
                }
                System.out.println();


            }
        }
    }

}

