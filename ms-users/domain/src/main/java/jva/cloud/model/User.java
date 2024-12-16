package jva.cloud.model;

import java.sql.Timestamp;
import lombok.Builder;

@Builder(toBuilder = true)
public record User(
    Long id,
    String name,
    String email,
    Timestamp creationDate,
    Timestamp updateDate,
    Boolean isActive) {}
