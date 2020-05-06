package cloud.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**@Name: Payment
 * @Description:  支付实体类
 * @Author: yangbo
 * @Date: 2020/4/2 9:55 下午
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    private int id;
    private double money;
    private String name;
}

