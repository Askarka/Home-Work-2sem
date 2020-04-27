package HomeWork.prog._6DONE;

import javafx.util.Pair;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

//Реализовать интерфейс Map, основываясь на классе AbstractMap (хранить значения и ключи в двух массивах, или в парах)
// A map cannot contain duplicate keys; each key can map to at most one value.

public class Map<K, V> extends AbstractMap<K, V> {

    private Pair<K, V>[] array;

    public Pair<K, V>[] getArray() {
        return array;
    }

    public Map(Map<? extends K,? extends V>[] o) {
        for(Pair<K, V> pair : array){
            this.put(pair.getKey(), pair.getValue());
        }
    }

    @Override
    public String toString() {
        return "Map{" +
                "array=" + Arrays.toString(array) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Map<?, ?> map = (Map<?, ?>) o;
        return Arrays.equals(array, map.array);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }

    public Map(Pair<K, V>[] array) {
        this.array = array;
    }

    public Map() {
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        HomeWork.ADS._2DONE.Set<Pair<K, V>> result= new HomeWork.ADS._2DONE.Set<>(0);
        for(Pair<K, V> pair : array){
            result.add(pair);
        }
        return (Set<Entry<K, V>>) result;
    }

    @Override
    public V getOrDefault(Object key, V defaultValue) {
        if(this.entrySet().contains(key)){
           for(Pair<K, V> pair : array){
               if(pair.getKey().equals(key)){
                   return pair.getValue();
               }
           }

        }
        return defaultValue;
    }

    @Override
    public void forEach(BiConsumer<? super K, ? super V> action) {
        for (Map.Entry<K, V> entry : this.entrySet()) {
            action.accept(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
        for (Map.Entry<K, V> entry : this.entrySet())
            entry.setValue(function.apply(entry.getKey(), entry.getValue()));
    }

    @Override
    public V putIfAbsent(K key, V value) {
        V v = this.get(key);
        if (v == null)
            v = this.put(key, value);

        return v;
    }

    @Override
    public boolean remove(Object key, Object value) {
        if (this.containsKey(key) && Objects.equals(this.get(key), value)) {
            this.remove(key);
            return true;
        } else
            return false;
    }

    @Override
    public boolean replace(K key, V oldValue, V newValue) {
        if (this.containsKey(key) && Objects.equals(this.get(key), oldValue)) {
            this.put(key, newValue);
            return true;
        } else
            return false;
    }

    @Override
    public V replace(K key, V value) {
        if (this.containsKey(key)) {
            return this.put(key, value);
        } else
            return null;
    }

    @Override
    public V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
        if (this.get(key) == null) {
            V newValue = mappingFunction.apply(key);
            if (newValue != null)
                this.put(key, newValue);
        }
        return null;
    }

    @Override
    public V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        if (this.get(key) != null) {
            V oldValue = this.get(key);
            V newValue = remappingFunction.apply(key, oldValue);
            if (newValue != null)
                this.put(key, newValue);
            else
                this.remove(key);
        }
        return null;
    }

    @Override
    public V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        V oldValue = this.get(key);
        V newValue = remappingFunction.apply(key, oldValue);
        if (oldValue != null ) {
            if (newValue != null)
                this.put(key, newValue);
            else
                this.remove(key);
        } else {
            if (newValue != null)
                this.put(key, newValue);
            else
                return null;
        }
        return oldValue;
    }

    @Override
    public V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
        V oldValue = this.get(key);
        V newValue = (oldValue == null) ? value :
                remappingFunction.apply(oldValue, value);
        if (newValue == null)
            this.remove(key);
        else
            this.put(key, newValue);
        return oldValue;
    }

}
