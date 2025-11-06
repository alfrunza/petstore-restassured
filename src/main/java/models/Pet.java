package models;

import java.util.List;

public class Pet {
    private long id;
    private String name;
    private Category category;
    private String[] photoUrls;
    private List<Tag> tags;
    private Status status;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }

    public String[] getPhotoUrls() {
        return photoUrls;
    }
    public void setPhotoUrls(String[] photoUrls) {
        this.photoUrls = photoUrls;
    }

    public List<Tag> getTags() {
        return tags;
    }
    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }

}
