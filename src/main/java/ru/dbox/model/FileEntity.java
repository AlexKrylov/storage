package ru.dbox.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.crypto.Data;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;

@Entity
@Table(name = "FILE_DIRECTORY", schema = "DIRECTORY")
public class FileEntity implements Serializable, Comparable<FileEntity> {
    @Id
    @Column(name = "FILE_ID")
    private int file_id;

    @Column(name = "FILE_NAME")
    private String file_name;

    @Column(name = "URL")
    private String url;

    @Column(name = "USER_ID")
    private int user_id;

    @Column(name = "TIMESTAMP")
    private Calendar calendar;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public FileEntity(String file_name, String url, int user_id, Calendar calendar) {
        this.file_id = file_id;
        this.file_name = file_name;
        this.url = url;
        this.user_id = user_id;
        this.calendar = calendar;
    }

    public FileEntity() {
    }

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
