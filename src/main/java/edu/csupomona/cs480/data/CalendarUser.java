package edu.csupomona.cs480.data;

import java.util.ArrayList;

public abstract class CalendarUser extends User implements CalendarUserInterface{
	private ArrayList<Event>  schedule = new ArrayList<Event>();
	private String id;
	
	@Override
	public boolean eventScheduled(Event e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addEvent(Event e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeEvent(Event e) {
		// TODO Auto-generated method stub
		return false;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<Event> getSchedule() {
        return schedule;
    }
	
	public ArrayList<Event> setSchedule(ArrayList<Event> schedule) {
		ArrayList<Event> oldschedule = this.schedule;
		this.schedule = schedule;
		return oldschedule;
    }
	
	public Event removeEventByName(String eventName) {
		int index = findEventIndexByName(eventName);
		if(index != -1)
			return schedule.get(index);
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
