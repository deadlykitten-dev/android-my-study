package com.kestrel9.android.mystudy.main;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

import com.kestrel9.android.mystudy.databinding.ContentTickerBinding;

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


        RecyclerView askRecyclerView = findViewById(R.id.recycler_ask);
        askRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        askListAdapter = new AskListAdapter(this);
        askListAdapter.setList(askList);

        askRecyclerView.setAdapter(askListAdapter);

        RecyclerView bidRecyclerView = findViewById(R.id.recycler_bid);
        bidRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        bidListAdapter = new BidListAdapter(this);
        bidListAdapter.setList(bidList);

        bidRecyclerView.setAdapter(bidListAdapter);

        RecyclerView orderRecyclerView = findViewById(R.id.recycler_order);
        orderRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        orderListAdapter = new OrderListAdapter(this);
        orderListAdapter.setList(orderList);

        orderRecyclerView.setAdapter(orderListAdapter);



        presenter = new MainPresenter(CoinoneApi.CoinoneApiService.retrofit.create(CoinoneApi.CoinoneApiService.class), this);

        presenter.loadApiData();



    }

    @Override
    public void addBidRow(OrderbookResponse.Bid bid) {
        bidList.add(bid);
    }

    @Override
    public void addAskRow(OrderbookResponse.Ask ask) {
        askList.add(ask);
    }

    @Override
    public void addOrderRow(TradesResponse.CompleteOrder order) {
        orderList.add(order);
    }

    @Override
    public void setTickerView(TickerResponse ticker) {
        mainBinding.setTicker(ticker);
    }

    @Override
    public void showFailLoad() {
        Toast.makeText(this, getString(R.string.text_fail), Toast.LENGTH_LONG).show();
    }

    @Override
    public void notifyListView() {
        bidListAdapter.notifyDataSetChanged();
        askListAdapter.notifyDataSetChanged();
        orderListAdapter.notifyDataSetChanged();
    }
}
