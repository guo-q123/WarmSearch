package priv.zhf.uniapp.service;

import priv.zhf.uniapp.entity.SUser;
import com.baomidou.mybatisplus.extension.service.IService;
import priv.zhf.utils.requestMessage.MyPage;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 */

public interface SUserService extends IService<SUser> {
    SUser login(SUser sUser);


    /**
     * 自定义分页查询方法
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param sUsers
     * @return
     */
    public MyPage searchPcUser(int pageNo, int limit, String idSorted, List<SUser> sUsers);

    /**
     * 根据id查询
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param users
     * @return
     */
    public MyPage searchById(int pageNo, int limit, String idSorted, List<Map> users);
}
