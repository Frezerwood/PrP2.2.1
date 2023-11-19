package hiber.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public Car() {

    }

    @Id
   @Column(name = "user_id")
    private long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private int series;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", series=" + series +
                '}';
    }
}
