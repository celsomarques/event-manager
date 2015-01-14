package com.embraer.eventmanager;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Celso Ricardo Marques Pereira - CRMPERE
 * @version 1.0 - 13/01/2015
 */
public interface EventRepository extends PagingAndSortingRepository<Event, String> {

}