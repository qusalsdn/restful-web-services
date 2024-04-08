package com.qusalsdn.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties({"field1", "field2"}) // 해당 어노테이션은 JSON 응답에 해당 요소를 포함시키지 않는다.
@JsonFilter("SomeBeanFilter") // 해당 어노테이션은 Bean에 필터링을 걸 수 있게 해준다.
public class SomeBean {
    private String field1;
    //    @JsonIgnore // 해당 어노테이션은 JSON 응답에 해당 요소를 포함시키지 않는다.
    private String field2;
    private String field3;

    public SomeBean(String field1, String field2, String field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }

    public String getField1() {
        return field1;
    }

    public String getField2() {
        return field2;
    }

    public String getField3() {
        return field3;
    }

    @Override
    public String toString() {
        return "SomeBean{" +
                "field1='" + field1 + '\'' +
                ", field2='" + field2 + '\'' +
                ", field3='" + field3 + '\'' +
                '}';
    }
}
