package com.qusalsdn.rest.webservices.restfulwebservices.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "user_details")
public class User {
    protected User() {
    }

    @Id
    @GeneratedValue
    private Integer id;

    @Size(min = 2, message = "이름의 최소 2자리 이상이여야 합니다.")
//    @JsonProperty("user_name") // 해당 어노테이션은 JSON의 속성과 요소 이름을 커스터마이징한다.
    private String name;

    @Past(message = "과거의 날짜여야 합니다.") // 해당 어노테이션은 필드의 값이 현재 날짜보다 이전인지를 검증한다.
//    @JsonProperty("birth_date")
    private LocalDate birthDate;

    @OneToMany(mappedBy = "user") // 해당 어노테이션은 일대다를 의미한다. 다른 Bean에서 user 객체를 사용하면 user_id가 자동으로 생성된다.
    @JsonIgnore
    private List<Post> posts;

    public User(Integer id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
