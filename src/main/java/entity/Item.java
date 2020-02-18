package entity;

import java.io.Serializable;
import java.time.LocalDate;

public class Item implements Serializable {

    private Integer id;
    private Integer idList;
    private String text;
    private LocalDate createDate;
    private Boolean isDone;

    public Item() {
    }

    public Item(Integer id, Integer idList, String text, LocalDate createDate, Boolean isDone) {
        this.id = id;
        this.idList = idList;
        this.text = text;
        this.createDate = createDate;
        this.isDone = isDone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdList() {
        return idList;
    }

    public void setIdList(Integer idList) {
        this.idList = idList;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public Boolean getDone() {
        return isDone;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", idList=" + idList +
                ", text='" + text + '\'' +
                ", createDate=" + createDate +
                ", isDone=" + isDone +
                '}';
    }
}
