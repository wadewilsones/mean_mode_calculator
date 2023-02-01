import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.AssertJUnit.assertTrue;

public class calculatorTest {

    @Test
    void calculateMean() {
        //Create an arrayList
        Calculator calculator = new Calculator("1,55,12,90,50");
       ArrayList <Double> data = calculator.getDataSet();
        double mean = calculator.getMean(data);
        assertThat(mean, CoreMatchers.is(41.6));
    }
    //One mode
    @Test
    void calculateMod() {
        Calculator calculator = new Calculator("1,4,5,6,7,9,12,11,10,71,91");
        ArrayList <Double> data = calculator.getDataSet();
        String mode = calculator.getMod(data);
        assertThat(mode, CoreMatchers.is("No mode"));

    }

    @Test
    void calculateModOneMode() {
        Calculator calculator = new Calculator("1,4,5,6,7,9,12,11,10,71,91,91,71,71");
        ArrayList <Double> data = calculator.getDataSet();
        String mode = calculator.getMod(data);
        assertThat(mode, CoreMatchers.is("The mode is 71.0"));
    }

    @Test
    void calculateModTwoMode() {
        Calculator calculator = new Calculator("1,4,5,6,7,9,12,11,10,71,91,91,71");
        ArrayList <Double> data = calculator.getDataSet();
        String mode = calculator.getMod(data);
        assertThat(mode, CoreMatchers.is("There are a few modes:71.0 and 91.0"));
    }


}
