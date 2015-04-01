/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tess.repositories.jpa;

import com.tess.entities.Address;
import com.tess.repositories.AddressRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ivan
 */
@Repository("addressRepository")
public class JpaAddressRepository extends JpaEntityRepository<Address> 
    implements AddressRepository {

    public JpaAddressRepository() {
        super(Address.class);
    }

    @Transactional
    @Override
    public List<Address> readAll() {
        return readAll("Address.findAll");
    }

    @Transactional
    @Override
    public Long save(Address entity) {
        saveEntity(entity);
        return entity.getId();
    }
    
}
