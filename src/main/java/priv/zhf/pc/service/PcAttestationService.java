package priv.zhf.pc.service;

import priv.zhf.pc.entity.PcAttestation;
import com.baomidou.mybatisplus.extension.service.IService;
import priv.zhf.utils.MyPage;

import java.util.List;

/**
 * <p>
 * 认领信息登记 服务类
 * </p>
 *
 */
public interface PcAttestationService extends IService<PcAttestation> {
    /**
     *
     * @param idSorted
     * @param pcAttestations
     * @return
     */
    public MyPage searchPcAttestation(String idSorted, List<PcAttestation> pcAttestations);
}
