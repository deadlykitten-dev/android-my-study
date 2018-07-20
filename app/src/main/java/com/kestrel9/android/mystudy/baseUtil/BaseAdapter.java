package com.kestrel9.android.mystudy.baseUtil;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Mystudy
 * Class: BaseAdapter
 * Created by kestr on 2018-07-13.
 * <p>
 * Description:
 */
public abstract class BaseAdapter<T, VH extends BaseViewHolder> extends RecyclerView.Adapter<VH> {
    protected List<T> items = new ArrayList<>();
    private Context context;

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        VH vh = createHolder(context, parent, viewType);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        if (items != null){
            holder.viewBind(items);
        }
        onBindHolder(holder, position);
    }

    public abstract VH createHolder(Context context, ViewGroup viewGroup, int viewType);

    public abstract void onBindHolder(VH holder, int position);


    public BaseAdapter(Context context) {
        super();
        this.context = context;
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    public T getItem(int index){
        return ((items != null && index < items.size()) ? items.get(index) : null);
    }

    public Context getContext(){
        return context;
    }

    public void setList(List<T> list){
        items = list;
        notifyDataSetChanged();
    }

    public List<T> getItems() {
        return items;
    }

    public void addAll(List<T> list){
        items.addAll(list);
        notifyDataSetChanged();
    }

    public void reset(){
        items.clear();
        notifyDataSetChanged();
    }
}
