package com.telran.telran_bot.repository;

import com.telran.telran_bot.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * This is interface for saving Events in database
 *
 * @author Igors Popmans
 * @version 1.0
 */

@Repository
public interface EventRepository extends JpaRepository<Event,Integer> {

    /**
     * This is the list of new Events by received user id
     *
     * @param userId must not be null
     * @return all new events for user
     */
    @Query("SELECT e FROM Event e WHERE e.isNew = true AND e.userId =:userId")
    List<Event> findAllByUserId(@Param("userId") long userId);



}
