package JavaOOP.Inheritance.OnlineRadioDatabase;

import JavaOOP.Inheritance.OnlineRadioDatabase.exceptions.InvalidSongException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(reader.readLine());

        SongDatabase songDatabase = new SongDatabase();
        while (n-- > 0) {
            try {
                String[] tokens = reader.readLine().split(";");

                Song song = new Song(tokens[0], tokens[1], tokens[2]);
                songDatabase.addSong(song);

                System.out.println("Song added.");
            } catch (InvalidSongException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Songs added: " + songDatabase.getSongCount());
        System.out.println("Playlist length: " + songDatabase.getTotalLengthOfSongs());
    }
}
