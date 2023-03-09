package user.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Table(name="teams")
public class TeamsEntity {

    @Id
    private Long id;

    private String team_name;

    private String description;

    @CreatedDate
    @Column(updatable = false)
    private Instant createDt;

    @LastModifiedDate
    private Instant updateDt;
}
