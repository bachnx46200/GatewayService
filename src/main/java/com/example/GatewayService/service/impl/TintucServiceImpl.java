package com.example.GatewayService.service.impl;

import com.example.GatewayService.entity.TinTuc;
import com.example.GatewayService.repository.TinTucRespository;
import com.example.GatewayService.service.ITintucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TintucServiceImpl implements ITintucService {
    @Autowired
    TinTucRespository tinTucRespository;

    @Override
    public List<TinTuc> findAll() {
        return tinTucRespository.findAll();
    }

    @Override
    public TinTuc save(TinTuc toEntityWhenAdd) {
        return tinTucRespository.save(toEntityWhenAdd);
    }

    @Override
    public Optional<TinTuc> findById(int id) {
        return tinTucRespository.findById(id);
    }

    @Override
    public TinTuc deleteSoftById(TinTuc dataDelete) {
        dataDelete.setTrangthai(false);
        tinTucRespository.save(dataDelete);
        return dataDelete;
    }

    @Override
    public List<TinTuc> findByloaitintuc(Boolean loaitintuc) {
        return tinTucRespository.findByLoaitintuc(loaitintuc);
    }

    @Override
    public List<TinTuc> findAllAndOrder() {
        return tinTucRespository.findAllOrderByIdDesc();
    }
}
