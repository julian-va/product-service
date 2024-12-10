package jva.cloud.model;

import java.sql.Timestamp;

public record User(Long id, String name, String email, Timestamp creationDate, Timestamp updateDate, boolean esActive) {
}
