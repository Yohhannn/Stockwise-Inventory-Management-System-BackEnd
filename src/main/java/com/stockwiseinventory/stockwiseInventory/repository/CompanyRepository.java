package com.stockwiseinventory.stockwiseInventory.repository;

import com.stockwiseinventory.stockwiseInventory.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
}
