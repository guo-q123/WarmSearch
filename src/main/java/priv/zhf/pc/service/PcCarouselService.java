package priv.zhf.pc.service;

import priv.zhf.pc.entity.PcCarousel;
import com.baomidou.mybatisplus.extension.service.IService;
import priv.zhf.utils.MyPage;

import java.util.List;

/**
 * <p>
 * PC端轮播图 服务类
 * </p>
 *
 */
public interface PcCarouselService extends IService<PcCarousel> {

    /**
     * 自定义分页查询方法
     * @param idSorted
     * @param pcCarousel
     * @return
     */
    public MyPage searchPcCarousel(String idSorted, List<PcCarousel> pcCarousel);

}
