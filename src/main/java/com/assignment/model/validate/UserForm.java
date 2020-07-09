package com.assignment.model.validate;

import java.util.ArrayList;
import java.util.HashMap;

public class UserForm {
    private String name;
    private String email;
    private String phone;
    private String username;
    private String password;
    private Double anPhone;

    public UserForm(String name, String email, String phone, String username, String password) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
    }

    public UserForm() {
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
        if (email==null||email.isEmpty()){
            ArrayList<String>emailErr=new ArrayList<String>();
            if (errors.containsKey("email")){
                emailErr=errors.get("email");
            }
            emailErr.add("Email is required!");
            errors.put("email", emailErr);
        }
        if (username == null || username.isEmpty()) {
            ArrayList<String> usernameErr = new ArrayList<String>();
            if (errors.containsKey("username")) {
                usernameErr = errors.get("username");
            }
            usernameErr.add("UserName is required!");
            errors.put("username", usernameErr);
        } else if (username.length() < 2 || username.length() > 20) {
            ArrayList<String> usernameErr = new ArrayList<String>();
            if (errors.containsKey("username")) {
                usernameErr = errors.get("username");
            }
            usernameErr.add("UserName must be 2 to 20 character!");
            errors.put("username", usernameErr);
        }
        if (password == null || password.isEmpty()) {
            ArrayList<String> passwordErr = new ArrayList<String>();
            if (errors.containsKey("password")) {
                passwordErr = errors.get("password");
            }
            passwordErr.add("Password is required!");
            errors.put("password", passwordErr);
        } else if (password.length() < 5 || password.length() > 20) {
            ArrayList<String> passwordErr = new ArrayList<String>();
            if (errors.containsKey("password")) {
                passwordErr = errors.get("password");
            }
            passwordErr.add("Password must be 5 to 20 character!");
            errors.put("password", passwordErr);
        }
        if (phone == null || phone.isEmpty()) {
            ArrayList<String> phoneErr = new ArrayList<String>();
            if (errors.containsKey("phone")) {
                phoneErr = errors.get("phone");
            }
            phoneErr.add("Phone is required!");
            errors.put("phone", phoneErr);
        } else if (phone.length() < 10 || phone.length() > 11) {
            ArrayList<String> phoneErr = new ArrayList<String>();
            if (errors.containsKey("phone")) {
                phoneErr = errors.get("phone");
            }
            phoneErr.add("Phone must be 10 to 11 character!");
            errors.put("phone", phoneErr);
        }
//        try {
//            anPhone != Double.parseDouble(phone);
//        } catch (NumberFormatException ex) {
//            ArrayList<String> priceErr = new ArrayList<String>();
//            if (errors.containsKey("phone")) {
//                priceErr = errors.get("phone");
//            }
//            priceErr.add("Phone must be a number!");
//            errors.put("phone", priceErr);
//        }
        return errors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
