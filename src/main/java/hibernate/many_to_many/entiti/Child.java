package hibernate.many_to_many.entiti;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "children")
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String firstName;

    @Column(name = "age")
    private int age;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "child_section", // связь 2-х таблиц через таблицу child_section
            joinColumns = @JoinColumn(name = "child_id"), // ключь таблицы Child
            inverseJoinColumns = @JoinColumn(name = "section_id") // ключь таблицы Section
    )
    private List<Section> sections;

    public Child() {
    }

    public Child(String name, int age) {
        this.firstName = name;
        this.age = age;
    }

    public void addSectionToChild(Section section){
        if (sections == null){
            sections = new ArrayList<>();
        }
        sections.add(section);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    @Override
    public String toString() {
        return "Child{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", age=" + age +
                '}';
    }
}
