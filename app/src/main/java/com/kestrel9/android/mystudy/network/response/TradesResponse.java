package com.kestrel9.android.mystudy.network.response;

import java.util.List;

/**
 * Mystudy
 * Class: TradesResponse
 * Created by kestr on 2018-07-11.
 * <p>
 * Description:
 */
public class TradesResponse {

    public String errorCode;
    public String timestamp;
    public List<CompleteOrder> completeOrders;
    public String result;
    public String currency;

    public class CompleteOrder{
        public String timestamp;
        public String price;
        public String qty;
    }
}
