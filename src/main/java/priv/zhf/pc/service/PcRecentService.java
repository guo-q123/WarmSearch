package priv.zhf.pc.service;

import priv.zhf.pc.entity.PcRecent;
import com.baomidou.mybatisplus.extension.service.IService;
import priv.zhf.utils.MyPage;

import java.util.List;

/**
 * <p>
 * PC端最新信息 服务类
 * </p>
 *
 */
public interface PcRecentService extends IService<PcRecent> {
    /**
     * 自定义分页查询方法
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param PcRecent
     * @return
     */
    public MyPage searchPcRecent(int pageNo, int limit, String idSorted, List<PcRecent> PcRecent);

}
