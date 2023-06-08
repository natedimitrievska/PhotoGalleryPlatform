package com.example.photogalleryplatform.model;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long photoId;

    private String PhotoTitle;

    private String PhotoDescription;

    private String PhotoTag;

    public Photo(){};

    public Photo(String photoTitle, String photoDescription, String photoTag) {
        PhotoTitle = photoTitle;
        PhotoDescription = photoDescription;
        PhotoTag = photoTag;
    }
}
