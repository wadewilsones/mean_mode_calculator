import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.AssertJUnit.assertTrue;

public class calculatorTest {

    @Test
    void calculateMean() {
        //Create an arrayList
        Calculator calculator = new Calculator("3,5,6,3,5", "1");
        double [] data = calculator.getDataSet();
        double mean = calculator.getMean(data);
        assertThat(mean, CoreMatchers.is(4.4));
    }
    //One mode
    @Test
    void calculateMod() {
        Calculator calculator = new Calculator("1,4,5,6,7", "2");
        double [] data = calculator.getDataSet();
        String mod = calculator.getMod(data);
        assertThat(mod, CoreMatchers.is("The mode is: 4.0"));
    }

}
