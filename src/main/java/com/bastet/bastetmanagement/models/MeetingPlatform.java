package com.bastet.bastetmanagement.models;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="MeetingPlatforms")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MeetingPlatform {
    @Id
    @Column(name="id")
    private UUID uuid = UUID.randomUUID();

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "baseUrl")
    private String baseUrl;
}
