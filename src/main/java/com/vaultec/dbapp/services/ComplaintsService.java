package com.vaultec.dbapp.services;

import com.vaultec.dbapp.repository.ComplaintsRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
public class ComplaintsService {

    private ComplaintsRepository complaintsRepository;

}
