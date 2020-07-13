package com.example.pixobackend.entity;
import javax.persistence.*;

@Entity
@Table(name = "files")
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long id;
    @Column
    private String fileName;
    @Column
    private String fileType;
    @Column
    private long userId;
    @Lob
    private byte[] data;

    public Media() {
        super();
    }

    public Media(String fileName, String fileType, byte[] data, long userId) {
        super();
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
        this.userId = userId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}