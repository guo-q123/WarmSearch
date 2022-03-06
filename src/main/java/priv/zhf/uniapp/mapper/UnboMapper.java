package priv.zhf.uniapp.mapper;

import io.swagger.annotations.ApiModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import priv.zhf.uniapp.entity.Unbo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 首页轮播图 Mapper 接口
 * </p>
 */
@Mapper
@Repository
@ApiModel("首页轮播图实体接口类")
public interface UnboMapper extends BaseMapper<Unbo> {


}
