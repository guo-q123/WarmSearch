package priv.zhf.uniapp.service;

import priv.zhf.uniapp.entity.GoodsDetail;
import com.baomidou.mybatisplus.extension.service.IService;
import priv.zhf.utils.MyPage;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 物品详情页信息 服务类
 * </p>
 *
 */
public interface GoodsDetailService extends IService<GoodsDetail> {

    /**
     * 自定义分页查询方法
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param goodsDetails
     * @return
     */
    public MyPage searchGoodsDetail(int pageNo, int limit, String idSorted, List<Map> goodsDetails);
    public MyPage searchGoodsDetail1(int pageNo, int limit, String idSorted, List<GoodsDetail> goodsDetails);
}
