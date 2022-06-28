package com.example.minitestquizz.Repository;

import com.example.minitestquizz.Model.Clazz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClazzRepository extends JpaRepository<Clazz,Long> {
}
