package hibernate.one_to_many_bi.entiti;

import javax.persistence.*;

@Entity // говорит о том, что данный класс будет иметь отображение в базе данных
@Table(name = "employees") // говорит о том, к какой именно таблице мы привязываем класс
public class Employee {

    @Id // говорит о том, что в таблице, столбец связанный с данным полем является Primary Key
    // GenerationType.IDENTITY - пологается на автоматическое увеличение столбца по правилам, прописанным в БД
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id") // говорит о том, к какому именно столбцу из таблицы мы привязываем поле класса
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;

    @Column(name="salary")
    private int salary;

    @ManyToOne(cascade =  {CascadeType.PERSIST, CascadeType.DETACH,
            CascadeType.REFRESH, CascadeType.MERGE}) // отношение к Department многие к одному, зависимость полная
    @JoinColumn(name = "department_id") // зависимость через столбец  department_id
    private Department department;

    public Employee() {
    }

    public Employee(String name, String surname, int salary) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                '}';
    }
}
