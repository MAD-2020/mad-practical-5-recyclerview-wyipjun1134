
package sg.edu.np.mad.mad_recyclerview;

import android.app.AlertDialog;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class DemoViewHolder extends RecyclerView.ViewHolder  {

    TextView txt;
    LinearLayout lo;


    public DemoViewHolder(@NonNull View itemView){
        super(itemView);
        txt = itemView.findViewById(R.id.text1);
        lo = itemView.findViewById(R.id.Linlayout);



        //to put stuff in your view
    }

}
