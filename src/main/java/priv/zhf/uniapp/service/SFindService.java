package priv.zhf.uniapp.service;

import priv.zhf.uniapp.entity.SFind;
import com.baomidou.mybatisplus.extension.service.IService;
import priv.zhf.utils.MyPage;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 招领信息表 服务类
 * </p>
 */
public interface SFindService extends IService<SFind> {

    /**
     * 自定义分页查询方法
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param sFinds
     * @return
     */
    public MyPage searchSFind(int pageNo, int limit, String idSorted, List<SFind> sFinds);

    public MyPage searchAllSFind(int pageNo, int limit, String idSorted, List<Map> sFinds);
}
