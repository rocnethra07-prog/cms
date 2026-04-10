package simple_course.dto;

import simple_course.util.IdGenerator;

import java.util.Objects;

public class Category {
    private String id;
    private String name;

    public Category(String name){
        this.id = IdGenerator.generateCategoryId();
        //TODO -- What if name is null or ""?
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
        //TODO -- instanceof User?
        //TODO -- Why check name.equals. If two categories have same name but different id, are they same category? Is this correct?
        if(obj == null || (!(obj instanceof User))) return false;
        Category c = (Category)obj;
        //TODO -- What happens when name is null but id is not null? (NullPointerException) Is this correct?
        return this.name.equals(c.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
