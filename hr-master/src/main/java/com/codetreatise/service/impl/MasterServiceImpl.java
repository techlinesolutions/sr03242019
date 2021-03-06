package com.codetreatise.service.impl;

import com.codetreatise.bean.Items;
import com.codetreatise.repository.MasterRepository;
import com.codetreatise.service.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MasterServiceImpl implements MasterService {

    private final MasterRepository masterRepository;

    @Autowired
    public MasterServiceImpl(MasterRepository masterRepository) {
        this.masterRepository = masterRepository;
    }

    @Override
    public Items save(Items entity) {
        return masterRepository.save(entity);
    }

    @Override
    public Items update(Items entity) {
        return masterRepository.save(entity);
    }

    @Override
    public void delete(Items entity) {
        masterRepository.delete(entity);
    }

    @Override
    public void delete(Long id) { masterRepository.delete(id);  }

    @Override
    public List<Items> findAll() {
        return masterRepository.findAll();
    }

    @Override
    public void deleteInBatch(List<Items> items) {
        masterRepository.deleteInBatch(items);
    }

    @Override
    public Items find(Long id) {
        return masterRepository.findOne(id);
    }

    @Override
    public Page<Items> findAll(Pageable pageable) {
        return masterRepository.findAll(pageable);
    }

    public Items findByItemname(String itemname){ return masterRepository.findByItemname(itemname); }
    @Override
    public List<Map<String, Object>> report(Long id) {
        List<Map<String, Object>> result = new ArrayList<>();
        Items items = masterRepository.findOne(id);
        Map<String, Object> item = new HashMap<>();
     //   item.put("itemdate", items.getItemKarigar().getIssuedate());
     //  item.put("country", items.getItemcode());
        item.put("name", items.getItemname());
      //  item.put("scanimage", items.getScanImage());
       // item.put("party", items.getAcntmst().toString());
      //  item.put("karigar", items.getKarigarmst().toString());
       // item.put("jadtar", items.getJadtarmst().toString());
      //  item.put("ghatgrswt", items.getItemKarigar().getGhatwt());
     //   item.put("karigarMtWt", items.getItemKarigar().getMtwt());
        result.add(item);

        return result;
    }
}
