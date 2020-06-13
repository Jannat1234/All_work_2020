package Day3_04182020;

public class custom_methods {

//User defined custom method will be created there
   // your reusable method must be static in order to be called on other classes
    // lets create one for void first
    //void method only executes your statement inside the method
    public static void voidAdd(int a, int b) {
      int result = a+b;
      System.out.println("My addition result is " + result);
    }//end of void method

    //create same method as return method
    //return method execute your statements as well as returns you the result you want
    public static int returnAdd(int a, int b){
        int result = a+b;
        System.out.println("My addition result is " + result);
        return result;//will return the result c
    }//end of return method



}//end of java class
