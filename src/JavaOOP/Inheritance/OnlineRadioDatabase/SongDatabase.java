package JavaOOP.Inheritance.OnlineRadioDatabase;

import java.util.ArrayList;
import java.util.List;

public class SongDatabase {
    private List<Song> songs;

    public SongDatabase() {
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        this.songs.add(song);
    }

    public String getTotalLengthOfSongs() {
        int hours = 0;
        int minutes = 0;
        int seconds = 0;
        for (Song song : this.songs) {
            String[] tokens = song.getLength().split(":");
            minutes += Integer.parseInt(tokens[0]);
            seconds += Integer.parseInt(tokens[1]);
        }

        minutes += seconds / 60;
        seconds %= 60;
        hours += minutes / 60;
        minutes %= 60;

        return String.format("%dh %dm %ds", hours, minutes, seconds);
    }

    public int getSongCount() {
        return this.songs.size();
    }
}
