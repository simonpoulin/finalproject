package fpt.java.finalproject.services;

import java.io.File;
import java.util.Map;
import java.util.UUID;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StorageServiceImpl implements StorageService {
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public String upload(File img) throws Exception {
        try {
            Map<String, String> result = cloudinary.uploader().upload(img, ObjectUtils.asMap("public_id", UUID.randomUUID()));
            System.out.println(result.toString());
            return result.get("secure_url");
        } catch (Exception e) {
           throw new RuntimeException("Error");
        }
    }

    @Override
    public void delete(String name) throws Exception {
        try {
            cloudinary.uploader().destroy(name, ObjectUtils.emptyMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
