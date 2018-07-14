package com.kestrel9.android.mystudy.main;

import com.kestrel9.android.mystudy.network.response.OrderbookResponse;
import com.kestrel9.android.mystudy.network.response.TickerResponse;
import com.kestrel9.android.mystudy.network.response.TradesResponse;

import java.util.List;

/**
 * Mystudy
 * Class: MainContract
 * Created by kestr on 2018-07-13.
 * <p>
 * Description:
 */
public interface MainContract {
    interface View{

        void addBidList(List<OrderbookResponse.Bid> bid);

        void addAskList(List<OrderbookResponse.Ask> ask);

        void addOrderList(List<TradesResponse.CompleteOrder> order);

        void setTickerView(TickerResponse ticker);

        void showFailLoad();
    }

    interface Presenter{

        void loadApiData();
    }
}
