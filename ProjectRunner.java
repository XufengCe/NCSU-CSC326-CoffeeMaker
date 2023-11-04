/**
 * 
 */
package dailymixes;

import java.io.IOException;
import java.text.ParseException;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Qitao Yang(yqitao)
/**
 * /**
 * This is the project runner class
 * 
 * @author Qitao Yang
 * @version 04.11.2023
 *
 */
public class ProjectRunner {

    /**
     * This method will run the program
     * 
     * @param args
     *            the string
     * @throws IOException
     *             exception that will be thrown
     * @throws ParseException
     *             exception that will be thrown
     * @throws DailyMixDataException
     *             exception that will be thrown
     */
    public static void main(String[] args)
        throws IOException,
        ParseException,
        DailyMixDataException {
        PlaylistReader playlistReader;

        if (args.length == 2) {
            playlistReader = new PlaylistReader(args[0], args[1]);
        }
        else {
            playlistReader = new PlaylistReader("input.txt", "playlists.txt");
        }
    }
}
