package com.kestrel9.android.mystudy.main;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.kestrel9.android.mystudy.R;
import com.kestrel9.android.mystudy.databinding.ActivityMainBinding;
import com.kestrel9.android.mystudy.main.ui.AskListAdapter;
import com.kestrel9.android.mystudy.main.ui.BidListAdapter;
import com.kestrel9.android.mystudy.main.ui.OrderListAdapter;
import com.kestrel9.android.mystudy.network.CoinoneApi;
import com.kestrel9.android.mystudy.network.response.OrderbookResponse;
import com.kestrel9.android.mystudy.network.response.TickerResponse;
import com.kestrel9.android.mystudy.network.response.TradesResponse;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private MainContract.Presenter presenter;

    private AskListAdapter askListAdapter;
    private BidListAdapter bidListAdapter;
    private OrderListAdapter orderListAdapter;

    private ActivityMainBinding mainBinding;


    private List<OrderbookResponse.Bid> bidList = new ArrayList<>();
    private List<OrderbookResponse.Ask> askList = new ArrayList<>();
    private List<TradesResponse.CompleteOrder> orderList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        askListAdapter = new AskListAdapter(this);
        askListAdapter.setList(askList);

        mainBinding.recyclerAsk.setAdapter(askListAdapter);

        bidListAdapter = new BidListAdapter(this);
        bidListAdapter.setList(bidList);

        mainBinding.recyclerBid.setAdapter(bidListAdapter);

        orderListAdapter = new OrderListAdapter(this);
        orderListAdapter.setList(orderList);

        mainBinding.recyclerOrder.setAdapter(orderListAdapter);

        presenter = new MainPresenter(CoinoneApi.CoinoneApiService.retrofit.create(CoinoneApi.CoinoneApiService.class), this);

        presenter.loadApiData();



    }

    @Override
    public void addBidList(List<OrderbookResponse.Bid> bid) {
        bidListAdapter.setList(bid);
        bidListAdapter.notifyDataSetChanged();
    }

    @Override
    public void addAskList(List<OrderbookResponse.Ask> ask) {
        askListAdapter.setList(ask);
        askListAdapter.notifyDataSetChanged();
    }

    @Override
    public void addOrderList(List<TradesResponse.CompleteOrder> order) {
        orderListAdapter.setList(order);
        orderListAdapter.notifyDataSetChanged();
    }

    @Override
    public void setTickerView(TickerResponse ticker) {
        mainBinding.setTicker(ticker);
    }

    @Override
    public void showFailLoad() {
        Toast.makeText(this, getString(R.string.text_fail), Toast.LENGTH_LONG).show();
    }
}
