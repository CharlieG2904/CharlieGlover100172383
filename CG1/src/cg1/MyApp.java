//Importing my array list to store the songs, artist and plays.
//Importing the iterator to loop the programme
//Importing the List for the array use
//Importing Scanner for turning user input to basic data (int,string)
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

//This section of the code defines the data types for the title & artist (strings) and the number of plays (integer)
class Song {
    private String title;
    private String artist;
    private int plays;

    //This is definining the class "Song" , setting the plays to 0, entering the title as "title" & artist as "artist"
    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
        this.plays = 0;
    }

//These are the getters. Inputting Title, Artist, Plays    
    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getPlays() {
        return plays;
    }

    public void incrementPlays() {
        plays++;
    }

    //This is a useful command that I have learnt to override a method in the superclass. This is converting the whole output to a string. 
    @Override
    public String toString() {
        return title + " by " + artist + " (Plays: " + plays + ")";
    }
}

//This section creates our class for the array that stores out title, artist and plays. Defining song list as private. 
class MusicStreamingService {
    private List<Song> songList;

//Creating the array to store our inputted title,artist and plays.
    public MusicStreamingService() {
        songList = new ArrayList<>();
    }

//This function is inputting the song title and artist and adding this to the array. Displaying "song added" & the song that has been inputted
    public void addSong(String title, String artist) {
        Song song = new Song(title, artist);
        songList.add(song);
        System.out.println("Song added: " + song);
    }