package priv.zhf.operate.service;

import priv.zhf.operate.entity.AdminUser;

/**
 * <p>
 *  服务类
 * </p>
 *
 */
public interface AdminUserService  {
    /**
     * 如果验证成功，返回adminUser对象
     * 否则，返回null或throw
     */
    public AdminUser verify(AdminUser adminUser);

}
