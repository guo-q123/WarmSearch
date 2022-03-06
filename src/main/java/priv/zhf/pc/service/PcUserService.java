package priv.zhf.pc.service;

import org.springframework.stereotype.Service;
import priv.zhf.pc.entity.PcUser;
import com.baomidou.mybatisplus.extension.service.IService;
import priv.zhf.utils.MyPage;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * PC端用户信息 服务类
 * </p>
 *
 */
@Service
public interface PcUserService extends IService<PcUser> {
    PcUser login(PcUser pcUser);

    /**
     * 自定义分页查询方法
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param pcUsers
     * @return
     */
    public MyPage searchPcUser(int pageNo, int limit, String idSorted, List<PcUser> pcUsers);

    priv.zhf.utils.requestMessage.MyPage searchById(int pageNo, int limit, String idSorted, List<Map> users);
}
