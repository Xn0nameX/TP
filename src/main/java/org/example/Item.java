package org.example;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
@NoArgsConstructor
@Entity
public class Item {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id", nullable = false)
    private int id;
    @Getter
    @Setter
    @Column(name = "value", nullable = false)
    private int value;
    @Getter
    @Version
    private long version;
    public Item(int V, int version){
        this.value =V;
        this.version = version;
    }
    @Override
    public String toString(){
        return String.format("%d", this.value);
    }
}
