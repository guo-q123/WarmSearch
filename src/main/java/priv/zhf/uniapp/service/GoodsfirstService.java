package priv.zhf.uniapp.service;

import priv.zhf.uniapp.entity.Goodsfirst;
import com.baomidou.mybatisplus.extension.service.IService;
import priv.zhf.utils.MyPage;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 首页展示的物品信息 服务类
 * </p>
 */
public interface GoodsfirstService extends IService<Goodsfirst> {

    /**
     * 自定义分页查询方法
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param goodsfirsts
     * @return
     */
    public MyPage searchUnbo(int pageNo, int limit, String idSorted, List<Goodsfirst> goodsfirsts);

    /**
     * 根据id查询
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param goodsfirsts
     * @return
     */
    public priv.zhf.utils.requestMessage.MyPage searchById(int pageNo, int limit, String idSorted, List<Map> goodsfirsts);

}
