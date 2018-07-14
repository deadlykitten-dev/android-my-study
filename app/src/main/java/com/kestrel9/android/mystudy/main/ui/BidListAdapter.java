package com.kestrel9.android.mystudy.main.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kestrel9.android.mystudy.BaseAdapter;
import com.kestrel9.android.mystudy.R;
import com.kestrel9.android.mystudy.network.response.OrderbookResponse;

/**
 * Mystudy
 * Class: BidListAdapter
 * Created by kestr on 2018-07-13.
 * <p>
 * Description:
 */
public class BidListAdapter extends BaseAdapter<OrderbookResponse.Bid> {

    public BidListAdapter(Context context) {
        super(context);
    }

    @Override
    protected View createView(Context context, ViewGroup viewGroup, int viewType) {
        return LayoutInflater.from(context).inflate(R.layout.row_bid, viewGroup, false);
    }

    @Override
    protected void bindView(OrderbookResponse.Bid item, BaseAdapter.ViewHolder viewHolder) {
        if (item != null){
            TextView tv_price = (TextView) viewHolder.getView(R.id.tv_price);
            TextView tv_qty = (TextView) viewHolder.getView(R.id.tv_qty);

            tv_price.setText(item.price);
            tv_qty.setText(item.qty);
        }

    }
}
