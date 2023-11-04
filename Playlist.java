/**
 * 
 */
package dailymixes;

import java.util.Arrays;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Qitao Yang(yqitao)
/**
 * /**
 * This is the playlist class for the song
 * 
 * @author Qitao Yang
 * @version 04.11.2023
 *
 */
public class Playlist implements Comparable<Playlist> {

    private GenreSet minGenreSet;
    private GenreSet maxGenreSet;
    private Song[] songs;
    private int capacity;
    private int numberOfSongs;
    private String name;

    /**
     * This the constructuor
     * 
     * @param playlistName
     *            the name of the list
     * @param minPop
     *            the value of pop
     * @param minRock
     *            the value of rock
     * @param minCountry
     *            the value of country
     * @param maxPop
     *            the max value of pop
     * @param maxRock
     *            the max value of rock
     * @param maxCountry
     *            the max value of country
     * @param playlistCap
     *            is the capacity
     */
    public Playlist(
        String playlistName,
        int minPop,
        int minRock,
        int minCountry,
        int maxPop,
        int maxRock,
        int maxCountry,
        int playlistCap) {
        this.name = playlistName;
        this.minGenreSet = new GenreSet(minPop, minRock, minCountry);
        this.maxGenreSet = new GenreSet(maxPop, maxRock, maxCountry);
        this.capacity = playlistCap;
        this.numberOfSongs = 0;
        this.songs = new Song[capacity];
    }


    /**
     * This is the getter method
     * 
     * @return a genreset
     */
    public GenreSet getMinGenreSet() {
        return minGenreSet;

    }


    /**
     * This is the setter method for name
     * 
     * @param newName
     *            the name of the list
     */
    public void setName(String newName) {
        this.name = newName;
    }


    /**
     * This is the getter method for maxGenreset
     * 
     * @return max Genre
     */
    public GenreSet getMaxGenreSet() {
        return maxGenreSet;
    }


    /**
     * This is the getter method for name
     * 
     * @return a string
     */
    public String getName() {
        return name;
    }


    /**
     * This is getter method for number of songs
     * 
     * @return a integer value
     */
    public int getNumberOfSongs() {
        return numberOfSongs;
    }


    /**
     * This is the getter method for songs
     * 
     * @return a array of song
     */
    public Song[] getSongs() {
        return songs;
    }


    /**
     * This is the getter method for capacity
     * 
     * @return a int value of capacity
     */
    public int getCapacity() {
        return capacity;
    }


    /**
     * This is the getter method for space left over
     * 
     * @return a int represent space left
     */
    public int getSpacesLeft() {
        return capacity - numberOfSongs;
    }


    /**
     * This is the method that test if the playlist is full
     * 
     * @return a true or false
     */
    public boolean isFull() {
        return capacity == numberOfSongs;
    }


    /**
     * This is the method that test if song is qualified for the playlist
     * 
     * @param song
     *            that is being evaluted
     * @return a true or false
     */
    public boolean isQualified(Song song) {
        return song.getGenreSet().isWithinRange(minGenreSet, maxGenreSet);
    }


    /**
     * This is the method that will test if the song can be added
     * 
     * @param newSong
     *            that is being tested
     * @return a true or false
     */
    public boolean addSong(Song newSong) {
        if (!isFull() && isQualified(newSong)) {
            songs[numberOfSongs] = newSong;
            numberOfSongs++;
            return true;
        }
        else {
            return false;
        }
    }


    /**
     * This is the to String method
     * 
     * @return a string representation
     */
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("Playlist: ");
        string.append(name);
        string.append(", # of songs: ");
        string.append(numberOfSongs);
        string.append(" (cap: ");
        string.append(capacity);
        string.append("), Requires: Pop:");
        string.append(minGenreSet.getPop());
        string.append("%-");
        string.append(maxGenreSet.getPop());
        string.append("%");
        string.append(", Rock:");
        string.append(minGenreSet.getRock());
        string.append("%-");
        string.append(maxGenreSet.getRock());
        string.append("%");
        string.append(", Country:");
        string.append(minGenreSet.getCountry());
        string.append("%-");
        string.append(maxGenreSet.getCountry());
        string.append("%");

        return string.toString();

    }


    /**
     * This is the equals method
     * 
     * @param obj
     *            object being compared
     * @return true or false
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Playlist compare = (Playlist)obj;
        return this.name.equals(compare.name) && this.minGenreSet.equals(
            compare.minGenreSet) && this.maxGenreSet.equals(compare.maxGenreSet)
            && this.capacity == compare.capacity
            && this.numberOfSongs == compare.numberOfSongs && Arrays.equals(
                this.songs, compare.songs);
    }


    /**
     * This method compare other playlist
     * 
     * @param other
     *            playlist that is being compared
     * @return a int represent the result
     */
    @Override
    public int compareTo(Playlist other) {
        if (this.capacity != other.capacity) {
            return Integer.compare(this.capacity, other.capacity);
        }
        else if (this.getSpacesLeft() != other.getSpacesLeft()) {
            return Integer.compare(this.getSpacesLeft(), other.getSpacesLeft());
        }

        else if (this.minGenreSet.compareTo(other.minGenreSet) != 0) {
            return this.minGenreSet.compareTo(other.minGenreSet);
        }
        else if (this.maxGenreSet.compareTo(other.maxGenreSet) != 0) {
            return this.maxGenreSet.compareTo(other.maxGenreSet);
        }
        else {
            return this.name.compareTo(other.name);
        }

    }

}
