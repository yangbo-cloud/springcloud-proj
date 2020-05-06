package cloud.common.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**@Name: CommonResult
 * @Description:  返回的公共的结果集
 * @Author: yangbo
 * @Date: 2020/4/2 9:55 下午
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommonResult<T> {
    private int code;
    private String message;
    private T data;
    //需要一个两个参数的构造方法
    public CommonResult(int code, String message){
        this(code,message,null);

    }

}
