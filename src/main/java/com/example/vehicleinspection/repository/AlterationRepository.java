package com.example.vehicleinspection.repository;

import com.example.vehicleinspection.model.Alteration;
import com.example.vehicleinspection.model.keys.AlterationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlterationRepository extends JpaRepository<Alteration, AlterationId> {
}
