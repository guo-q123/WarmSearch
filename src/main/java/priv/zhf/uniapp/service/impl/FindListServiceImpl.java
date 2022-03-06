package priv.zhf.uniapp.service.impl;

import priv.zhf.uniapp.entity.FindList;
import priv.zhf.uniapp.mapper.FindListMapper;
import priv.zhf.uniapp.service.FindListService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import priv.zhf.utils.MyPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 待招领物品详情表 服务实现类
 * </p>
 *
 */
@Service
public class FindListServiceImpl extends ServiceImpl<FindListMapper, FindList> implements FindListService {

    @Override
    public MyPage searchFindList(int pageNo, int limit, String idSorted, List<FindList> findLists) {
        MyPage page = null;
        List<FindList> findListsList = new ArrayList<>();
        findListsList.addAll(findLists);
        if(idSorted != null && idSorted.startsWith("-")){
            Collections.reverse(findListsList );
        }
        int total = findListsList .size();
        int maxPageNo = findListsList .size()%limit == 0? findListsList.size()/limit:findListsList .size()/limit + 1;
        if(pageNo>maxPageNo){
            pageNo = maxPageNo;
        }
        int beginIndex = (pageNo-1)*limit;
        int endIndex = pageNo*limit;
        if(endIndex>total){
            endIndex = total;
        }

//        page = new MyPage(findListsList .subList(beginIndex, endIndex), total);
        page = new MyPage(findListsList, total);

        return page;
    }

    @Override
    public priv.zhf.utils.requestMessage.MyPage searchById(int pageNo, int limit, String idSorted, List<Map> findLists) {
        priv.zhf.utils.requestMessage.MyPage page = null;
        List<Map> infoList = new ArrayList<>();
        infoList.addAll(findLists);
        if(idSorted != null && idSorted.startsWith("-")){
            Collections.reverse(infoList);
        }
        int total = infoList.size();
        int maxPageNo = infoList.size()%limit == 0? infoList.size()/limit:infoList.size()/limit + 1;
        if(pageNo>maxPageNo){
            pageNo = maxPageNo;
        }
        int beginIndex = (pageNo-1)*limit;
        int endIndex = pageNo*limit;
        if(endIndex>total){
            endIndex = total;
        }

        page = new priv.zhf.utils.requestMessage.MyPage(infoList.subList(beginIndex, endIndex), total);
        return page;
    }
}
