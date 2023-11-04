/**
 * 
 */
package dailymixes;

import queue.EmptyQueueException;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Qitao Yang(yqitao)
/**
 * /**
 * This is the PlaylistCalculator test class
 * 
 * @author Qitao Yang
 * @version 04.11.2023
 *
 */
public class PlaylistCalculatorTest extends student.TestCase {

    private PlaylistCalculator calculator;
    private Playlist[] playlists;
    private ArrayQueue<Song> songQueue;

    /**
     * Set up tests
     */
    public void setUp() {

        playlists = new Playlist[3];
        playlists[0] = new Playlist("A", 0, 0, 0, 10, 10, 10, 10);
        playlists[1] = new Playlist("B", 0, 0, 0, 10, 10, 10, 10);
        playlists[2] = new Playlist("C", 0, 0, 0, 10, 10, 10, 10);
        songQueue = new ArrayQueue<>();
        calculator = new PlaylistCalculator(songQueue, playlists);

    }


    /**
     * Test null constructor
     */
    public void testNullConstructor() {
        Exception exception = null;
        try {
            calculator = new PlaylistCalculator(null, playlists);
        }
        catch (IllegalArgumentException e) {
            exception = e;
        }
        assertTrue(exception instanceof IllegalArgumentException);
    }


    /**
     * This is test getokaylistforsong method
     */
    public void testGetPlaylistForSong() {
        Song song1 = new Song("Song1", 0, 0, 0, "A");
        Song song2 = new Song("Song2", 0, 0, 0, "B");
        Song song3 = new Song("Song3", 0, 0, 0, "C");
        Song song4 = new Song("Song4", 11, 11, 11, "D");
        Song song5 = new Song("Song4", 100, 100, 100, "B");
        Song song6 = new Song("Song6", 90, 90, 90, "");

        assertNull(calculator.getPlaylistForSong(null));
        assertNull(calculator.getPlaylistForSong(song4));
        assertEquals(playlists[0], calculator.getPlaylistForSong(song1));
        assertEquals(playlists[1], calculator.getPlaylistForSong(song2));
        assertEquals(playlists[2], calculator.getPlaylistForSong(song3));

        for (int i = 0; i < 10; i++) {
            playlists[0].addSong(song1);
        }

        assertNull(calculator.getPlaylistForSong(song1));
        assertNull(calculator.getPlaylistForSong(song5));

    }


    /**
     * This is the testAddsong method
     */
    public void testAddSongToPlayList() {
        assertFalse(calculator.addSongToPlaylist());
        Song song1 = new Song("Song1", 0, 0, 0, "A");
        songQueue.enqueue(song1);
        assertTrue(calculator.addSongToPlaylist());
        songQueue.clear();
        Song nullSong = null;
        songQueue.enqueue(nullSong);
        assertFalse(calculator.addSongToPlaylist());

    }


    /**
     * This rest rejected
     */
    public void testReject() {
        Song song1 = new Song("Song1", 0, 0, 0, "A");
        songQueue.enqueue(song1);
        int sizeOfQueue = songQueue.getSize();
        calculator.reject();
        assertEquals(sizeOfQueue - 1, songQueue.getSize());
        songQueue.clear();
        Exception exception = null;
        try {
            calculator.reject();
        }
        catch (EmptyQueueException e) {
            exception = e;
        }
        assertTrue(exception instanceof EmptyQueueException);
    }


    /**
     * This test getter method for queue
     */
    public void testGetQueue() {
        assertEquals(songQueue, calculator.getQueue());
    }


    /**
     * This test getter for playlists
     */
    public void testGetPlaylists() {
        assertEquals(playlists, calculator.getPlaylists());
    }


    /**
     * This test forPlaylistIndex
     */
    public void testGetPlaylistIndex() {
        assertEquals(0, calculator.getPlaylistIndex("A"));
        assertEquals(1, calculator.getPlaylistIndex("B"));
        assertEquals(2, calculator.getPlaylistIndex("C"));
        assertEquals(-1, calculator.getPlaylistIndex("E"));
    }
}
