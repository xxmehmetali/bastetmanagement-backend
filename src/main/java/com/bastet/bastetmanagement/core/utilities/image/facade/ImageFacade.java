package com.bastet.bastetmanagement.core.utilities.image.facade;

import com.bastet.bastetmanagement.core.utilities.image.models.Image;
import com.bastet.bastetmanagement.core.utilities.image.models.ImageUploadResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageFacade {
    ResponseEntity<ImageUploadResponse> upload(MultipartFile file) throws IOException;
    Image getImageDetails(String name) throws IOException;
    public ResponseEntity<byte[]> getImage(String name) throws IOException;
}
