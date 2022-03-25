package repositories;

import models.Clothing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Cart implements Repository<Clothing> {
    private List<Clothing> clothing;

    public Cart() {
        this.clothing = new ArrayList<>();
    }

    @Override
    public Collection<Clothing> getModels() {
        return Collections.unmodifiableCollection(clothing);
    }

    @Override
    public void add(Clothing model) {
        clothing.add(model);
    }


}
