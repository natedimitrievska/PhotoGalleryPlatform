package com.example.photogalleryplatform.service;

import com.example.photogalleryplatform.model.Photo;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

public interface PhotoService {


    Optional<Photo> create(String PhotoTitle,String PhotoDescription,String PhotoTag);
    Optional<Photo> edit (Long photoId,String PhotoTitle,String PhotoDescription,String PhotoTag);

    void deleteById(Long photoId);
    List<Photo> listAllPhotos();

    Optional<Photo> findById(Long photoId);
}
