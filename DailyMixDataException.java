/**
 * 
 */
package dailymixes;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Qitao Yang(yqitao)
/**
 * /**
 * This is the class that will throw a DailyMixDataException
 * 
 * @author Qitao Yang
 * @version 04.11.2023
 *
 */
@SuppressWarnings("serial")
public class DailyMixDataException extends Exception {
    /**
     * This is the constructor with a parameter for DailyMixDataException
     * 
     * @param string
     *            a string value
     */
    public DailyMixDataException(String string) {
        super(string);
    }


    /**
     * This is the constructor with no parameter for DailyMixDataException
     */
    public DailyMixDataException() {
        this(null);
    }

}
