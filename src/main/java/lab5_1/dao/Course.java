package lab5_1.dao;

import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Course {

    private int id;
    private String title;
    private int length;
    private String description;

    // ==============================


    public Course() {
    }

    public Course(int id, String title, int length, String description) {
        this.id = id;
        this.title = title;
        this.length = length;
        this.description = description;
    }


    // ==============================

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequenceName = "courses_id_seq", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)  // from example for mySql
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "length")
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // ==============================

    @Override
    public String toString() {
        return String.format("%-3d %-50s %-4d",
                id, title, length);
    }
}
