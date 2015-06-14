package whereismymoney.floatec.de.whereismymoney;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;

import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.melnykov.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MainActivity extends Activity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private TransactionStore ts = new TransactionStore();
    private double lat=0;
    private double lng=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ts.getToken();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        final RecyclerView recList = (RecyclerView) findViewById(R.id.cardList);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);
        ts.addDemoData();
        ContactAdapter ca = new ContactAdapter(ts.store);
        recList.setAdapter(ca);


        startService(new Intent(getBaseContext(), CheckLocation.class));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newEntry();
            }
        });
        registerReceiver(new BroadcastReceiver() {
                             @Override
                             public void onReceive(Context context, Intent intent) {
                                 lat=intent.getDoubleExtra("Latitude", 0);
                                 lng=intent.getDoubleExtra("Longitude", 0);
                                 Log.i("loc",lat+" "+lng);
                             }
                         },
                new IntentFilter(CheckLocation.BROADCAST_ACTION));
    }
    private void newEntry(){
        newEntry(false);
    }

    private void newEntry(boolean auto){
        final boolean automode=auto;
        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        alert.setTitle("How much have you spend?");
        alert.setMessage("");

// Set an EditText view to get user input
         final EditText input = new EditText(getApplicationContext());
        LinearLayout ll=new LinearLayout(getApplicationContext());
        ll.setOrientation(LinearLayout.VERTICAL);
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
         ll.addView(input);
        final EditText input2 = new EditText(getApplicationContext());
        if(!automode){
            TextView tw=new TextView(getApplicationContext());
            tw.setTextColor(Color.BLACK);
            tw.setText("Where are you right now?");
            ll.addView(tw);
            ll.addView(input2);
        }
        alert.setView(ll);
        AlertDialog.Builder ok = alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                Transaction t=new Transaction(Float.parseFloat(String.valueOf(input.getText())),lat,lng);
                ts.store.add(t);
                if(!automode){
                    t.setName(input2.getText().toString());
                }
                Collections.sort(ts.store);
                Collections.reverse(ts.store);

            }
        });

        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // Canceled.
            }
        });

        alert.show();
    }

    private List<ContactInfo> createList(int size) {

        List<ContactInfo> result = new ArrayList<>();
        for (int i=1; i <= size; i++) {
            ContactInfo ci = new ContactInfo();
            ci.name = ContactInfo.NAME_PREFIX + i;
            ci.surname = ContactInfo.SURNAME_PREFIX + i;
            ci.email = ContactInfo.EMAIL_PREFIX + i + "@test.com";

            result.add(ci);

        }

        return result;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
