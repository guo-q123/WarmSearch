package priv.zhf.pc.mapper;

import io.swagger.annotations.ApiModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import priv.zhf.pc.entity.PcGoodskind;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 */
@Mapper
@Repository
@ApiModel("PC端物品种类信息实体接口类")
public interface PcGoodskindMapper extends BaseMapper<PcGoodskind> {

}
