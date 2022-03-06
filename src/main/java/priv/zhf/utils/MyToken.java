package priv.zhf.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * token类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyToken implements java.io.Serializable{
    private String token;
}
