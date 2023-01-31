package com.vaultec.dbapp.repository;

import com.vaultec.dbapp.model.entity.Complaint;
import com.vaultec.dbapp.repository.custom.CustomComplaintsRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComplaintsRepository extends JpaRepository<Complaint, Long>, CustomComplaintsRepository {

    List<Complaint> findAllByDwellerId(Long id);

    List<Complaint> findAllByVerStatusStatus(String ver_status);
}
