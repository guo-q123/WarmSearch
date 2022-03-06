package priv.zhf.operate.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 
 * </p>
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="Adminuser对象", description="")
public class AdminUser implements java.io.Serializable {

    @ApiModelProperty(value = "姓名(登录名)")
    private String username;

    /**
     * @JsonIgnore 该对象不需要变成json对象上传到前端
     */
    @ApiModelProperty(value = "登录密码")
    private String password;

}
