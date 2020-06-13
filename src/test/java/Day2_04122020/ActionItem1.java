package Day2_04122020;

public class ActionItem1 {

    public static void main(String[] args) {

    //declaring dynamic string
        String [] streetNumber;

        //declare int array
        int [] zipCode;

      //defining dynamic array with the length of the variables
       streetNumber = new String[4];
        streetNumber [0] = "5002";
        streetNumber [1] = "2202";
        streetNumber [2] = "9022";
        streetNumber [3] = "5544";


        // defining dynamic int array with length of thr variables
        zipCode = new int [4];
        zipCode [0] = 11234;
        zipCode [1] = 11080;
        zipCode [2] = 11430;
        zipCode [3] = 11404;

        //now creating forLoop
        for(int i=0; i< streetNumber.length; i++) {
        System.out.println("my street number is " + streetNumber [i] + " my zip code " + zipCode [i]);

        }//end of forLoop

        System.out.println("");
        int a=0;
        while (a< zipCode.length) {
            System.out.println("my street number is " + streetNumber [a] + " my zip code " + zipCode [a]);
            a = a + 1;
        }//end of whileLoop









    }//end of main method



}//end of java class
