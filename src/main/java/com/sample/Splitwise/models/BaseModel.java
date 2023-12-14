package com.sample.Splitwise.models;
import jakarta.persistence.*;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    //@CreatedDate
    private Date createdAt;


    //@LastModifiedDate
    private Date lastModifiedAt;
}
