package com.bastet.bastetmanagement.core.utilities.image.service.impl;

import com.bastet.bastetmanagement.core.utilities.image.ImageUtility;
import com.bastet.bastetmanagement.core.utilities.image.dao.ImageRepository;
import com.bastet.bastetmanagement.core.utilities.image.models.Image;
import com.bastet.bastetmanagement.core.utilities.image.models.ImageUploadResponse;
import com.bastet.bastetmanagement.core.utilities.image.service.ImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Service
public class ImageServiceImpl implements ImageService {
    @Resource
    ImageRepository imageRepository;
//    //https://stackoverflow.com/questions/55993377/spring-storing-images-as-byte-arrays-in-database-and-retrieving-them
    @Override
    public ResponseEntity<ImageUploadResponse> upload(MultipartFile file) throws IOException {
        imageRepository.save(Image.builder()
                .id(UUID.randomUUID())
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .image(ImageUtility.compressImage(file.getBytes())).build());
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ImageUploadResponse("Image uploaded successfully: " +
                        file.getOriginalFilename()));
    }

    public Image getImageDetails(String name) throws IOException {
        final Optional<Image> dbImage = imageRepository.findByName(name);
        return Image.builder()
                .id(dbImage.get().getId())
                .name(dbImage.get().getName())
                .type(dbImage.get().getType())
                .image(ImageUtility.decompressImage(dbImage.get().getImage())).build();
    }

    public ResponseEntity<byte[]> getImage(String name) throws IOException {
        final Optional<Image> dbImage = imageRepository.findByName(name);
        return ResponseEntity
                .ok()
                .contentType(MediaType.valueOf(dbImage.get().getType()))
                .body(ImageUtility.decompressImage(dbImage.get().getImage()));
    }
}
