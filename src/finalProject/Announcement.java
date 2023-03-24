package finalProject;
public class Announcement implements Distributable{
    String reason;
    String text;

    public String getReason() {
        return this.reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }
}