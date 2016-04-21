package net.ayesay.konyan.bigpocket;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import net.ayesay.konyan.bigpocket.realm_model.Transaction;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.realm.Realm;

public class AddActivity extends AppCompatActivity {

    @Bind(R.id.et_description)
    EditText etDescription;
    @Bind(R.id.et_category)
    EditText etCategory;
    @Bind(R.id.et_amount)
    EditText etAmount;

    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        ButterKnife.bind(this);

        realm = Realm.getDefaultInstance();
    }

    public void actionAddTransaction(View v) {
        String desc = etDescription.getText().toString();
        String category = etCategory.getText().toString();
        String amount = etAmount.getText().toString();
        float amount_f= Float.parseFloat(amount);

        //need to check input
        //assume as checked

        realm.beginTransaction();
        Transaction transaction = realm.createObject(Transaction.class);
        transaction.setId(transaction.genPrimaryKey());
        transaction.setDescription(desc);
        transaction.setCategory(category);
        transaction.setAmount(amount_f);
        transaction.setDate_time(System.currentTimeMillis());
        //expense should be 2
        transaction.setType(2);
        realm.copyToRealmOrUpdate(transaction);
        realm.commitTransaction();

    }

    @Override
    protected void onStop() {
        super.onStop();
        realm.close();
    }
}
