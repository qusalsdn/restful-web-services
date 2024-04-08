package com.qusalsdn.rest.webservices.restfulwebservices.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Post {
    @Id
    @GeneratedValue
    private Integer id;

    private String description;

    // 해당 어노테이션은 다대일을 의미한다. 기본 fetch 타입은 EAGER이지만 현재는 게시물을 가져올 때 게시물에 연결된 사용자 세부 정도도 가져오려는건 아니기 때문에 LAZY로 설정한다.
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    public Post(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
