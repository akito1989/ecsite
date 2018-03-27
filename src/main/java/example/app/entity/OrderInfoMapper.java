package example.app.entity;

import java.util.List;

public interface OrderInfoMapper {

	List<OrderInfo> getOrederInfo(String year,String month,String day);
}
