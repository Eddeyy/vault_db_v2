package com.vaultec.dbapp.services;

import com.vaultec.dbapp.model.entity.Complaint;
import com.vaultec.dbapp.model.enums.UserType;
import com.vaultec.dbapp.repository.ComplaintsRepository;
import com.vaultec.dbapp.validation.UsableBy;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Getter
@Setter(onMethod = @__(@Autowired))
public class ComplaintsService {

    private ComplaintsRepository complaintsRepository;

    public List<Complaint> findAll() {
        return complaintsRepository.findAll();
    }

    @UsableBy({UserType.UNEMPLOYED, UserType.ENGINEER, UserType.MEDIC, UserType.MANAGER, UserType.OVERSEER})
    public boolean addComplaint(Complaint complaint) {

        if(complaintsRepository.exists(Example.of(complaint))) {
            System.out.println("UNABLE TO CREATE COMPLAINT - THIS COMPLAINT ALREADY EXISTS");
            return false;
        }

        complaintsRepository.save(complaint);
        return true;
    }

    @UsableBy({UserType.MANAGER, UserType.OVERSEER})
    public boolean setVerStatus(List<Long> compId, String verStatus) {

        List<Complaint> complaints =
                compId.stream()
                .map( id -> complaintsRepository.findById(id).orElse(null))
                .toList();

        complaints.forEach( comp -> {
            if(comp == null) {
                return;
            }
            comp.setVerStatus(verStatus);
            complaintsRepository.save(comp);
        });

        if(complaints.contains(null)) {
            System.out.println("COMPLETED VERIFICATION PROCESS WITH SOME ERRORS.");
        }

        System.out.println("VERIFIED " + complaints.stream().filter(Objects::nonNull).count() + " COMPLAINTS SUCCESSFULLY.");
        return true;
    }
}
