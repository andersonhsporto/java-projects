package dev.anderson.userapi.users.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "planets")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "username", unique = true, nullable = false)
  private String username;

  @Column(name = "password", nullable = false)
  private String password;

  @Column(name = "date_of_birth", nullable = false)
  private LocalDate dateOfBirth;

  @CreatedDate
  @Column(name = "created_at")
  private LocalDateTime createdAt;

  @LastModifiedDate
  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

  public void hashPassword(String hash) {
    this.password = hash;
  }

  @Override
  public String toString() {
    return "UserEntity [id = " + id + ", name=" + name + ", username=" + username + ", password="
        + password + ", dateOfBirth=" + dateOfBirth + ", createdAt=" + createdAt + ", updatedAt="
        + updatedAt + "]";
  }

  @Override
  public int hashCode() {
    return Objects.hash(createdAt, dateOfBirth, id, name, password, updatedAt, username);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    UserEntity other = (UserEntity) obj;
    return Objects.equals(createdAt, other.createdAt)
        && Objects.equals(dateOfBirth, other.dateOfBirth) && Objects.equals(id, other.id)
        && Objects.equals(name, other.name) && Objects.equals(password, other.password)
        && Objects.equals(updatedAt, other.updatedAt) && Objects.equals(username, other.username);
  }

}
