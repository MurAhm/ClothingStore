package repositories;

import java.util.Collection;

public interface Repository<T> {

    Collection<T> getProducts();

    void add(T model);


}
