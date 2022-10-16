import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayAssignment {

    public static void main(String[] args) {
        int[][] recArr = {{1,2,3},{4,5,6},{7,8,9}};
        diagonalPrint(recArr);
        int [] A = {1,2,3,0,0,2,1};
        System.out.println(allNumsWithin(A,3));


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

        for(int i = 0;i<A.length;i++){
            System.out.println("this is i: "+i);
            for (int j = i;j<A.length;j++){
                System.out.println("j: "+j);
                if(0 <= A[j] && A[j] < k){
                    lCheck[A[j]] = 1;
                }
                //looped lcheck = [1,0,1]
                boolean full = true;
                for(int d = 0; d<lCheck.length; d++){
                    //System.out.println(d);
                    if (lCheck[d] == 0){
                        full = false;
                    }
                }
                System.out.println(full);
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
        //System.out.printf(m[0][0]+" ");
        int aCounter = 0,bCounter = 0,dover = 0;
        boolean claped = true;
        /*
        for(int i = 0;i<m.length;i++){
            System.out.println("jf");
            bCounter++;
            if(aCounter<dover && claped){
                bCounter++;
                aCounter = 0;
                i= 0;
                System.out.println("his");

            }else if(!claped){
                i--;
                bCounter--;
            }
            for (int j=0;j<bCounter;j++){
                System.out.print(m[i][j]+" ");
                dover ++;
                aCounter += 2;

            }
        }
        */
        int rowTops = 1;
        boolean rowBack = false;
        int rowBobs = 0;
        int i = 0;
        while (i<rowTops){
            //System.out.println("this is i "+i);
            //System.out.print(m[i][0] + " ");
            if(rowTops<m.length&&!rowBack){
                rowTops++;
                //System.out.printf("row");
            }else if(rowTops==m.length){
                //System.out.printf("this");
                i = 0;
                rowTops--;
                rowBack = true;
                rowBobs = m.length-1;
            }else if(rowBobs == rowTops && rowBack){
                i = 0;
                rowBobs--;
                rowTops--;
            }

            else{
                //System.out.printf("that");
                rowTops--;
            }
            for(int j = 0;j<rowTops;j++){
                //System.out.print(m[i][j] +" ");
            }
        }
    }

}

