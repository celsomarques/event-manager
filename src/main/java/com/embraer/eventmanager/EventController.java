package com.embraer.eventmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Celso Ricardo Marques Pereira - CRMPERE
 * @version 1.0 - 13/01/2015
 */
@Controller(value = "eventController")
@RequestMapping(value = "/events")
public class EventController {

	@Autowired
	private EventRepository repository;
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Iterable<Event> findAll() {
		return this.repository.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Event create(@RequestBody Event event) {
		return this.repository.save(event);
	}
}