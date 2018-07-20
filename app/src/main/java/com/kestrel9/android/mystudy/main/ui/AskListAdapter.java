package com.kestrel9.android.mystudy.main.ui;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kestrel9.android.mystudy.baseUtil.BaseAdapter;
import com.kestrel9.android.mystudy.R;
import com.kestrel9.android.mystudy.baseUtil.BaseViewHolder;
import com.kestrel9.android.mystudy.databinding.RowAskBinding;
import com.kestrel9.android.mystudy.network.response.OrderbookResponse;

/**
 * Mystudy
 * Class: AskListAdapter
 * Created by kestr on 2018-07-13.
 * <p>
 * Description:
 */
public class AskListAdapter extends BaseAdapter<OrderbookResponse.Ask, AskListAdapter.ViewHolder> {

    public AskListAdapter(Context context) {
        super(context);
    }

    @Override
    public ViewHolder createHolder(Context context, ViewGroup viewGroup, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_ask, viewGroup, false));
    }

    @Override
    public void onBindHolder(ViewHolder holder, int position) {
        holder.binding.tvQty.setText(items.get(position).qty);
        holder.binding.tvPrice.setText(items.get(position).price);
    }

    class ViewHolder extends BaseViewHolder<OrderbookResponse.Ask>{
        RowAskBinding binding;
        ViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
}
