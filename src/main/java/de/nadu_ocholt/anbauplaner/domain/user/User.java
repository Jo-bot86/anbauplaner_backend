package de.nadu_ocholt.anbauplaner.domain.user;

import de.nadu_ocholt.anbauplaner.domain.calendar.Calendar;
import de.nadu_ocholt.anbauplaner.shared.persistence.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = {"email_address", "username"}))
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String username;

    @NotNull
    @Column(nullable = false)
    private String passwordHash;

    @NotNull
    @Column(nullable = false)
    private String emailAddress;

    @NotNull
    @Column(nullable = false)
    private Role role = Role.MEMBER; // z.B. ADMIN, MEMBER, VIEWER

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Calendar> calendars;

}
