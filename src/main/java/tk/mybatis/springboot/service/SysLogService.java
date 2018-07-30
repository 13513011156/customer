package tk.mybatis.springboot.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.springboot.mapper.SysLogMapper;
import tk.mybatis.springboot.model.SysLog;

import java.util.List;

@Service
public class SysLogService {
	
	@Autowired
	private SysLogMapper sysLogMapper;

	public PageInfo<SysLog> findAll(SysLog sysLog) {
		PageHelper.startPage(sysLog.getPage(),sysLog.getRows());
		Example example = new Example(SysLog.class);
		Example.Criteria criteria = example.createCriteria();
		if (sysLog.getCreateTime() != null) {
			criteria.andEqualTo("createTime", sysLog.getCreateTime());
		}
		Example.OrderBy orderBy=example.orderBy("createTime");
		orderBy.desc();
		List<SysLog> list = sysLogMapper.selectByExample(example);
		return new PageInfo<SysLog>(list);
	}

}
