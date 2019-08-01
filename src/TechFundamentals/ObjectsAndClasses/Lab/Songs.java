package TechFundamentals.ObjectsAndClasses.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Songs {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(reader.readLine());
        List<Song> record = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split("_");
            Song newSong = new Song();
            newSong.setTypeList(tokens[0]);
            newSong.setName(tokens[1]);
            newSong.setTime(tokens[2]);
            record.add(newSong);
        }
        String cmd = reader.readLine();
        if (cmd.equals("all")) {
            for (Song song : record) {
                System.out.println(song.getName());
            }
        } else {
            for (Song song : record) {
                if (cmd.equals(song.getTypeList())) {
                    System.out.println(song.getName());
                }
            }
        }

    }
}


class Song {
    private String typeList;
    private String Name;
    private String Time;


    public String getTypeList() {
        return typeList;
    }

    public void setTypeList(String typeList) {
        this.typeList = typeList;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }
}

