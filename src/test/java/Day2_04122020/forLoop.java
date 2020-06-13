package Day2_04122020;

public class forLoop {

    public static void main(String[] args) {

        String[] states = new String[4];
        states[0] = "New York";
        states[1] = "California";
        states[2] = "ohio";
        states[3] = "Arizona";

        //defining the loop
        //print all the states from 0 to 3 in sequence
        //i++ each time is adding +1 to i
        //i represents your initial/starting point of your index
        for (int i = 0; i < states. length; i++) {

            System.out.println("My state is " + states[i]);
        }//end of for loop

        }//end of main method


    }//end of java class
