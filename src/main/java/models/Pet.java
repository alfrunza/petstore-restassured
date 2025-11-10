package models;

import java.util.List;

/**
 * Class representing a pet.
 */
public class Pet {
    private long id;
    private String name;
    private Category category;
    private String[] photoUrls;
    private List<Tag> tags;
    private Status status;

    // Default constructor
    public Pet() {
    }

    // Parameterized constructor
    public Pet(long id, String name, Category category, String[] photoUrls, List<Tag> tags, Status status) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

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
