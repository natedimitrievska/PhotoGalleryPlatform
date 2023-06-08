package com.example.photogalleryplatform.web;


import com.example.photogalleryplatform.model.Photo;
import com.example.photogalleryplatform.service.PhotoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8896")
@RequestMapping(path = "/api/photos")
@AllArgsConstructor
public class PhotoController {

    private final PhotoService photoService;


    @GetMapping("/allPhotos")
    public List<Photo> findAll() {
        return this.photoService.listAllPhotos();

    }
    @GetMapping("/{id}")
    public Optional<Photo> findById(@PathVariable Long photoId) {
        return this.photoService.findById(photoId);

    }

    @PostMapping("/add")
    public ResponseEntity<Photo> createPhoto(@RequestBody PhotoRequest request) {
        Optional<Photo> createdPhoto = photoService.create(request.getPhotoTitle(), request.getPhotoDescription(), request.getPhotoTag());
        if (createdPhoto.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdPhoto.get());
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Photo> updatePhoto(@PathVariable Long photoId, @RequestBody PhotoRequest request) {
        Optional<Photo> updatedPhoto = photoService.edit(photoId, request.getPhotoTitle(), request.getPhotoDescription(), request.getPhotoTag());
        if (updatedPhoto.isPresent()) {
            return ResponseEntity.ok(updatedPhoto.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePhoto(@PathVariable Long photoId) {
        photoService.deleteById(photoId);
        return ResponseEntity.noContent().build();
    }

    public class PhotoRequest {

        private String photoTitle;
        private String photoDescription;
        private String photoTag;

        // Getters and setters
        public String getPhotoTitle() {
            return photoTitle;
        }

        public void setPhotoTitle(String photoTitle) {
            this.photoTitle = photoTitle;
        }

        public String getPhotoDescription() {
            return photoDescription;
        }

        public void setPhotoDescription(String photoDescription) {
            this.photoDescription = photoDescription;
        }

        public String getPhotoTag() {
            return photoTag;
        }

        public void setPhotoTag(String photoTag) {
            this.photoTag = photoTag;
        }
    }

}
