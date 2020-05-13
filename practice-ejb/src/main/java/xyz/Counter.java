package xyz;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.io.Serializable;
import java.util.Objects;

@SessionScoped
public class Counter implements Serializable {

    private int counter;

    @PostConstruct
    public void initialize() {
        counter = 0;
    }

    public int inc() {
        return ++counter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Counter counter1 = (Counter) o;
        return counter == counter1.counter;
    }

    @Override
    public int hashCode() {
        return Objects.hash(counter);
    }

    @Override
    public String toString() {
        return "Counter{" +
                "counter=" + counter +
                '}';
    }
}
