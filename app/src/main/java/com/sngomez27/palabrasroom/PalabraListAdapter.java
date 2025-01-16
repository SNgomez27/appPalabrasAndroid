package com.sngomez27.palabrasroom;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;


public class PalabraListAdapter extends ListAdapter<Palabra, PalabraListAdapter.PalabraViewHolder> {


    Context context;






    private PalabraViewModel mPalabraViewModel;


    public  PalabraListAdapter(@NonNull DiffUtil.ItemCallback<Palabra> diffCallback, Context context){
        super(diffCallback);
        this.context = context;
    }
    @NonNull
    @Override
    public PalabraViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        return PalabraViewHolder.create(parent);
    }




    @Override
    public  void onBindViewHolder (@NonNull PalabraViewHolder holder, int position){
        Palabra current = getItem(position);
        holder.bind(current.getmPalabra());
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPalabraViewModel = new ViewModelProvider((ViewModelStoreOwner) context).get(PalabraViewModel.class);
                mPalabraViewModel.delte(current);
                notifyItemRemoved(holder.getAdapterPosition());
                Toast toast = Toast.makeText(context,"se borro",Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
    static class PalabraDiff extends DiffUtil.ItemCallback<Palabra> {
        @Override
        public boolean areItemsTheSame(@NonNull Palabra oldItem, @NonNull Palabra newItem) {
            return oldItem == newItem;
        }
        @Override
        public  boolean areContentsTheSame(@NonNull Palabra olditem, @NonNull Palabra newItem){
            return  olditem.getmPalabra().equals(newItem.getmPalabra());
        }
    }


    public  static class PalabraViewHolder extends RecyclerView.ViewHolder {


        private final TextView palabraItemView;
        private final ImageButton delete;


        private PalabraViewHolder (@NonNull  View itemView){
            super(itemView);
            palabraItemView = itemView.findViewById(R.id.textView);
            delete = itemView.findViewById(R.id.basura);
        }
        public  void bind (String text){
            palabraItemView.setText(text);
        }
        static PalabraViewHolder create (ViewGroup parent){
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recyclerview_item, parent, false);
            return new PalabraViewHolder(view);
        }








    }










}





