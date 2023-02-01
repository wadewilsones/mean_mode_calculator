import java.util.ArrayList;
import java.util.Collections;
public class Calculator {
    private ArrayList <Double> dataSet;

    // Constructor
    public Calculator (String dataSet){
        this.dataSet = convertToDouble(dataSet); // convert to double ArrayList
    }

    public ArrayList <Double> getDataSet(){
        return this.dataSet;
    }

    public ArrayList <Double> convertToDouble(String dataSet){
        // Convert string to double
        try{
            //Remove all commas
            String[] slicedDataSet = dataSet.split(",");
            Double[] convertedString = new Double[slicedDataSet.length];
            ArrayList <Double> numberedSet = new  ArrayList <Double>();
            //Convert to double
            for(int i = 0; i < slicedDataSet.length; i++){
                convertedString[i] = (Double.parseDouble(slicedDataSet[i]));
            }
            Collections.addAll(numberedSet, convertedString);
            return numberedSet;
        }
        catch(Exception err){
            System.out.println("Error!");
            throw err;
        }
    }
    public double getMean(ArrayList <Double> dataSet) {
        double total = 0;
        double mean = 0;
        //Add all numbers to total
        for(double num : dataSet){
            total += num;
        }
        mean = total/dataSet.size();
        return mean;
    }

    public String getMod(ArrayList<Double> dataSet) {
        //Store frequencies
        int[] frequencyArray = new int[dataSet.size()];
        for(int i = 0; i < dataSet.size(); i++){
            int frequency = 1;
            for(int j = i+1; j < dataSet.size(); j++){
                if(dataSet.get(i).equals(dataSet.get(j))){
                    frequency++;
                }
            }
            frequencyArray[i] = frequency;
        }
        int highestValue = 1;
        int highestValueIndex = 0;
        String data = null;

        for(int i = 0; i < frequencyArray.length; i++){
            if(frequencyArray[i] > highestValue){
                highestValue = frequencyArray[i];
                highestValueIndex = i;
                data = "The mode is " + dataSet.get(highestValueIndex);
            }
            else if(frequencyArray[i] == highestValue && frequencyArray[i] > 1){
                data = "There are a few modes:" + dataSet.get(highestValueIndex) + " and " + dataSet.get(i);
            }
            else if(highestValue == 1){
                data = "No mode";
            }

        }

        return data;
    }
}
