package simple_course.dto;

import simple_course.util.IdGenerator;

import java.util.List;

public class Lesson {
    private String id;
    private String title;
    private String content;

    private int index;
    private String videoURL ;
    private List<String> resources;

    public Lesson(String title, String content, int index){
        this.id = IdGenerator.generateLessonId();
        this.title = title;
        this.content = content;
        this.index = index;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }

    public List<String> getResources() {
        return resources;
    }

    public void setResources(List<String> resources) {
        this.resources = resources;
    }

    public String toString(){
        return "{ Lesson : " + this.id + " , Title : " + this.title  +" }";
    }
}
