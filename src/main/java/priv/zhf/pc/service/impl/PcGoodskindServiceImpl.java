package priv.zhf.pc.service.impl;

import priv.zhf.pc.entity.PcGoodskind;
import priv.zhf.pc.mapper.PcGoodskindMapper;
import priv.zhf.pc.service.PcGoodskindService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import priv.zhf.utils.MyPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 *  PC端物品种类
 * </p>
 *
 */
@Service
public class PcGoodskindServiceImpl extends ServiceImpl<PcGoodskindMapper, PcGoodskind> implements PcGoodskindService {

    @Override
    public MyPage searchKinds(int pageNo, int limit, String idSorted, List<PcGoodskind> pcGoodskinds) {
        MyPage page = null;
        List<PcGoodskind> pcGoodskindsList = new ArrayList<>();
        pcGoodskindsList.addAll(pcGoodskinds);
        if(idSorted != null && idSorted.startsWith("-")){
            Collections.reverse(pcGoodskindsList);
        }
        int total = pcGoodskindsList.size();
        int maxPageNo = pcGoodskindsList.size()%limit == 0? pcGoodskindsList.size()/limit:pcGoodskindsList.size()/limit + 1;
        if(pageNo>maxPageNo){
            pageNo = maxPageNo;
        }
        int beginIndex = (pageNo-1)*limit;
        int endIndex = pageNo*limit;
        if(endIndex>total){
            endIndex = total;
        }

        page = new MyPage(pcGoodskindsList.subList(beginIndex, endIndex), total);

        return page;
    }
}
