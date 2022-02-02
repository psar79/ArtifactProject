package ArtifactProject.dao.entity;

import javax.persistence.*;

@Entity
public class Information {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int size;
    private Type type;

    @OneToOne(mappedBy = "information")
    private Letter letter;

    public Information() {
    }

    public Long getId() {
        return id;
    }

    public Information setId(Long id) {
        this.id = id;
        return this;
    }

    public int getSize() {
        return size;
    }

    public Information setSize(int size) {
        this.size = size;
        return this;
    }

    public Type getType() {
        return type;
    }

    public Information setType(Type type) {
        this.type = type;
        return this;
    }
//    public Information setType(String type) {
//        this.type = type;
//        return this;
//    }

    public Letter getLetter() {
        return letter;
    }

    public Information setLetter(Letter letter) {
        this.letter = letter;
        return this;
    }
}
