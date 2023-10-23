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