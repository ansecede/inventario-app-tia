package com.inventario.tia.app.stores;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreService {

    private final StoreRepository storeRepository;

    @Autowired
    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public List<Store> getAllStores(){
        return storeRepository.findAll();
    }

    public Store registerNewStore(Store store) throws BadRequestException {
        Optional<Store> storeByNumName = storeRepository.findProductByNumName(store.getNumName());
        if (storeByNumName.isPresent()) {
            throw new BadRequestException("Tienda con código" + store.getNumName() + " ya existe");
        }
        return storeRepository.save(store);
    }
}
