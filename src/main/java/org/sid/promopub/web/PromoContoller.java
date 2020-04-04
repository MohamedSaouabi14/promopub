package org.sid.promopub.web;

import lombok.Data;
import org.sid.promopub.dao.PromotionRepository;
import org.sid.promopub.dao.PubliciteRepository;
import org.sid.promopub.entities.Promotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
public class PromoContoller {
    @Autowired
    private PromotionRepository promotionRepository;

    @GetMapping(path = "/photoPromo/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getPhoto(@PathVariable("id") Long id) throws Exception {
        Promotion pr = promotionRepository.findById(id).get();
        return Files.readAllBytes(Paths.get(System.getProperty("user.home") + "/promotions/" + pr.getPhotoname()));
    }

    @PostMapping(path = "/uploadPhoto/{id}")
    public void uploadPhoto(MultipartFile file, @PathVariable Long id) throws Exception {
        Promotion pr = promotionRepository.findById(id).get();
        pr.setPhotoname(id + ".jpg");
        Files.write(Paths.get(System.getProperty("user.home") + "/promotions/" + pr.getPhotoname()), file.getBytes());
        promotionRepository.save(pr);
    }
}


