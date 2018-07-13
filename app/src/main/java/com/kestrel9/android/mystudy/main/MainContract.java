package com.kestrel9.android.mystudy.main;

import com.kestrel9.android.mystudy.network.response.OrderbookResponse;
import com.kestrel9.android.mystudy.network.response.TickerResponse;
import com.kestrel9.android.mystudy.network.response.TradesResponse;

/**
 * Mystudy
 * Class: MainContract
 * Created by kestr on 2018-07-13.
 * <p>
 * Description:
 */
public interface MainContract {
    interface View{

        void addBidRow(OrderbookResponse.Bid bid);

        void addAskRow(OrderbookResponse.Ask ask);

        void addOrderRow(TradesResponse.CompleteOrder order);

        void setTickerView(TickerResponse ticker);

        void showFailLoad();

        void notifyListView();
    }

    interface Presenter{

        void loadApiData();
    }
}
