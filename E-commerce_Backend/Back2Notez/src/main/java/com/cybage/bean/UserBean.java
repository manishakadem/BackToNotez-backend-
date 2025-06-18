package com.cybage.bean;

import lombok.Data;
import jakarta.validation.constraints.*;

@Data
public class UserBean {
    private int userId;
    
    @NotBlank(message="Name is requried")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Name should contain characters")
    private String name;
    
    @NotBlank(message = "Email is required")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@gmail\\.com$", message = "Email must be a valid Gmail address")
    private String email;
    
    @NotBlank(message = "Password is required")
    @Pattern(
        regexp = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#$%^&+=!]).{8,}$",
        message = "Password must be at least 8 characters and include a number, letter, and special character"
    )
    private String password;
    
    @NotBlank(message = "Contact is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Contact must be a 10-digit number")  
    private String contact;
    

    public UserBean() {}

    public UserBean(int userId, String name, String email, String password, String contact) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.contact = contact;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "UserBean [userId=" + userId + ", name=" + name + ", email=" + email +
               ", password=" + password + ", contact=" + contact + "]";
    }

}