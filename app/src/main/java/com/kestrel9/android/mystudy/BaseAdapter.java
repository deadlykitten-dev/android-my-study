package com.kestrel9.android.mystudy;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Mystudy
 * Class: BaseAdapter
 * Created by kestr on 2018-07-13.
 * <p>
 * Description:
 */
public abstract class BaseAdapter<T> extends RecyclerView.Adapter<BaseAdapter.ViewHolder> {
    private List<T> items;
    private Context context;


    public class ViewHolder extends RecyclerView.ViewHolder {
        private Map<Integer, View> views;

        public ViewHolder(View view) {
            super(view);
            views = new HashMap<>();
            views.put(0, view);
        }

        public void initViewList(int[] idList) {
            for (int id : idList)
                initViewById(id);
        }

        public void initViewById(int id) {
            View view = (getView() != null ? getView().findViewById(id) : null);

            if (view != null) {
                views.put(id, view);
            }
        }

        public View getView() {
            return getView(0);
        }

        public View getView(int id) {
            if (views.containsKey(id))
                return views.get(id);
            else
                initViewById(id);
            return views.get(id);
        }
    }

    protected abstract View createView(Context context, ViewGroup viewGroup, int viewType);

    protected abstract void bindView(T item, BaseAdapter.ViewHolder viewHolder);

    public BaseAdapter(Context context) {
        super();
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new ViewHolder(createView(context, viewGroup, viewType));
    }

    @Override
    public void onBindViewHolder(@NonNull BaseAdapter.ViewHolder holder, int position) {
        bindView(getItem(position), holder);

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
