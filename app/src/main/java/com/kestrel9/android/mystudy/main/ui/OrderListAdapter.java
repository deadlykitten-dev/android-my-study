package com.kestrel9.android.mystudy.main.ui;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kestrel9.android.mystudy.baseUtil.BaseAdapter;
import com.kestrel9.android.mystudy.R;
import com.kestrel9.android.mystudy.baseUtil.BaseViewHolder;
import com.kestrel9.android.mystudy.databinding.RowOrderBinding;
import com.kestrel9.android.mystudy.network.response.TradesResponse;

/**
 * Mystudy
 * Class: OrderListAdapter
 * Created by kestr on 2018-07-13.
 * <p>
 * Description:
 */
public class OrderListAdapter extends BaseAdapter<TradesResponse.CompleteOrder, OrderListAdapter.ViewHolder> {

    public OrderListAdapter(Context context) {
        super(context);
    }

    @Override
    public ViewHolder createHolder(Context context, ViewGroup viewGroup, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_order, viewGroup, false));
    }

    @Override
    public void onBindHolder(ViewHolder holder, int position) {
        holder.binding.tvQty.setText(items.get(position).qty);
        holder.binding.tvPrice.setText(items.get(position).price);
    }

    class ViewHolder extends BaseViewHolder<TradesResponse.CompleteOrder>{
        RowOrderBinding binding;
        ViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
}
