import java.lang.reflect.Executable;
import java.util.Iterator;
public class Calculator {
    private double[] dataSet;

    // Constructor
    public Calculator (String dataSet, String option){
        this.dataSet =  convertToDouble(dataSet); // convert to double
        if(option.equals("1") || option.equals("mean")){
            getMean(this.dataSet);
        }
        else if(option.equals("2") || option.equals("mode")){
            getMod(this.dataSet);
        }
        else{
            System.out.println("Wrong operation number, please try again!");
        }
    }

    public double[] getDataSet(){
        return this.dataSet;
    }

    public double[] convertToDouble(String dataSet){
        // Convert string to double
        try{
            //Remove all commas
            String[] slicedDataSet = dataSet.split(",");
            double[] convertedString = new double[slicedDataSet.length];
            //Convert to double
            // Get the iterator
            for(int i = 0; i < slicedDataSet.length; i++){
                convertedString[i] = Double.parseDouble(slicedDataSet[i]);
            }

            return convertedString;
        }
        catch(Exception err){
            System.out.println("Error!");
            throw err;
        }
    }
    public double getMean(double[] dataSet) {
        return 1;
    }

    public double getMod(double[] dataSet) {
        return 1;
    }
}
