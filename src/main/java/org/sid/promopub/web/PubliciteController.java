package org.sid.promopub.web;

import org.sid.promopub.dao.PubliciteRepository;
import org.sid.promopub.entities.Promotion;
import org.sid.promopub.entities.Publicite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Paths;

public class PubliciteController {
    @Autowired
    private PubliciteRepository publiciteRepository;

    @GetMapping(path = "/photoPub/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getPhoto(@PathVariable("id") Long id) throws Exception {
        Publicite pub = publiciteRepository.findById(id).get();
        return Files.readAllBytes(Paths.get(System.getProperty("user.home") + "/publicites/" + pub.getPhotoname()));
    }

    @PostMapping(path = "/uploadPhoto/{id}")
    public void uploadPhoto(MultipartFile file, @PathVariable Long id) throws Exception {
        Publicite pub = publiciteRepository.findById(id).get();
        pub.setPhotoname(id + ".jpg");
        Files.write(Paths.get(System.getProperty("user.home") + "/publicites/" + pub.getPhotoname()), file.getBytes());
        publiciteRepository.save(pub);
    }
}
