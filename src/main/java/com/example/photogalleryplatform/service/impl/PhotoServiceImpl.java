package com.example.photogalleryplatform.service.impl;

import com.example.photogalleryplatform.model.Photo;
import com.example.photogalleryplatform.repository.PhotoRepository;
import com.example.photogalleryplatform.service.PhotoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PhotoServiceImpl implements PhotoService {

    private final PhotoRepository photoRepository;

    @Override
    public Optional<Photo> create(String PhotoTitle, String PhotoDescription, String PhotoTag) {
        return Optional.of(this.photoRepository.save(new Photo(PhotoTitle,PhotoDescription,PhotoTag)));

    }

    @Override
    public Optional<Photo> edit(Long photoId, String PhotoTitle, String PhotoDescription, String PhotoTag) {
        Photo photo =this.photoRepository.findById(photoId).orElseThrow(()->new RuntimeException("Photo not found"));
        photo.setPhotoTitle(PhotoTitle);
        photo.setPhotoDescription(PhotoDescription);
        photo.setPhotoTag(PhotoTag);

        return Optional.of(this.photoRepository.save(photo));
    }

    @Override
    public void deleteById(Long photoId) {
            this.photoRepository.deleteById(photoId);
    }

    @Override
    public List<Photo> listAllPhotos() {
        return this.photoRepository.findAll();
    }

    @Override
    public Optional<Photo> findById(Long photoId) {
        return this.photoRepository.findById(photoId);
    }

}
