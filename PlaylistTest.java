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
 * This is the test class for playlist
 * 
 * @author Qitao Yang
 * @version 04.11.2023
 *
 */
public class PlaylistTest extends student.TestCase {

    private Playlist testPlaylist;
    private Song testSong;
    private Song testSong2;
    private Song testSong3;
    private Song testSong4;
    private Song testSong5;

    /**
     * This is the set up for the test
     */
    public void setUp() {
        testPlaylist = new Playlist("A", 0, 0, 0, 10, 10, 10, 3);
        testSong = new Song("SongA", 1, 2, 3, "listA");
        testSong2 = new Song("SongB", 4, 5, 6, "listB");
        testSong3 = new Song("SongC", 7, 8, 9, "listC");
        testSong4 = new Song("SongD", 0, 0, 0, "listD");
        testSong5 = new Song("SongE", 100, 100, 100, "listE");
    }


    /**
     * This is the test for addsong
     */
    public void testAddSong() {
        assertFalse(testPlaylist.addSong(testSong5));
        testPlaylist.addSong(testSong);
        testPlaylist.addSong(testSong2);
        testPlaylist.addSong(testSong3);
        testPlaylist.addSong(testSong4);
        testPlaylist.addSong(testSong5);
        assertEquals(3, testPlaylist.getNumberOfSongs());
    }


    /**
     * This is the test for isfull
     */
    public void testIsFull() {
        testPlaylist.addSong(testSong);
        testPlaylist.addSong(testSong2);
        testPlaylist.addSong(testSong3);
        assertTrue(testPlaylist.isFull());
    }


    /**
     * This is the test for toString
     */
    public void testToString() {
        assertEquals(
            "Playlist: A, # of songs: 0 (cap: 3), Requires: Pop:0%-10%, "
                + "Rock:0%-10%, Country:0%-10%", testPlaylist.toString());
    }


    /**
     * This is the test for equals method
     */
    public void testEquals() {
        Song song1 = new Song("Song1", 3, 2, 7, "JayChou");
        Song song2 = new Song("Song2", 2, 3, 6, "JayChou");
        Song song3 = new Song("Song3", 1, 4, 5, "JayChou");

        Playlist playlist1 = new Playlist("JayChou", 0, 1, 3, 4, 5, 9, 5);
        Playlist playlist2 = new Playlist("JayChou", 0, 1, 3, 4, 5, 9, 5);
        Playlist playlist3 = new Playlist("NotJayChou", 0, 1, 3, 4, 5, 9, 5);
        Playlist playlist4 = new Playlist("JayChou", 0, 2, 3, 4, 5, 9, 5);
        Playlist playlist5 = new Playlist("JayChou", 0, 1, 3, 4, 6, 9, 5);
        Playlist playlist6 = new Playlist("JayChou", 0, 1, 3, 4, 5, 9, 4);
        Playlist playlist7 = new Playlist("JayChou", 0, 1, 3, 4, 5, 9, 5);
        Playlist playlist8 = new Playlist("JayChou", 0, 1, 3, 4, 5, 9, 5);

        playlist1.addSong(song1);
        playlist1.addSong(song2);
        playlist2.addSong(song1);
        playlist2.addSong(song2);
        playlist3.addSong(song1);
        playlist3.addSong(song2);
        playlist4.addSong(song1);
        playlist4.addSong(song2);
        playlist5.addSong(song1);
        playlist5.addSong(song2);
        playlist6.addSong(song1);
        playlist7.addSong(song1);
        playlist7.addSong(song3);
        playlist8.addSong(song1);
        playlist8.addSong(song2);
        playlist8.addSong(song3);

        String a = "";
        assertFalse(playlist1.equals(a));
        assertFalse(playlist1.equals(null));
        assertTrue(playlist1.equals(playlist1));
        assertTrue(playlist1.equals(playlist2));
        assertFalse(playlist1.equals(playlist3));
        assertFalse(playlist1.equals(playlist4));
        assertFalse(playlist1.equals(playlist5));
        assertFalse(playlist1.equals(playlist6));
        assertFalse(playlist1.equals(playlist7));
        assertFalse(playlist1.equals(playlist8));
    }


    /**
     * This is the test for compare to method
     */
    public void testCompareTo() {
        Playlist playlist1 = new Playlist("A", 0, 1, 2, 3, 4, 5, 10);
        Playlist playlist2 = new Playlist("B", 0, 1, 2, 3, 4, 5, 10);
        Playlist playlist3 = new Playlist("A", 0, 1, 2, 3, 4, 5, 15);
        Playlist playlist4 = new Playlist("A", 0, 1, 2, 3, 4, 5, 5);
        Playlist playlist5 = new Playlist("A", 1, 2, 3, 4, 5, 6, 10);
        Playlist playlist6 = new Playlist("A", 0, 1, 2, 5, 6, 7, 15);

        assertEquals(1, playlist1.compareTo(playlist4));
        assertEquals(-1, playlist4.compareTo(playlist1));
        playlist2.addSong(testSong);
        assertEquals(1, playlist1.compareTo(playlist2));
        playlist1.addSong(testSong);
        playlist1.addSong(testSong2);
        assertEquals(-1, playlist1.compareTo(playlist2));

        playlist2 = new Playlist("B", 0, 1, 2, 3, 4, 5, 10);
        assertEquals(-1, playlist2.compareTo(playlist5));
        assertEquals(1, playlist5.compareTo(playlist2));

        assertEquals(-1, playlist3.compareTo(playlist6));
        assertEquals(1, playlist6.compareTo(playlist3));

    }

}
