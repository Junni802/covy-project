package covy.userservice.vo;

import java.util.Date;
import lombok.Data;

/**
 * <클래스 설명>
 *
 * @author : junni802
 * @date : 2025-02-21
 */

@Data
public class ResponseOrder {
    private String productId;
    private Integer qty;
    private Integer unitPrice;
    private Integer totalPrice;
    private Date createdAt;

    private String orderId;
}
