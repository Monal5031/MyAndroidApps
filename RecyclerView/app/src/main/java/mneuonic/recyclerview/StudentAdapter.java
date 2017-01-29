package mneuonic.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Monal on 1/29/2017.
 */

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder>{

    Context c;
    ArrayList<String> names= new ArrayList<String>();
    ArrayList<String> id= new ArrayList<String>();
    ArrayList<String> rating= new ArrayList<String>();

    public StudentAdapter(Context c, ArrayList<String> names, ArrayList<String> id,ArrayList<String> rating) {
        this.c = c;
        this.names = names;
        this.id = id;
        this.rating=rating;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student1,parent,false);

        ViewHolder vh= new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.tvName.setText(names.get(position));
        holder.tvID.setText(id.get(position));
        holder.tvRating.setText(rating.get(position));
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvID;
        TextView tvRating;

        public ViewHolder(View itemView) {
            super(itemView);

            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvID = (TextView) itemView.findViewById(R.id.tvID);
            tvRating = (TextView) itemView.findViewById(R.id.tvRating);

            tvName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Toast.makeText(c,rating.get(getAdapterPosition()),Toast.LENGTH_SHORT).show();
                }
            });

            tvID.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Toast.makeText(c,rating.get(getAdapterPosition()),Toast.LENGTH_SHORT).show();
                }

            });

            tvRating.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Toast.makeText(c,rating.get(getAdapterPosition()),Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
