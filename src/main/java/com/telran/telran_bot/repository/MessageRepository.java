package com.telran.telran_bot.repository;

import com.telran.telran_bot.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

/**
 * This is interface for saving messages in database
 *
 * @author Igors Popmans
 * @version 1.0
 */
@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {

    /**
     * This method select all new messages from database,which are new
     *
     * @return list all new messages
     */
    @Query("SELECT m FROM Message m WHERE m.isNew = true")
    List<Message> findAllNewMessages();

    /**
     * This method to change all  messages from new to old
     *
     * @param messageIds list message ids
     */
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Message m SET m.isNew = false WHERE m.id IN  :messageIds ")
    void changeIsNewToFalse(@Param("messageIds") List<Integer> messageIds);
}

