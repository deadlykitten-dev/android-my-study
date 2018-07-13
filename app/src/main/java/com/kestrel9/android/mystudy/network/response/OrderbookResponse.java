package com.kestrel9.android.mystudy.network.response;

import java.util.List;

/**
 * Mystudy
 * Class: OrderbookResponse
 * Created by kestr on 2018-07-11.
 * <p>
 * Description:
 */
public class OrderbookResponse {
    public String timestamp;
    public List<Bid> bid;
    public String errorCode;
    public String currency;
    public String result;
    public List<Ask> ask;

    public class Bid{
        public String price;
        public String qty;
    }

    public class Ask{
        public String price;
        public String qty;
    }
}
