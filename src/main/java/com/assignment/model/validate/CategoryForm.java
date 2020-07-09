package com.assignment.model.validate;

import java.util.ArrayList;
import java.util.HashMap;

public class CategoryForm {
    private String name;
    private String image;
    private String description;

    public CategoryForm(String name, String image, String description) {
        this.name = name;
        this.image = image;
        this.description = description;
    }

    public CategoryForm() {
    }

    public HashMap<String, ArrayList<String>> getErrors() {
        HashMap<String, ArrayList<String>> errors = new HashMap<String, ArrayList<String>>();
        if (name == null || name.isEmpty()) {
            ArrayList<String> nameErrors = new ArrayList<String>();
            if (errors.containsKey("name")) {
                nameErrors = errors.get("name");
            }
            nameErrors.add("Name is required!");
            errors.put("name", nameErrors);
        } else if (name.length() < 5 || name.length() > 20) {
            ArrayList<String> nameErrors = new ArrayList<String>();
            if (errors.containsKey("name")) {
                nameErrors = errors.get("name");
            }
            nameErrors.add("Name must be 5 to 20 character!");
            errors.put("name", nameErrors);
        }
        if (image == null || image.isEmpty()) {
            ArrayList<String> imageErr = new ArrayList<String>();
            if (errors.containsKey("image")) {
                imageErr = errors.get("image");
            }
            imageErr.add("Image is required!");
            errors.put("image", imageErr);
        }
        if (description == null || description.isEmpty()) {
            ArrayList<String> descriptionErr = new ArrayList<String>();
            if (errors.containsKey("description")) {
                descriptionErr = errors.get("description");
            }
            descriptionErr.add("Description is required!");
            errors.put("description", descriptionErr);
        } else if (description.length() < 5 || description.length() > 500) {
            ArrayList<String> descriptionErr = new ArrayList<String>();
            if (errors.containsKey("description")) {
                descriptionErr = errors.get("description");
            }
            descriptionErr.add("Description must be 5 to 500 character!");
            errors.put("description", descriptionErr);
        }

        return errors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
