package Day2_04122020;

public class LinearArray {


    public static void main(String[] args) {

   //declare the array variables first
   String[] locations, countries, places;
   //declare the empty int array variables first
        int[] number, houseAddress;

        //define the String array variables
        locations = new String[] { "Sixflag","Disney", "Beach"};
        countries = new String[] {"Bangladesh", "USA","Canada","india"};

        //define the int array variables
        number = new int [] {1,2,3,4,};
        houseAddress = new int[] {222, 333, 444, 555};

        //print the last value from locations variable
        System.out.println("My location is " + locations [2] + " is in array index " + number [2]);

    }//end of main method


}//end of java class
