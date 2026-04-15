package com.visa.mada.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.visa.mada.Model.Passport;

@Repository
public interface PassportRepository extends JpaRepository<Passport, Integer> {
}