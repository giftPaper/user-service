package user.domain.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "users")
@Getter @Setter
public class UsersEntity implements Serializable {

    @Id
    private Long id;

    private String firstname;

    private String lastname;

    private String middlename;

    private Instant birthDt;

    @CreatedDate
    private Instant createDt;

    @LastModifiedDate
    private Instant updateDt;
}
