package io.infi.devtogetherapi.dto.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.infi.devtogetherapi.dto.enums.Roles;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Collection;

@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString
@Builder
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
    private Long id;
    private String email;
    private String token;
    private String username;
    private String bio;
    private String image;
    private String joinedAt;
    @JsonIgnore
    private Roles role;
}
