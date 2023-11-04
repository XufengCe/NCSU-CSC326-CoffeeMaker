package dailymixes;
//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those who
//do.
//-- Qitao Yang(yqitao)
/**
* /**
* This is the test class for DailyMixDataException
* 
* @author Qitao Yang
* @version 04.11.2023
*
*/
public class DailyMixDataExceptionTest extends student.TestCase
{

    /**
     * This is the set up for the test class
     */
    public void setUp()
    {
        //Design purpose 
    }
    
    /**
     * This is the test method for the exception
     */
    public void testDailyMixedDataException()
    {
        DailyMixDataException e = new DailyMixDataException("Error error");
        assertTrue(e instanceof DailyMixDataException);
    }
    
    /**
     * This test the default constructor
     */
    public void testDefault()
    {
        DailyMixDataException e = new DailyMixDataException();
        assertTrue(e instanceof DailyMixDataException);
    }
}
