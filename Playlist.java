package dailymixes;

//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those who
//do.
//-- Haowen Zhang (Hw109)

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 * 
 * @author Hw109
 * @version 2023年11月3日
 */
public class Playlist
    implements Comparable<Playlist>
{
    // ~ Fields ................................................................
    private GenreSet minGenreSet;
    private GenreSet maxGenreSet;
    private Song[] songs;
    private int capacity;
    private int numberOfSongs;
    private String name;

    // ~ Constructors ..........................................................
    public Playlist(
        String playlistName,
        int minPop,
        int minRock,
        int minCountry,
        int maxPop,
        int maxRock,
        int maxCountry,
        int playlistCap)
    {

    }


    // ~Public Methods ........................................................
    public GenreSet getMinGenreSet()
    {

    }


    public void setName(String str)
    {

    }


    public int getSpacesLeft()
    {

    }


    public GenreSet getMaxGenreSet()
    {

    }


    public int compareTo(Playlist other)
    {

    }


    public int getNumberOfSongs()
    {

    }


    public boolean addSong(Song newSong)
    {

    }


    public String toString()
    {

    }


    public boolean isFull()
    {

    }


    public boolean equals(Object obj)
    {

    }


    public Song[] getSongs()
    {

    }


    public int getCapacity()
    {

    }


    public void getName()
    {

    }


    public boolean isQualified(Song song)
    {

    }
}
