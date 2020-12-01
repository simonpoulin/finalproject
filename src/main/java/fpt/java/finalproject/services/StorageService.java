package fpt.java.finalproject.services;

import java.io.File;

public interface StorageService {
    String upload(File img) throws Exception;

    void delete(String name) throws Exception;
}
