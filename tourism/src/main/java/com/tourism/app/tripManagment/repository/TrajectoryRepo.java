package com.tourism.app.tripManagment.repository;

import com.tourism.app.tripManagment.model.Trajectory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrajectoryRepo extends JpaRepository<Trajectory, Long> {

}
