package priv.zhf.uniapp.service;

import priv.zhf.uniapp.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import priv.zhf.utils.MyPage;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 寻物类别 服务类
 * </p>
 *
 */
public interface CategoryService extends IService<Category> {

    /**
     * 自定义分页查询方法
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param categories
     * @return
     */
    public MyPage searchCategory(int pageNo, int limit, String idSorted, List<Map> categories);

    public MyPage searchAllCategory(int pageNo, int limit, String idSorted, List<Category> categories);

}
