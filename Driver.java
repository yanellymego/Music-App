import java.util.Scanner;
import java.util.LinkedList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.io.*;

public class Driver {

  public static void main(String[] args){
    boolean continueMenu = true;
    LinkedList<Listener> listenerAccts = new LinkedList<Listener>();
    LinkedList<Playlist> existingPlaylists = new LinkedList<Playlist>();
    LinkedList<Songs> allSongs = new LinkedList<Songs>();
    LinkedList<Collection> existingCollections = new LinkedList<Collection>();

    Playlist pll = new Playlist("Dancing Alone in My Room");
    Playlist pll2 = new Playlist("Driving Downtown");
    Playlist pll3 = new Playlist("Tune Out the Pain :')");

    String[] genres = {"pop, hot, new"};
    Artist olivia = new Artist("Olivia Rodrigo");
    Songs sn1 = new Songs("Brutal", olivia, genres);
    Songs sn2 = new Songs("Traitor", olivia, genres);
    Songs sn3 = new Songs("Driver's License", olivia, genres);
    Songs sn4 = new Songs("1 Step Forward, 3 Steps Back", olivia, genres);
    Songs sn5 = new Songs("Deja Vu", olivia, genres);
    Songs sn6 = new Songs("Good 4 U", olivia, genres);
    Songs sn7 = new Songs("Enough for You", olivia, genres);
    Songs sn8 = new Songs("Happier", olivia, genres);
    Songs sn9 = new Songs("Jealousy, Jealousy", olivia, genres);
    Songs sn10 = new Songs("Favorite Crime", olivia, genres);
    Songs sn11 = new Songs("Hope Ur Ok", olivia, genres);

    LinkedList<Songs> track = new LinkedList<Songs>();
    track.add(sn1);
    track.add(sn2);
    track.add(sn3);
    track.add(sn4);
    track.add(sn5);
    track.add(sn6);
    track.add(sn7);
    track.add(sn8);
    track.add(sn9);
    track.add(sn10);
    track.add(sn11);
    Albums sour = new Albums("Sour", track);

    existingPlaylists.add(pll);
    existingPlaylists.add(pll2);
    existingPlaylists.add(pll3);

    existingCollections.addAll(existingPlaylists);
    existingCollections.add(sour);
    allSongs.addAll(sour.getSongs());

    while (continueMenu){
      Scanner scnr = new Scanner(System.in);

      System.out.println("\n-------------------------------------MENU---------------------------------------------");
      System.out.println("1. Create a listener account");
      System.out.println("2. List all Playlists and Albums available to shuffle");
      System.out.println("3. Add songs to an existing playlist");
      System.out.println("4. Export all songs on the platform out to a file in ascending order by times streamed");
      System.out.println("5. Exit");

      try {
        int userOpt = scnr.nextInt();

        switch (userOpt) {
            case 1:
              System.out.print("\nPlease insert your name: ");
              String temp = scnr.nextLine();
              String userName = scnr.nextLine();
              Listener user = new Listener(userName);
              listenerAccts.add(user);
              break;
            case 2:
              System.out.println("All available albums or playlists: ");
              for (int i = 0; i < existingCollections.size(); i++){
                System.out.println("\t" + (i + 1) + ". " + existingCollections.get(i).getName());
              }

              System.out.print("Enter the corresponding number of what you want to play: ");
              int contentNum = scnr.nextInt();

              if (existingCollections.get(contentNum - 1).size() > 0){
                existingCollections.get(contentNum - 1).shuffle();
              } else {
                System.out.println("No content available.");
              }
              break;
            case 3:
              System.out.println("\nExisting Playlists: ");
              for (int i = 0; i < existingPlaylists.size(); i++){
                System.out.println("\t" + (i + 1) + ". " + existingPlaylists.get(i).getName());
              }
              System.out.print("Enter playlist number: ");
              int playlistTitle = scnr.nextInt();

              System.out.print("Enter song title: ");
              temp = scnr.nextLine();
              String songTitle = scnr.nextLine();

              System.out.print("Enter the artist's name: ");
              String artistName = scnr.nextLine();
              Artist artist = new Artist(artistName);

              String[] genre = new String[3];
              System.out.print("Enter number of genres (up to 3): ");
              int genreNum = scnr.nextInt();
              System.out.print("Enter genres (separated by a space): ");
              for (int i = 0; i < genreNum; i++){
                genre[i] = scnr.next();
              }

              Songs song = new Songs(songTitle, artist, genre);
              Playlist currPlaylist = existingPlaylists.get(playlistTitle - 1);
              currPlaylist.add(song);
              allSongs.add(song);
              System.out.println(currPlaylist);
              break;
            case 4:
              String fileName = "allSongs.txt";
              try{
                LinkedList<Songs> ll = new LinkedList<Songs>();
                PrintWriter pw = new PrintWriter (new FileWriter(fileName));

                Collections.sort(allSongs);
                for (Songs sg: allSongs){
                  pw.println(sg);
                }
                pw.close();
              } catch (IOException e){
                System.out.println("Cannot find" + fileName);
              }
              break;
            case 5:
              continueMenu = false;
              break;
            default:
              System.out.println("The number you have selected is not on the list! Try again: ");
              break;
        }
      } catch (InputMismatchException e){
        System.out.println("The input you have entered is not an option on the list, try again: ");
      }
    }
  }
}
