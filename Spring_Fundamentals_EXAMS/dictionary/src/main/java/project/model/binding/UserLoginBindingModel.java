package project.model.binding;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserLoginBindingModel {

    private String username;
    private String password;


    public UserLoginBindingModel() {
    }

    @NotBlank(message = "Username field cannot be empty string")
    @Size(min = 3, max = 20, message = "Allowed size for username is 3 - 20 symbols")
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }


    @NotBlank(message = "Password field cannot be empty string")
    @Size(min = 3, max = 20, message = "Allowed size for password is 3 - 20 symbols")
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
