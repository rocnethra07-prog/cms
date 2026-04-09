package simple_course.dto;

import simple_course.util.IdGenerator;

import java.util.Objects;

public class Category {
    private String id;
    private String name;

    public Category(String name){
        this.id = IdGenerator.generateCategoryId();
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==this) return true;
        if(obj == null || (!(obj instanceof User))) return false;
        Category c = (Category)obj;
        return this.name.equals(c.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
