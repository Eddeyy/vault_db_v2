package com.vaultec.dbapp.repository.custom.impl;

import com.vaultec.dbapp.model.Dweller;
import com.vaultec.dbapp.model.LoginCredentials;
import com.vaultec.dbapp.repository.custom.CustomDwellerRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;

public class CustomDwellerRepositoryImpl implements CustomDwellerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Dweller findByCredentials(String login, String password256) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Dweller> criteriaQuery = criteriaBuilder.createQuery(Dweller.class);
        Root<Dweller> dwellerRoot = criteriaQuery.from(Dweller.class);
        Root<LoginCredentials> credentialsRoot = criteriaQuery.from(LoginCredentials.class);
        Join<Dweller, LoginCredentials> creds = dwellerRoot.join("loginCredentials", JoinType.INNER);

        return entityManager.createQuery(criteriaQuery.select(dwellerRoot)
                        .where(
                                criteriaBuilder.and(
                                        criteriaBuilder.equal(creds.get("login"), login),
                                        criteriaBuilder.equal(creds.get("password"), password256)
                        ))
                ).getResultList().stream()
                .findFirst().orElse(new Dweller());
    }
}
