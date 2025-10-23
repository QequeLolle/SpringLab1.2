package lab4_3.dao;

import jakarta.persistence.*;

@Entity
@Table(name = "teachers")
public class Teacher {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequenceName = "teachers_id_seq", allocationSize = 1)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "addr")
    private String addr;

    @Column(name = "phone")
    private String phone;

    // ==============================

    public Teacher() {
    }

    public Teacher(int id, String name, String addr, String phone) {
        this.id = id;
        this.name = name;
        this.addr = addr;
        this.phone = phone;
    }

    // ==============================

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // ==============================

    @Override
    public String toString() {
        return String.format("%-3d %-40s %-50s %-10s",
                id, name, addr, phone);
    }
}
