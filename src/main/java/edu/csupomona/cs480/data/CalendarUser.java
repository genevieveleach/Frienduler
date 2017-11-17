package edu.csupomona.cs480.data;

import java.util.ArrayList;

import edu.csupomona.cs480.data.provider.EventList;

public abstract class CalendarUser extends User implements CalendarUserInterface{
	private EventList  schedule;
	
	public CalendarUser(String id) {
		super(id);
		schedule = new EventList();
	}
	
	@Override
	public boolean eventScheduled(Event e) {
		int index = schedule.indexOf(e);
		if(index == -1)
			return false;
		return true;
	}

	@Override
	public boolean addEvent(Event e) {
		if(eventScheduled(e))
			return false;
		int indexBelong = findIndexWhereEventBelongs(e);
		schedule.add(indexBelong, e);
		return true;
	}

	private int findIndexWhereEventBelongs(Event e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean removeEvent(Event e) {
		return schedule.remove(e);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public EventList getSchedule() {
        return schedule;
    }
	
	public EventList setSchedule(EventList schedule) {
		EventList oldschedule = this.schedule;
		this.schedule = schedule;
		return oldschedule;
    }
	
	public Event removeEventByName(String eventName) {
		int index = findEventIndexByName(eventName);
		if(index != -1)
			return schedule.remove(index);
		return null;
	}
	
	public Event findEventByName(String eventName) {
		int index = findEventIndexByName(eventName);
		if(index != -1) {
			return schedule.get(index);
		}
		return null;
	}
	
	
	private int findEventIndexByName(String eventName) {
		int index = -1;
		for(int i = 0; i < schedule.size(); i++) {
			Event e = schedule.get(i);
			if(e == null)
				return index;
			else if (e.getName().equals(eventName))
				return i;
		}
		return index;
	}
}
