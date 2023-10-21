package project.model.binding;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRegisterBindingModel {

    private String username;
    private String email;
    private String password;
    private String confirmPassword;


    public UserRegisterBindingModel() {
    }

    @NotBlank(message = "The field cannot be empty string")
    @Size(min = 3, max = 20, message = "Allowed size is 3 - 20 symbols")
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }


    @NotBlank(message = "The field cannot be empty string")
    @Email(message = "Enter valid email, please")
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }



    @NotBlank(message = "The field cannot be empty string")
    @Size(min = 3, max = 20, message = "Allowed size is 3 - 20 symbols")
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }



    @NotBlank(message = "The field cannot be empty string")
    @Size(min = 3, max = 20, message = "Allowed size is 3 - 20 symbols")
    public String getConfirmPassword() {
        return confirmPassword;
    }
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
