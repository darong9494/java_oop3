package http.jason;

import lombok.Data;

@Data
public class Album {
    int userId;
    int id;
    String title;

    public Album(int userId, int id, String title) {
        this.userId = userId;
        this.id = id;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Album{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}

