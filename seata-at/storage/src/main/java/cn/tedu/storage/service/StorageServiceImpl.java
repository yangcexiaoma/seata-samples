package cn.tedu.storage.service;

import cn.tedu.storage.mapper.StorageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Date 2020/9/5 9:55
 * @Author yangce
 */
@Service
public class StorageServiceImpl implements StorageService{
    @Autowired
    private StorageMapper storageMapper;
    @Override
    @Transactional
    public void decrease(Long productId, Integer count) {
        storageMapper.decrease(productId,count);
//                if (Math.random() < 0.5) {
//            throw new RuntimeException("模拟异常");
//        }
    }
}
