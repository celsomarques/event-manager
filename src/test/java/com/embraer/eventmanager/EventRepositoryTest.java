package com.embraer.eventmanager;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring/application-context-mongo.xml")
public class EventRepositoryTest {

	@Autowired
	private EventRepository repository;

	@Test
	public void readsFirstPageCorrectly() {

		Page<Event> events = this.repository.findAll(new PageRequest(0, 10));
		assertTrue(events.isFirst());
	}
	
	@Test
	public void insertEvent() {
		
		Event event = new Event();
		event.setExternalCreationDate(new Date());
		event.setBusinessDocumentNumber("40045766");
		event.setBusinessDocumentCorrelatedNumber("2200980");
		
		event = this.repository.save(event);
		Iterable<Event> events = this.repository.findAll();
		
		assertNotNull(event.getId());
		assertNotNull(events);
	}
}
