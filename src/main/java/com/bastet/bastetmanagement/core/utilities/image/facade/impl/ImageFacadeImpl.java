package com.bastet.bastetmanagement.core.utilities.image.facade.impl;

import com.bastet.bastetmanagement.core.utilities.image.dao.ImageRepository;
import com.bastet.bastetmanagement.core.utilities.image.facade.ImageFacade;
import com.bastet.bastetmanagement.core.utilities.image.models.Image;
import com.bastet.bastetmanagement.core.utilities.image.models.ImageUploadResponse;
import com.bastet.bastetmanagement.core.utilities.image.service.ImageService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

@Component
public class ImageFacadeImpl implements ImageFacade {
    @Resource
    ImageRepository imageRepository;

    ImageService imageService;

    public ResponseEntity<ImageUploadResponse> upload(MultipartFile file)
            throws IOException {
        return imageService.upload(file);
    }

    public Image getImageDetails(String name) throws IOException {
        return imageService.getImageDetails(name);
    }

    public ResponseEntity<byte[]> getImage(String name) throws IOException {
        return imageService.getImage(name);
    }
}
