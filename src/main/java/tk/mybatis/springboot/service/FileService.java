package tk.mybatis.springboot.service;

import com.github.pagehelper.PageHelper;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.springboot.mapper.FileMapper;
import tk.mybatis.springboot.model.UploadFile;
import tk.mybatis.springboot.model.vo.UserVo;
import tk.mybatis.springboot.util.UUIDGenerator;

import java.util.Date;
import java.util.List;

@Service
public class FileService{
	
	@Autowired
	private FileMapper fileMapper;

	public int save(MultipartFile file, UserVo userVo, String status) {
		UploadFile f=new UploadFile();
		String fileName=file.getOriginalFilename();
		String type=fileName.substring(fileName.lastIndexOf("."));
		f.setId(UUIDGenerator.getUUID());
		f.setFileName(fileName);
		f.setFileSize(file.getSize());
		f.setFileType(type);
		f.setFileState(status);
		f.setUploadTime(new Date());
		f.setUploadUser(userVo.getLoginName());
		int i=fileMapper.insert(f);
		return i;
	}

	public PageInfo<UploadFile> findAll(UploadFile uploadFile) {
		PageHelper.startPage(uploadFile.getPage(),uploadFile.getRows());
		Example example = new Example(UploadFile.class);
		Example.Criteria criteria = example.createCriteria();
		if (uploadFile.getFileName() != null && uploadFile.getFileName().length() > 0) {
			criteria.andLike("fileName", "%" + uploadFile.getFileName()  + "%");
		}
		if (uploadFile.getFileType()  != null && uploadFile.getFileType() .length() > 0) {
			criteria.andLike("fileType", "%" + uploadFile.getFileType()  + "%");
		}
		Example.OrderBy orderBy=example.orderBy("uploadTime");
		orderBy.desc();
		List<UploadFile> list=fileMapper.selectByExample(example);

		return new PageInfo<UploadFile>(list);
	}

	public UploadFile findById(String id) {
		return fileMapper.selectByPrimaryKey(id);
	}

	public int delete(String id) {
		return fileMapper.deleteByPrimaryKey(id);
	}


}
