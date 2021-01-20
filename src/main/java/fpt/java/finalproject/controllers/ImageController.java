package fpt.java.finalproject.controllers;

// import java.net.URL;
// import java.net.URLConnection;
// import java.nio.file.Files;
// import java.nio.file.Path;
// import java.nio.file.Paths;

import org.springframework.core.io.ByteArrayResource;
// import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

// import fpt.java.finalproject.utils.ImageResolver;

@Controller
public class ImageController {

    @GetMapping("/getimage/{id}")
    @ResponseBody
    public ResponseEntity<ByteArrayResource> getImage(@PathVariable String id) {

        // try {
        //     URL url = new URL(new ImageResolver().solve(id, "fill", 200, 200));
        //     URLConnection connection = url.openConnection();
        //     connection.setRequestProperty("User-Agent", "xxxxxx");
        //     Path file = Paths.get();
        //     byte[] buffer = Files.readAllBytes(file);
        //     ByteArrayResource bar = new ByteArrayResource(buffer);
        //     return ResponseEntity.ok().contentLength(buffer.length).contentType(MediaType.parseMediaType("image/png"))
        //             .body(bar);
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }

        return ResponseEntity.badRequest().build();
    }
}
