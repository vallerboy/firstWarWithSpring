package pl.oskarpolak.springdemostart.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class RegisterForm {
    @Size(min = 3, max = 19)
    private String login;
    @Pattern(regexp = "[a-z]+")
    private String password;
    @Pattern(regexp = "[a-z]+")
    private String passwordRepeat;
    @Email
    private String email;
}
