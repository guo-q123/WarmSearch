package priv.zhf.pc.mapper;

import io.swagger.annotations.ApiModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import priv.zhf.pc.entity.PcCarousel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * PC端轮播图 Mapper 接口
 * </p>
 */
@Mapper
@Repository
@ApiModel("PC端轮播图实体接口类")
public interface PcCarouselMapper extends BaseMapper<PcCarousel> {

}
