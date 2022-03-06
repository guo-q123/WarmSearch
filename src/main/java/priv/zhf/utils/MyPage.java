package priv.zhf.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 自定义分页
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyPage {
    private List items;
    private int total;
}
