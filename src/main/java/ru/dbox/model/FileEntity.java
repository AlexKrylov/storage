package ru.dbox.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "FILE_DIRECTORY", schema = "DIRECTORY")
public class FileEntity implements Serializable, Comparable<FileEntity> {
    public FileEntity() {}

    public FileEntity(String file_name, String url) {
        this.file_name = file_name;
        this.url = url;
    }

    @Id
    @Column(name = "FILE_ID")
    private int file_id;

    @Column(name = "FILE_NAME")
    private String file_name;

    @Column(name = "URL")
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getFile_id() {
        return file_id;
    }

    public void setFile_id(int file_id) {
        this.file_id = file_id;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    @Override
    public int compareTo(FileEntity o) {
        return Long.compare(o.file_id, this.file_id);
    }
}
