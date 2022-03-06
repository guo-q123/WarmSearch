package priv.zhf.pc.service.impl;

import priv.zhf.pc.entity.PcRecent;
import priv.zhf.pc.mapper.PcRecentMapper;
import priv.zhf.pc.service.PcRecentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import priv.zhf.utils.MyPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * PC端最新信息 服务实现类
 * </p>
 *
 */
@Service
public class PcRecentServiceImpl extends ServiceImpl<PcRecentMapper, PcRecent> implements PcRecentService {

    @Override
    public MyPage searchPcRecent(int pageNo, int limit, String idSorted, List<PcRecent> PcRecent) {
        MyPage page = null;
        List<PcRecent> PcRecentlList = new ArrayList<>();
        PcRecentlList.addAll(PcRecent);
        if(idSorted != null && idSorted.startsWith("-")){
            Collections.reverse(PcRecentlList);
        }
        int total = PcRecentlList.size();
        int maxPageNo = PcRecentlList.size()%limit == 0? PcRecentlList.size()/limit:PcRecentlList.size()/limit + 1;
        if(pageNo>maxPageNo){
            pageNo = maxPageNo;
        }
        int beginIndex = (pageNo-1)*limit;
        int endIndex = pageNo*limit;
        if(endIndex>total){
            endIndex = total;
        }

//        page = new MyPage(PcRecentlList.subList(beginIndex, endIndex), total);
        page = new MyPage(PcRecentlList, total);

        return page;
    }
}
