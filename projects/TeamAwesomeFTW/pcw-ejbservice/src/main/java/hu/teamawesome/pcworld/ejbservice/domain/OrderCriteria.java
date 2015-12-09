package hu.teamawesome.pcworld.ejbservice.domain;

public class OrderCriteria
{
	private long customerId;
	private boolean showArchived;
	
	public OrderCriteria()
	{
		this(-1L, true);
    }
	public OrderCriteria(long customerId, boolean showArchived)
	{
		this.customerId = customerId;
		this.showArchived = showArchived;
    }
	
	public long getCustomerId() {
		return this.customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	
	public boolean getShowArchived() {
		return this.showArchived;
	}
	public void setShowArchived(boolean showArchived) {
		this.showArchived = showArchived;
	}
	
    @Override
    public String toString() {
        return "OrderCriteriaStub [customerId=" + customerId + "; showArchived=" + showArchived + "]";
    }

}
