package hu.teamawesome.pcworld.ejbservice.domain;

public class CustomerCriteria
{
	private long id;

	public CustomerCriteria() {
    }

	public long getId() {
		return this.id;
	}
	public void setId(long id) {
		this.id = id;
	}
    @Override
    public String toString() {
        return "CustomerCriteriaStub [id=" + id + "]";
    }

}
