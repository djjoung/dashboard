package chargingstation;

import javax.persistence.*;
// import java.util.List;

@Entity
@Table(name="DashBoard_table")
public class DashBoard {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private String carNumber;
        private String packType;
        private Integer packQty;
        private String orderStatus;
        private Long orderId;
        private String carName;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
        public String getCarNumber() {
            return carNumber;
        }

        public void setCarNumber(String carNumber) {
            this.carNumber = carNumber;
        }
        public String getPackType() {
            return packType;
        }

        public void setPackType(String packType) {
            this.packType = packType;
        }
        public Integer getPackQty() {
            return packQty;
        }

        public void setPackQty(Integer packQty) {
            this.packQty = packQty;
        }
        public String getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
        }
        public Long getOrderId() {
            return orderId;
        }

        public void setOrderId(Long orderId) {
            this.orderId = orderId;
        }
        public String getCarName() {
            return carName;
        }

        public void setCarName(String carName) {
            this.carName = carName;
        }

}