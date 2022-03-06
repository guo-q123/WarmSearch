package priv.zhf.uniapp.service;

import priv.zhf.uniapp.entity.FindList;
import com.baomidou.mybatisplus.extension.service.IService;
import priv.zhf.utils.MyPage;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 待招领物品详情表 服务类
 * </p>
 */
public interface FindListService extends IService<FindList> {

    /**
     * 自定义分页查询方法
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param findLists
     * @return
     */
    public MyPage searchFindList(int pageNo, int limit, String idSorted, List<FindList> findLists);

    /**
     * 根据id查询
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param findLists
     * @return
     */
    public priv.zhf.utils.requestMessage.MyPage searchById(int pageNo, int limit, String idSorted, List<Map> findLists);
}
