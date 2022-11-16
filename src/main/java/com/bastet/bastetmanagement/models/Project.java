package com.bastet.bastetmanagement.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Projects")
//@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    @Id
    @Column(name="id")
    @Getter private UUID uuid = UUID.randomUUID();

    @Column(name = "occupation")
    @Getter @Setter private String occupation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "corporation")
    @Getter @Setter private Corporation corporation;

    @Override
    public String toString() {
        return "Project{" +
                "uuid=" + uuid +
                ", occupation='" + occupation + '\'' +
                ", corporation=" + corporation +
                '}';
    }
//NOT FINISHED
}
