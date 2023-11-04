/**
 * 
 */
package dailymixes;

import java.util.Arrays;
import list.AList;
import queue.EmptyQueueException;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Qitao Yang(yqitao)
/**
 * /**
 * This is the playlistcalculator class
 * 
 * @author Qitao Yang
 * @version 04.11.2023
 *
 */
public class PlaylistCalculator {

    private Playlist[] playlists;
    private AList<Song> rejectedTracks;
    private ArrayQueue<Song> songQueue;

    /**
     * This is the constant that is being used for the class represent number of
     * position
     */
    public static final int NUM_PLAYLISTS = 3;
    /**
     * This is the constant that is being used for the class represent min%
     */
    public static final int MIN_PERCENT = 0;
    /**
     * This is the constant that is being used for the class represent max%
     */
    public static final int MAX_PERCENT = 100;

    /**
     * This is the constructor of the playlist calculator
     * 
     * @param songQueue
     *            queue of song
     * @param playlists
     *            array of playlists
     */
    public PlaylistCalculator(

        ArrayQueue<Song> songQueue,
        Playlist[] playlists) {
        if (songQueue == null) {
            throw new IllegalArgumentException();
        }
        this.songQueue = songQueue;
        this.playlists = playlists;
        this.rejectedTracks = new AList<>();

    }


    /**
     * This is the method that get the playlist for the song
     * 
     * @param nextSong
     *            the song that we get the playlist from
     * @return a playlist the method obtain
     */
    public Playlist getPlaylistForSong(Song nextSong) {
        if (nextSong == null) {
            return null;
        }

        String suggestedPlaylistStringName = nextSong.getPlaylistName();
        Playlist suggestedPlaylist = null;

        for (int i = 0; i < playlists.length; i++) {
            if (playlists[i].getName().equals(suggestedPlaylistStringName)) {
                suggestedPlaylist = playlists[i];
                break;
            }

        }

        if (suggestedPlaylist != null) {
            if (!suggestedPlaylist.isFull() && suggestedPlaylist.isQualified(
                nextSong)) {
                return suggestedPlaylist;
            }

            else {
                return null;
            }
        }

        else {
            suggestedPlaylist = getPlaylistWithMostRoom(nextSong);
            return suggestedPlaylist;
        }

    }


    /**
     * This is the helper method for getplaylist for song
     * 
     * @param song
     *            that we obtain the bestpossible playlist from
     * @return a playlist that fit the most
     */
    private Playlist getPlaylistWithMostRoom(Song song) {
        Playlist[] sortedPlaylists = playlists.clone();
        Arrays.sort(sortedPlaylists);

        Playlist bestPossiblePlayList = null;

        for (int i = 0; i < sortedPlaylists.length; i++) {
            if (sortedPlaylists[i].isQualified(song) && !sortedPlaylists[i]
                .isFull()) {
                bestPossiblePlayList = sortedPlaylists[i];
            }
        }

        return bestPossiblePlayList;
    }


    /**
     * This is the method that test if the front queue can be added to the list
     * 
     * @return a true or false
     */
    public boolean addSongToPlaylist() {
        if (songQueue.isEmpty()) {
            return false;
        }

        Song frontSong = songQueue.getFront();
        Playlist suggestedPlaylist = getPlaylistForSong(frontSong);

        if (suggestedPlaylist != null) {
            suggestedPlaylist.addSong(frontSong);
            songQueue.dequeue();
            return true;
        }
        else {
            return false;
        }
    }


    /**
     * This is a method that can reject from the playlist
     */
    public void reject() {
        if (songQueue.isEmpty()) {
            throw new EmptyQueueException();
        }
        Song frontSong = songQueue.getFront();
        rejectedTracks.add(frontSong);
        songQueue.dequeue();
    }


    /**
     * This method obtain index
     * 
     * @param playlistName
     *            name of a list
     * @return a int represent the index
     */
    public int getPlaylistIndex(String playlistName) {
        for (int i = 0; i < NUM_PLAYLISTS; i++) {
            if (playlists[i].getName().equals(playlistName)) {
                return i;
            }
        }
        return -1;
    }


    /**
     * This is the getter method for queue
     * 
     * @return a arrayQueue
     */
    public ArrayQueue<Song> getQueue() {
        return songQueue;
    }


    /**
     * This is the getter method for playlist
     * 
     * @return a array of playlists
     */
    public Playlist[] getPlaylists() {
        return playlists;
    }

}
