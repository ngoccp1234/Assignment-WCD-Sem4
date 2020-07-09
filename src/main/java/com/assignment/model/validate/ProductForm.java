package com.assignment.model.validate;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.HashMap;

public class ProductForm {
    private String name;
    private String image;
    private String price;
    private String quantity;
    private String description;
    private double aDoubleprice;
    private int anIntQuantity;


    public ProductForm(String name, String image, String price, String quantity, String description) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    public ProductForm() {
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
        if (price == null || price.isEmpty()) {
            ArrayList<String> priceErr = new ArrayList<String>();
            if (errors.containsKey("price")) {
                priceErr = errors.get("price");
            }
            priceErr.add("Price is required!");
            errors.put("price", priceErr);
        }
//        try {
//            aDoubleprice = Double.parseDouble(price);
//        } catch (NumberFormatException ex) {
//            ArrayList<String> priceErr = new ArrayList<String>();
//            if (errors.containsKey("price")) {
//                priceErr = errors.get("price");
//            }
//            priceErr.add("Price must be a number!");
//            errors.put("price", priceErr);
//        }
        if (quantity==null||quantity.isEmpty()){
            ArrayList<String>quantityErr=new ArrayList<String>();
            if (errors.containsKey("quantity")){
                quantityErr=errors.get("quantity");
            }
            quantityErr.add("Quantity is required !");
            errors.put("quantity", quantityErr);
        }
//        try {
//            anIntQuantity= Integer.parseInt(quantity);
//        }catch (NumberFormatException ex){
//            ArrayList<String>quantityErr=new ArrayList<String>();
//            if (errors.containsKey("description")){
//                quantityErr=errors.get("description");
//            }
//            quantityErr.add("Quantity must be a number!");
//            errors.put("description",quantityErr);
//        }

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
