package com.example.demoday1.model;

public class User {
    private Long id;
    private String name;
    private String email;

    // Konstruktor tanpa argumen
    public User() {
    }

    // Konstruktor dengan semua argumen
    public User(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getter dan Setter untuk 'id'
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter dan Setter untuk 'name'
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter dan Setter untuk 'email'
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // (Opsional) Metode toString untuk representasi string dari objek
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    // (Opsional) Metode equals dan hashCode jika Anda membutuhkannya
    // Biasanya digunakan untuk perbandingan objek dan digunakan dalam koleksi seperti Set dan Map
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId().equals(user.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
