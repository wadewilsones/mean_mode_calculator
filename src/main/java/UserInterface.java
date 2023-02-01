import java.util.Scanner;
import javafx.application.Application;
import javafx.stage.Stage;

public class UserInterface {
    //Commands
    private String [] commands;
    private String dataSet;
    private String option;

    public UserInterface(){
        //Set up commands
        String greetingLine = "Hello! To use this interface you can press either number of an option or use words like \"mean\" or \"mode\"!";

        this.commands = new String[]{"1. Calculate Mean", "2. Calculate Mode"};
        //print commands
        System.out.println(greetingLine);
        PrintCommands();
        // Accept input
        getUserInput();
    }

    public void PrintCommands(){
        for(int i = 0; i < commands.length; i++){
            System.out.println(commands[i]);
        }
    }

    // Collection of methods

    public void getUserInput(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter your option below:");
        String userOption = reader.nextLine();

        System.out.println("Enter your data set using commas!");
        String userDataSet = reader.nextLine();
        this.dataSet = userDataSet;
        this.option = userOption;
    }

    public String getData(){
        return dataSet;
    }
    public String getOption(){
        return option;
    }

}
