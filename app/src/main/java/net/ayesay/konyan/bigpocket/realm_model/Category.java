package net.ayesay.konyan.bigpocket.realm_model;

import io.realm.RealmObject;

/**
 * Created by zeta on 4/22/16.
 */
public class Category extends RealmObject{
    //id, name, type
    long id;
    String name;
    int type;





    public Category() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
