package hibernate.many_to_many.entiti;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "section")
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "child_section", // связь 2-х таблиц через таблицу child_section
            joinColumns = @JoinColumn(name = "section_id"), // ключь таблицы Section
            inverseJoinColumns = @JoinColumn(name = "child_id") // ключь таблицы Child
    )
    private List<Child> children;

    public void addChildToSection(Child child){
        if (children == null){
            children = new ArrayList<>();
        }
        children.add(child);
    }

    public Section() {
    }

    public Section(String name) {
        this.name = name;
    }

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


    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Section{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
