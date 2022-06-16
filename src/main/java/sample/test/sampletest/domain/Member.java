package sample.test.sampletest.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Member {

    @Id //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

//    @Column(name = "USERNAME") USERNAME랑 맵핑
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
