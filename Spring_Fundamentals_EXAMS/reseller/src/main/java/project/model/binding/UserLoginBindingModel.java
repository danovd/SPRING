package project.model.binding;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserLoginBindingModel {

    private String username;
    private String password;



    public UserLoginBindingModel() {
    }

    @NotBlank(message = "Username cannot be empty")
    @Size(min = 3, max = 20, message = "Username length is allowed to be 3-20 symbols")
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }



    @NotBlank(message = "Password cannot be empty")
    @Size(min = 3, max = 20, message = "Password length is allowed to be 3-20 symbols")
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
