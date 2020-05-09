package com.example.myapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterReminders extends RecyclerView.Adapter<AdapterReminders.MyViewHolder>{

    private List<Reminders> allReminders;
    private TextView message,time;
    int x = 0;
    public AdapterReminders(List<Reminders> allReminders) {
        this.allReminders = allReminders;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        final View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.reminder_item,viewGroup,false);
        final Button delete = view.findViewById(R.id.deleteButton);
        delete.setTag(x);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setVisibility(View.GONE);
                allReminders.remove(delete.getTag());
            }
        });
        x++;
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        Reminders reminders = allReminders.get(i);
        if(!reminders.getMessage().equals(""))
            message.setText(reminders.getMessage());
        else
            message.setHint("No Message");
        time.setText(reminders.getRemindDate().toString());

    }

    @Override
    public int getItemCount() {
        return allReminders.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            message = itemView.findViewById(R.id.textView1);
            time = itemView.findViewById(R.id.textView2);
        }
    }

}
