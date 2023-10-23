/*
 * MyApp.java 
 * 
 * Date: 23/10/2023
 * 
 * Author: Charlie Glover
 * 
 */


package cg1; 
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

//This is the remove song method. Allowing the user to input the song in the array to remove. If the user inputs a song that is not available then it will display " Song not found"
//The iterator is used here to loop the method. 
    public void removeSong(String title) {
        Iterator<Song> iterator = songList.iterator();
        while (iterator.hasNext()) {
            Song song = iterator.next();
            if (song.getTitle().equals(title)) {
                iterator.remove();
                System.out.println("Song removed: " + song);
                return;
            }
        }
        System.out.println("Song not found: " + title);
    }

//This method is quite simple. It allows the user to output all the songs in the array that have been inputted. 
    public void printAllSongs() {
        System.out.println("All songs:");
        for (Song song : songList) {
            System.out.println(song);
        }
    }

//This method is my unique method that can list the songs that have been played over a certain number of times. 
    public void printSongsOverPlays(int playsThreshold) {
        System.out.println("Songs with more than " + playsThreshold + " plays:");
        for (Song song : songList) {
            if (song.getPlays() > playsThreshold) {
                System.out.println(song);
            }
        }
    }

//This is where I have learnt to use the scanner import, this section is defining the musicstreamingservice 
    public static void main(String[] args) {
        MusicStreamingService streamingService = new MusicStreamingService();
        Scanner scanner = new Scanner(System.in);

    //looping until an input between 1-5 is entered then displays and runs the correct method that is related
        while (true) {
            System.out.println("|---------------------------------------------------------|");
            System.out.println("|                      Main Menu                          |");
            System.out.println("|   \nOptions:                                            |");
            System.out.println("|     1. Add a new song                                   |");
            System.out.println("|     2. Remove a song                                    |");
            System.out.println("|     3. Print all songs                                  |");
            System.out.println("|     4. Print songs with plays over a threshold          |");
            System.out.println("|     5. Exit                                             |");  
            System.out.println("|---------------------------------------------------------|");                                          

            int choice = scanner.nextInt();
            scanner.nextLine();  //the new character

//I have used switch techniques to basically run through the different outcomes of the program, this is not ideal in larger programs but for this it works.
            switch (choice) {
//First scenario, "1" is entered then you input the artist and the title
                case 1:
                    System.out.print("Enter song title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter artist: ");
                    String artist = scanner.nextLine();
                    streamingService.addSong(title, artist);
                    break;
//This is the second scenario "2" removing songs. Enter the song you want to remove
                case 2:
                    System.out.print("Enter the title of the song to remove: ");
                    String titleToRemove = scanner.nextLine();
                    streamingService.removeSong(titleToRemove);
                    break;
//This is the third scenario "3" printing the list of all the songs that have been inputted
                case 3:
                    streamingService.printAllSongs();
                    break;
//This is the fourth scenario "4" printing the songs over a certain number of plays. 
                case 4:
                    System.out.print("Enter the minimum number of plays: ");
                    int playsThreshold = scanner.nextInt();
                    streamingService.printSongsOverPlays(playsThreshold);
                    break;
//Exiting the program
                case 5:
                    System.out.println("Goodbye!");
                    System.exit(0);
//This is displayed when an incorrect value is entered. 
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

