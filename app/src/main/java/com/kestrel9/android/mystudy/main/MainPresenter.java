package com.kestrel9.android.mystudy.main;

import com.kestrel9.android.mystudy.network.CoinoneApi;
import com.kestrel9.android.mystudy.network.response.OrderbookResponse;
import com.kestrel9.android.mystudy.network.response.TickerResponse;
import com.kestrel9.android.mystudy.network.response.TradesResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Mystudy
 * Class: MainPresenter
 * Created by kestr on 2018-07-13.
 * <p>
 * Description:
 */
public class MainPresenter implements MainContract.Presenter {

    private CoinoneApi.CoinoneApiService coinoneApiService;
    private MainContract.View view;

    public MainPresenter(CoinoneApi.CoinoneApiService coinoneApiService, MainContract.View view) {
        this.coinoneApiService = coinoneApiService;
        this.view = view;
    }

    @Override
    public void loadApiData() {

        final Call<OrderbookResponse> orderbookResponseCall = coinoneApiService.orderbookResponseCall();

        orderbookResponseCall.enqueue(new Callback<OrderbookResponse>() {
            @Override
            public void onResponse(Call<OrderbookResponse> call, Response<OrderbookResponse> response) {
                if (response.body() == null) return;
                OrderbookResponse orderbookResponse = response.body();
                if (orderbookResponse == null) return;
                if (orderbookResponse.result.equals("success")) {

                    for (OrderbookResponse.Ask ask:
                            orderbookResponse.ask) {
                        view.addAskRow(ask);
                    }
                    for (OrderbookResponse.Bid bid:
                            orderbookResponse.bid) {
                        view.addBidRow(bid);
                    }
                }
                view.notifyListView();
            }

            @Override
            public void onFailure(Call<OrderbookResponse> call, Throwable t) {
                view.showFailLoad();
            }
        });

        final Call<TradesResponse> tradesResponseCall = coinoneApiService.tradesResponseCall();

        tradesResponseCall.enqueue(new Callback<TradesResponse>() {
            @Override
            public void onResponse(Call<TradesResponse> call, Response<TradesResponse> response) {
                if (response.body() == null) return;
                TradesResponse tradesResponse = response.body();
                if (tradesResponse == null) return;
                if (tradesResponse.result.equals("success")){
                    for (TradesResponse.CompleteOrder order:
                            tradesResponse.completeOrders){
                        view.addOrderRow(order);
                    }
                }
                view.notifyListView();
            }

            @Override
            public void onFailure(Call<TradesResponse> call, Throwable t) {
                view.showFailLoad();
            }
        });

        final Call<TickerResponse> tickerResponseCall = coinoneApiService.tickerResponseCall();

        tickerResponseCall.enqueue(new Callback<TickerResponse>() {
            @Override
            public void onResponse(Call<TickerResponse> call, Response<TickerResponse> response) {
                if (response.body() == null) return;
                TickerResponse tickerResponse = response.body();
                if (tickerResponse == null) return;
                if (tickerResponse.result.equals("success")){
                    view.setTickerView(tickerResponse);
                }
                view.notifyListView();
            }

            @Override
            public void onFailure(Call<TickerResponse> call, Throwable t) {
                view.showFailLoad();
            }
        });

    }
}
