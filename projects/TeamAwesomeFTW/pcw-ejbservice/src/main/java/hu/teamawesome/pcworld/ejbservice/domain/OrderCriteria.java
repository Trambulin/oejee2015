package hu.teamawesome.pcworld.ejbservice.domain;

public class OrderCriteria
{
	private long id;

	public OrderCriteria() {
    }

	public long getId() {
		return this.id;
	}
	public void setId(long id) {
		this.id = id;
	}
    @Override
    public String toString() {
        return "OrderCriteriaStub [id=" + id + "]";
    }

}
