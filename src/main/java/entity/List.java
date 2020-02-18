package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class List implements Serializable {

    private Integer id;
    private Integer idUser;
    private String name;
    private LocalDate createDate;
    private Boolean isDone;

    public List() {
    }

    public List(Integer idUser, String name, LocalDate createDate, Boolean isDone) {
        this.idUser = idUser;
        this.name = name;
        this.createDate = createDate;
        this.isDone = isDone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        List list = (List) o;
        return id.equals(list.id) &&
                idUser.equals(list.idUser) &&
                name.equals(list.name) &&
                createDate.equals(list.createDate) &&
                isDone.equals(list.isDone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idUser, createDate);
    }

    @Override
    public String toString() {
        return "List{" +
                "id=" + id +
                ", idUser=" + idUser +
                ", name='" + name + '\'' +
                ", createDate=" + createDate +
                ", isDone=" + isDone +
                '}';
    }

}
