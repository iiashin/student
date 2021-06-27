package service;

import dao.MajorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Major;

import java.util.List;

@Service
public class MajorServiceImpl implements MajorService {
    @Autowired
    private MajorDao majorDao;
    @Override
    public List<Major> queryMajor() {
        return majorDao.queryMajor();
    }
}
