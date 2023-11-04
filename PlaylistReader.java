/**
 * 
 */
package dailymixes;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Qitao Yang(yqitao)
/**
 * /**
 * This is the playlist reader class
 * 
 * @author Qitao Yang
 * @version 04.11.2023
 *
 */
public class PlaylistReader {
    private ArrayQueue<Song> queue;
    private Playlist[] playlists;

    /**
     * This is the constructor for the class
     * 
     * @param songsFileName
     *            filename for songs
     * @param playlistsFileName
     *            file name for playlist
     * @throws FileNotFoundException
     *             exception that being thrown
     * @throws java.text.ParseException
     *             exception that is being thrown
     * @throws DailyMixDataException
     *             exception that is being thrown
     */
    public PlaylistReader(String songsFileName, String playlistsFileName)
        throws FileNotFoundException,
        ParseException,
        DailyMixDataException {
        queue = readQueueFile(songsFileName);
        playlists = readPlaylistFile(playlistsFileName);
        new PlaylistWindow(new PlaylistCalculator(queue, playlists));
    }


    /**
     * This is the private helper method for the class
     * 
     * @param num1
     *            number 1
     * @param num2
     *            number 2
     * @param num3
     *            number 3
     * @return true or false
     */
    private boolean isInValidPercentRange(int num1, int num2, int num3) {
        int minValue = PlaylistCalculator.MIN_PERCENT;
        int maxValue = PlaylistCalculator.MAX_PERCENT;
        return num1 <= maxValue && num1 >= minValue && num2 <= maxValue
            && num1 >= minValue && num1 <= maxValue && num1 >= minValue;
    }


    /**
     * This is the method that will read the playlist file
     * 
     * @param playlistFileName
     *            name of the playlist file
     * @return a array of playlist
     * @throws ParseException
     *             exception being thrown
     * @throws FileNotFoundException
     *             exception being thrown
     * @throws DailyMixDataException
     *             exception being thrown
     */
    @SuppressWarnings("resource")
    private Playlist[] readPlaylistFile(String playlistFileName)
        throws ParseException,
        FileNotFoundException,
        DailyMixDataException {
        Playlist[] playlists = new Playlist[3];
        Scanner file = new Scanner(new File(playlistFileName));

        int lineCount = 0;

        while (file.hasNextLine() && lineCount < 3) {
            String read = file.nextLine();
            Scanner currLine = new Scanner(read).useDelimiter(",\\s*");
            String nameOfList = "";
            if (currLine.hasNext()) {
                nameOfList = currLine.next();
            }
            else {
                throw new ParseException("Text file broken", 0);
            }

            int[] genreSet = new int[6];
            for (int i = 0; i < 6; i++) {
                if (currLine.hasNextInt()) {
                    genreSet[i] = currLine.nextInt();
                }
                else {
                    throw new ParseException("Text file broken", 0);
                }
            }

            int capacity = 0;
            if (currLine.hasNextInt()) {
                capacity = currLine.nextInt();
            }
            else {
                throw new ParseException("Text file broken", 0);
            }

            if (currLine.hasNext()) {
                throw new ParseException("Text file broken", 0);
            }

            if (!isInValidPercentRange(genreSet[0], genreSet[1], genreSet[2])
                || (!isInValidPercentRange(genreSet[3], genreSet[4],
                    genreSet[5]))) {
                throw new DailyMixDataException();
            }

            playlists[lineCount] = new Playlist(nameOfList, genreSet[0],
                genreSet[1], genreSet[2], genreSet[3], genreSet[4], genreSet[5],
                capacity);

            lineCount++;
            currLine.close();
        }

        if (lineCount < 3) {
            throw new DailyMixDataException();
        }

        file.close();
        return playlists;

    }


    /**
     * This is the method that will read the queue
     * 
     * @param songFileName
     *            file name for songs
     * @return a arrayqueue of songs
     * @throws ParseException
     *             exception being thrown
     * @throws FileNotFoundException
     *             exception being thrown
     * @throws DailyMixDataException
     *             exception being thrown
     */
    @SuppressWarnings("resource")
    private ArrayQueue<Song> readQueueFile(String songFileName)
        throws ParseException,
        FileNotFoundException,
        DailyMixDataException {
        ArrayQueue<Song> songQueue = new ArrayQueue<>(
            ArrayQueue.DEFAULT_CAPACITY);
        Scanner file = new Scanner(new File(songFileName));

        int lineCount = 0;

        while (file.hasNextLine()) {
            String read = file.nextLine();
            Scanner currLine = new Scanner(read).useDelimiter(",\\s*");
            int tokenCount = 0;
            String songName = "";
            if (currLine.hasNext()) {
                songName = currLine.next();
                tokenCount++;
            }
            else {
                throw new ParseException("Text file broken", 0);
            }

            int[] genreSet = new int[3];
            for (int i = 0; i < 3; i++) {
                if (currLine.hasNextInt()) {
                    genreSet[i] = currLine.nextInt();
                    tokenCount++;
                }
                else {
                    throw new ParseException("Text file broken", 0);
                }
            }

            String suggestedPlaylist = "";
            if (currLine.hasNext()) {
                suggestedPlaylist = currLine.next();
                tokenCount++;
            }

            if (tokenCount < 4) {
                throw new ParseException("Text file broken", 0);
            }

            if (currLine.hasNext()) {
                throw new ParseException("Text file broken", 0);
            }

            if (!isInValidPercentRange(genreSet[0], genreSet[1], genreSet[2])) {
                throw new DailyMixDataException("Broken genreSet");
            }

            Song newSong = new Song(songName, genreSet[0], genreSet[1],
                genreSet[2], suggestedPlaylist);
            songQueue.enqueue(newSong);

            lineCount++;
            currLine.close();
        }

        file.close();
        return songQueue;

    }
}
