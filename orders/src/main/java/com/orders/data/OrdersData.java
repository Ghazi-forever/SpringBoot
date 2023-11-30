package com.orders.data;

public class OrdersData {
        private Long Userid;

        private String customerName;

        public OrdersData(Long userid, String customerName) {
                Userid = userid;
                this.customerName = customerName;
        }

        public OrdersData() {
        }

        public Long getUserid() {
                return Userid;
        }

        public void setUserid(Long userid) {
                Userid = userid;
        }

        public String getCustomerName() {
                return customerName;
        }

        public void setCustomerName(String customerName) {
                this.customerName = customerName;
        }

        @Override
        public String toString() {
                return "OrdersData{" +
                        "Userid=" + Userid +
                        ", customerName='" + customerName + '\'' +
                        '}';
        }
}

