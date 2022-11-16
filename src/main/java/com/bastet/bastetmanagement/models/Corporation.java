package com.bastet.bastetmanagement.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Corporations")
//@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","projects"})
public class Corporation {
    @Id
    @Column(name="id")
    @Getter private UUID uuid = UUID.randomUUID();

    @Getter @Setter private String name;
    @Getter @Setter private String description;
    @Getter @Setter private String taxNumber;
    @Getter @Setter private String foundationDate;

    @OneToMany(mappedBy = "corporation", fetch = FetchType.LAZY)
    @Getter @Setter private List<Project> projects;

    @Override
    public String toString() {
        return "Corporation{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", taxNumber='" + taxNumber + '\'' +
                ", foundationDate='" + foundationDate + '\'' +
                '}';
    }
}
