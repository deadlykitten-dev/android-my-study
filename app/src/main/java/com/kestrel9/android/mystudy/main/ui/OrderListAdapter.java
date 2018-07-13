package com.kestrel9.android.mystudy.main.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kestrel9.android.mystudy.BaseAdapter;
import com.kestrel9.android.mystudy.R;
import com.kestrel9.android.mystudy.network.response.TradesResponse;

/**
 * Mystudy
 * Class: OrderListAdapter
 * Created by kestr on 2018-07-13.
 * <p>
 * Description:
 */
public class OrderListAdapter extends BaseAdapter<TradesResponse.CompleteOrder> {

    public OrderListAdapter(Context context) {
        super(context);
    }

    @Override
    protected View createView(Context context, ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.row_order, viewGroup, false);
        return view;
    }

    @Override
    protected void bindView(TradesResponse.CompleteOrder item, BaseAdapter.ViewHolder viewHolder) {
        TextView tv_price = (TextView) viewHolder.getView(R.id.tv_price);
        TextView tv_qty = (TextView) viewHolder.getView(R.id.tv_qty);

        tv_price.setText(item.price);
        tv_qty.setText(item.qty);
    }
}
