package net.ayesay.konyan.bigpocket.realm_model;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by zeta on 4/22/16.
 */
public class Transaction extends RealmObject {
    //id, Description, Amount, Date+Time, Category, Type

    @PrimaryKey
    long id;
    String description;
    float amount;
    long date_time;



    String category;
    int type;

    public Transaction() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getDate_time() {
        return date_time;
    }

    public void setDate_time(long date_time) {
        this.date_time = date_time;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


    public long genPrimaryKey(){
        long primaryKey = Realm.getDefaultInstance().where(Transaction.class).count();
        return primaryKey == 0 ? primaryKey : primaryKey+1;
    }
}
