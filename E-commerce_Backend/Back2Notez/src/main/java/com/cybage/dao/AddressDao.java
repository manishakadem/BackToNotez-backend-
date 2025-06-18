package com.cybage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cybage.entity.*;
@Repository
public interface AddressDao extends JpaRepository<AddressEntity, Integer> {

}
