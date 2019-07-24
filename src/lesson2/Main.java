package lesson2;

public class Main {

    public static void stringToArray(String line, String[][] arr) throws WrongArraySize {
        //arr = new String[4][4];
        String[] arrline = line.split("\n");

        /*for(String readarr: arrline){
            System.out.println(readarr);
        }*/
        if (arrline.length != 4) {
            throw new WrongArraySize("no 4 columns");
        }
        for (int i = 0; i < arrline.length; i++) {
            if (arrline[i].split(" ").length != 4) {
                throw new WrongArraySize("no 4 in row");
            }
            arr[i] = arrline[i].split(" ");
        }


        /*for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length; j++){
                System.out.print(arr[i][j]) ;
            }
            System.out.println() ;
        }*/

    }

    public static void stringArrayToInt(String[][] arr, int[][] array) throws NotIntInArray {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                array[i][j] = Integer.parseInt(arr[i][j]);
            }
            System.out.println();
        }
    }

    public static float getFromArr(int[][] arr) {
        float count = 0 * 1.0f;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                count += arr[i][j];
            }
            System.out.println();
        }

        return count / 2;
    }

    public static void main(String[] args) {
        // String line = "1 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 1 0";
        String line = "1 3 1 2 \n2 3 2 2\n5 6 7 7\n3 3 0 а";
        String[][] arr = new String[4][4];
        try {
            stringToArray(line, arr);
        } catch (WrongArraySize e) {
            System.out.println("\u001B[31mERROR!!! ERROR!!!" + e.getClass() + "  "
                    + e.getMessage() + "    " + e.getStackTrace());
            return;
        }
/*
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length; j++){
                System.out.print(arr[i][j]) ;
            }
            System.out.println() ;
        }
        /*Integer.parseInt("234");*/
        int[][] array = new int[4][4];
        try {
            stringArrayToInt(arr, array);
        } catch (NumberFormatException e) {
            System.out.println("\u001B[31mERROR!!! ERROR!!!" + new NotIntInArray("can't do it in int").getClass() + "  "
                    + new NotIntInArray("can't do it in int").getMessage() + "\u001B[0m");
            return;
        }

        System.out.println(getFromArr(array));

    }
}
