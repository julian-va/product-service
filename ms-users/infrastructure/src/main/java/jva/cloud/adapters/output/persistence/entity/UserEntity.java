package jva.cloud.adapters.output.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Timestamp;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class UserEntity {
    @Id
    private Long id;
    private String name;
    private String email;
    @Column(value = "creation_date")
    private Timestamp creationDate;
    @Column(value = "update_date")
    private java.sql.Timestamp updateDate;
    @Column(value = "is_active")
    private boolean isActive;
}
