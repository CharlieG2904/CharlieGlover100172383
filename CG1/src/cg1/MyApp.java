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


class Song {
    private String title;
    private String artist;
    private int plays;

//This is definining the class "Song" , setting the plays to 0, entering the title as "title" & artist as "artist"
    public Song(String title, String artist ) {
        this.title = title;
        this.artist = artist;
        this.plays = 0;
    }

//These are the getters. Declaring as public 
    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getPlays() {
        return plays;
    }

    public void incrementPlays(int plays) {
    this.plays += plays;
    }


//Overrides a method in the superclass. This is converting the whole output to a string and then formatting the output to display it as I want
    @Override
    public String toString() {
        return title + " by " + artist + " (Plays: " + plays + ")";
    }
}


class MusicStreamingService {
    private List<Song> songList;

//Creating the array to store our inputted title,artist and plays. This is named songList
    public MusicStreamingService() {
        songList = new ArrayList<>();
    }

//This function is inputting the song title and artist and adding this to the array. Displaying "song added" & the song that has been inputted
    public void addSong(String title, String artist, int plays) {
    Song song = new Song(title, artist);
    song.incrementPlays(plays); 
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
        System.out.println("-----------------------------------------------------------------------");
        System.out.printf("| %-30s | %-30s | %-10s |\n", "Title", "Artist", "Plays");
        System.out.println("-----------------------------------------------------------------------");

        for (Song song : songList) {
            System.out.printf("| %-30s | %-30s | %-10d |\n", song.getTitle(), song.getArtist(), song.getPlays());
        }

        System.out.println("-----------------------------------------------------------------------");
    }

//This method is my unique method that can list the songs that have been played over a certain number of times. 
    public void printSongsOverPlays(int playsThreshold) {
    System.out.println("Songs with more than " + playsThreshold + " plays:");
    System.out.println("--------------------------------------------------");
    System.out.printf("| %-30s | %-30s | %-10s |\n", "Title", "Artist", "Plays");
    System.out.println("--------------------------------------------------");

    for (Song song : songList) {
        if (song.getPlays() > playsThreshold) {
            System.out.printf("| %-30s | %-30s | %-10d |\n", song.getTitle(), song.getArtist(), song.getPlays());
        }
    }

    System.out.println("--------------------------------------------------");
}

//Scanner allowing user to take input from console. defining the musicstreamingservice 
        public static void main(String[] args) {
            MusicStreamingService streamingService = new MusicStreamingService();
            Scanner scanner = new Scanner(System.in);
            streamingService.addSong("Strangers", "Kenya Grace", 100);
            streamingService.addSong("Prada", "casso & raye", 50);
            streamingService.addSong("Greedy", "Tate MCrae", 75);
            streamingService.addSong("First person shooter", "Drake & JCole", 120);
            streamingService.addSong("IDGAF", "Drake", 90);
            streamingService.addSong("Virginia Beach", "Drake", 60);
            streamingService.addSong("Water", "Tyla", 110);
            streamingService.addSong("Adore U", "Fred Again", 70);
            streamingService.addSong("Disconnect", "Becky Hill", 85);
            streamingService.addSong("Asking", "Sonny Fodera", 95);

//looping until an input between 1-5 is entered then displays and runs the correct method that is related, displayed as table
        while (true) {
            System.out.println("|---------------------------------------------------------|");
            System.out.println("|                      Main Menu                          |");
            System.out.println("|      Options:                                           |");
            System.out.println("|      1. Add a new song                                  |");
            System.out.println("|      2. Remove a song                                   |");
            System.out.println("|      3. Print all songs                                 |");
            System.out.println("|      4. Print songs with plays over a threshold         |");
            System.out.println("|      5. Exit                                            |");  
            System.out.println("|---------------------------------------------------------|");                                          

            int choice = scanner.nextInt();
            scanner.nextLine();  //the new character

//I have used switch techniques to basically run through the different outcomes of the program
            switch (choice) {
//First scenario, "1" is entered then you input the artist and the title
                case 1:
                    System.out.print("Enter song title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter artist: ");
                    String artist = scanner.nextLine();
                    System.out.print("Enter number of plays: ");
                    int plays = scanner.nextInt();
                    streamingService.addSong(title, artist, plays);
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
                    int playsThreshold = 0;
                    boolean validInput = false;

                    while (!validInput) {
                        System.out.print("Enter the minimum number of plays: ");
                        if (scanner.hasNextInt()) {
                            playsThreshold = scanner.nextInt();
                            validInput = true; 
                        } else {
                            System.out.println("Invalid input. Please enter a valid integer.");
                            scanner.nextLine(); 
                        }
                    }
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

