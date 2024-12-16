package jva.cloud.adapters.output.persistence.entity;

import static jva.cloud.utils.ConfigConstant.DEFAULT_PASSWORD;

import java.sql.Timestamp;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class UserEntity {
  @Id private Long id;
  private String name;
  private String email;
  @Builder.Default private String password = DEFAULT_PASSWORD;

  @Column(value = "creation_date")
  private Timestamp creationDate;

  @Column(value = "update_date")
  private Timestamp updateDate;

  @Column(value = "is_active")
  private Boolean isActive;
}
