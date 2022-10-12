package guru.qa.repo;

import guru.qa.domain.Car;
import guru.qa.domain.Ferrari;
import guru.qa.domain.Mercedes;

import java.util.Iterator;
import java.util.Map;

public class CarStore {

    private Map<String, Car> store = Map.of(
            "Ferrari", new Ferrari(),
            "Mercedes", new Mercedes()
    );

    public Car lookup(String carName) {
        for (String key : store.keySet()) {
            if (key.equalsIgnoreCase(carName)) {
                return store.get(key);
            }
        }
        throw new IllegalArgumentException("Car not found for given name: " + carName);
    }

    public Object[] carFromStore() {
        String[] catalog = new String[store.size()];
        Iterator it = store.entrySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            catalog[i] = pair.getKey().toString();
            i++;
        }
        return catalog;
    }

    public void carList() {
        Object[] catalog = carFromStore();
        for (var i = 0; i < catalog.length; i++) {
            System.out.println(" - " + catalog[i]);
        }

    }
}
