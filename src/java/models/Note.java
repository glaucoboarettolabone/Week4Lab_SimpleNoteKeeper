package models;

import java.io.Serializable;

/**
 *
 * @author 815000
 */
public class Note implements Serializable {
    private String title;
    private String contents; 

    public Note() {
        title = "";
        contents = "";
    }

    public Note(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }
}
