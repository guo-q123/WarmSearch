package priv.zhf.pc.service.impl;

import priv.zhf.pc.entity.PcCarousel;
import priv.zhf.pc.mapper.PcCarouselMapper;
import priv.zhf.pc.service.PcCarouselService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import priv.zhf.utils.MyPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * PC端轮播图 服务实现类
 * </p>
 *
 */
@Service
public class PcCarouselServiceImpl extends ServiceImpl<PcCarouselMapper, PcCarousel> implements PcCarouselService {

    @Override
    public MyPage searchPcCarousel(String idSorted, List<PcCarousel> pcCarousel) {
        MyPage page = null;
        List<PcCarousel> pcCarouselList = new ArrayList<>(pcCarousel);
        if(idSorted != null && idSorted.startsWith("-")){
            Collections.reverse(pcCarouselList);
        }
        int total = pcCarouselList.size();
//        int maxPageNo = pcCarouselList.size()%limit == 0? pcCarouselList.size()/limit:pcCarouselList.size()/limit + 1;
//        if(pageNo>maxPageNo){
//            pageNo = maxPageNo;
//        }
//        int beginIndex = (pageNo-1)*limit;
//        int endIndex = pageNo*limit;
//        if(endIndex>total){
//            endIndex = total;
//        }

//        page = new MyPage(pcCarouselList.subList(beginIndex, endIndex), total);
        page = new MyPage(pcCarouselList, total);

        return page;
    }
}
