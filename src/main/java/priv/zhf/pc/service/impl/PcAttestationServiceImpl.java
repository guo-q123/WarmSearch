package priv.zhf.pc.service.impl;

import priv.zhf.pc.entity.PcAttestation;
import priv.zhf.pc.mapper.PcAttestationMapper;
import priv.zhf.pc.service.PcAttestationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import priv.zhf.utils.MyPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * 认领信息登记 服务实现类
 * </p>
 *
 */
@Service
public class PcAttestationServiceImpl extends ServiceImpl<PcAttestationMapper, PcAttestation> implements PcAttestationService {

    @Override
    public MyPage searchPcAttestation(String idSorted, List<PcAttestation> pcAttestations) {
        MyPage page = null;
        List<PcAttestation> pcAttestationsList = new ArrayList<>();
        pcAttestationsList.addAll(pcAttestations);
        if(idSorted != null && idSorted.startsWith("-")){
            Collections.reverse(pcAttestationsList);
        }
        int total = pcAttestationsList.size();
//        int maxPageNo = pcAttestationsList.size()%limit == 0? pcAttestationsList.size()/limit:pcAttestationsList.size()/limit + 1;
//        if(pageNo>maxPageNo){
//            pageNo = maxPageNo;
//        }
//        int beginIndex = (pageNo-1)*limit;
//        int endIndex = pageNo*limit;
//        if(endIndex>total){
//            endIndex = total;
//        }

//        page = new MyPage(pcAttestationsList.subList(beginIndex, endIndex), total);
        page = new MyPage(pcAttestationsList, total);

        return page;
    }
}
