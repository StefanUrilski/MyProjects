package JavaOOP.Inheritance.OnlineRadioDatabase;

import JavaOOP.Inheritance.OnlineRadioDatabase.exceptions.*;

public class Song {
    private String artistName;
    private String songName;
    private String length;

    public Song(String artistName, String songName, String length) throws InvalidSongException {
        this.setArtistName(artistName);
        this.setSongName(songName);
        this.setLength(length);
    }

    private void setArtistName(String artistName) throws InvalidArtistNameException {
        if (artistName.length() < 3 || artistName.length() > 20) {
            throw new InvalidArtistNameException("Artist name should be between 3 and 20 symbols.");
        }

        this.artistName = artistName;
    }

    private void setSongName(String songName) throws InvalidSongNameException {
        if (songName.length() < 3 || songName.length() > 30) {
            throw new InvalidSongNameException("Song name should be between 3 and 30 symbols.");
        }

        this.songName = songName;
    }

    private void setLength(String length) throws InvalidSongLengthException {
        String[] tokens = length.split(":");
        if (Integer.parseInt(tokens[0]) < 0 || Integer.parseInt(tokens[0]) > 14) {
            throw new InvalidSongMinutesException("Song minutes should be between 0 and 14.");
        }

        if (Integer.parseInt(tokens[1]) < 0 || Integer.parseInt(tokens[1]) > 59) {
            throw new InvalidSongSecondsException("Song seconds should be between 0 and 59.");
        }

        this.length = length;
    }

    public String getLength() {
        return this.length;
    }
}
