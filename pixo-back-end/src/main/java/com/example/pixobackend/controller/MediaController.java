package com.example.pixobackend.controller;

import com.example.pixobackend.entity.Media;
import com.example.pixobackend.service.MediaService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/upload")

@Api(value="Upload Controller",  description="Operations pertaining to Upload in pixogram")
public class MediaController {

    MediaService mediaService;

    @Autowired
    public MediaController(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    List<String> files = new ArrayList<String>();
    @ApiOperation(value = "Upload Pic By Id ")
    @PostMapping("/storeImages/{userId}")
    public Media storeFile(@ApiParam(value = "User Id from which user media store in database", required = true)
                               @RequestParam("file") MultipartFile file, @PathVariable long userId) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Media dbFile = new Media(fileName, file.getContentType(),compressBytes(file.getBytes()),userId);
        return mediaService.save(dbFile);
    }
    @ApiOperation(value = "get list of user media", response = List.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
    @GetMapping("/getUserMedia/{userId}")
    public List<Media> getUserMedia(@ApiParam(value = "user id from which user media will be retrieved", required = true)
                                        @PathVariable long userId ) throws IOException {
        ArrayList<Media> dbFile = new ArrayList<Media>();
        dbFile=mediaService.findByUserId(userId);
        ArrayList<Media> img = new ArrayList<Media>();
        for(Media u: dbFile )
        {
            Media pic= new Media(u.getFileName(),u.getFileType(),decompressBytes(u.getData()),userId);
            img.add(pic);
        }
        return img;

    }
    public static byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
        }

        return outputStream.toByteArray();

    }
    public static byte[] decompressBytes(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (DataFormatException e) {
            e.printStackTrace();
        }
        return outputStream.toByteArray();
    }
}

