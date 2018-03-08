package pl.oskarpolak.springdemostart.models;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.annotation.sql.DataSourceDefinitions;

@Data
@NoArgsConstructor
public class LoginForm {
    @NotEmpty
    private String login;
    @NotEmpty
    private String password;
}

