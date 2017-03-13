import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ggeor on 13-Mar-17.
 */
public class SimpleTest {
    @Test
    public void whatToTest_whatConditions_expectedResult(){
        String simpleString = "object";
        Assert.assertEquals("Expected word - " + simpleString, "object", simpleString);
    }
}
