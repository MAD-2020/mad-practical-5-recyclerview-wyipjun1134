package sg.edu.np.mad.mad_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
    private static final String TAG = "RecyclerView";
    ArrayList<String> list = new ArrayList<>();
    Button addbtn;
    TextView taskTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list.add("Buy Milk");
        list.add("Send Postage");
        list.add("Buy Android development Book");
        addbtn = findViewById(R.id.addBtn);

        final RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final DemoAdapter mAdapter = new DemoAdapter(list,this);
        LinearLayoutManager mLayout = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayout);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        addbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                taskTxt = findViewById(R.id.taskTxt);
                list.add(taskTxt.getText().toString());
                mAdapter.notifyDataSetChanged();
                taskTxt.setText("");//clear text
                showNewEntry(recyclerView , list);
            }
        });
    }


    /**
     * Upon calling this method, the keyboard will retract
     * and the recyclerview will scroll to the last item
     *
     * @param rv RecyclerView for scrolling to
     * @param data ArrayList that was passed into RecyclerView
     */
    private void showNewEntry(RecyclerView rv, ArrayList data){
        //scroll to the last item of the recyclerview
        rv.scrollToPosition(data.size() - 1);

        //auto hide keyboard after entry
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(rv.getWindowToken(), 0);
    }


}
