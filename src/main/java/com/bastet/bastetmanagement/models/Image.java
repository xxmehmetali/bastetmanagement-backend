package com.bastet.bastetmanagement.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "image")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    @Id
    @Column(name="id")
    private UUID uuid = UUID.randomUUID();

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "image", unique = false, nullable = false, length = 100000)
    private byte[] image;
}