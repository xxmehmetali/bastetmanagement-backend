package com.bastet.bastetmanagement.core.utilities.image.service;

import com.bastet.bastetmanagement.core.utilities.image.models.Image;
import com.bastet.bastetmanagement.core.utilities.image.models.ImageUploadResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {
    ResponseEntity<ImageUploadResponse> upload(MultipartFile file)
            throws IOException;
    Image getImageDetails(String name) throws IOException;
    ResponseEntity<byte[]> getImage(String name) throws IOException;
}
