package pl.oskarpolak.springdemostart.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegisterForm {
    private String login;
    private String password;
    private String passwordRepeat;
    private String email;
}
