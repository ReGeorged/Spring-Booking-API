package com.exam.giorgibazierashvili.entities;


import com.exam.giorgibazierashvili.constants.RecordState;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;


@Data
@MappedSuperclass
public class AppEntity {
    @Temporal(TemporalType.DATE)
    @Column(name = "CREATED_DATE", nullable = false, updatable = false)
    private Date createdDate;
    @Temporal(TemporalType.DATE)
    @Column(name = "LAST_MODIFIED_DATE", nullable = true, updatable = true)
    private Date lastModifiedDate;
    @Column(name = "RECORD_STATE")
    private RecordState recordState;

    @PrePersist
    protected void onCreate() {
        createdDate = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        lastModifiedDate = new Date();
    }
}
