package chargingstation;

import chargingstation.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

// import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class DashBoardViewHandler {


    @Autowired
    private DashBoardRepository dashBoardRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPayFinished_then_CREATE_1 (@Payload PayFinished payFinished) {
        try {

            if (!payFinished.validate()) return;

            // view 객체 생성
            DashBoard dashBoard = new DashBoard();
            // view 객체에 이벤트의 Value 를 set 함
            dashBoard.setOrderId(payFinished.getOrderId());
            dashBoard.setCarName(payFinished.getCarName());
            dashBoard.setCarNumber(payFinished.getCarNumber());
            dashBoard.setOrderStatus(payFinished.getOrderStatus());
            dashBoard.setPackQty(payFinished.getOrderPackQty());
            dashBoard.setPackType(payFinished.getOrderPackType());
            // view 레파지 토리에 save
            dashBoardRepository.save(dashBoard);
            System.out.println("$$$$$ whenPayFinished_then_CREATE_1 in DashBoard: " + payFinished.toJson() + "$$$$$"); 

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderPlaced_then_UPDATE_1(@Payload OrderPlaced orderPlaced) {
        try {
            if (!orderPlaced.validate()) return;
                // view 객체 조회

                    List<DashBoard> dashBoardList = dashBoardRepository.findByOrderId(orderPlaced.getId());
                    for(DashBoard dashBoard : dashBoardList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    dashBoard.setOrderStatus(orderPlaced.getOrderStatus());
                    dashBoard.setPackType(orderPlaced.getPackType());
                    dashBoard.setPackQty(orderPlaced.getPackQty());
                    dashBoard.setCarName(orderPlaced.getCarName());
                    dashBoard.setCarNumber(orderPlaced.getCarNumber());
                    dashBoard.setCarName(orderPlaced.getCarName());
                    // view 레파지 토리에 save
                    dashBoardRepository.save(dashBoard);
                    System.out.println("$$$$$ whenOrderPlaced_then_UPDATE_1 in DashBoard: " + orderPlaced.toJson() + "$$$$$"); 
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenMountCompleted_then_UPDATE_3(@Payload MountCompleted mountCompleted) {
        try {
            if (!mountCompleted.validate()) return;
                // view 객체 조회
                List<DashBoard> dashBoardList = dashBoardRepository.findByOrderId(mountCompleted.getOrderId());
                for(DashBoard dashBoard : dashBoardList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    dashBoard.setOrderStatus(mountCompleted.getOrderStatus());
                    // view 레파지 토리에 save
                    dashBoardRepository.save(dashBoard);
                    System.out.println("$$$$$ whenMountCompleted in DashBoard: " + mountCompleted.toJson() + "$$$$$"); 
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderCanceled_then_UPDATE_4(@Payload OrderCanceled orderCanceled) {
        try {
            if (!orderCanceled.validate()) return;
                // view 객체 조회
                List<DashBoard> dashBoardList = dashBoardRepository.findByOrderId(orderCanceled.getId());
                for(DashBoard dashBoard : dashBoardList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    dashBoard.setOrderStatus(orderCanceled.getOrderStatus());
                    // view 레파지 토리에 save
                    dashBoardRepository.save(dashBoard);
                    System.out.println("$$$$$ whenOrderCanceled in DashBoard: " + orderCanceled.toJson() + "$$$$$"); 
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPayCanceled_then_UPDATE_5(@Payload PayCanceled payCanceled) {
        try {
            if (!payCanceled.validate()) return;
                // view 객체 조회
                List<DashBoard> dashBoardList = dashBoardRepository.findByOrderId(payCanceled.getOrderId());
                for(DashBoard dashBoard : dashBoardList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    dashBoard.setOrderStatus(payCanceled.getOrderStatus());
                    // view 레파지 토리에 save
                    dashBoardRepository.save(dashBoard);
                    System.out.println("$$$$$ whenPayCanceled in DashBoard: " + payCanceled.toJson() + "$$$$$"); 
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenMountCancelRequested_then_UPDATE_6(@Payload MountCancelRequested mountCancelRequested) {
        try {
            if (!mountCancelRequested.validate()) return;
                // view 객체 조회
            Optional<DashBoard> dashBoardOptional = dashBoardRepository.findById(mountCancelRequested.getOrderId());

            if( dashBoardOptional.isPresent()) {
                DashBoard dashBoard = dashBoardOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashBoard.setOrderStatus(mountCancelRequested.getOrderStatus());
                // view 레파지 토리에 save
                dashBoardRepository.save(dashBoard);
                System.out.println("$$$$$ whenMountCancelRequested in DashBoard: " + mountCancelRequested.toJson() + "$$$$$"); 
            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenMountCanceled_then_UPDATE_7(@Payload MountCanceled mountCanceled) {
        try {
            if (!mountCanceled.validate()) return;

            List<DashBoard> dashBoardList = dashBoardRepository.findByOrderId(mountCanceled.getOrderId());
            for(DashBoard dashBoard : dashBoardList){
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashBoard.setOrderStatus(mountCanceled.getOrderStatus());
                // view 레파지 토리에 save
                dashBoardRepository.save(dashBoard);
                System.out.println("$$$$$ whenMountCanceled in DashBoard: " + mountCanceled.toJson() + "$$$$$"); 
            }            
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

