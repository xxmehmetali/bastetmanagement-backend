package com.bastet.bastetmanagement.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Projects")
//@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Project {
    @Id
    @Column(name="id")
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id = UUID.randomUUID();

    @Column(name = "occupation")
    private String occupation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "corporation")
    private Corporation corporation;

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    private List<Context> contexts;

    @Override
    public String toString() {
        return "Project{" +
                "uuid=" + id +
                ", occupation='" + occupation + '\'' +
                ", corporation=" + corporation +
                '}';
    }
//NOT FINISHED
}
