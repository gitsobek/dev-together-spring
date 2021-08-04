package io.infi.devtogetherapi.models;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Builder(toBuilder = true)
@Entity
@Table(name = "users",
        indexes = @Index(
                name = "idx_user_email",
                columnList = "email",
                unique = true
        ))
public class User extends BaseEntity {
    @Id
    @SequenceGenerator(
            name = "user_seq",
            sequenceName = "user_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_seq"
    )
    private Long id;
    private String username;
    private String email;
    private String password;
    private String bio;
    private String image;

    @Singular
    @OneToMany(
            mappedBy = "followee",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<FollowRelation> followers;
}
