package hu.morkalla.gymproject.ejbservice.domain;

public class TimetableStub {

	private String room;
	private String day;
	private String time;
	private WorkoutStub workout;

	public TimetableStub() {
		super();
	}

	public TimetableStub(String room, String day, String time, WorkoutStub workout) {
		super();
		this.room = room;
		this.day = day;
		this.time = time;
		this.workout = workout;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public WorkoutStub getWorkout() {
		return workout;
	}

	public void setWorkout(WorkoutStub workout) {
		this.workout = workout;
	}

	@Override
	public String toString() {
		return "TimetableStub [room=" + room + ", day=" + day + ", time=" + time + ", workout=" + workout + "]";
	}

}
