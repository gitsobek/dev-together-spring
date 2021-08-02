package io.infi.devtogetherapi.controllers.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginUserRequest {
    @Email(message = "Invalid e-mail format.")
    @NotEmpty(message = "Field must be not empty.")
    private String email;

    @NotEmpty(message = "Field must be not empty.")
    @Size(min = 6, max = 24, message = "Password must contain 6-24 characters.")
    private String password;
}
