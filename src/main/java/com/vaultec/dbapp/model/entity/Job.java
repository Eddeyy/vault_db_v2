package com.vaultec.dbapp.model.entity;

import com.vaultec.dbapp.model.enums.JobType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "JOBS", schema = "VAULT")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "job_gen")
    @SequenceGenerator(name = "job_gen", sequenceName = "JOBS_ID_SEQ", allocationSize = 1)
    private Long job_id;

    private String job_title;

    public Job(JobType job_title) {
        setJob_id((long) job_title.ordinal());
        setJob_title(job_title.getJobTitle());
    }
}
