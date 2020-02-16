package ru.kondrashkov.webspring.entity;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "notes")
public class Notes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "id")
    private Long id;
    @Column(columnDefinition = "header")
    @NotBlank
    @Size(min = 3, max = 100)
    private String header;
    @Column(columnDefinition = "note")
    @NotBlank
    private String note;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Notes{" +
                "id=" + id +
                ", header='" + header + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
