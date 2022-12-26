package note;

public class Note {
    private int id;
    private String content;

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Note(int id, String content) {
        this.id = id;
        this.content = content;
    }
}
