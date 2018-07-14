package com.kestrel9.android.mystudy.network;

import com.kestrel9.android.mystudy.network.response.OrderbookResponse;
import com.kestrel9.android.mystudy.network.response.TickerResponse;
import com.kestrel9.android.mystudy.network.response.TradesResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Mystudy
 * Class: CoinoneApi
 * Created by kestr on 2018-07-11.
 * <p>
 * Description:
 */
public class CoinoneApi {
    private static final String BASE_URL = "https://api.coinone.co.kr/";

    public interface CoinoneApiService{
        @GET("/ticker/")
        Call<TickerResponse> tickerResponseCall();

        @GET("/orderbook/")
        Call<OrderbookResponse> orderbookResponseCall();

        @GET("/trades/")
        Call<TradesResponse> tradesResponseCall();

        public static final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }
}


