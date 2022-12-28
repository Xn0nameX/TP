package org.example;

import org.hibernate.annotations.OptimisticLock;

import javax.persistence.*;

@Entity
@Table(name = "test")
public class Item2 {
    @Id
    @GeneratedValue
    @Column(name =  "id" )
    Long id;

    @Column(name = "val")
    int val;

    @Column (name =  "junkField" )
    @OptimisticLock(excluded =  true )
    int junkField;

    @Version
    long version;

    public Item2(){

    }
    public Item2(int val){
        this.val=val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public long getVersion() {
        return version;
    }

    @Override
    public String toString() {
        return "Item2{" +
                "id=" + id +
                ", val=" + val +
                ", junkField=" + junkField +
                ", version=" + version +
                '}';
    }

    public int getVal() {
        return val;
    }
}
