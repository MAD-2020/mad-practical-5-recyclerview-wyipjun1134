package sg.edu.np.mad.mad_recyclerview;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static androidx.recyclerview.widget.RecyclerView.*;

public class DemoAdapter extends RecyclerView.Adapter<DemoViewHolder> {
    ArrayList<String> data = new ArrayList<>();
    AlertDialog.Builder delete;
    TextView DeleteTxt;
    Context mContext;
    TextView deleteTxt;

    public DemoAdapter(ArrayList<String> input, Context context){
        data = input;
        mContext = context;
    }


    public DemoViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);
        Context context = null;




        return new DemoViewHolder(item);
    }

    public void onBindViewHolder(final DemoViewHolder holder, int position){
        String s = data.get(position);
        holder.txt.setText(s);
        holder.itemView.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            // handle your click here.
            delete = new AlertDialog.Builder(mContext);
            delete.setTitle("Delete");
            final View view = LayoutInflater.from(mContext).inflate(R.layout.delete,null);
            deleteTxt = view.findViewById(R.id.DeleteTxt);
            deleteTxt.setText(String.format("%s?", data.get(holder.getLayoutPosition())));
            delete.setCancelable(false);
            delete.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int id) {
                    data.remove(holder.getLayoutPosition());
                    notifyDataSetChanged();
                }
            });
            delete.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int id) {

                }
            });
            AlertDialog alert = delete.create();
            alert.setView(view);
            alert.show();
        } });


}
    public int getItemCount()
    {
        return data.size();
    }
    public interface OnNoteListener{
        void onNoteClick(int position);
    }

    //where you put everything else
}
