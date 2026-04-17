package com.visa.mada.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.visa.mada.Model.DemandeStatutHistorique;
import com.visa.mada.Model.DemandeStatutHistoriqueId;

@Repository
public interface DemandeStatutHistoriqueRepository
        extends JpaRepository<DemandeStatutHistorique, DemandeStatutHistoriqueId> {
}
