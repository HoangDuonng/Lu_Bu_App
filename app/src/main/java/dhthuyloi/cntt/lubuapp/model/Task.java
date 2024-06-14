package dhthuyloi.cntt.lubuapp.model;

import androidx.core.text.util.LocalePreferences;

public class Task {
    private String id;
    private String title;
    private String description;
    private String time;
    private String day;

    public Task() {
    }

    public Task(String id, String title, String description, String time, String day) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.time = time;
        this.day = day;
    }

    public Task(String title, String time, String day) {
        this.title = title;
        this.time = time;
        this.day = day;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", time='" + time + '\'' +
                ", day='" + day + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
