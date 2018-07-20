package com.kestrel9.android.mystudy.baseUtil;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Mystudy
 * Class: BaseViewHolder
 * Created by kestr on 2018-07-20.
 * <p>
 * Description:
 */
public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    protected T item;

    protected BaseViewHolder(View itemView) {
        super(itemView);
    }

    protected final void viewBind(T item){
        this.item = item;
    }

}
