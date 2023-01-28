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
        double total = 0;
        for(int i = 0; i < dataSet.length; i++){
            total = total+dataSet[i];
        }
        double mean = total/(dataSet.length);
        return mean;
    }

    public String getMod(double[] dataSet) {
        //Store frequencies
        int[] numberFrequency = new int[dataSet.length];

        for(int i = 0; i < dataSet.length; i++){
            int frequency = 1;
            for(int j = 1; j < dataSet.length-1; j++){
                if(dataSet[i] == dataSet[j]){
                    frequency++;
                }
            }
            numberFrequency[i] = frequency;
        }

        //Find the highest value and its index
        double highestValue = 0;
        int highestValueIndex = 0;
        String data = "There is no mode!";
        for(int i = 0; i < numberFrequency.length; i++){
            if(numberFrequency[i] > highestValue){
                highestValue = numberFrequency[i];
                highestValueIndex = i;
                data = "The mode is: " + dataSet[highestValueIndex];
            }

        }
        return data;
    }
}
