
public class Main {
    //User interface

    //FOR TESTING
    public static void main(String[] arg){

        //Display intro and collect user input
        UserInterface userInterface = new UserInterface();
        // Create a dataSet
        Calculator newCalculator = new Calculator(userInterface.getData(), userInterface.getOption()); //Replace wth user input

    }

}
