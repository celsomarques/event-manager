package com.embraer.eventmanager;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/**
 * O Event e responsavel por prover meta informa��es sobre a transa��o (Envelope Wrapper) , fornecendo mecanismo de roteamento
 * baseado no envelope. EAI Pattern <link>http://www.eaipatterns.com/EnvelopeWrapper.html</link>
 * 
 * @author ercarval
 * @version 1.0 12/12/2012 12:12
 */
@Data
@Document(collection = "events")
public class Event implements Serializable {

	private static final long serialVersionUID = 6031189271493379521L;

	public enum EventPriority {
		HIGH, MEDIUM, LOW
	}

	public enum EventStatus {
		DELIVERY, SUCCESS, ERROR, QUEUED, DEQUEUED
	}

	@Id
	private String id;

	private String eventName;

	private String sender;

	private String receiver;

	private String sourceObject;

	private String internalID;

	@Indexed
	private String businessDocumentNumber;

	private String businessDocumentCorrelatedNumber;

	private EventPriority eventPriority;

	private Integer batchSize;

	private Integer batchPosition;

	private EventStatus eventStatus;

	private String statusMessage;

	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date externalCreationDate;

	private Object payload;

	private Object objectPayload;

	public Event() {
		eventPriority = EventPriority.MEDIUM;
		batchSize = 0;
		batchPosition = 0;
		eventStatus = EventStatus.QUEUED;
		statusMessage = "";
		externalCreationDate = new Date();

	}

	public Event(String eventName, String sender, String receiver, String sourceObject, String internalID,
			String businessDocumentNumber, String businessDocumentCorrelatedNumber) {
		this();
		this.eventName = eventName;
		this.sender = sender;
		this.receiver = receiver;
		this.sourceObject = sourceObject;
		this.internalID = internalID;
		this.businessDocumentNumber = businessDocumentNumber;
		this.businessDocumentCorrelatedNumber = businessDocumentCorrelatedNumber;
	}

	public boolean containsError() {
		return EventStatus.ERROR.equals(this.eventStatus);
	}
}
